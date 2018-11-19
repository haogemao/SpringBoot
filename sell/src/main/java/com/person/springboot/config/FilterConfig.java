package com.person.springboot.config;

import com.person.springboot.filter.SessionFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    @Bean
    public Filter sessionFilter() {
        return new SessionFilter();
    }
}
