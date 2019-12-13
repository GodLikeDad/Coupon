package com.dream.dshop.user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DshopUserWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DshopUserWebApplication.class, args);
    }

}
