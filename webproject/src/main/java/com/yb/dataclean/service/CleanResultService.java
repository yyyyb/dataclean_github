package com.yb.dataclean.service;

import com.yb.dataclean.domain.CleanResult;
import com.yb.dataclean.enums.ResultEnum;
import com.yb.dataclean.exception.GirlException;
import com.yb.dataclean.repository.CleanResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CleanResultService {
    @Autowired
    CleanResultRepository cleanResultRepository;
    @Transactional
    public List<CleanResult> findallcleanresult(){
        List list = cleanResultRepository.findAll();
        if(StringUtils.isEmpty(list)){
            throw new GirlException(ResultEnum.UNKONW_ERROR);
        }
        return cleanResultRepository.findAll();
    }

    public CleanResult addonecleanresult(CleanResult cleanResult){
        return cleanResultRepository.save(cleanResult);
    }

    @Modifying
    public void deleteonecleanresult(Integer resultid){
        CleanResult cleanResult=cleanResultRepository.findById(resultid).get();
        if(StringUtils.isEmpty(cleanResult)){
            throw new GirlException(ResultEnum.UNKONW_ERROR);
        }
        cleanResultRepository.deleteById(resultid);
    }
    @Modifying
    public CleanResult updatecleanresult(CleanResult cleanResult){
        return cleanResultRepository.save(cleanResult);
    }
}
