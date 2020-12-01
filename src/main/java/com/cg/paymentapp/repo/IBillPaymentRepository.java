package com.cg.paymentapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.beans.BillPayment;

@Repository
public interface IBillPaymentRepository extends JpaRepository<BillPayment,Integer>{

	//public BillPayment addBillPayment(BillPayment payment) throws InvalidInputException;
	//public BillPayment viewBillPayment(BillPayment payment) throws InvalidInputException;
	
	
}
