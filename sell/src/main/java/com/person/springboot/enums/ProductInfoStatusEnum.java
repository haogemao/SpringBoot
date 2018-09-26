package com.person.springboot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.aspectj.apache.bcel.classfile.Code;

@Getter
@AllArgsConstructor
public enum ProductInfoStatusEnum implements CodeEnum {

    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;

    private String message;
}
