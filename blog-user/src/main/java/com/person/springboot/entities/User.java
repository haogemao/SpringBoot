package com.person.springboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "��������Ϊ��")
    @Size(min = 2, max = 20)
    @Column(nullable = false, length = 20)
    private String name;

    @NotEmpty(message = "���䲻��Ϊ��")
    @Size(max = 50)
    @Email(message = "�����ʽ����ȷ")
    @Column(nullable = false, length = 50, unique = true)
    private String email;


    @NotEmpty(message = "�˺Ų���Ϊ��")
    @Size(max = 20, min = 3)
    @Column(nullable = false, length = 20, unique = true)
    private String username;

    @NotEmpty(message = "���벻��Ϊ��")
    @Size(max = 100)
    @Column(length = 100)
    private String password;

    @Column(length = 2000)
    private String avatar; //ͷ��ͼƬ��ַ

    public User(Long id, String name, String email, String username) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
    }
}
