package com.mkyong.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sjc.hrms.exception.PrivillageException;

@Controller
public class LoginController extends BaseController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView init(Model model) {
		System.out.println("index request executed ");
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model) {
		System.out.println("login request executed ");
		model.addAttribute("msg", "Please Enter Your Login Details");
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("loginBean") LoginBean loginAttributes, BindingResult result,
			Model model) {
		System.out.println("doLogin request executed ");
		if (loginAttributes != null && loginAttributes.getUserName() != null & loginAttributes.getPassword() != null) {
			if (loginAttributes.getUserName().equals("robin") && loginAttributes.getPassword().equals("robin123")) {
				model.addAttribute("msg", "welcome" + loginAttributes.getUserName());
				return "success";
			} else {
				model.addAttribute("error", "Invalid Details");
				return "login";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}

	}

	@RequestMapping(value = "/check/{type}", method = RequestMethod.GET)
	public ModelAndView getPages(@PathVariable("type") String type) {
		System.out.println("check request executed ");
		type = "error";
		if ("error".equals(type)) {
			throw new PrivillageException("access restrition");
		} else {
			return new ModelAndView("index").addObject("msg", type);
		}

	}

}