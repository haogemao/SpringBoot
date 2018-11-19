package com.person.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

/**
 * 鏉冮檺.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�3鏈�14鏃�
 */
@Entity // 瀹炰綋
public class Authority implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id // 涓婚敭
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 鑷闀跨瓥鐣�
    private Long id; // 鐢ㄦ埛鐨勫敮涓�鏍囪瘑

    @Column(nullable = false) // 鏄犲皠涓哄瓧娈碉紝鍊间笉鑳戒负绌�
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.core.GrantedAuthority#getAuthority()
     */
    @Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
