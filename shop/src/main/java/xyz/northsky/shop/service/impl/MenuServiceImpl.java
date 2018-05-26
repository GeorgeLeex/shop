package xyz.northsky.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import xyz.northsky.shop.dao.MenuMapper;
import xyz.northsky.shop.entity.Menu;
import xyz.northsky.shop.service.MenuService;

import java.util.ArrayList;
import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {

    private final String MENUS = "menus";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired(required = false)
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectMenus() {
        List<Menu> menus = new ArrayList<>();
        Object obj = redisTemplate.opsForValue().get(MENUS);
        if (obj != null && obj instanceof List) {
            menus = ((List<Menu>) obj);
        } else {
            menus = menuMapper.selectByExample(null);
            redisTemplate.opsForValue().set(MENUS, menus);
        }
        return menus;
    }
}
