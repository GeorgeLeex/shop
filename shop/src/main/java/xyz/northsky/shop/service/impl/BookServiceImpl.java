package xyz.northsky.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.io.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import xyz.northsky.shop.dao.BookMapper;
import xyz.northsky.shop.dto.BookCondition;
import xyz.northsky.shop.dto.BookEditDto;
import xyz.northsky.shop.entity.Book;
import xyz.northsky.shop.entity.BookExample;
import xyz.northsky.shop.service.BookService;
import xyz.northsky.shop.utils.StringUtil;
import xyz.northsky.shop.utils.WebUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class BookServiceImpl implements BookService {


    @Autowired(required = false)
    private BookMapper bookMapper;

    @Override
    public List<Map<String, Object>> selectBookByType(Integer typeId) {
        return null;
    }

    @Override
    public Map<String, Object> seeBookById(Integer bookId) {
        return bookMapper.seeBookById(bookId);
    }

    @Override
    public PageInfo<Object> searchBook(String bookName, Integer typeId, int sortId, int pageNum, int pageSize) {
        bookName = bookName == null || "".equals(bookName) ? null : "%" + bookName + "%";
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> books = bookMapper.searchBook(bookName, typeId, sortId);
        PageInfo pageInfo = new PageInfo(books);
        return pageInfo;
    }

    /**
     * 图书不定条件查询
     * @param condition
     * @return
     */
    public List<Book> selectBookByCondition(BookCondition condition) {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        if (condition != null) {
            if (StringUtil.isNotBlank(condition.getBookName())) {
                criteria.andNameLike("%" + condition.getBookName() + "%");
            }
            if (StringUtil.isNotBlank(condition.getBookAuthor())) {
                criteria.andAuthorLike("%" + condition.getBookAuthor() + "%");
            }
            if (condition.getBeginPrice() != null) {
                criteria.andPriceGreaterThanOrEqualTo(condition.getBeginPrice());
            }
            if (condition.getEndPrice() != null) {
                criteria.andPriceLessThanOrEqualTo(condition.getEndPrice());
            }
            if (condition.getType() != null) {
                criteria.andTypeEqualTo(condition.getType());
            }
        }
        criteria.andStatusEqualTo("1");
        bookExample.setOrderByClause("id desc");
        return bookMapper.selectByExample(bookExample);
    }

    @Override
    public Book selectBookById(Integer bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    @Transactional
    public boolean updateBookById(BookEditDto dto) {
        Book book = convertBookDtoToBook(dto);
        return bookMapper.updateByPrimaryKeySelective(book) > 0;
    }

    private Book convertBookDtoToBook(BookEditDto dto) {
        Book book = new Book();
        MultipartFile image = dto.getImage();
        String fileName = new WebUtil().uploadImgToLocal(image);
        book.setId(dto.getId());
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        book.setDescription(dto.getDescription());
        book.setWordNum(dto.getWordNum());
        book.setPageNum(dto.getPageNum());
        book.setImage(fileName);
        book.setPublishTime(dto.getPublishTime());
        book.setPressId(dto.getPressId());
        book.setInventory(dto.getInventory());
        book.setType(dto.getType());
        return book;
    }



    @Override
    public boolean deleteBookById(Integer bookId) {
        Book book = new Book();
        book.setStatus("0");
        book.setId(bookId);
        return bookMapper.updateByPrimaryKeySelective(book) > 0;
    }

    @Override
    public boolean batchDeleteBookByIds(String ids) {
        boolean isDelete = false;
        if (StringUtil.isNotBlank(ids)) {
            Book book = new Book();
            book.setStatus("0");
            BookExample example = new BookExample();
            example.createCriteria().andIdIn(StringUtil.ConvertIdsToIntegerList(ids));
            isDelete = bookMapper.updateByExampleSelective(book, example) > 0;
        }
        return isDelete;
    }

    @Override
    @Transactional
    public boolean insertBook(BookEditDto dto) {
        Book book = convertBookDtoToBook(dto);
        return bookMapper.insertSelective(book) > 0;
    }


    @Override
    public List<Map<String, Object>> selectBookWithTypeById(Integer id, Integer quantities) {
        List<Map<String, Object>> books = new ArrayList<>(1);
        HashMap<String, Object> book = bookMapper.selectBookWithTypeById(id);
        book.put("id", 0);
        book.put("quantity", quantities);
        books.add(book);
        return books;
    }
}
