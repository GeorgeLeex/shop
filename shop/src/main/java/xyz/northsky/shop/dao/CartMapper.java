package xyz.northsky.shop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import xyz.northsky.shop.entity.Cart;
import xyz.northsky.shop.entity.CartExample;

public interface CartMapper {

    List<Map<String, Object>> selectCartByCartIds(@Param("ids") List<Integer> ids);

    List<Map<String, Object>> selectCartByUserId(@Param("userId") Integer userId);

    int countByExample(CartExample example);

    int deleteByExample(CartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    List<Cart> selectByExample(CartExample example);

    Cart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}