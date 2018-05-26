package xyz.northsky.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.northsky.shop.service.MenuService;

@Controller
public class HelloController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/address")
    public String test1(){
        return "address";
    }

    @RequestMapping("/home")
    public String test22(){
        return "home";
    }

    @RequestMapping("/index")
    public String test3(){
        return "index";
    }

    @RequestMapping("/information")
    public String testSpringBoot1(){
        return "information";
    }

    @RequestMapping("/introduction")
    public String test4(){
        return "introduction";
    }

    @RequestMapping("/login")
    public String test5(){
        return "login";
    }

    @RequestMapping("/order")
    public String test6(){
        return "order";
    }

    @RequestMapping("/password")
    public String test7(){
        return "password";
    }

    @RequestMapping("/pay")
    public String test8(){
        return "pay";
    }

    @RequestMapping("/register")
    public String test9(){
        return "register";
    }

    @RequestMapping("/search")
    public String test10(){
        return "search";
    }

    @RequestMapping("/shopcart")
    public String test11(){
        return "shopcart";
    }

    @RequestMapping("/success")
    public String test2(){
        return "success";
    }

    /*@RequestMapping("/admin")
    public String test12(){
        return "admin";
    }*/

    @RequestMapping("/table")
    public String test13(){
        return "table";
    }

    @RequestMapping("/bookedit")
    public String editBook () {
        return "bookedit";
    }

    @GetMapping("/adminlogin")
    public String index13(){
        return "adminlogin";
    }
}
