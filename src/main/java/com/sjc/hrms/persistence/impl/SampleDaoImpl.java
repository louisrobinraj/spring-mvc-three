package com.sjc.hrms.persistence.impl;


import java.util.List;

import com.sjc.hrms.core.persistence.BaseJpaDAO;
import com.sjc.hrms.model.LoginBean;

public class SampleDaoImpl extends BaseJpaDAO<LoginBean> implements SampleDao {
	
	public SampleDaoImpl() {
		super(LoginBean.class);
	}

	protected SampleDaoImpl(Class<LoginBean> entityClass) {
		super(LoginBean.class);
	}

	
	@Override
	public LoginBean getBrandByName(String brandName) {
	return queryFor("select u from BpmBrand u where LOWER(u.brandName) =?1", brandName);
	}
	
	@Override
	public List<LoginBean> getAllBrand() {
		return queryForList("select u from BpmBrand u where u.brandName is not null");
	}

	@Override
	public LoginBean findBrand(long brandId) {
		return queryFor("select u from BpmBrand u where u.id = ?1", brandId);
	}
}
