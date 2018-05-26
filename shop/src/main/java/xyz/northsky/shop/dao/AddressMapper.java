package xyz.northsky.shop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.northsky.shop.entity.Address;
import xyz.northsky.shop.entity.AddressExample;

public interface AddressMapper {

    int saveAddressForUser(Address address);

    int countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}