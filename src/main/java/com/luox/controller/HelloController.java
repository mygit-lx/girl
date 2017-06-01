package com.luox.controller;

import com.luox.constant.GrilProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by luox on 2017/5/23.
 */

@RestController
@RequestMapping(value = "/test")
public class HelloController {

    @Autowired
    private GrilProperties girlProperties;

    @RequestMapping(value = {"/say","/hi"},method = RequestMethod.POST)
    public String say(){
        return girlProperties.getCupSize();
    }

    //http://localhost:8082/girl/test/hello/1991
    @RequestMapping(value = "/hello/{id}",method = RequestMethod.GET)
    public String hello(@PathVariable("id") Integer id){
        return "id:"+id;//id:1991
    }

    //http://localhost:8082/girl/test/test01?id=1992
    @RequestMapping(value = "/test01",method = RequestMethod.GET)
    public String test01(@RequestParam(value = "id" ,required = false,defaultValue = "2017") Integer myid){
        return "id:"+myid;//id:1992
    }

    //http://localhost:8082/girl/test/test01?id=1992
    @GetMapping(value = "/test02")
    public String test02(@RequestParam(value = "id") Integer myid){
        return "id:"+myid;//id:1992
    }
}
