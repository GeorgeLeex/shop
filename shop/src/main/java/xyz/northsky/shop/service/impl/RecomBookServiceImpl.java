package xyz.northsky.shop.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xyz.northsky.shop.dao.BookMapper;
import xyz.northsky.shop.service.RecomBookService;
import xyz.northsky.shop.utils.CollectionUtil;
import xyz.northsky.shop.utils.JacksonObjectMapper;
import xyz.northsky.shop.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 刷新推荐书籍
 */
@Component
public class RecomBookServiceImpl implements RecomBookService {

    @Autowired(required = false)
    private BookMapper bookMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    private final String RECOM_BOOKS = "recomBooks";

    /**
     * 获取当前最新的推荐书籍
     * @return
     */
    @Override
    public List<Map<String, Object>> getCurrentRecomBooks() {
        List<Map<String, Object>> mapList = new ArrayList<>();
        Object o = redisTemplate.opsForValue().get(RECOM_BOOKS);
        if (o != null) {
            ObjectMapper objectMapper = JacksonObjectMapper.getInstance();
            if (o instanceof List) {
                mapList = objectMapper.convertValue(o, List.class);
            }
        } else {
            mapList = bookMapper.selectRecomBooks();
            redisTemplate.opsForValue().set(RECOM_BOOKS, mapList);
        }
        return mapList;
    }

    @Override
    // 每天每三小时执行一次
    @Scheduled(cron = "0 0 0/3 1/1 1/1 ?")
    // 每分钟执行一次
    //@Scheduled(cron = "0 0/1 0/1 1/1 1/1 ?")
    public void refreshRecommendBook() {

        List<Map<String, Object>> books = bookMapper.selectRecomBooks();
        redisTemplate.opsForValue().set(RECOM_BOOKS, books);

    }

    @Override
    public boolean setRecomBooks(String ids) {
        if (StringUtil.isNotBlank(ids)) {
            List<Integer> list = StringUtil.ConvertIdsToIntegerList(ids);
            if (CollectionUtil.isNotEmpty(list)) {
                List<Map<String, Object>> books = bookMapper.selectRecomBooksByIds(list);
                redisTemplate.opsForValue().set(RECOM_BOOKS, books);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
