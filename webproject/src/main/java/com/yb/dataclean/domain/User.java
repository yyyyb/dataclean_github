package com.yb.dataclean.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    //用户名
    @Id
    private String userid;
    //密码
    private String password;

    public User() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
