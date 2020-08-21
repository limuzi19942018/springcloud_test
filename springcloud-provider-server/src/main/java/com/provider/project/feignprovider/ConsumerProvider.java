package com.provider.project.feignprovider;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: yongl
 * @DATE: 2020/8/21 13:42
 */

@FeignClient(name = "consumer-server")
public interface ConsumerProvider {


    @PostMapping("/cityName/insertVoByParams")
    String insertVoByParams(@RequestParam("city")String city);
}
