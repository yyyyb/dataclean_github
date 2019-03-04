package com.yb.dataclean.service;

import com.yb.dataclean.domain.User;
import com.yb.dataclean.enums.ResultEnum;
import com.yb.dataclean.exception.GirlException;
import com.yb.dataclean.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Transactional
    public User findUserByUseridandPassword(String userid,String password){
        User user = userRepository.findByUseridAndPassword(userid,password);
        if (StringUtils.isEmpty(user)){
            //返回“帐号或者密码错误” code=1
            throw new GirlException(ResultEnum.LOGIN_ERROR);
        }else{
            return user;
        }
    }
}
