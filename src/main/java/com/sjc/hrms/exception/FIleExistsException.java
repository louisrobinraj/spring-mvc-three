package com.sjc.hrms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Resource already exists")
public class FIleExistsException extends ServiceException{

	private static final long serialVersionUID = 1L;

	public FIleExistsException(String message) {
		super(message);
	}

}
