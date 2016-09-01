package com.mkyong.web.controller;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginBean {
	 
	@NotEmpty(message = "userName should not be blank.")
	@Size(min = 5, max = 10)
    private String userName;
    private String password;
    @NotEmpty(message = "password should not be blank.")
	@Size(min = 3, max = 10)
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