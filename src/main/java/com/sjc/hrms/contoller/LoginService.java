package com.sjc.hrms.contoller;

import com.sjc.hrms.model.LoginBean;

public interface LoginService {

	boolean authenticateUser(LoginBean login);

}
