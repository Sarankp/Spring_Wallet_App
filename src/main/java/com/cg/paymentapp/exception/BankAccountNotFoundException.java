package com.cg.paymentapp.exception;

@SuppressWarnings("serial")
public class BankAccountNotFoundException extends RuntimeException {
String msg;

 public BankAccountNotFoundException(String msg) {
super(msg);
this.msg=msg;
}
}
