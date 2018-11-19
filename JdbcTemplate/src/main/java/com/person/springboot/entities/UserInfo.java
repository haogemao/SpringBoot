package com.person.springboot.entities;

public class UserInfo {

    private Integer id;

    private String username;

    private String password;

    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserInfo(Integer id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
