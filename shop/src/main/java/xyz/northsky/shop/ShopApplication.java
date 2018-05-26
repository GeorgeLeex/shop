package xyz.northsky.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import xyz.northsky.shop.config.UserFilter;

@SpringBootApplication
@EnableCaching
/*@EnableJpaRepositories*/
@MapperScan("xyz.northsky.shop.dao")
@ServletComponentScan(basePackageClasses = {UserFilter.class})
@EnableScheduling
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }
}
