package com.consumer.project.controller;

import com.consumer.project.feignProvider.ProviderServiceProvider;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: yongli
 * @DATE: 2020/8/2 16:40
 */

@Controller
@RequestMapping("/consumer")
@Slf4j
public class ConsumerTestController {

    @Resource
    private ProviderServiceProvider providerServiceProvider;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${spring.application.name}")
    private String currentServiceName;


    /**
     * 获取当前服务名称
     * @return 返回当前服务名称
     */
    @ResponseBody
    @GetMapping("/getServiceName")
    public String getServiceName(){
        return currentServiceName;
    }


    /**
     * 调用另外一个微服务的测试方法
     * @param message
     * @return
     */
    @ResponseBody
    @PostMapping("/testMethod")
    public String testMethod(String message){
        return providerServiceProvider.testProvider(message);
    }


    @ResponseBody
    @GetMapping("/getPort")
    public String getPort(){
        return "当前的服务端口号是"+serverPort;
    }


    /**
     * 该接口为了测试调用provider负载均衡使用的
     */
    @GetMapping("/getProviderService")
    public void getProviderService(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider-server");
        log.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }


}
