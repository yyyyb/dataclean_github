package com.yb.dataclean.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Job {
    //任务ID
    @Id
    @GeneratedValue
    private Integer jobid;
    //任务名称
    @NotNull(message = "任务名称不能为空")
    private String jobname;
    //任务描述
    private String jobdesc;
    //数据源类型
    private String datatype;
    //数据源名称
    private String dataname;
    //数据源文件
    private String datafile;
    //算法类型
    private String algtype;
    //算法名称
    private String algname;
    //算法包文件名
    private String algfile;

    public Job() {
    }

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
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

    public String getDatafile() {
        return datafile;
    }

    public void setDatafile(String datafile) {
        this.datafile = datafile;
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

    public String getAlgfile() {
        return algfile;
    }

    public void setAlgfile(String algfile) {
        this.algfile = algfile;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobid=" + jobid +
                ", jobname='" + jobname + '\'' +
                ", jobdesc='" + jobdesc + '\'' +
                ", datatype='" + datatype + '\'' +
                ", dataname='" + dataname + '\'' +
                ", datafile='" + datafile + '\'' +
                ", algtype='" + algtype + '\'' +
                ", algname='" + algname + '\'' +
                ", algfile='" + algfile + '\'' +
                '}';
    }
}
