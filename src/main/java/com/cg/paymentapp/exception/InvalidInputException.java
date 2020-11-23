package com.cg.paymentapp.exception;

public class InvalidInputException extends RuntimeException {
	String msg;
	public InvalidInputException(String msg) {
		super(msg);
		this.msg=msg;
	}
}
