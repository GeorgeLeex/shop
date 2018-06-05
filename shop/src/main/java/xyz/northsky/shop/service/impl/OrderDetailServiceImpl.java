package xyz.northsky.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.northsky.shop.dao.OrderDetailMapper;
import xyz.northsky.shop.entity.OrderDetail;
import xyz.northsky.shop.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired(required = false)
    private OrderDetailMapper orderDetailMapper;

    @Override
    @Transactional
    public int insertOrderDetail(OrderDetail orderDetail) {
        return orderDetailMapper.insertSelective(orderDetail);
    }
}
