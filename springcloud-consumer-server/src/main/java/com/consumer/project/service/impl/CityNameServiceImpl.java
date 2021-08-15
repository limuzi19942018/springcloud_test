package com.consumer.project.service.impl;

import com.consumer.project.feignProvider.ProviderServiceProvider;
import com.consumer.project.model.CityName;
import com.consumer.project.dao.CityNameMapper;
import com.consumer.project.service.ICityNameService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yongli
 * @since 2020-08-09
 */
@Service
public class CityNameServiceImpl extends ServiceImpl<CityNameMapper, CityName> implements ICityNameService {
    @Resource
    private CityNameMapper cityNameMapper;
    @Resource
    private ProviderServiceProvider providerServiceProvider;

    private final static Logger LOGGER = LoggerFactory.getLogger(CityNameServiceImpl.class);

    //@GlobalTransactional(name ="test",rollbackFor = Exception.class)
    @Override
    public String insertVo(String country,String city) {
        CityName cityName = new CityName();
        cityName.setCity(city);
        cityName.setCountry(country);
        //本地事务
        boolean insert=this.insert(cityName);
        //微服务事务（feignclient调用）
        String s = providerServiceProvider.testSeata(city);
        //伪造异常
        int a=1/0;
        LOGGER.info("插入是否成功的标示:{}",s);
        return s;
    }

    //@GlobalTransactional
    @Override
    public void insertVoByParams(String city) {
        CityName cityName = new CityName();
        cityName.setCity(city);
        //本地事务
        boolean insert=this.insert(cityName);
    }
}
