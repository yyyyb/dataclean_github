package com.yb.dataclean.exception;

import com.yb.dataclean.enums.ResultEnum;

//Sping框架只会对RuntimeException异常才会进行事务回滚  如果是Exception的话不会进行事务回滚的
public class GirlException extends RuntimeException{
        private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
}

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
