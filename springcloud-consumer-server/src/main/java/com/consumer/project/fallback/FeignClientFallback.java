package com.consumer.project.fallback;


import com.consumer.project.feignProvider.ProviderServiceProvider;
import org.springframework.stereotype.Component;


/**
 * 为FeignClient 添加回滚类
 */
@Component
public class FeignClientFallback implements ProviderServiceProvider {
    @Override
    public String testProvider(String message) {
        return "我是回滚类里面的一个默认的数据:"+message;
    }

    @Override
    public String testSeata(String city) {
        return null;
    }
}
