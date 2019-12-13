package com.dream.dshop.user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dream.dshop.user.mapper")
@EnableDubbo
public class DshopUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DshopUserServiceApplication.class, args);
    }

}
