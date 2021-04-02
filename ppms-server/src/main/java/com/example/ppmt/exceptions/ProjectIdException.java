package com.example.ppmt.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ProjectIdException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProjectIdException(String message) {
		super(message);
	}
	
	 
}
