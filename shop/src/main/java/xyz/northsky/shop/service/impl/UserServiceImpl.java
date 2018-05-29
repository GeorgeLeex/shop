package xyz.northsky.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import xyz.northsky.shop.dao.UserMapper;
import xyz.northsky.shop.dto.UserCondition;
import xyz.northsky.shop.entity.User;
import xyz.northsky.shop.entity.UserExample;
import xyz.northsky.shop.service.UserService;
import xyz.northsky.shop.utils.CollectionUtil;
import xyz.northsky.shop.utils.StringUtil;
import xyz.northsky.shop.utils.WebUtil;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    @Override
    public Optional<User> userIsExist(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andNickNameEqualTo(user.getNickName())
                .andPasswordEqualTo(user.getPassword());
        List<User> users = userMapper.selectByExample(userExample);
        Optional<User> optional = users != null && users.size() > 0 ? Optional.ofNullable(users.get(0)) : Optional.empty();
        return optional;
    }

    @Override
    @Transactional
    public boolean addUser(User user) {
        user.setStatus("1");
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean userNameIsExist(String userName) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNickNameEqualTo(userName);
        int i = userMapper.countByExample(userExample);
        boolean isExist = i > 0;
        return isExist;
    }

    /**
     * 根据用户id查询用户个人信息
     * @param userId
     * @return
     */
    @Override
    public User selectUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 根据用户id更新用户个人信息
     * @param user
     * @return
     */
    @Override
    public boolean updateUserInfo(User user) {
        return userMapper.updateByPrimaryKeySelective(user) > 0;
    }

    /**
     * 根据用户id和密码查询是否有符合的记录
     * @param user
     * @return
     */
    @Override
    public boolean checkPsdByUserId(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(user.getId()).andPasswordEqualTo(user.getPassword()).andStatusEqualTo("1");
        return userMapper.countByExample(userExample) > 0;
    }

    @Override
    public List<User> selectUsersByCondition(UserCondition condition) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (condition != null) {
            if (StringUtil.isNotBlank(condition.getUserName())) {
                criteria.andNickNameLike("%" + condition.getUserName() + "%");
            }
            if (condition.getUserGender() != null && !("2".equals(condition.getUserGender()))) {
                criteria.andGenderEqualTo(condition.getUserGender());
            }
            if (condition.getUserBirth() != null) {
                criteria.andBirthEqualTo(condition.getUserBirth());
            }
            if (StringUtil.isNotBlank(condition.getUserTel())) {
                criteria.andTelLike("%" + condition.getUserTel() + "%");
            }
        }
        criteria.andStatusEqualTo("1");
        userExample.setOrderByClause("id desc");
        return userMapper.selectByExample(userExample);
    }

    @Override
    @Transactional
    public boolean insertUserByUser(User user) {
        return userMapper.insertSelective(user) > 0;
    }

    @Override
    public boolean deleteUserById(Integer userId) {
        User user = new User();
        user.setStatus("0");
        user.setId(userId);
        return userMapper.updateByPrimaryKeySelective(user) > 0;
    }

    @Override
    public boolean batchDeleteUserByIds(String ids) {
        User user = new User();
        user.setStatus("0");
        UserExample userExample = new UserExample();
        List<Integer> list = StringUtil.ConvertIdsToIntegerList(ids);
        if (CollectionUtil.isNotEmpty(list)) {
            userExample.createCriteria().andIdIn(list);
        } else {
            return false;
        }
        return userMapper.updateByExampleSelective(user, userExample) > 0;
    }

    @Override
    public String uploadImg(MultipartFile img, Integer id) {
        String fileName = new WebUtil().uploadImgToLocal(img);
        User user = new User();
        user.setImg(fileName);
        user.setId(id);
        return userMapper.updateByPrimaryKeySelective(user) > 0 ? fileName : null;
    }

    @Override
    public User checkAdmin(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(user.getName()).andPasswordEqualTo(user.getPassword()).andStatusEqualTo("3");
        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtil.isNotEmpty(users)) {
            return users.get(0);
        } else {
            return null;
        }
    }
}
