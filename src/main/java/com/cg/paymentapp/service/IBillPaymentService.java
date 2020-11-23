package com.cg.paymentapp.service;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.exception.InvalidInputException;

public interface IBillPaymentService {

	public BillPayment addBillPayment(BillPayment payment) throws InvalidInputException;
	public BillPayment viewBillPayment(BillPayment payment) throws InvalidInputException;
	
}
