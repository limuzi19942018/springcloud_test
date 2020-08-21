package com.consumer.project.service;

import com.baomidou.mybatisplus.service.IService;
import com.consumer.project.model.CityName;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yongli
 * @since 2020-08-09
 */
public interface ICityNameService extends IService<CityName> {

    String insertVo(String country,String city);

    void insertVoByParams(String city);
}
