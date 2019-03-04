package com.yb.dataclean.controller;

import com.yb.dataclean.domain.Result;
import com.yb.dataclean.domain.User;
import com.yb.dataclean.repository.UserRepository;
import com.yb.dataclean.service.UserService;
import com.yb.dataclean.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @PostMapping(value = "/user")
    public Result<User> userLogin(User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        String userid=user.getUserid();
        String password=user.getPassword();

        return ResultUtil.success(userService.findUserByUseridandPassword(userid,password));
    }
}
