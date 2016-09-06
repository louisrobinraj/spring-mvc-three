package com.sjc.hrms.contoller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjc.hrms.model.LoginBean;
import com.sjc.hrms.model.ResponseEntity;

public class HrmsController {
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
}
