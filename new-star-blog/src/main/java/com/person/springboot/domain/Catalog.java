package com.person.springboot.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Catalog 瀹炰綋
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�10鏃�
 */
@Entity // 瀹炰綋
public class Catalog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // 涓婚敭
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 鑷闀跨瓥鐣�
    private Long id; // 鐢ㄦ埛鐨勫敮涓�鏍囪瘑

    @NotEmpty(message = "鍚嶇О涓嶈兘涓虹┖")
    @Size(min = 2, max = 30)
    @Column(nullable = false) // 鏄犲皠涓哄瓧娈碉紝鍊间笉鑳戒负绌�
    private String name;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    protected Catalog() {
    }

    public Catalog(User user, String name) {
        this.name = name;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
