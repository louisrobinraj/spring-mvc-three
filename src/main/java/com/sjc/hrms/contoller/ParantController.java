package com.sjc.hrms.contoller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.sjc.hrms.exception.GenericException;

@Controller
public class ParantController {
	@ExceptionHandler(GenericException.class)
	public ModelAndView handleException(GenericException ex, HttpServletResponse response) throws IOException {
		ModelAndView model = new ModelAndView("/error/generic_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
		return model;

	}
}
