package com.yongli.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: yongli
 * @DATE: 2020/8/2 16:40
 */

@Controller
@RequestMapping("/consumerTest")
public class ConsumerTestController {


    @ResponseBody
    @PostMapping("/testMethod")
    public Object testMethod(String message){
        return message;
    }
}
