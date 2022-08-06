package com.consumer.project.controller;

import com.consumer.project.feignProvider.ProviderServiceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author: yongli
 * @DATE: 2020/8/2 16:40
 */

@Controller
@RequestMapping("/consumer")
public class ConsumerTestController {

    @Resource
    private ProviderServiceProvider providerServiceProvider;

   /* @Value("${server.port}")
    private String serverPort;*/


    @ResponseBody
    @PostMapping("/testMethod")
    public String testMethod(String message){
        return providerServiceProvider.testProvider(message);
    }


   /* @ResponseBody
    @PostMapping("/getPort")
    public String getPort(){
        return "当前的服务端口号是"+serverPort;
    }*/
}
