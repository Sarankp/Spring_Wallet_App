package com.cg.paymentapp.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.BeneficiaryDetails;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.BeneficiaryRepositoryImpl;
@Service
public class BeneficiaryServiceImpl implements IBeneficiaryService {
	@Autowired
	private  BeneficiaryRepositoryImpl repo;
	
	

	@Override
	public BeneficiaryDetails addBeneficiary(BeneficiaryDetails bd) throws InvalidInputException {
		
		return repo.save(bd);
	}

	@Override
	public BeneficiaryDetails updateBeneficiary(BeneficiaryDetails bd) throws InvalidInputException {
	
		return repo.save(bd);
	}

	@Override
	public BeneficiaryDetails deleteBeneficiary(BeneficiaryDetails bd) throws InvalidInputException {
		// TODO Auto-generated method stub
		Optional< BeneficiaryDetails>bds = repo.findById(bd.getBeneficiaryId());
		BeneficiaryDetails beneficiary = null;
		if(bds.isPresent()) {
			beneficiary = bds.get();
		}
		repo.delete(bd);;
		return beneficiary;
	}
	

	@Override
	public BeneficiaryDetails viewBeneficiary(BeneficiaryDetails bd) throws InvalidInputException {
		// TODO Auto-generated method stub
		Optional< BeneficiaryDetails>bds = repo.findById(bd.getBeneficiaryId());
		BeneficiaryDetails beneficiary = null;
		if(bds.isPresent()) {
		beneficiary = bds.get();
		}
		return beneficiary;
			}

	@Override
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer) throws InvalidInputException {
		// TODO Auto-generated method stub
		return  repo.findAll(customer.getMobileNo());
	}

	
}
