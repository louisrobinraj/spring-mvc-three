package com.sjc.hrms.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sjc.hrms.model.LoginBean;
import com.sjc.hrms.services.LoginService;

@Controller
public class LoginController extends ParantController {

	public static final String indexPageName = "index";
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView initApp() {
		return new ModelAndView(indexPageName);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView viewLoginPage(Model model) {
		return loginService.viewLoginPage(model);
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(@Valid @ModelAttribute("loginBean") LoginBean loginBean, BindingResult bindingresult,
			HttpSession session, HttpServletRequest request, Model model) {
		return loginService.authenticateUser(loginBean, bindingresult, session, request, model);
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}