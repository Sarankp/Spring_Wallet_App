package com.cg.paymentapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.beans.BeneficiaryDetails;
import com.cg.paymentapp.exception.InvalidInputException;
@Repository
public interface BeneficiaryRepositoryImpl  extends JpaRepository<BeneficiaryDetails,Integer>
{
	
	@Query("SELECT customer FROM Customer  customer WHERE customer.mobileNo=:mobNo")
	List<BeneficiaryDetails> findAll(@Param("mobNo") String mobNo) throws InvalidInputException ;
	
}


