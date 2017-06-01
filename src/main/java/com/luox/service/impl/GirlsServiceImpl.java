package com.luox.service.impl;

import com.luox.entity.Girl;
import com.luox.enums.ResultEnum;
import com.luox.repositoty.GirlRepository;
import com.luox.service.GirlsService;
import com.luox.utils.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by luox on 2017/6/1.
 */
@Service
public class GirlsServiceImpl implements GirlsService {

    @Autowired
    private GirlRepository girlRepository;


    @Override
    @Transactional
    public void insertTwo() {
        Girl girl1 = new Girl();
        girl1.setCupSize("A");
        girl1.setAge(16);
        girlRepository.save(girl1);

        Girl girl2 = new Girl();
        girl2.setCupSize("EE");
        girl2.setAge(22);
        girlRepository.save(girl2);
    }

    @Override
    public void getAge(Integer id) throws Exception{
        Girl one = girlRepository.findOne(id);
        Integer age = one.getAge();
        if(age<10){
            throw new ExceptionUtil(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10 && age<16){
            throw new ExceptionUtil(ResultEnum.MIDDLE_SCHOOL);
        }

    }

    @Override
    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}
