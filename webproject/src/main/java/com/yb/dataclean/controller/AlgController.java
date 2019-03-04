package com.yb.dataclean.controller;

import com.yb.dataclean.domain.Alg;
import com.yb.dataclean.domain.Result;
import com.yb.dataclean.repository.AlgRepository;
import com.yb.dataclean.service.AlgService;
import com.yb.dataclean.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AlgController {
    @Autowired
    AlgRepository algRepository;
    @Autowired
    AlgService algService;

    @GetMapping(value = "/alg")
    public Result<List<Alg>> findallalg(){
        return ResultUtil.success(algService.findallalg());
    }
    @PostMapping(value = "/alg/addone")
    public Result<Alg> addonealg(@Valid Alg alg, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(3,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(algService.addonealg(alg));
    }
    @PostMapping(value = "/alg/deleteone")
    public Result deleteonealg(Integer algid){
        algService.deletealg(algid);
        return ResultUtil.success();
    }
    @PostMapping(value = "/alg/update")
    public Result<Alg> updateonealg(@Valid Alg alg ,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(3,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(algService.updatealg(alg));
    }
}
