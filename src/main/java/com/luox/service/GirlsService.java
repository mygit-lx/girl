package com.luox.service;

import com.luox.entity.Girl;

import java.util.List;

/**
 * Created by luox on 2017/6/1.
 */
public interface GirlsService {

    public void insertTwo();

    public void getAge(Integer id) throws Exception;

    public Girl findOne(Integer id);
}
