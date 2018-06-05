package xyz.northsky.shop.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import xyz.northsky.shop.dao.SyscodeMapper;
import xyz.northsky.shop.dto.LabelValueBean;
import xyz.northsky.shop.entity.Syscode;
import xyz.northsky.shop.entity.SyscodeExample;
import xyz.northsky.shop.service.SyscodeService;
import xyz.northsky.shop.utils.CollectionUtil;
import xyz.northsky.shop.utils.JacksonObjectMapper;
import xyz.northsky.shop.utils.StringUtil;

import java.util.*;

@Service
public class SyscodeServiceImpl implements SyscodeService {

    @Autowired(required = false)
    private SyscodeMapper syscodeMapper;

    @Autowired
    RedisTemplate redisTemplate;

    private final String BOOK_TYPES_NAME = "bookTypes";

    @Override
    public Map<String, List<LabelValueBean>> selectByType(String type) {
        Map<String, List<LabelValueBean>> bookTypes = new HashMap<>();
        Object types = redisTemplate.opsForValue().get(BOOK_TYPES_NAME);
        if (types != null) {
            ObjectMapper objectMapper = JacksonObjectMapper.getInstance();
            Map hashMap = objectMapper.convertValue(types, Map.class);
            return hashMap;
        }

        updateCacheTypes(type, bookTypes);

        return bookTypes;
    }

    private void updateCacheTypes(String type, Map<String, List<LabelValueBean>> bookTypes) {
        List<Map<String, Object>> mapList = syscodeMapper.selectByType(type);
        if (CollectionUtil.isNotEmpty(mapList)) {
            mapList.forEach(map -> {
                Object fName = map.get("f_name");
                LabelValueBean labelValueBean = new LabelValueBean(String.valueOf(map.get("pro_name")), String.valueOf(map.get("id")));

                if (bookTypes.containsKey(fName)) {
                    List<LabelValueBean> labelValueBeans = bookTypes.get(fName);
                    labelValueBeans.add(labelValueBean);
                } else {
                    List<LabelValueBean> labelValueBeans = new ArrayList<>();
                    labelValueBeans.add(labelValueBean);
                    bookTypes.put(String.valueOf(fName), labelValueBeans);
                }

            });
            redisTemplate.opsForValue().set(BOOK_TYPES_NAME, bookTypes);
        }
    }

    @Override
    public List<LabelValueBean> selectLabelValueByType(String type) {
        return syscodeMapper.selectLabelValueBeanByType(type);
    }

    @Override
    public List<LabelValueBean> selectFirstType() {
        List<LabelValueBean> labelValueBeanList = new ArrayList<>();
        SyscodeExample syscodeExample = new SyscodeExample();
        syscodeExample.createCriteria().andTypeEqualTo("图书类别").andFIdIsNull().andStatusEqualTo("1");
        List<Syscode> syscodes = syscodeMapper.selectByExample(syscodeExample);
        if (CollectionUtil.isNotEmpty(syscodes)) {
            syscodes.forEach(syscode -> {
                LabelValueBean labelValueBean = new LabelValueBean(syscode.getProName(), syscode.getId().toString());
                labelValueBeanList.add(labelValueBean);
            });
        }
        return labelValueBeanList;
    }

    @Override
    public List<Map<String, Object>> selectTypesByCondition(String secondName, Integer firstType) {

        secondName = StringUtil.isNotBlank(secondName) ? "%" + secondName + "%" : null;
        List<Map<String, Object>> mapList = syscodeMapper.selectTypesByCondition(secondName, firstType);
        return mapList;
    }

    @Override
    public HashMap<String, Object> selectTypeByTypeId(Integer typeId) {
        return syscodeMapper.selectTypeByTypeId(typeId);
    }

    @Override
    public boolean updateTypeSelective(Syscode syscode) {
        boolean isUpdate = syscodeMapper.updateByPrimaryKeySelective(syscode) > 0;
        if (isUpdate) {
            updateCacheTypes("图书类别", new HashMap<>());
        }
        return isUpdate;
    }

