package com.gateway.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: yongl
 * @DATE: 2020/8/2 16:17
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class GatewayApplication {
    public static void main(String[] args)  {
        SpringApplication.run(GatewayApplication.class, args);
        System.out.println("网关启动成功");
    }

}
