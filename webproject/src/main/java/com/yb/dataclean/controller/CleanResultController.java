package com.yb.dataclean.controller;

import com.yb.dataclean.domain.CleanResult;
import com.yb.dataclean.domain.Result;
import com.yb.dataclean.repository.CleanResultRepository;
import com.yb.dataclean.service.CleanResultService;
import com.yb.dataclean.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CleanResultController {
    @Autowired
    CleanResultRepository cleanResultRepository;
    @Autowired
    CleanResultService cleanResultService;
    @GetMapping(value = "/cleanresult")
    public Result<List<CleanResult>> findallcleanresult(){
        return ResultUtil.success(cleanResultService.findallcleanresult());
    }
    @PostMapping(value = "/cleanresult/addone")
    public Result<CleanResult> addonecleanresult(@Valid CleanResult cleanResult, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(6,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(cleanResultService.addonecleanresult(cleanResult));
    }
    @PostMapping(value = "/cleanresult/deleteone")
    public Result deleteonecleanresult(Integer resultid){
        cleanResultService.deleteonecleanresult(resultid);
        return ResultUtil.success();
    }
    @PostMapping(value = "/cleanresult/update")
    public Result<CleanResult> updatecleanresult(@Valid CleanResult cleanResult,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(6,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(cleanResultService.updatecleanresult(cleanResult));
    }
}
