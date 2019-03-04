package com.yb.dataclean.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Jarfile {
    //算法包的ID
    @Id
    @GeneratedValue
    private Integer jarfileid;
    //算法包的文件名称
    @NotEmpty(message = "算法包名不能为空")
    private String jarfilename;
    //算法包的名称
    private String jarname;

    public Jarfile() {
    }

    public Integer getJarfileid() {
        return jarfileid;
    }

    public void setJarfileid(Integer jarfileid) {
        this.jarfileid = jarfileid;
    }

    public String getJarfilename() {
        return jarfilename;
    }

    public void setJarfilename(String jarfile) {
        this.jarfilename = jarfile;
    }

    public String getJarname() {
        return jarname;
    }

    public void setJarname(String jarname) {
        this.jarname = jarname;
    }

    @Override
    public String toString() {
        return "Jarfile{" +
                "jarfileid=" + jarfileid +
                ", jarfile='" + jarfilename + '\'' +
                ", jarname='" + jarname + '\'' +
                '}';
    }
}
