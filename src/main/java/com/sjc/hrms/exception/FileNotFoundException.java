package com.sjc.hrms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Resource not found")
public class FileNotFoundException extends ServiceException{
	private static final long serialVersionUID = 1L;

	public FileNotFoundException(String message){
		super(message);
	}
}
