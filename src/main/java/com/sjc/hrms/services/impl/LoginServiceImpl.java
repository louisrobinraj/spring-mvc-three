package com.sjc.hrms.services.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.sjc.hrms.controller.LoginController;
import com.sjc.hrms.model.LoginBean;
import com.sjc.hrms.persistence.AuthenticationDao;
import com.sjc.hrms.services.LoginService;
import com.sjc.hrms.utils.Constants;

public class LoginServiceImpl implements LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private AuthenticationDao authenticationDao;

	@Override
	public ModelAndView authenticateUser(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			BindingResult bindingresult, HttpSession session, HttpServletRequest request, Model model) {
		ModelAndView view = new ModelAndView();
		if (!bindingresult.hasErrors()) {
			LoginBean userData=authenticationDao.checkUserCredantial(loginBean.getUserName(),loginBean.getPassword());
			if (userData==null) {
				bindingresult.addError(new ObjectError("invalid", "Invalid Credentials!!!"));
				logger.error("invalid credential");
				view.setViewName(Constants.INDEXPAGE);
			} else {
				session.setAttribute("Login_userName", loginBean.getUserName());
				logger.debug("login user -->" + session.getAttribute("Login_userName"));
				view.setViewName(Constants.SUCCESSPAGE);
			}
		}else{
			logger.debug("please enter valid user details");
			view.setViewName(Constants.INDEXPAGE);
		}

		return view;

	}

}
