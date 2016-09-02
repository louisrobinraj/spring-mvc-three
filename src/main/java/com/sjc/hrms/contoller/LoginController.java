package com.sjc.hrms.contoller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sjc.hrms.exception.GenericException;
import com.sjc.hrms.model.LoginBean;

@Controller
public class LoginController extends ParantController {

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
	}

	@RequestMapping(value = "/test/{type}", method = RequestMethod.GET)
	public String test(@PathVariable("type") String type) {
		if (type.equals("404")) {
			throw new GenericException("404", "404 exception");
		} else {
			throw new GenericException("405", "405 exception");
		}
	}

}