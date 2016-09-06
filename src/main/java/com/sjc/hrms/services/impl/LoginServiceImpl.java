package com.sjc.hrms.services.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.sjc.hrms.contoller.LoginController;
import com.sjc.hrms.model.LoginBean;
import com.sjc.hrms.services.LoginService;

public class LoginServiceImpl implements LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Override
	public ModelAndView authenticateUser(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			BindingResult bindingresult, HttpSession session, HttpServletRequest request, Model model) {
		ModelAndView view = new ModelAndView("login");
		if (!bindingresult.hasErrors()) {
			if (!(loginBean.getUserName().equals("robin"))) {
				bindingresult.addError(new ObjectError("invalid", "Invalid Credentials!!!"));
				logger.error("invalid credential");
				view.setViewName("login");
			} else {
				session.setAttribute("Login_userName", loginBean.getUserName());
				logger.debug("login user -->" + session.getAttribute("Login_userName"));
				view.setViewName("success");
			}
		}

		return view;

	}

	@Override
	public Model viewLoginPage(Model model) {
		model.addAttribute("loginBean", new LoginBean());
		model.addAttribute("msg", "Please Enter Your Login Details");
		return model ;
	}

}
