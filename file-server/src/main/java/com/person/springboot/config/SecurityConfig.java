package com.person.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring Security 閰嶇疆绫�.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�3鏈�8鏃�
 */
@Configuration
@EnableWebMvc
public class SecurityConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
        ;
    }
}