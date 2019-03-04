package com.yb.dataclean.service;

import com.yb.dataclean.domain.Datasource;
import com.yb.dataclean.enums.ResultEnum;
import com.yb.dataclean.exception.GirlException;
import com.yb.dataclean.repository.DataSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
import java.util.List;

@Service
public class DataSourceService {
    @Autowired
    DataSourceRepository dataSourceRepository;
    @Transactional

    public List<Datasource> findalldatasource(){
        List<Datasource> list=dataSourceRepository.findAll();
        if(StringUtils.isEmpty(list)){
            throw new GirlException(ResultEnum.UNKONW_ERROR);
        }
        return dataSourceRepository.findAll();
    }
    public Datasource addonedatasource(@Valid Datasource datasource){
        datasource.setDatatype(datasource.getDatatype());
        datasource.setDataname(datasource.getDataname());
        datasource.setDatadesc(datasource.getDatadesc());
        datasource.setTablename(datasource.getTablename());
        datasource.setComa(datasource.getComa());
        datasource.setFirstline(datasource.getFirstline());
        datasource.setDatabasename(datasource.getDatabasename());

        return dataSourceRepository.save(datasource);
    }
    @Modifying
    public void deletedatasouce(Integer dataid){
        Datasource datasource = dataSourceRepository.findById(dataid).get();
        if(StringUtils.isEmpty(datasource)){
            throw new GirlException(ResultEnum.UNKONW_ERROR);
        }
        dataSourceRepository.deleteById(dataid);
    }
    @Modifying
    public Datasource updatedatasource(@Valid Datasource datasource){
        return  dataSourceRepository.save(datasource);
    }
}
