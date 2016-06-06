package com.spotippos.exception;

import java.util.List;

public class CouldNotInsertRealtyException extends Exception {

	private static final long serialVersionUID = 6986066332928109890L;
	
	private List<InvalidRealtyException> exceptions;
	
	public CouldNotInsertRealtyException(String message, List<InvalidRealtyException> exceptions) {
		super(message);
		this.exceptions = exceptions;
	}

	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer(super.getMessage());
		exceptions.forEach(exception -> {
			sb.append("\n");
			sb.append(exception.getMessage());
		});
		return sb.toString();
	}
}
