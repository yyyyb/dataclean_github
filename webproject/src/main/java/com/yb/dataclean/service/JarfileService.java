package com.yb.dataclean.service;

import com.yb.dataclean.domain.Alg;
import com.yb.dataclean.domain.Jarfile;
import com.yb.dataclean.enums.ResultEnum;
import com.yb.dataclean.exception.GirlException;
import com.yb.dataclean.repository.JarfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class JarfileService {
    @Autowired
    JarfileRepository jarfileRepository;
    @Transactional
    public List<Jarfile> findalljarfile(){
        List<Jarfile> list=jarfileRepository.findAll();
        if(StringUtils.isEmpty(list)){
            throw new GirlException(ResultEnum.UNKONW_ERROR);
        }
        return jarfileRepository.findAll();
    }
    public Jarfile addonejarfile(Jarfile jarfile){
        return jarfileRepository.save(jarfile);
    }
    @Modifying
    public void deleteonejarfile(Integer jarfileid){
        Jarfile jarfile = jarfileRepository.findById(jarfileid).get();
        if(StringUtils.isEmpty(jarfile)){
            throw new GirlException(ResultEnum.UNKONW_ERROR);
        }
        jarfileRepository.deleteById(jarfileid);
    }
    @Modifying
    public Jarfile updatejarfile(Jarfile jarfile){
        return jarfileRepository.save(jarfile);
    }
}
