package com.sjc.hrms.services;

import com.sjc.hrms.model.LoginBean;

public interface LoginService {

	boolean authenticateUser(LoginBean login);

}
