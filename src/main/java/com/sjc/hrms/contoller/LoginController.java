package com.sjc.hrms.contoller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

	public static final  String indexPageName="index";
	public static final  String loginPageName="login";
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView initApp() {
		return new ModelAndView(indexPageName);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView viewLoginPage(Model model) {
		model=loginService.viewLoginPage(model);
		return new ModelAndView(loginPageName); 
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(@Valid @ModelAttribute("loginBean") LoginBean loginBean, BindingResult bindingresult,HttpSession session, HttpServletRequest request, Model model) {
		return loginService.authenticateUser(loginBean, bindingresult, session, request, model);
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
	public ResponseEntity saveData(@RequestBody ResponseEntity responseEntity) {
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

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}