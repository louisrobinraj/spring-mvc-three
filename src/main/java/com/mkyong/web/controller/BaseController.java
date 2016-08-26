package com.mkyong.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjc.hrms.exception.ExceptionMessageDTO;
import com.sjc.hrms.exception.FileNotFoundException;
import com.sjc.hrms.exception.PrivillageException;
import com.sjc.hrms.exception.ServiceException;

@Controller
//@RequestMapping(value = "/apps/v1")
public class BaseController {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ExceptionMessageDTO handleException(RuntimeException e, HttpServletResponse response) throws IOException {
		HttpStatus responseCode = HttpStatus.BAD_REQUEST;
		if (e instanceof FileNotFoundException) {
			responseCode = HttpStatus.NOT_FOUND;
		} else if (e instanceof PrivillageException) {
			responseCode = HttpStatus.FORBIDDEN;
		} else if (e instanceof IllegalArgumentException) {
			responseCode = HttpStatus.FORBIDDEN;
		}
		else if (e instanceof ServiceException) {
			responseCode = HttpStatus.FORBIDDEN;
		}
		response.setStatus(responseCode.value());
		ExceptionMessageDTO msg = new ExceptionMessageDTO();
		msg.setMessage(e.getMessage());
		return msg;
	}

}
