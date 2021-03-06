package com.person.springboot.exceptions;

import com.person.springboot.enums.ResultEnum;

public class GirlException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -7608183206432004457L;
    private Integer code;

    public GirlException(ResultEnum reslutEnum) {
        super(reslutEnum.getMsg());
        // TODO Auto-generated constructor stub
        this.code = reslutEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
