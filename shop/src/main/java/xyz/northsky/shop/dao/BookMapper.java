package xyz.northsky.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import xyz.northsky.shop.entity.Book;
import xyz.northsky.shop.entity.BookExample;

public interface BookMapper {

    List<Map<String, Object>> selectBookByType(@Param("typeId") Integer typeId);

    Map<String, Object> seeBookById(@Param("bookId") Integer bookId);

    List<Map<String, Object>> selectRecomBooks();

    List<Map<String, Object>> searchBook(@Param("bookName") String bookName, @Param("typeId") Integer typeId, @Param("sortId") int sortId);

    int countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Map<String,Object>> selectRecomBooksByIds(@Param("ids") List<Integer> ids);

    HashMap<String,Object> selectBookWithTypeById(Integer id);

}