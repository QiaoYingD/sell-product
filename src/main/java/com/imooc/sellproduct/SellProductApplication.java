package com.imooc.sellproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.imooc.sellproduct.mapper"})
public class SellProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellProductApplication.class, args);
    }

}
