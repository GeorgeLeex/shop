package xyz.northsky.shop.service;

import org.springframework.web.multipart.MultipartFile;
import xyz.northsky.shop.dto.UserCondition;
import xyz.northsky.shop.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean userNameIsExist(String userName);

    boolean addUser(User user);

    Optional<User> userIsExist(User user);

    User selectUserById(Integer userId);

    boolean updateUserInfo(User user);

    boolean checkPsdByUserId(User user);

    List<User> selectUsersByCondition(UserCondition user);

    boolean insertUserByUser(User user);

    boolean deleteUserById(Integer userId);

    boolean batchDeleteUserByIds(String ids);

    String uploadImg(MultipartFile img, Integer id);

    User checkAdmin(User user);
}
