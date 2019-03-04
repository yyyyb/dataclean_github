package com.yb.dataclean.service;

import com.yb.dataclean.domain.Job;
import com.yb.dataclean.enums.ResultEnum;
import com.yb.dataclean.exception.GirlException;
import com.yb.dataclean.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;
    @Transactional
    public List<Job> findalljob(){
        List list=jobRepository.findAll();
        if(StringUtils.isEmpty(list)){
            throw new GirlException(ResultEnum.UNKONW_ERROR);
        }
       return jobRepository.findAll();
    }

    public Job addonejob(Job job){
        return jobRepository.save(job);
    }
    @Modifying
    public void deleteonejob(Integer jobid){
        Job job=jobRepository.findById(jobid).get();
        if(StringUtils.isEmpty(job)){
            throw new GirlException(ResultEnum.UNKONW_ERROR);
        }
        jobRepository.deleteById(jobid);
    }
    @Modifying
    public Job updatejob(Job job){
        return jobRepository.save(job);
    }
}
