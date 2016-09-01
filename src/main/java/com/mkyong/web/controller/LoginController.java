package com.mkyong.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView init(Model model) {
		System.out.println("index request executed ");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model) {
		System.out.println("login request executed ");
		model.addAttribute("loginBean", new LoginBean());
		model.addAttribute("msg", "Please Enter Your Login Details");
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String saveOrUpdateUser(@Valid LoginBean loginBean, BindingResult result, Model model) {
		System.out.println("doLogin request executed ");
		if (result.hasErrors()) {
			System.out.println("error hash login page");
			return "login";
		} else {
			model.addAttribute("lfobj", loginBean);
			System.out.println("success");
			return "success";
		}
		// if (loginAttributes != null && loginAttributes.getUserName() != null
		// & loginAttributes.getPassword() != null) {
		// if (loginAttributes.getUserName().equals("robin") &&
		// loginAttributes.getPassword().equals("robin123")) {
		// model.addAttribute("msg", "welcome" + loginAttributes.getUserName());
		// return "success";
		// } else {
		// model.addAttribute("error", "Invalid Details");
		// return "login";
		// }
		// } else {
		// model.addAttribute("error", "Please enter Details");
		// return "login";
		// }

	}

}