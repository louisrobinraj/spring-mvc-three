package com.sjc.hrms.persistence;

import com.sjc.hrms.core.persistence.JpaDAO;
import com.sjc.hrms.model.LoginBean;

public interface AuthenticationDao extends JpaDAO<LoginBean> {

	public LoginBean checkUserCredantial(String regionName);
}
