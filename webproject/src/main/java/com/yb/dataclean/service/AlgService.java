package com.yb.dataclean.service;

import com.yb.dataclean.domain.Alg;
import com.yb.dataclean.domain.Datasource;
import com.yb.dataclean.enums.ResultEnum;
import com.yb.dataclean.exception.GirlException;
import com.yb.dataclean.repository.AlgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
import java.util.List;

@Service
public class AlgService {
    @Autowired
    AlgRepository algRepository;

    @Transactional
    public List<Alg> findallalg(){
        List<Alg> list=algRepository.findAll();
        if(StringUtils.isEmpty(list)){
            throw new GirlException(ResultEnum.UNKONW_ERROR);
        }
        return algRepository.findAll();
    }
    public Alg addonealg(@Valid Alg alg){

        return algRepository.save(alg);
    }
    @Modifying
    public void deletealg(Integer algid){
        Alg alg = algRepository.findById(algid).get();
        if(StringUtils.isEmpty(alg)){
            throw new GirlException(ResultEnum.UNKONW_ERROR);
        }
        else {
             algRepository.deleteById(algid);
        }
    }
    @Modifying
    public Alg updatealg(@Valid Alg alg){
        return algRepository.save(alg);
    }
}
