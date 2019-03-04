package com.yb.dataclean.controller;

import com.yb.dataclean.properties.GrilProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private GrilProperties grilProperties;

    @RequestMapping(value = {"/hi/"},method = RequestMethod.GET)
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
//        return grilProperties.getCupSize();
        return "id+ " + id;
    }
}
