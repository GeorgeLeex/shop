package xyz.northsky.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.northsky.shop.dto.LabelValueBean;
import xyz.northsky.shop.entity.Menu;
import xyz.northsky.shop.entity.User;
import xyz.northsky.shop.service.*;
import xyz.northsky.shop.utils.ResponseCode;
import xyz.northsky.shop.utils.ResponseMessage;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private SyscodeService syscodeService;

    @Autowired
    private RecomBookService recomBookService;

    @Autowired
    private CartService cartService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexHome(HttpSession session, Model model){
        Map<String, List<LabelValueBean>> bookTypes = syscodeService.selectByType("图书类别");
        session.setAttribute("types", bookTypes);
        List<Map<String, Object>> recomBooks = recomBookService.getCurrentRecomBooks();
        model.addAttribute("recomBooks", recomBooks);
        Object user = session.getAttribute("user");
        int cartNum = 0;
        if (user != null) {
            cartNum = cartService.selectCartNumByUserId(((User) user).getId());// 获取当前购物车商品数量
        }
        session.setAttribute("cartNum", cartNum);
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage userLogin(User user, HttpSession session){
        Optional<User> optionalUser = userService.userIsExist(user);
        ResponseMessage responseMessage = new ResponseMessage();
        if (optionalUser.isPresent()) {

            session.setAttribute("user", optionalUser.get());
            responseMessage.code(ResponseCode.OK);
        } else {
            responseMessage.code(ResponseCode.NO);
        }
        return responseMessage;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String forwardToLogin(){
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut(HttpSession session) {
        session.invalidate();

        return "login";
    }

    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage getMenus(){
        ResponseMessage responseMessage = new ResponseMessage();
        List<Menu> menus = menuService.selectMenus();
        return responseMessage.code(ResponseCode.OK).data(menus);
    }

    @RequestMapping("/admin")
    public String adminIndex(Model model, HttpSession session){
        List<LabelValueBean> list = syscodeService.selectFirstType();
        session.setAttribute("firstTypes", list);
        // 查询图书类别
        List<LabelValueBean> labelValueBeanList = syscodeService.selectLabelValueByType("图书类别");
        session.setAttribute("bookTypes", labelValueBeanList);
        // 查询出版社
        List<LabelValueBean> labelValueBeanList1 = syscodeService.selectLabelValueByType("出版社");
        session.setAttribute("press", labelValueBeanList1);
        return "admin";
    }

}
