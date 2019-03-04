package com.yb.dataclean.controller;

import com.yb.dataclean.domain.Datasource;
import com.yb.dataclean.domain.Result;
import com.yb.dataclean.repository.DataSourceRepository;
import com.yb.dataclean.service.DataSourceService;
import com.yb.dataclean.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DatasourceController {
    @Autowired
    DataSourceRepository dataSourceRepository;
    @Autowired
    DataSourceService dataSourceService;
    @GetMapping(value = "/datasource")
    public Result<List<Datasource>> findalldatasource(){
        return ResultUtil.success(dataSourceService.findalldatasource());
    }
    @PostMapping(value = "/datasource/addone")
    public Result<Datasource> addonedatasource(@Valid Datasource datasource, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(2,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(dataSourceService.addonedatasource(datasource));
    }
    @PostMapping(value = "/datasource/delete")
    public Result deletedatasource(Integer dataid){
        dataSourceService.deletedatasouce(dataid);
        return ResultUtil.success();
    }
    @PostMapping(value = "/datasource/update")
    public Result<Datasource> updatedatasource(@Valid Datasource datasource,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(2,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(dataSourceService.updatedatasource(datasource));
    }
}
