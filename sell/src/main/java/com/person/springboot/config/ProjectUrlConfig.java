package com.person.springboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * prefix的规则，只能有小写字母和数字以及-组成，并且以字母开头
 */
@Data
@ConfigurationProperties(prefix = "project-url")
@Component
public class ProjectUrlConfig {

    /**
     * 微信公众平台授权Url  配置授权域即可
     */
//    public String wechatMpAuthorize;

    /**
     * 微信开放平台授权url 配置授权域即可
     */
//    public String wechatOpenAuthorize;

    /**
     * 本项目的地址
     */
//    @Value("${projectUrl.project}")
    public String project;
}
