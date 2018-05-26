package xyz.northsky.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.northsky.shop.service.CartService;
import xyz.northsky.shop.utils.ResponseCode;
import xyz.northsky.shop.utils.ResponseMessage;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/cart/batchdelete", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseMessage batchDeleteCart(String ids){
        ResponseMessage responseMessage = new ResponseMessage();
        return responseMessage.code(cartService.batchDeleteCartById(ids) ? ResponseCode.OK : ResponseCode.NO);
    }

    @RequestMapping(value = "/cart/{cartId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseMessage deleteCartById(@PathVariable("cartId") Integer cartId){
        ResponseMessage responseMessage = new ResponseMessage();
        return responseMessage.code(cartService.deleteCartById(cartId) ? ResponseCode.OK : ResponseCode.NO);
    }

    @RequestMapping(value = "/cart/{userId}", method = RequestMethod.GET)
    public String showCartByUserId(@PathVariable(value = "userId", required = false) Integer userId, Model model) {
        List<Map<String, Object>> carts = cartService.selectCartByUserId(userId);
        model.addAttribute("carts", carts);
        return "shopcart";
    }

    @RequestMapping(value = "/cart/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addBookToShopcart (Integer userId, Integer bookId, Integer bookNum, HttpSession session) {
        int cartNum = cartService.insertBookToShopcart(userId, bookId, bookNum);
        ResponseMessage responseMessage = new ResponseMessage();
        ResponseCode responseCode = null;
        switch (cartNum) {
            case -1 : responseCode = ResponseCode.NO;break;
            case 0 : responseCode = ResponseCode.OK;break;
            case 1 :
                responseCode = ResponseCode.OK;
                Object num = session.getAttribute("cartNum");
                if (num != null) {
                    int newNum = ((int) num) + cartNum;
                    session.setAttribute("cartNum", newNum);
                    responseMessage.data(newNum);
                }
        }
        return responseMessage.code(responseCode);
    }

}
