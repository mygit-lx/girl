package com.luox;

import com.luox.entity.Girl;
import com.luox.service.GirlsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by luox on 2017/6/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlsService girlsService;

    @Test
    public void findOneTest(){
        Girl one = girlsService.findOne(10);
        Assert.assertEquals(new Integer(22),one.getAge());
    }
}
