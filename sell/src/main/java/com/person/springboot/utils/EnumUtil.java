package com.person.springboot.utils;

import com.person.springboot.enums.CodeEnum;

public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumclass){
        for (T each:enumclass.getEnumConstants()) {
            if (each.getCode().equals(code)){
                return each;
            }
        }
        return null;
    }
}
