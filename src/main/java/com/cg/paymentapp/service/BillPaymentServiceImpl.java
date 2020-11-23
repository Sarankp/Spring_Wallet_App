package com.cg.paymentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.IBillPaymentRepository;
@Service
public class BillPaymentServiceImpl implements IBillPaymentService {
	
	@Autowired
	private IBillPaymentRepository BillpaymentRepository;
	
	@Override
	public BillPayment addBillPayment(BillPayment payment) {
		// TODO Auto-generated method stub
		return BillpaymentRepository.save(payment);
	}
	@Override
	public BillPayment viewBillPayment(BillPayment payment) throws InvalidInputException {
		return BillpaymentRepository.getOne(payment.getBillId());
		
	}

	

}
