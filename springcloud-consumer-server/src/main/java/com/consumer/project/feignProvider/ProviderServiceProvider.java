package com.consumer.project.feignProvider;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: yongl
 * @DATE: 2020/8/2 18:55
 */

@FeignClient(name = "provider-server")
public interface ProviderServiceProvider {


    /**
     * 测试跳转到提供服务的接口
     * 注意请求参数里面一定要加上@RequestParam 注解，要不然值传不过去
     * @param message 测试字符串
     * @return
     */
    @PostMapping("/provider/testProvider")
    String testProvider(@RequestParam(value = "message") String message);


    /**
     * 测试两个微服务之间的seata调用
     * @param city 参数
     * @return 返回一个字符串
     */
    @PostMapping("/person/insertVoByParams")
    String testSeata(@RequestParam(value = "city")String city);
}
