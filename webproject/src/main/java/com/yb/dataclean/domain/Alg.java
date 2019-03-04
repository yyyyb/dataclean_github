package com.yb.dataclean.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Alg {
    //算法ID
    @Id
    @GeneratedValue
    private Integer algid;
    //算法类型
    @NotEmpty(message = "算法类型不能为空")
    private String algtype;
    //算法名称
    @NotEmpty(message = "算法包不能为空")
    private String algname;
    //jar包名称
    private String jarname;
    //算法的主类
    private  String algclass;
    //输入参数
    private String parameter;
    //算法描述
    private String algdesc;

    public Alg() {
    }

    public Integer getAlgid() {
        return algid;
    }

    public void setAlgid(Integer algid) {
        this.algid = algid;
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

    public String getJarname() {
        return jarname;
    }

    public void setJarname(String jarname) {
        this.jarname = jarname;
    }

    public String getAlgclass() {
        return algclass;
    }

    public void setAlgclass(String algclass) {
        this.algclass = algclass;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getAlgdesc() {
        return algdesc;
    }

    public void setAlgdesc(String algdesc) {
        this.algdesc = algdesc;
    }

    @Override
    public String toString() {
        return "Alg{" +
                "algid=" + algid +
                ", algtype='" + algtype + '\'' +
                ", algname='" + algname + '\'' +
                ", jarname='" + jarname + '\'' +
                ", algclass='" + algclass + '\'' +
                ", parameter='" + parameter + '\'' +
                ", algdesc='" + algdesc + '\'' +
                '}';
    }
}
