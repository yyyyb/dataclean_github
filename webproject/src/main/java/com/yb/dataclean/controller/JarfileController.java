package com.yb.dataclean.controller;

import com.yb.dataclean.domain.Jarfile;
import com.yb.dataclean.domain.Result;
import com.yb.dataclean.repository.JarfileRepository;
import com.yb.dataclean.service.JarfileService;
import com.yb.dataclean.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class JarfileController {
    @Autowired
    JarfileRepository jarfileRepository;
    @Autowired
    JarfileService jarfileService;

    @GetMapping(value = "/jarfile")
    public Result<List<Jarfile>> findalljarfile(){
        return ResultUtil.success(jarfileService.findalljarfile());
    }
    @PostMapping(value = "/jarfile/addone")
    public Result<Jarfile> addonejarfile(@Valid Jarfile jarfile, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(4,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(jarfileService.addonejarfile(jarfile));
    }
    @PostMapping(value = "/jarfile/deleteone")
    public Result deleteonealgfile(Integer jarfileid){
        jarfileService.deleteonejarfile(jarfileid);
        return ResultUtil.success();
    }
    @PostMapping(value = "/jarfile/update")
    public Result<Jarfile> updatejarfile(@Valid Jarfile jarfile,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(4,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(jarfileService.updatejarfile(jarfile));
    }
}
