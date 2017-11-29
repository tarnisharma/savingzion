package com.saving.zion.fishonindia.exceptions;

public class CustomAjaxException extends RuntimeException{
	/**
	 * Generated version UID.
	 */
	private static final long serialVersionUID = 1L;

	
	public CustomAjaxException() {
		super();
	}
	
	/**
	 * 
	 * @param message
	 */
	public CustomAjaxException(String message) {
		super(message);
	}


	public CustomAjaxException(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public CustomAjaxException(String message,Throwable cause) {
		super(message, cause);
	}
}
