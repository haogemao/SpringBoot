package com.person.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello World 鎺у埗鍣�.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @date 2017骞�1鏈�26鏃�
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World! Welcome to visit waylau.com!";
    }

}
 