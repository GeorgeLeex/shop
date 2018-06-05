package xyz.northsky.shop.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class JacksonObjectMapper {

    private volatile static ObjectMapper singleton = null;

    private JacksonObjectMapper(){}

    public static ObjectMapper getInstance(){
        if (singleton == null) {
            synchronized (ObjectMapper.class) {
                if (singleton == null) {
                    singleton = new ObjectMapper();
                }
            }
        }
        return singleton;
    }

}
