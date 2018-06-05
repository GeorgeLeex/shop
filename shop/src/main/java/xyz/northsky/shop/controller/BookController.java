package xyz.northsky.shop.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import xyz.northsky.shop.dto.BookCondition;
import xyz.northsky.shop.dto.BookEditDto;
import xyz.northsky.shop.entity.Book;
import xyz.northsky.shop.service.BookService;
import xyz.northsky.shop.service.RecomBookService;
import xyz.northsky.shop.utils.ResponseCode;
import xyz.northsky.shop.utils.ResponseMessage;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private RecomBookService recomBookService;

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public String seeBookIntroduction(@PathVariable("bookId") Integer bookId, Model model){
        Map<String, Object> book = bookService.seeBookById(bookId);
        model.addAttribute("book", book);
        // 获取推荐书籍
        List<Map<String, Object>> recomBooks = recomBookService.getCurrentRecomBooks();
        model.addAttribute("recomBooks", recomBooks);
        return "introduction";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String findBookByName(String bookName, Integer typeId, @RequestParam(defaultValue = "1") int sortId,
                                 @RequestParam(defaultValue = "1") int pageNum, Model model) {

        // 条件查询书籍
        PageInfo<Object> pageInfo = bookService.searchBook(bookName, typeId, sortId, pageNum, 12);
        // 获取推荐书籍
        List<Map<String, Object>> recomBooks = recomBookService.getCurrentRecomBooks();
        model.addAttribute("recomBooks", recomBooks);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("bookName", bookName);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("typeId", typeId);
        model.addAttribute("sortId", sortId);
        return "search";
    }

    @RequestMapping(value = "/condition", method = RequestMethod.POST)
    public String searchBookByCondition(BookCondition condition, Model model) {
        List<Book> books = bookService.selectBookByCondition(condition);
        model.addAttribute("books", books);
        model.addAttribute("condition", condition);
        return "admin";
    }

    @RequestMapping(value = "/manage")
    public String bookManageIndex (Model model) {
        List<Book> books = bookService.selectBookByCondition(null);
        model.addAttribute("books", books);
        return "admin";
    }

    @RequestMapping(value = "/manage/{bookId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage findBookById(@PathVariable Integer bookId) {
        Book book = bookService.selectBookById(bookId);
        ResponseMessage responseMessage = new ResponseMessage();
        return responseMessage.data(book);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editBook(BookEditDto dto, Model model) {
        boolean isUpdate = bookService.updateBookById(dto);
        List<Book> books = bookService.selectBookByCondition(null);
        model.addAttribute("books", books);
        model.addAttribute("condition", null);
        return "admin";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, "publishTime", new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = "/manage", method = RequestMethod.DELETE)
    public String deleteBook(Integer bookId, Model model) {
        boolean isDelete = bookService.deleteBookById(bookId);
        List<Book> books = bookService.selectBookByCondition(null);
        model.addAttribute("books", books);
        model.addAttribute("condition", null);
        return "admin";
    }

    @RequestMapping(value = "/manage/batch", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseMessage batchDeleteBook (@RequestParam(value = "id", required = false) String id) {
        System.out.println(id);
        boolean isDelete = bookService.batchDeleteBookByIds(id);
        return new ResponseMessage().code(isDelete ? ResponseCode.OK : ResponseCode.NO);
    }

    @RequestMapping(value = "/manage/add", method = RequestMethod.POST)
    public String insertBook (BookEditDto dto, Model model) {
        boolean isDelete = bookService.insertBook(dto);
        List<Book> books = bookService.selectBookByCondition(null);
        model.addAttribute("books", books);
        model.addAttribute("condition", null);
        return "admin";
    }

    @RequestMapping(value = "/recom", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage setRecommentBooks(String ids) {
        boolean isSet = recomBookService.setRecomBooks(ids);
        return new ResponseMessage().code(isSet ? ResponseCode.OK : ResponseCode.NO);
    }

}
