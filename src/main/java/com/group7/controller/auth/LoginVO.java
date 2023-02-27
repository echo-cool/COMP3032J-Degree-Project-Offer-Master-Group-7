package com.group7.controller.auth;


import com.group7.db.jpa.User;

import java.io.Serializable;

/**
 * @Author: WangYuyang
 * @Date: 2023/2/26-19:56
 * @Project: COMP3032J_FYP_Thesis_Group_7
 * @Package: com.group7.controller.auth
 * @Description:
 **/
public class LoginVO implements Serializable {
    private String id;
    private String token;
    private User user;
    //省略getter、setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
