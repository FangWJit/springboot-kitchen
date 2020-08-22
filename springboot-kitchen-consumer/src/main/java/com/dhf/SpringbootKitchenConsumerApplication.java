package com.dhf;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class SpringbootKitchenConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKitchenConsumerApplication.class, args);
    }

}
