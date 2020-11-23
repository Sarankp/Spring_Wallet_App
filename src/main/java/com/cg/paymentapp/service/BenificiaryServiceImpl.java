package com.cg.paymentapp.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.BenificiaryDetails;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repo.IBenificiaryRepository;
@Service

public class BenificiaryServiceImpl implements IBenificiaryService {
	@SuppressWarnings("unused")
	@Autowired
	private IBenificiaryRepository bdRepository;
	
	

	@Override
	public BenificiaryDetails addBenificiary(BenificiaryDetails bd) throws InvalidInputException {
		
		return bdRepository.save(bd);
	}

	@Override
	public BenificiaryDetails updateBenificiary(BenificiaryDetails bd) throws InvalidInputException {
	
		return  bdRepository.save(bd);
	}

	@Override
	public BenificiaryDetails deleteBenificiary(BenificiaryDetails bd) throws InvalidInputException {
		// TODO Auto-generated method stub
		/*Optional< BeneficiaryDetails>bds = bdRepository.delete(bd);
		BeneficiaryDetails beneficiary = null;
		if(bds.isPresent()) {
			beneficiary = bds.get();
		}*/
		bdRepository.deleteBeneficiary(bd);
		return bd;
	}

	@Override
	public BenificiaryDetails viewBenificiary(BenificiaryDetails bd) throws InvalidInputException {
		// TODO Auto-generated method stub
		/*ptional< BeneficiaryDetails>bds = bdRepository.(bd);
		BeneficiaryDetails beneficiary = null;
		if(bds.isPresent()) {
		beneficiary = bds.get();*/
		//}
		bdRepository.viewBeneficiary(bd);
		return bd;
		
	}
	
	@Override
	public List<BenificiaryDetails> viewAllBenificiary(Customer customer) throws InvalidInputException {
		// TODO Auto-generated method stub
		return  bdRepository.viewAllBeneficiary(customer);
	}

}