package com.yb.dataclean.controller;

import com.yb.dataclean.domain.Job;
import com.yb.dataclean.domain.Result;
import com.yb.dataclean.repository.JarfileRepository;
import com.yb.dataclean.repository.JobRepository;
import com.yb.dataclean.service.JobService;
import com.yb.dataclean.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class JobController {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    JobService jobService;

    @GetMapping(value = "/job")
    public Result<List<Job>> findalljob(){
        return ResultUtil.success(jobService.findalljob());
    }
    @PostMapping(value = "/job/addone")
    public Result<Job> addonejob(@Valid Job job, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(5,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(jobService.addonejob(job));
    }
    @PostMapping(value = "/job/deleteone")
    public Result deleteonejob(Integer jobid){
        jobService.deleteonejob(jobid);
        return ResultUtil.success();
    }
    @PostMapping(value = "/job/update")
    public Result<Job> updatejob(@Valid Job job,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(5,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(jobService.updatejob(job));
    }
}
