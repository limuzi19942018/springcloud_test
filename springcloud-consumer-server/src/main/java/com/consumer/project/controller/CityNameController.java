package com.consumer.project.controller;


import com.consumer.project.feignProvider.ProviderServiceProvider;
import com.consumer.project.result.SuccessTip;
import com.consumer.project.service.ICityNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yongli
 * @since 2020-08-09
 */
@Controller
@RequestMapping("/cityName")
public class CityNameController {

    @Autowired
    private ICityNameService iCityNameService;

    @PostMapping("/insertVo")
    @ResponseBody
    public Object insertVo(String country,String city){
        String s = iCityNameService.insertVo(country, city);
        return new SuccessTip(s);
    }

    @PostMapping("/insertVoByParams")
    @ResponseBody
    public String insertVoByParams(String city){
        iCityNameService.insertVoByParams(city);
        return "插入成功";
    }
}

