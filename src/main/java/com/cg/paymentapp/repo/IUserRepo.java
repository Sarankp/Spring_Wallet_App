package com.cg.paymentapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.beans.Customer;
@Repository
public interface IUserRepo extends JpaRepository<Customer,String> {

	public Customer findCustomerBymobileNoAndPassword(String mobileNumber, String password);
}