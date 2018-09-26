package com.person.springboot.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotEmpty(message = "openid不能为空")
    private String openid;

    @NotEmpty(message = "密码不能为空")
    private String password;
}
