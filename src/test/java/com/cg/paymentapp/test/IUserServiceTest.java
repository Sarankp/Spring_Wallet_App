package com.cg.paymentapp.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.service.IUserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserServiceTest {
	
	@Autowired
	private IUserService userService;
	@Test
	public final void testValidateLogin() {
	
		Customer cust=new Customer();
		cust.setMobileNo("8008453620");
       cust.setPassword("Amara@08");
		assertNotNull(userService.validateLogin(cust.getMobileNo(),cust.getPassword()));	
	}
	@Test
	public final void testValidateLogin2() {
	
		Customer cust=new Customer();
		cust.setMobileNo("9014836030");
       cust.setPassword("Venkat@412");
		assertNull(userService.validateLogin(cust.getMobileNo(),cust.getPassword()));
	}
}
