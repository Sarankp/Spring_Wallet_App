package com.cg.paymentapp.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.beans.BillType;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.service.IBillPaymentService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BillPaymentServiceTest {
	@Autowired
	private IBillPaymentService billPaymentService;
	

	@Test
	public final void testAddBillPayment() {
		BillPayment payment = new BillPayment();
		payment.setBillId(4);
		payment.setBilltype(BillType.LPG);
		payment.setAmount(700);
		payment.setPaymentDate(LocalDate.now());
		Wallet wallet =new Wallet();
		wallet.setWalletId(4);
		payment.setWallet(wallet);
		assertNotNull(billPaymentService.addBillPayment(payment));
	
	}

	@Test
	public final void testViewBillPayment() {
		BillPayment payment = new BillPayment();
		payment.setBillId(4);
		payment.setBilltype(BillType.LPG);
		payment.setAmount(700);
		payment.setPaymentDate(LocalDate.now());
		Wallet wallet =new Wallet();
		wallet.setWalletId(4);
		payment.setWallet(wallet);
		assertNotNull(billPaymentService.addBillPayment(payment));
		
	}

}
