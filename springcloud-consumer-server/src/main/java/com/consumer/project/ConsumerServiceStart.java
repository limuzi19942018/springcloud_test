package com.consumer.project;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan(basePackageClasses = ConsumerServiceStart.class)
@MapperScan(basePackages = {"com.consumer.project.dao"})
public class ConsumerServiceStart {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceStart.class, args);
        System.out.println("启动成功！");
    }

}
