package com.sjc.hrms.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.sjc.hrms.model.LoginBean;

public interface LoginService {

	public ModelAndView authenticateUser(@Valid @ModelAttribute("loginBean") LoginBean loginBean, BindingResult bindingresult,HttpSession session, HttpServletRequest request, Model model);

	

}
