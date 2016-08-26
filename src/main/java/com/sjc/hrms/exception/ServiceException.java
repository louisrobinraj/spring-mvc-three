package com.sjc.hrms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class ServiceException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ServiceException(String message){
		super(message);
	}
	
	public ServiceException(Throwable t){
		super(t);
	}

	public ServiceException(String message, Throwable t){
		super(message, t);
	}
	

}
