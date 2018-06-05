package xyz.northsky.shop.service;

import java.util.List;
import java.util.Map;

public interface RecomBookService {

    void refreshRecommendBook();

    List<Map<String, Object>> getCurrentRecomBooks();

    boolean setRecomBooks(String ids);
}
