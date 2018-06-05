package xyz.northsky.shop.service;

import java.util.List;
import java.util.Map;

public interface CartService {

    List<Map<String, Object>> selectCartByUserId(Integer userId);

    boolean deleteCartById(Integer cartId);

    boolean batchDeleteCartById(String ids);

    List<Map<String, Object>> selectCartByCartIds(String ids, String quantities);

    Integer selectCartNumByUserId(Integer userId);

    int insertBookToShopcart(Integer userId, Integer bookId, Integer bookNum);
}
