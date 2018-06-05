package xyz.northsky.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import xyz.northsky.shop.dto.UserCondition;
import xyz.northsky.shop.entity.User;
import xyz.northsky.shop.service.UserService;
import xyz.northsky.shop.utils.ResponseCode;
import xyz.northsky.shop.utils.ResponseMessage;
import xyz.northsky.shop.utils.StringUtil;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/namecheck", method = RequestMethod.POST)
    @ResponseBody
    public String checkUserNameIsExist (String userName){
        boolean isExist = userService.userNameIsExist(userName);
        return String.valueOf(isExist);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String informationIndex(@PathVariable("userId") Integer userId, Model model){
        User user = userService.selectUserById(userId);
        model.addAttribute("userInfo", user);
        return "information";
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String updateUserInfo(User user) {
        String updateMsg = userService.updateUserInfo(user) ? "成功" : "失败";
        logger.info("用户信息更新" + updateMsg + ":" + user);
        return "redirect:/user/" + user.getId();
    }

    @RequestMapping(value = "/password", method = RequestMethod.GET)
    public String passwordIndex() {
        return "password";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = "/psdcheck", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage checkPsdByUserId(User user) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.code(userService.checkPsdByUserId(user)? ResponseCode.OK : ResponseCode.NO);
        return responseMessage;
    }

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage updateUserPassword(User user) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.code(userService.updateUserInfo(user)? ResponseCode.OK : ResponseCode.NO);
        return responseMessage;
    }

    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String userManageIndex(Model model) {
        List<User> userList = userService.selectUsersByCondition(null);
        model.addAttribute("users", userList);
        return "usermanage";
    }

    @RequestMapping(value = "/condition", method = RequestMethod.POST)
    public String selectUserByCondition(UserCondition condition, Model model) {
        List<User> users = userService.selectUsersByCondition(condition);
        model.addAttribute("condition", condition);
        model.addAttribute("users", users);
        return "usermanage";
    }

    @RequestMapping(value = "/manage/add", method = RequestMethod.POST)
    public String insertUser(User user, Model model) {
        boolean isAdd = userService.insertUserByUser(user);
        List<User> userList = userService.selectUsersByCondition(null);
        model.addAttribute("users", userList);
        return "usermanage";
    }

    @RequestMapping(value = "/manage/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage selectUserById(@PathVariable("userId") Integer userId, Model model) {
        ResponseMessage responseMessage = new ResponseMessage();
        User user = userService.selectUserById(userId);
        return responseMessage.data(user);
    }

    @RequestMapping(value = "/manage/edit", method = RequestMethod.POST)
    public String editUser(User user, Model model){
        boolean isUpdate = userService.updateUserInfo(user);
        List<User> userList = userService.selectUsersByCondition(null);
        model.addAttribute("users", userList);
        return "usermanage";
    }

    @RequestMapping(value = "/manage", method = RequestMethod.DELETE)
    public String deleteUserById(Integer userId, Model model) {
        boolean isDelete = userService.deleteUserById(userId);
        List<User> userList = userService.selectUsersByCondition(null);
        model.addAttribute("users", userList);
        return "usermanage";
    }

    @RequestMapping(value = "/manage/batch", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseMessage batchDeleteUserByIds(@RequestParam("ids") String ids) {
        boolean isDelete = userService.batchDeleteUserByIds(ids);
        return new ResponseMessage().code(isDelete ? ResponseCode.OK : ResponseCode.NO);
    }

    @PostMapping("/img")
    @ResponseBody
    public ResponseMessage uploadImg(MultipartFile img, HttpSession session) {
        System.out.println(img);
        User user = (User) session.getAttribute("user");
        String imgPath = userService.uploadImg(img, user.getId());
        ResponseMessage responseMessage = new ResponseMessage();
        if (StringUtil.isNotBlank(imgPath)) {
            responseMessage.code(ResponseCode.OK);
            responseMessage.data(imgPath);
            user.setImg(imgPath);
            session.setAttribute("user", user);
        } else {
            responseMessage.code(ResponseCode.NO);
        }

        return responseMessage;
    }

    @PostMapping("/admin/login")
    @ResponseBody
    public ResponseMessage adminLogin(User user, HttpSession session) {
        ResponseMessage responseMessage = new ResponseMessage();
        User admin = userService.checkAdmin(user);
        if (admin == null) {
            responseMessage.code(ResponseCode.NO);
        } else {
            session.setAttribute("admin", admin);
            responseMessage.code(ResponseCode.OK);
        }
        return responseMessage;
    }

    @GetMapping("/admin/logout")
    public String adminLogOut(HttpSession session){
        session.invalidate();
        return "adminlogin";
    }
}
