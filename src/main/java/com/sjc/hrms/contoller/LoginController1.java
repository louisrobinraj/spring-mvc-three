package com.sjc.hrms.contoller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sjc.hrms.model.LoginBean;

@Controller
public class LoginController1 {

	@Autowired
	private LoginService loginService;

	@RequestMapping("login.html")
	public String toLogin(Model model) {
		LoginBean login = new LoginBean();
		model.addAttribute("login", login);
		return "login";
	}

	@RequestMapping(value = "login.html", method = RequestMethod.POST)
	public ModelAndView doLogin(@Valid @ModelAttribute("login") LoginBean login, BindingResult bindingresult,
			HttpSession session) {
		ModelAndView view = new ModelAndView("login");
		if (!bindingresult.hasErrors()) {
			if (!loginService.authenticateUser(login)) {
				bindingresult.addError(new ObjectError("invalid", "Invalid Credentials!!!"));
				return new ModelAndView("error");
			} else {
				session.setAttribute("login", login);
				view.setViewName("success");
			}
		}

		return view;
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login.html";
	}

}