package com.peron.springboot;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMailApplicationTests {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    /**
     * 简单邮件发送
     * @throws Exception
     */
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Spring Boot 发送邮件测试");
        message.setText("Spring Boot 发送邮件测试");
        message.setTo("1246810048@qq.com");
        message.setFrom("507297824@qq.com");
        mailSender.send(message);
    }

    @Test
    /**
     * 带附件
     * @throws Exception
     */
    public void sendAttachmentsMail() throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("507297824@qq.com");
        helper.setTo("1246810048@qq.com");
        helper.setSubject("Spring Boot 发送邮件测试");
        helper.setText("有附件的邮件");

        FileSystemResource file = new FileSystemResource(new File("E:\\Document\\code\\SpringBoot\\spring_boot-mail\\target\\classes\\weixin.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        mailSender.send(message);
    }

    @Test
    /**
     * 嵌入静态资源
     * @throws Exception
     */
    public void sendInlineMail() throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("507297824@qq.com");
        helper.setTo("1246810048@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:weixin\"/></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("E:\\Document\\code\\SpringBoot\\spring_boot-mail\\target\\classes\\weixin.jpg"));
        //addInline函数中资源名称weixin需要与正文中cid:weixin对应起来
        helper.addInline("weixin", file);

        mailSender.send(message);
    }

    @Test
    public void sendTemplateMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("507297824@qq.com");
        helper.setTo("1246810048@qq.com");
        helper.setSubject("主题：模板邮件");

        Context context = new Context();
        context.setVariable("id", "006");
        String text = templateEngine.process("emailTemplate", context);
        helper.setText(text, true);

        mailSender.send(mimeMessage);
    }

}
