package com.person.springboot.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * User 瀹炰綋
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�3鏈�5鏃�
 */
@Entity // 瀹炰綋
public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    @Id // 涓婚敭
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 鑷闀跨瓥鐣�
    private Long id; // 鐢ㄦ埛鐨勫敮涓�鏍囪瘑

    @NotEmpty(message = "濮撳悕涓嶈兘涓虹┖")
    @Size(min = 2, max = 20)
    @Column(nullable = false, length = 20) // 鏄犲皠涓哄瓧娈碉紝鍊间笉鑳戒负绌�
    private String name;

    @NotEmpty(message = "閭涓嶈兘涓虹┖")
    @Size(max = 50)
    @Email(message = "閭鏍煎紡涓嶅")
    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @NotEmpty(message = "璐﹀彿涓嶈兘涓虹┖")
    @Size(min = 3, max = 20)
    @Column(nullable = false, length = 20, unique = true)
    private String username; // 鐢ㄦ埛璐﹀彿锛岀敤鎴风櫥褰曟椂鐨勫敮涓�鏍囪瘑

    @NotEmpty(message = "瀵嗙爜涓嶈兘涓虹┖")
    @Size(max = 100)
    @Column(length = 100)
    private String password; // 鐧诲綍鏃跺瘑鐮�

    @Column(length = 200)
    private String avatar; // 澶村儚鍥剧墖鍦板潃

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

    protected User() { // JPA 鐨勮鑼冭姹傛棤鍙傛瀯閫犲嚱鏁帮紱璁句负 protected 闃叉鐩存帴浣跨敤
    }

    public User(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        //  闇�灏� List<Authority> 杞垚 List<SimpleGrantedAuthority>锛屽惁鍒欏墠绔嬁涓嶅埌瑙掕壊鍒楄〃鍚嶇О
        List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<>();
        for (GrantedAuthority authority : this.authorities) {
            simpleAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return simpleAuthorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEncodePassword(String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePasswd = encoder.encode(password);
        this.password = encodePasswd;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, username='%s', name='%s', email='%s', password='%s']", id, username, name, email,
                password);
    }
}
