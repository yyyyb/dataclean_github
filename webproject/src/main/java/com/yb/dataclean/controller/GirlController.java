package com.yb.dataclean.controller;

import com.yb.dataclean.domain.Girl;
import com.yb.dataclean.domain.Result;
import com.yb.dataclean.repository.GirlRepository;
import com.yb.dataclean.service.GirlService;
import com.yb.dataclean.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    //查询所有
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return  girlRepository.findAll();
    }

    //新增一个
    @PostMapping(value= "/girls")
    public Result<Girl> grilAdd(@Valid  Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlRepository.save(girl));

    }

    //通过ID查询
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get() ;
    }


    //更新一个
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpadate(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupsize,@RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setAge(age);
        girl.setCupSize(cupsize);
        girl.setId(id);
        return girlRepository.save(girl);
    }
    //删除
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    //通过年龄查询列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
       return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
        
    }
}
