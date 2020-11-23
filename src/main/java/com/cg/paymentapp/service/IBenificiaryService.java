package com.cg.paymentapp.service;

import java.util.List;

import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;

public interface IBenificiaryService {
	public BenificiaryDetails addBenificiary(BenificiaryDetails bd) throws InvalidInputException;
	public BenificiaryDetails updateBenificiary(BenificiaryDetails bd) throws InvalidInputException;
	public BenificiaryDetails deleteBenificiary(BenificiaryDetails bd) throws InvalidInputException;
	public BenificiaryDetails viewBenificiary(BenificiaryDetails bd) throws InvalidInputException;
	public List<BenificiaryDetails> viewAllBenificiary(Customer customer) throws InvalidInputException;
	
}