package com.sjc.hrms.persistence.impl;

import java.util.List;

import com.sjc.hrms.model.LoginBean;

public interface SampleDao {

	LoginBean getBrandByName(String brandName);

	List<LoginBean> getAllBrand();

	LoginBean findBrand(long brandId);

}
