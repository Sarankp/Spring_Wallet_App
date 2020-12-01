package com.cg.paymentapp.service;

import java.util.List;

import com.cg.paymentapp.beans.BeneficiaryDetails;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;

public interface IBeneficiaryService {
	public BeneficiaryDetails addBeneficiary(BeneficiaryDetails bd) throws InvalidInputException;
	public BeneficiaryDetails updateBeneficiary(BeneficiaryDetails bd) throws InvalidInputException;
	public BeneficiaryDetails deleteBeneficiary(BeneficiaryDetails bd) throws InvalidInputException;
	public BeneficiaryDetails viewBeneficiary(BeneficiaryDetails bd) throws InvalidInputException;
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer) throws InvalidInputException;
	
}

