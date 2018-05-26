package xyz.northsky.shop.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.northsky.shop.config.AlipayConfig;
import xyz.northsky.shop.dto.BookDto;
import xyz.northsky.shop.dto.OrderDetailDto;
import xyz.northsky.shop.dto.OrderInfo;
import xyz.northsky.shop.entity.Address;
import xyz.northsky.shop.entity.User;
import xyz.northsky.shop.service.AddressService;
import xyz.northsky.shop.service.BookService;
import xyz.northsky.shop.service.CartService;
import xyz.northsky.shop.service.OrderService;
import xyz.northsky.shop.utils.ResponseCode;
import xyz.northsky.shop.utils.ResponseMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/order")
public class OrderController implements AlipayConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CartService cartService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String indexOrderSuccess(Model model, HttpServletRequest request) throws Exception {
        String tradeNoStr = request.getParameter("out_trade_no");
        if (tradeNoStr.charAt(tradeNoStr.length() - 1) == '1') {
            String tradeNo = tradeNoStr.substring(0, tradeNoStr.length() - 2);
            model.addAttribute("payAmount", request.getParameter("total_amount"));
            model.addAttribute("tradeNo", tradeNo);
            model.addAttribute("flag", "1");
        } else {
            model.addAttribute("flag", "0");
        }
        return "success";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    @ResponseBody
    public String processOrder() throws Exception{
        return "success";
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public void aliPay(String orderInfo, HttpSession session, HttpServletResponse response) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        OrderInfo info = objectMapper.readValue(orderInfo, OrderInfo.class);

        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APPID, PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest payRequest = new AlipayTradePagePayRequest();
        payRequest.setNotifyUrl(NOTIFY_URL);
        payRequest.setReturnUrl(USER_RETURN_URL);

        String tradeNo = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        List<BookDto> books = info.getBooks();
        StringBuilder sb = new StringBuilder();
        for (BookDto book : books) {
            sb.append("<<").append(book.getBookName()).append(">> ");
        }

        info.setOrderNo(tradeNo);
        info.setCreateTime(new Date());
        String flag = orderService.insertOrder(info) ? "1" : "0";

        payRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+tradeNo+"_"+flag+"\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":"+info.getTotal_amount()+"," +
                "    \"subject\":\""+sb.toString()+"\"" +
                "  }");

        logger.info("userId : " + info.getUserId() + ", tradeNo : " + tradeNo + ", payAmount : " + info.getTotal_amount());

        String result = alipayClient.pageExecute(payRequest).getBody();

        logger.info("result : " + result);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(result);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage saveCartDataToSession(String ids, String quantities, HttpSession session){
        ResponseMessage responseMessage = new ResponseMessage();
        session.setAttribute("ids", ids);
        session.setAttribute("quantities", quantities);
        return responseMessage.code(ResponseCode.OK);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexOrder(ModelMap modelMap, HttpSession session){
        List<Address> addresses = Collections.emptyList(); //用户收货地址
        Object userObject = session.getAttribute("user");
        if (userObject != null) {
            addresses = addressService.selectAddressByUserId(((User) userObject).getId()); // 获取session中的用户id查询用户的收货地址列表
        }

        modelMap.addAttribute("addresses", addresses);

        List<Map<String, Object>> carts =
                cartService.selectCartByCartIds(String.valueOf(session.getAttribute("ids")), String.valueOf(session.getAttribute("quantities")));
        modelMap.put("carts", carts);
        return "pay";
    }

    @RequestMapping(value = "/{userId}/{orderStatus}", method = RequestMethod.GET)
    public String selectOrderByUserId(@PathVariable("userId") Integer userId,
                                      @PathVariable(value = "orderStatus", required = false) Integer orderStatus, Model model) {
        Map<String, List<OrderDetailDto>> orderList = orderService.selectOrdersByUserId(userId, orderStatus);
        model.addAttribute("orders", orderList);
        model.addAttribute("flag", orderStatus);
        return "order";
    }

    /**
     * 立即购买, 根据图书id把查询到的图书信息以及页面选择的购买数量传输到订单页面
     * @param id 图书ID
     * @param quantities 页面选择的购买数量
     * @return
     */
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public String buyNow(Integer id, Integer quantities, Model model, HttpSession session) {

        List<Address> addresses = Collections.emptyList(); //用户收货地址
        Object userObject = session.getAttribute("user");
        if (userObject != null) {
            addresses = addressService.selectAddressByUserId(((User) userObject).getId()); // 获取session中的用户id查询用户的收货地址列表
        }

        model.addAttribute("addresses", addresses);

        List<Map<String, Object>> books = bookService.selectBookWithTypeById(id, quantities);

        model.addAttribute("carts", books);

        return "pay";
    }

    @RequestMapping(value = "/sure", method = RequestMethod.POST)
    public String sureReceive(Integer orderId, HttpSession session){
        boolean isUpdate = orderService.updateOrderStatusById(orderId);
        User user = (User) session.getAttribute("user");
        return "redirect:/order/" + user.getId() + "/1";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteOrderByOrderId(Integer orderId, HttpSession session) {
        boolean isDelete = orderService.deleteOrderStatusById(orderId);
        User user = (User) session.getAttribute("user");
        return "redirect:/order/" + user.getId() + "/2";
    }

}
