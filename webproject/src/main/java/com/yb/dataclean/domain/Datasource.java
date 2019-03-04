package com.yb.dataclean.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Datasource {
    //数据源ID
    @Id
    @GeneratedValue
    private Integer dataid;
    //数据源类型
    @NotEmpty(message = "数据源类型不能为空")
    private String datatype;
    //数据源名称
    @NotEmpty(message = "数据源名称不能为空")
    private String dataname;
    //数据源描述
    private String datadesc;
    //表名
    private String tablename;
    //分隔符
    private String coma;
    //第一行列名
    private String firstline;
    //数据库名称
    private String databasename;

    public Datasource() {
    }

    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getDataname() {
        return dataname;
    }

    public void setDataname(String dataname) {
        this.dataname = dataname;
    }

    public String getDatadesc() {
        return datadesc;
    }

    public void setDatadesc(String datadesc) {
        this.datadesc = datadesc;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getComa() {
        return coma;
    }

    public void setComa(String comma) {
        this.coma = comma;
    }

    public String getFirstline() {
        return firstline;
    }

    public void setFirstline(String firstline) {
        this.firstline = firstline;
    }

    public String getDatabasename() {
        return databasename;
    }

    public void setDatabasename(String databasename) {
        this.databasename = databasename;
    }
}
