package com.person.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootUploadApplication {

//	private int maxUploadSizeInMb = 10 * 1024 * 1024;//10M

    public static void main(String[] args) {
        SpringApplication.run(SpringBootUploadApplication.class, args);
    }

}
