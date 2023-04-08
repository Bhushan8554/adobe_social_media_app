package com.adobe.exceptions;

public class PostException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	public PostException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PostException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PostException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PostException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
