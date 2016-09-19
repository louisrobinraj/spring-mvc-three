package com.sjc.hrms.persistence.impl;

import com.sjc.hrms.core.persistence.BaseJpaDAO;
import com.sjc.hrms.model.LoginBean;
import com.sjc.hrms.persistence.AuthenticationDao;

public class AuthenticationDaoImpl extends BaseJpaDAO<LoginBean> implements AuthenticationDao {

	public AuthenticationDaoImpl() {
		super(LoginBean.class);
	}

	protected AuthenticationDaoImpl(Class<LoginBean> entityClass) {
		super(LoginBean.class);
	}

	@Override
	public LoginBean checkUserCredantial(String userName,String password) {
		return queryFor("select obj from LoginBean obj where obj.userName=?1 and obj.password=?2",userName,password);
	}

}