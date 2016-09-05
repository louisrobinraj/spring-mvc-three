package com.sjc.hrms.services.impl;

import com.sjc.hrms.model.LoginBean;
import com.sjc.hrms.services.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean authenticateUser(LoginBean login) {
		if (login.getUserName().equals("robin") && login.getPassword().equals("robin123")) {
			return true;
		}
		return false;
	}

}
