package com.provider.project.controller;


import com.provider.project.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yongli
 * @since 2020-08-09
 */
@Controller
public class PersonController {

    @Autowired
    private IPersonService iPersonService;

    @Value("${spring.application.name}")
    private String currentServiceName;

    @PostMapping("/insertPersonVo")
    @ResponseBody
    public Object insertPersonVo(String address){
        Boolean aBoolean = iPersonService.insertPersonVo(address);
        return aBoolean;
    }


    @PostMapping("/insertVoByParams")
    @ResponseBody
    public String insertVoByParams(String city){
        return  iPersonService.insertVoByParams(city);
    }


    /**
     * 获取当前服务名称
     * @return 返回当前服务名称
     */
    @ResponseBody
    @GetMapping("/getServiceName")
    public String getServiceName(){
        return currentServiceName;
    }
}

