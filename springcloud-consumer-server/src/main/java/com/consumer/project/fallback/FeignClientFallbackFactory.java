package com.consumer.project.fallback;

import com.consumer.project.feignProvider.ProviderServiceProvider;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * 为ProviderServiceProvider FeignClient 创建回滚类，这个类要实现FallbackFactory
 * 并重写create方法，这个类可以打印目标服务的异常
 */
@Component
@Slf4j
public class FeignClientFallbackFactory implements FallbackFactory<ProviderServiceProvider> {
    @Override
    public ProviderServiceProvider create(Throwable throwable) {
        return new ProviderServiceProvider() {
            @Override
            public String testProvider(String message) {
                //异常日志最好放在各个fallback方法里面
                log.error("异常信息为：",throwable);
                return "我是异常返回的默认信息："+message;
            }

            @Override
            public String testSeata(String city) {
                return null;
            }
        };
    }
}
