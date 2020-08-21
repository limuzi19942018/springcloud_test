package com.provider.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: yongl
 * @DATE: 2020/8/2 18:49
 */

@Controller
@RequestMapping("/provider")
public class ProviderTestController {

    @PostMapping("/testProvider")
    @ResponseBody
    public String testProvider(String message){
        return "我是消费者提供的"+message;
    }
}
