package xyz.northsky.shop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.northsky.shop.dto.OrderDetailDto;
import xyz.northsky.shop.entity.OrderDetail;
import xyz.northsky.shop.entity.OrderDetailExample;

public interface OrderDetailMapper {
    int countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    OrderDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    List<OrderDetailDto> selectOrderDetailByOrderId(Integer orderId);
}