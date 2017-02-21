package com.iqmsoft.butterfaces.boot.view;

import org.springframework.web.context.annotation.RequestScope;

import com.iqmsoft.butterfaces.boot.security.Identity;

import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScope
public class LoginBean {

    @Inject
    private Identity identity;

    private String userName = "admin";
    private String password = "password";

    public String login() {
       return identity.login(userName, password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
