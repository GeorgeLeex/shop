package xyz.northsky.shop.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import xyz.northsky.shop.utils.JacksonObjectMapper;

import javax.servlet.Filter;

@Configuration
public class GlobalConfiguration {

    @Bean
    public CacheManager getCacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheManager redisCacheManager = RedisCacheManager.create(redisConnectionFactory);
        return redisCacheManager;
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = JacksonObjectMapper.getInstance();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 序列化时会保存对象的类型信息, 用数组保存, index0为类型信息, index1为值, 会导致普通的json字符串转换成对象失败
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson.setObjectMapper(objectMapper);
        redisTemplate.setValueSerializer(jackson);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new UserFilter());
        bean.addUrlPatterns("/*");
        bean.addServletNames("userFilter");
        return bean;
    }

    /*@Bean(name = "userFilter")
    public Filter userFilter(){
        return new UserFilter();
    }*/

}
