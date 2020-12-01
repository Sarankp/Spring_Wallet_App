package com.cg.paymentapp.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.service.WalletService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletServiceTest {
	@Autowired
	private WalletService walletservice;

	
	@Test
	public final void testcreateAccount() {
		Customer customer=new Customer();
		customer.setName("ww");
		customer.setMobileNo("56789");
		Wallet wallet=new Wallet();
		wallet.setBalance(null);
		customer.setWallet(wallet);
		assertNotNull(walletservice.createAccount(null, null, null));
		}
	@Test
	public final void testsave() {
		Customer customer=new Customer();
		customer.setName("ww");
		assertNotNull(walletservice.save(customer));

	}
	
     @Test
     public final void testfindOne() {
    	 Customer customer=new Customer();
    	 }
     
     
} 
     
     
     /*@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}*/


