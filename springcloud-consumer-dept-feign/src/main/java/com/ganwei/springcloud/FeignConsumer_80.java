package com.ganwei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Ribbon和Eureka整合以后，我们不用关心服务吗和端口号
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.ganwei.springcloud"})
public class FeignConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumer_80.class,args);
    }
}
