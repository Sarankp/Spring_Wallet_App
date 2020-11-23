package com.cg.paymentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.service.IBillPaymentService;

@RestController
@RequestMapping("/billpayment")
public class BillPaymentController {
	@Autowired
	private IBillPaymentService BillPaymentService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/payment/add")
	public ResponseEntity<BillPayment> insertBillPayment(
			@RequestBody BillPayment payment){
		BillPayment pmt = BillPaymentService.addBillPayment(payment);
		
		if(pmt == null)
		{
			return new ResponseEntity("Sorry! couldn't update!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<BillPayment>(pmt, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/payment/view")
	public ResponseEntity<BillPayment> viewBillPayment(
			@RequestBody BillPayment payment){
		BillPayment pmt = BillPaymentService.viewBillPayment(payment);
		
		if(pmt == null)
		{
			return new ResponseEntity("Sorry! couldn't update!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<BillPayment>(pmt, HttpStatus.OK);
	}
	
	
}
