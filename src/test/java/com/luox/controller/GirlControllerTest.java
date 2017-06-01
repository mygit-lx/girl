package com.luox.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by luox on 2017/6/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

    //项目打包：mvn clean package
    //项目调过单元测试打包：mvn clean package -Dmaven.test.skip=true

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private GirlController girlController;
//
//    @Test
//    public void girlList() throws Exception {
//        girlController.girlList();
//    }

    @Test
    public void girlList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/girls")).andExpect(MockMvcResultMatchers.status().isOk());
    }

//    @Test
//    public void girlList() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders.get("/girls"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .string("abc"));
//    }

}