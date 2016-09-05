package com.sjc.hrms.contoller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.sjc.hrms.exception.GenericException;

@Controller
public class ParantController {
	@ExceptionHandler(GenericException.class)
	public String  handleException(GenericException ex, HttpServletResponse response,HttpServletRequest request) throws IOException {
		System.out.println("error occuered "+request.getRequestURI());
		ModelAndView model = new ModelAndView();
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
		return "/error/generic_error";

	}
	
}