package com.person.springboot.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response {

    private boolean success;

    private String message;

    private Object data;
}
