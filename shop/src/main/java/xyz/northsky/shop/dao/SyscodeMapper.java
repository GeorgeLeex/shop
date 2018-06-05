package xyz.northsky.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import xyz.northsky.shop.dto.LabelValueBean;
import xyz.northsky.shop.entity.Syscode;
import xyz.northsky.shop.entity.SyscodeExample;

public interface SyscodeMapper {

    List<LabelValueBean> selectLabelValueBeanByType(String type);

    List<Map<String, Object>> selectByType(String type);

    int countByExample(SyscodeExample example);

    int deleteByExample(SyscodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Syscode record);

    int insertSelective(Syscode record);

    List<Syscode> selectByExample(SyscodeExample example);

    Syscode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Syscode record, @Param("example") SyscodeExample example);

    int updateByExample(@Param("record") Syscode record, @Param("example") SyscodeExample example);

    int updateByPrimaryKeySelective(Syscode record);

    int updateByPrimaryKey(Syscode record);

    List<Map<String,Object>> selectTypesByCondition(@Param("secondName") String secondName, @Param("firstType") Integer firstType);

    HashMap<String,Object> selectTypeByTypeId(Integer typeId);
}