package com.person.springboot.domain;

import java.io.Serializable;
import java.sql.Timestamp;

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
 * Comment 瀹炰綋
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�9鏃�
 */
@Entity // 瀹炰綋
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // 涓婚敭
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 鑷闀跨瓥鐣�
    private Long id; // 鐢ㄦ埛鐨勫敮涓�鏍囪瘑

    @NotEmpty(message = "璇勮鍐呭涓嶈兘涓虹┖")
    @Size(min = 2, max = 500)
    @Column(nullable = false) // 鏄犲皠涓哄瓧娈碉紝鍊间笉鑳戒负绌�
    private String content;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false) // 鏄犲皠涓哄瓧娈碉紝鍊间笉鑳戒负绌�
    @org.hibernate.annotations.CreationTimestamp  // 鐢辨暟鎹簱鑷姩鍒涘缓鏃堕棿
    private Timestamp createTime;

    protected Comment() {
        // TODO Auto-generated constructor stub
    }

    public Comment(User user, String content) {
        this.content = content;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

}
