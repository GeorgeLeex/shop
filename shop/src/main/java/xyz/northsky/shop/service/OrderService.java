package xyz.northsky.shop.service;

import xyz.northsky.shop.dto.OrderDetailDto;
import xyz.northsky.shop.dto.OrderInfo;

import java.util.List;
import java.util.Map;

public interface OrderService {

    boolean insertOrder(OrderInfo orderInfo);

    Map<String,List<OrderDetailDto>> selectOrdersByUserId(Integer userId, Integer orderStatus);

    boolean updateOrderStatusById(Integer orderId);

    boolean deleteOrderStatusById(Integer orderId);
}
