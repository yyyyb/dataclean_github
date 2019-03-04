package com.yb.dataclean.enums;

public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
//    PRIMARY_SCHOOL(100,"上下学"),
//    MIDDLE_SCHOOL(101,"上初中"),
    LOGIN_ERROR(1,"用户名或者密码错误"),
    DATASOURCE_ERROR(2,"数据源类型或者数据源名称不能为空"),
    ALG_ERROR(3,"算法类型或者算法包不能为空"),
    JARFILE_ERROR(4,"算法包名不能为空"),
    JOB_ERROR(5,"任务名称不能为空"),
    CLEANRESULT_ERROR(6,"清洗结果数据异常")
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
