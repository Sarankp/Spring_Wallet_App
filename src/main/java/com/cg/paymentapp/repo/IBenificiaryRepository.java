package com.cg.paymentapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;

public interface IBenificiaryRepository extends JpaRepository<BenificiaryDetails,Integer>{
	public BenificiaryDetails addBeneficiary(BenificiaryDetails bd) throws InvalidInputException;
	public BenificiaryDetails updateBeneficiary(BenificiaryDetails bd) throws InvalidInputException;
	public BenificiaryDetails deleteBeneficiary(BenificiaryDetails bd) throws InvalidInputException;
	public BenificiaryDetails viewBeneficiary(BenificiaryDetails bd) throws InvalidInputException;
	public List<BenificiaryDetails> viewAllBeneficiary(Customer customer) throws InvalidInputException;
	
}