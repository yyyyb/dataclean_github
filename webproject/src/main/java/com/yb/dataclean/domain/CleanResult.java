package com.yb.dataclean.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CleanResult {
    //结果ID
    @Id
    @GeneratedValue
    private Integer resultid;
    //任务名
    private String jobname;
    //任务描述
    private String jobdesc;
    //数据源类型
    private String datatype;
    //数据源名称
    private String dataname;
    //算法类型
    private String algtype;
    //算法名
    private String algname;

    public CleanResult() {
    }

    public Integer getResultid() {
        return resultid;
    }

    public void setResultid(Integer resultid) {
        this.resultid = resultid;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getJobdesc() {
        return jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        this.jobdesc = jobdesc;
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

    public String getAlgtype() {
        return algtype;
    }

    public void setAlgtype(String algtype) {
        this.algtype = algtype;
    }

    public String getAlgname() {
        return algname;
    }

    public void setAlgname(String algname) {
        this.algname = algname;
    }
}
