package com.provider.project.service.impl;

import com.provider.project.feignprovider.ConsumerProvider;
import com.provider.project.model.Person;
import com.provider.project.dao.PersonMapper;
import com.provider.project.service.IPersonService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
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
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {
    private final static Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);
    @Resource
    private ConsumerProvider consumerProvider;

    @GlobalTransactional
    @Override
    public Boolean insertPersonVo(String address) {
        Person person = new Person();
        person.setAddress(address);
        boolean insert = this.insert(person);
        //调用consumer分支事务
        consumerProvider.insertVoByParams(address);
        int a=1/0;
        LOGGER.info("插入数据的结构为:{}",insert);
        return insert;

    }

    @GlobalTransactional(name ="test" ,rollbackFor = Exception.class)
    @Override
    public String insertVoByParams(String city) {
        Person person = new Person();
        person.setCity(city);
        boolean insert = this.insert(person);
        return "最终插入结果为:"+String.valueOf(insert);
    }
}
