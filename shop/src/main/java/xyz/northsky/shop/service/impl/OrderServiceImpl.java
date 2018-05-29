package xyz.northsky.shop.service.impl;

import com.google.common.base.Joiner;
import com.google.common.primitives.Ints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.northsky.shop.dao.BookMapper;
import xyz.northsky.shop.dao.OrderDetailMapper;
import xyz.northsky.shop.dao.OrderMapper;
import xyz.northsky.shop.dto.BookDto;
import xyz.northsky.shop.dto.OrderDetailDto;
import xyz.northsky.shop.dto.OrderInfo;
import xyz.northsky.shop.entity.Book;
import xyz.northsky.shop.entity.Order;
import xyz.northsky.shop.entity.OrderDetail;
import xyz.northsky.shop.entity.OrderExample;
import xyz.northsky.shop.service.OrderService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired(required = false)
    private OrderMapper orderMapper;

    @Autowired(required = false)
    private OrderDetailMapper orderDetailMapper;

    @Autowired(required = false)
    private BookMapper bookMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean insertOrder(OrderInfo orderInfo) {
        Order order = new Order();
        order.setOrderNo(orderInfo.getOrderNo());
        order.setUserId(orderInfo.getUserId());
        order.setCreateTime(orderInfo.getCreateTime());
        order.setPayAmount(orderInfo.getTotal_amount());
        order.setReceiver(orderInfo.getReceiver());
        order.setTel(orderInfo.getTel());
        order.setAddress(orderInfo.getAddress());

        if (!(orderMapper.insertOrder(order) > 0)) {
            logger.info("订单插入失败!order:"+order);
            throw new RuntimeException();
        }

        List<BookDto> books = orderInfo.getBooks();
        for (BookDto book : books) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setBookId(book.getBookId());
            orderDetail.setOrderId(order.getId());
            orderDetail.setQuantity(book.getQuantity());
            orderDetail.setSingleMoney(book.getSingleMoney());
            orderDetail.setTotal(book.getSingleTotal());

            if (!(orderDetailMapper.insertSelective(orderDetail) > 0)) {
                logger.info("订单明细插入失败, orderDetail:"+orderDetail);
                throw new RuntimeException();
            }


        }

        return true;
    }

    /**
     * 根据用户id和订单状态查询订单信息
     * @param userId
     * @param orderStatus
     * @return
     */

    @Override
    public Map<String, List<OrderDetailDto>> selectOrdersByUserId(Integer userId, Integer orderStatus) {
        Map<String, List<OrderDetailDto>> listMap = new LinkedHashMap<>();

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUserIdEqualTo(userId); // 根据用户id查询
        if (Objects.nonNull(orderStatus) && !"3".equals(orderStatus.toString())) { // 传入的订单状态不为空且不为3时, 3代表查询所有订单 根据订单状态id查询, 为空时查询用户所有订单
            criteria.andStatusEqualTo(orderStatus.toString());
        }
        criteria.andStatusNotEqualTo("0");
        orderExample.setOrderByClause("status asc, create_time desc"); // 根据订单状态升序, 创建日期倒叙排序, 让未完成订单排在已完成订单前面
        List<Order> orders = orderMapper.selectByExample(orderExample);  // 用户订单list
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        orders.forEach(order -> { // 遍历用户订单, 查询订单明细
            List<OrderDetailDto> orderDetailDtoList = orderDetailMapper.selectOrderDetailByOrderId(order.getId());
            // 将订单信息与订单明细信息组装到map集合中, key为订单信息,value为订单明细list
            String key = Joiner.on("#").useForNull("null").join(new Object[]{order.getId(), order.getOrderNo(),
                    Objects.nonNull(order.getCreateTime()) ? sdf.format(order.getCreateTime()) : "null",
                    Objects.nonNull(order.getFinishTime()) ? sdf.format(order.getFinishTime()) : "null",
                    order.getStatus(), order.getPayAmount()}); // key的格式: 订单id#流水号#创建日期#完成日期#订单状态#总金额
            listMap.put(key, orderDetailDtoList);
        });

        return listMap;
    }

    @Override
    @Transactional
    public boolean updateOrderStatusById(Integer orderId) {
        Order order = new Order();
        order.setStatus("2");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            order.setFinishTime(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        order.setId(orderId);
        return orderMapper.updateByPrimaryKeySelective(order) > 0;
    }

    @Override
    public boolean deleteOrderStatusById(Integer orderId) {
        Order order = new Order();
        order.setStatus("0");
        order.setId(orderId);
        return orderMapper.updateByPrimaryKeySelective(order) > 0;
    }

    @Override
    @Transactional
    public boolean activeOrderByNo(String tradeNo) {
        Order order = new Order();
        order.setStatus("1");
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andOrderNoEqualTo(tradeNo);
        return orderMapper.updateByExampleSelective(order, orderExample) > 0;
    }
}
