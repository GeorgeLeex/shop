package xyz.northsky.shop.service;

import xyz.northsky.shop.dto.LabelValueBean;
import xyz.northsky.shop.entity.Syscode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SyscodeService {

    Map<String, List<LabelValueBean>> selectByType(String type);

    List<LabelValueBean> selectLabelValueByType(String type);

    List<LabelValueBean> selectFirstType();

    List<Map<String,Object>> selectTypesByCondition(String secondName, Integer firstType);

    HashMap<String,Object> selectTypeByTypeId(Integer typeId);

    boolean updateTypeSelective(Syscode syscode);

    boolean insertType(Syscode syscode);

    boolean deleteTypeById(Integer typeId);

    boolean batchDeleteByIds(String ids);

    Syscode selectSyscodeById(Integer pressId);

    List<LabelValueBean> selectPressByCondition(String proName);

    boolean insertPress(String proName);

    boolean updatePressSelective(Syscode syscode);

    boolean deletePressById(Integer pressId);

    boolean batchDeletePressByIds(String id);
}
