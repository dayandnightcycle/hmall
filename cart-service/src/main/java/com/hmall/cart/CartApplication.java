package com.hmall.cart;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@MapperScan("com.hmall.cart.mapper")
@SpringBootApplication
/* 当定义的FeignClient不在SpringBootApplication的扫描包范围时，这些FeignClient无法使用，需要添加basePackages或者clients */
@EnableFeignClients(basePackages = "com.hmall.api.client")
public class CartApplication {
    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);
    }
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}