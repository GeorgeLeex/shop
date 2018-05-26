package xyz.northsky.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.northsky.shop.dao.CartMapper;
import xyz.northsky.shop.entity.Cart;
import xyz.northsky.shop.entity.CartExample;
import xyz.northsky.shop.service.CartService;
import xyz.northsky.shop.utils.CollectionUtil;
import xyz.northsky.shop.utils.StringUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired(required = false)
    private CartMapper cartMapper;

    public boolean batchDeleteCartById(String ids) {
        CartExample cartExample = new CartExample();
        if (StringUtil.isNotBlank(ids)) {
            cartExample.createCriteria().andIdIn(
                    Arrays.stream(ids.split(",")).map(s -> {
                        return Integer.valueOf(s);
                    }).collect(Collectors.toList())
            );
        }
        Cart cart = new Cart();
        cart.setStatus("0");
        return cartMapper.updateByExampleSelective(cart, cartExample) > 0;
    }

    @Override
    public boolean deleteCartById(Integer cartId) {
        Cart cart = new Cart();
        cart.setId(cartId);
        cart.setStatus("0");
        return cartMapper.updateByPrimaryKeySelective(cart) > 0;
    }

    @Override
    public List<Map<String, Object>> selectCartByUserId(Integer userId) {
        return cartMapper.selectCartByUserId(userId);
    }

    @Override
    public List<Map<String, Object>> selectCartByCartIds(String idsStr, String quantitiesStr) {
        List<Integer> ids = null;
        if (StringUtil.isNotBlank(idsStr)) {
            ids = Arrays.stream(idsStr.split(",")).map(s -> {
                return Integer.valueOf(s.trim());
            }).collect(Collectors.toList());
        }
        List<Integer> quantities = null;
        if (StringUtil.isNotBlank(quantitiesStr)) {
            quantities = Arrays.stream(quantitiesStr.split(",")).map(s -> {
                return Integer.valueOf(s.trim());
            }).collect(Collectors.toList());
        }

        List<Map<String, Object>> carts = cartMapper.selectCartByCartIds(ids);

        if (CollectionUtil.isNotEmpty(carts)) {
            for (Map<String, Object> cart : carts) {
                for (int i = 0; i < ids.size(); i++) {
                    if (ids.get(i).equals(Integer.valueOf(cart.get("id").toString()))) {
                        cart.put("quantity", quantities.get(i));
                        break;
                    }
                }
            }
        }

        return carts;
    }

    /**
     * 根据用户id查询用户购物车商品数量
     * @param userId
     * @return
     */
    @Override
    public Integer selectCartNumByUserId(Integer userId) {
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andStatusEqualTo("1").andUserIdEqualTo(userId);
        return cartMapper.countByExample(cartExample);
    }

    /**
     * 插入图书或更新图书数量到用户购物车
     * @param userId
     * @param bookId
     * @param bookNum
     * @return
     */
    @Override
    @Transactional
    public int insertBookToShopcart(Integer userId, Integer bookId, Integer bookNum) {
        CartExample cartExample = new CartExample();
        int i = -1; // 操作结果, -1表示操作失败, 0表示更新成功, 1表示插入新纪录成功
        // 根据用户id和图书id查询用户购物车信息
        cartExample.createCriteria().andUserIdEqualTo(userId).andBookIdEqualTo(bookId).andStatusEqualTo("1");
        List<Cart> carts = cartMapper.selectByExample(cartExample);
        if (CollectionUtil.isNotEmpty(carts)) {
            // 记录不为空,表示图书已存在用户购物车中, 更新购物车图书数量
            Cart cart = new Cart();
            cart.setQuantity(carts.get(0).getQuantity() + bookNum);
            cart.setId(carts.get(0).getId());
            i = cartMapper.updateByPrimaryKeySelective(cart) > 0 ? 0 : -1;
        } else {
            // 插入图书记录
            Cart cart = new Cart();
            cart.setUserId(userId);
            cart.setBookId(bookId);
            cart.setQuantity(bookNum);
            i = cartMapper.insertSelective(cart) > 0 ? 1 : -1;
        }
        return i;
    }
}
