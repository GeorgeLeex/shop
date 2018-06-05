package xyz.northsky.shop.service;

import com.github.pagehelper.PageInfo;
import xyz.northsky.shop.dto.BookCondition;
import xyz.northsky.shop.dto.BookEditDto;
import xyz.northsky.shop.entity.Book;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface BookService {

    List<Map<String, Object>> selectBookByType(Integer typeId);

    Map<String, Object> seeBookById(Integer bookId);

    PageInfo<Object> searchBook(String bookName, Integer typeId, int sortId, int pageNum, int pageSize);

    List<Book> selectBookByCondition(BookCondition condition);

    Book selectBookById(Integer bookId);

    boolean updateBookById(BookEditDto dto);

    boolean deleteBookById(Integer bookId);

    boolean batchDeleteBookByIds(String ids);

    boolean insertBook(BookEditDto dto);

    List<Map<String,Object>> selectBookWithTypeById(Integer id, Integer quantities);
}
