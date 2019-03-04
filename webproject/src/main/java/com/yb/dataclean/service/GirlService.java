package com.yb.dataclean.service;

import com.yb.dataclean.domain.Girl;
import com.yb.dataclean.enums.ResultEnum;
import com.yb.dataclean.exception.GirlException;
import com.yb.dataclean.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public void insertTwo(){
        Girl girlA= new Girl();
        Girl girlB=new Girl();
        girlA.setAge(18);
        girlA.setCupSize("A");
        girlB.setAge(17);
        girlB.setCupSize("C");
        girlRepository.save(girlA);
        girlRepository.save(girlB);
    }
    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).get();
        Integer age= girl.getAge();
        if (age<10){
            //返回“上小学” code=100
            throw new GirlException(ResultEnum.UNKONW_ERROR);
        }else if(age>10&&age<16){
            //返回“上初中” code=101
            throw new GirlException(ResultEnum.UNKONW_ERROR);
        }
    }

    //通过ID查询女生
    public Girl findone(Integer id){
        return girlRepository.findById(id).get();
    }
}
