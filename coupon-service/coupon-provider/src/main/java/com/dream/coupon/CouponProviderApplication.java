package com.dream.coupon;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.dream.coupon.dal.mapper")
public class CouponProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponProviderApplication.class, args);
    }

}
