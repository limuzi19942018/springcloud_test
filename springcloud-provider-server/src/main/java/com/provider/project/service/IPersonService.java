package com.provider.project.service;

import com.provider.project.model.Person;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yongli
 * @since 2020-08-09
 */
public interface IPersonService extends IService<Person> {

    Boolean insertPersonVo(String address);

    String insertVoByParams(String city);
}