    @Override
    public boolean insertType(Syscode syscode) {
        syscode.setType("图书类别");
        boolean isInsert = syscodeMapper.insertSelective(syscode) > 0;
        if (isInsert) {
            updateCacheTypes("图书类别", new HashMap<>());
        }
        return isInsert;
    }

    @Override
    public boolean deleteTypeById(Integer typeId) {
        Syscode syscode = new Syscode();
        syscode.setStatus("0");
        syscode.setId(typeId);
        boolean isDelete = syscodeMapper.updateByPrimaryKeySelective(syscode) > 0;
        if (isDelete) {
            updateCacheTypes("图书类别", new HashMap<>());
        }
        return isDelete;
    }

    @Override
    public boolean batchDeleteByIds(String ids) {

        if (StringUtil.isNotBlank(ids)) {
            List<Integer> list = StringUtil.ConvertIdsToIntegerList(ids);
            if (CollectionUtil.isNotEmpty(list)) {
                Syscode syscode = new Syscode();

                SyscodeExample syscodeExample = new SyscodeExample();
                SyscodeExample.Criteria criteria = syscodeExample.createCriteria();

                syscode.setStatus("0");
                criteria.andIdIn(list);
                boolean isDelete = syscodeMapper.updateByExampleSelective(syscode, syscodeExample) > 0;
                if (isDelete) {
                    updateCacheTypes("图书类别", new HashMap<>());
                }
                return isDelete;
            }
        }

        return false;
    }

    @Override
    public Syscode selectSyscodeById(Integer pressId) {
        return syscodeMapper.selectByPrimaryKey(pressId);
    }

    @Override
    public List<LabelValueBean> selectPressByCondition(String proName) {
        SyscodeExample syscodeExample = new SyscodeExample();
        SyscodeExample.Criteria criteria = syscodeExample.createCriteria();
        if (StringUtil.isNotBlank(proName)) {
            criteria.andProNameLike("%" + proName + "%");
        }
        criteria.andTypeEqualTo("出版社");
        criteria.andStatusEqualTo("1");
        syscodeExample.setOrderByClause("id desc");
        List<LabelValueBean> labelValueBeanList = new ArrayList<>();
        List<Syscode> syscodes = syscodeMapper.selectByExample(syscodeExample);
        if (CollectionUtil.isNotEmpty(syscodes)) {
            syscodes.forEach(syscode -> {
                LabelValueBean labelValueBean = new LabelValueBean(syscode.getProName(), syscode.getId().toString());
                labelValueBeanList.add(labelValueBean);

            });
        }
        return labelValueBeanList;
    }

    @Override
    public boolean insertPress(String proName) {
        Syscode syscode = new Syscode();
        syscode.setProName(proName);
        syscode.setType("出版社");
        return syscodeMapper.insertSelective(syscode) > 0;
    }

    @Override
    public boolean updatePressSelective(Syscode syscode) {

        return syscodeMapper.updateByPrimaryKeySelective(syscode) > 0;
    }

    @Override
    public boolean deletePressById(Integer pressId) {
        Syscode syscode = new Syscode();
        syscode.setStatus("0");
        syscode.setId(pressId);
        return syscodeMapper.updateByPrimaryKeySelective(syscode) > 0;
    }

    @Override
    public boolean batchDeletePressByIds(String id) {
        if (StringUtil.isNotBlank(id)) {
            List<Integer> list = StringUtil.ConvertIdsToIntegerList(id);
            if (CollectionUtil.isNotEmpty(list)) {
                Syscode syscode = new Syscode();
                syscode.setStatus("0");
                SyscodeExample syscodeExample = new SyscodeExample();
                syscodeExample.createCriteria().andIdIn(list);
                return syscodeMapper.updateByExampleSelective(syscode, syscodeExample) > 0;
            }
        }
        return false;
    }
}
