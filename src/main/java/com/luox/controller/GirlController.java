package com.luox.controller;

import com.luox.constant.Result;
import com.luox.repositoty.GirlRepository;
import com.luox.entity.Girl;
import com.luox.service.GirlsService;
import com.luox.utils.ResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by luox on 2017/6/1.
 */
@RestController
public class GirlController {

    private static final Logger log = Logger.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlsService girlsService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        log.info("拦截之后执行该方法！");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girlAdd")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 添加一个女生-新
     * @param girl
     * @return
     */
    @PostMapping(value = "/girlAdd/new")
    public Girl girlAddNew(Girl girl){
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        return girlRepository.save(girl);
    }

    /**
     * 添加一个女生-表单验证
     * @param girl
     * @return
     */
    @PostMapping(value = "/girlAdd/new1")
    public Result<Girl> girlAddNew1(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        return ResultUtil.result(0,"添加成功",girlRepository.save(girl));
    }

    /**
     * 查找一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl getGirlById(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 删除一个女生
     * @param id
     */
    @DeleteMapping(value = "/delGirl/{id}")
    public void delGirlById(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 更新一个女生
     * @param id
     */
    @PutMapping(value = "/updateGirl/{id}")
    public Girl updateGirlById(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 通过年龄查找女生
     * @param age
     * @return
     */
    @GetMapping(value = "/getGirlByAge/age/{age}")
    public List<Girl> findGirlsByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlsService.insertTwo();
    }

    @GetMapping(value = "/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlsService.getAge(id);
    }
}
