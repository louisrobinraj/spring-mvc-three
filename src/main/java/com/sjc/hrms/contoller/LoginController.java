package com.sjc.hrms.contoller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sjc.hrms.exception.GenericException;
import com.sjc.hrms.model.ResponseEntity;
import com.sjc.hrms.services.LoginService;
import com.sjc.hrms.model.LoginBean;

@Controller
public class LoginController extends ParantController {

	@Autowired
	private LoginService loginService;

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
	public ModelAndView doLogin(@Valid @ModelAttribute("loginBean") LoginBean loginBean, BindingResult bindingresult,
			HttpSession session,HttpServletRequest request,Model model) {
		 model.addAttribute("msg", "trades request, serving page " + request.getRequestURI());
		ModelAndView view = new ModelAndView("login");
		if (!bindingresult.hasErrors()) {
			if (!loginService.authenticateUser(loginBean)) {
				bindingresult.addError(new ObjectError("invalid", "Invalid Credentials!!!"));
				return new ModelAndView("login");
			} else {
				session.setAttribute("login", loginBean);
				view.setViewName("success");
			}
		}

		return view;
	}
	
	
	
	@RequestMapping(value = "/test/{type}", method = RequestMethod.GET)
	public String test(@PathVariable("type") String type) {
		if (type.equals("404")) {
			throw new GenericException("404", "404 exception");
		} else {
			throw new GenericException("405", "405 exception");
		}
	}

	@RequestMapping(value = "getResponse/{name}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity getShopInJSON(@PathVariable String name) {

		ResponseEntity entity = new ResponseEntity();
		entity.setMessgae("HI");
		entity.setName(name);
		ArrayList<String> list = new ArrayList<String>();
		list.add("robin1");
		list.add("robin2");
		list.add("robin3");
		list.add("robin4");
		list.add("robin5");
		list.add("robin6");
		list.add("robin7");
		list.add("robin8");
		return entity;

	}

	@RequestMapping(value = "/save/save-user", method = RequestMethod.POST)
	public ResponseEntity saveCompetitorDimension(@RequestBody ResponseEntity responseEntity) {
		System.out.println("Name :: " + responseEntity.getName());
		System.out.println("Message :: " + responseEntity.getMessgae());
		return responseEntity;
	}

	@RequestMapping(value = "/addData", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseBody
	public ResponseEntity addPerson(@RequestBody LoginBean loginBean) {

		ResponseEntity entity = new ResponseEntity();
		entity.setName(loginBean.getUserName());
		entity.setMessgae(loginBean.getPassword());
		return entity;
	}


	@RequestMapping("login.html")
	public String toLogin(Model model) {
		LoginBean login = new LoginBean();
		model.addAttribute("login", login);
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login.html";
	}

}