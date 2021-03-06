package com.iqmsoft.butterfaces.boot.security;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.iqmsoft.butterfaces.boot.mongo.Admin;
import com.iqmsoft.butterfaces.boot.mongo.AdminRepository;


@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Identity {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private String userName;
    private boolean loggedIn;
    
    @Autowired
	private AdminRepository adminRepository;

    public String login(String userName, String password) {
        log.info("Try to login user {}", userName);
        
        List<Admin> a = adminRepository.findAll();
        
        String uname = a.get(0).getName();
        
        String pwd = a.get(0).getPwd();
        
        this.loggedIn = uname.equals(userName) && pwd.equals(password);

        if (loggedIn) {
            this.userName = userName;
            log.info("User {} logged in.", userName);
            return "/secure/index.jsf?faces-redirect=true";
        } else {
            this.userName = null;
            log.info("User {} not logged in. Bad credentials.", userName);
            return null;
        }
    }

    public String logout() {
        loggedIn = false;
       

        log.info("User {} logged out", userName);

        return "/login.jsf?faces-redirect=true";
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUserName() {
        return userName;
    }
}
