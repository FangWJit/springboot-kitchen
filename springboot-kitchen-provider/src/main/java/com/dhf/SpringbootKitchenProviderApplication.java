package com.dhf;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration //开启dubbo注解
@MapperScan(basePackages = "com.dhf.dao")
public class SpringbootKitchenProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKitchenProviderApplication.class, args);
    }

}
