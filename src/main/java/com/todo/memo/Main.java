package com.todo.memo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
// import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by gddev3 on 16/5/26.
 */
@SpringBootApplication
@EnableConfigurationProperties()
// @EnableFeignClients
 @EnableEurekaClient
@EnableTransactionManagement
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    public void run(){
        System.out.println("");
    }

}
