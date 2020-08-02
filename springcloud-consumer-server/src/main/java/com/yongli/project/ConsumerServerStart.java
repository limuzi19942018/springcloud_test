package com.yongli.project;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: yongl
 * @DATE: 2020/7/30 16:33
 */

@SpringBootApplication
//扫描监听器
@ServletComponentScan
//确保在后台创建一个任务执行者
@EnableSwagger2
@EnableFeignClients
@EnableDiscoveryClient
public class ConsumerServerStart {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServerStart.class, args);
        System.out.println("启动成功！");
    }

}
