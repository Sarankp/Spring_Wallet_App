package com.cg.paymentapp.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.beans.BillType;
import com.cg.paymentapp.controller.BillPaymentController;
import com.cg.paymentapp.service.BillPaymentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value =BillPaymentController.class )
class BillPaymentControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BillPaymentServiceImpl billpaymentimpl;
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void testPostDTH() throws Exception{
		BillPayment payment = new BillPayment();
		payment.setBillId(1);
		payment.setBilltype(BillType.DTH);
		payment.setAmount(399);
		payment.setPaymentDate(LocalDate.now());
		Mockito.when(billpaymentimpl.addBillPayment(payment)).thenReturn(payment);
		String json = mapper.writeValueAsString(payment);
		mockMvc.perform(post("http://localhost:8080/wallet_app/payment/add").contentType(MediaType.APPLICATION_JSON)
		.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	
	@Test
	public void testGetDTH() throws Exception{
		BillPayment payment = new BillPayment();
		payment.setBillId(1);
		payment.setBilltype(BillType.DTH);
		payment.setAmount(399);
		payment.setPaymentDate(LocalDate.now());
		Mockito.when(billpaymentimpl.viewBillPayment(payment)).thenReturn(payment);
		mockMvc.perform(get("http://localhost:8080/wallet_app/payment/view")).andExpect(status().isOk());
	}
	
	
	@Test
	public void testPostPrepaid() throws Exception{
		BillPayment payment = new BillPayment();
		payment.setBillId(2);
		payment.setBilltype(BillType.MobilePrepaid);
		payment.setAmount(599);
		payment.setPaymentDate(LocalDate.now());
		Mockito.when(billpaymentimpl.addBillPayment(payment)).thenReturn(payment);
		String json = mapper.writeValueAsString(payment);
		mockMvc.perform(post("http://localhost:8080/wallet_app/payment/add").contentType(MediaType.APPLICATION_JSON)
		.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	
	@Test
	public void testGetPrepaid() throws Exception{
		BillPayment payment = new BillPayment();
		payment.setBillId(2);
		payment.setBilltype(BillType.MobilePrepaid);
		payment.setAmount(599);
		payment.setPaymentDate(LocalDate.now());
		Mockito.when(billpaymentimpl.viewBillPayment(payment)).thenReturn(payment);
		mockMvc.perform(get("http://localhost:8080/wallet_app/payment/view")).andExpect(status().isOk());
	}
	

	@Test
	public void testPostPostpaid() throws Exception{
		BillPayment payment = new BillPayment();
		payment.setBillId(3);
		payment.setBilltype(BillType.MobilePostpaid);
		payment.setAmount(999);
		payment.setPaymentDate(LocalDate.now());
		Mockito.when(billpaymentimpl.addBillPayment(payment)).thenReturn(payment);
		String json = mapper.writeValueAsString(payment);
		mockMvc.perform(post("http://localhost:8080/wallet_app/payment/add").contentType(MediaType.APPLICATION_JSON)
		.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	
	@Test
	public void testGetPostpaid() throws Exception{
		BillPayment payment = new BillPayment();
		payment.setBillId(3);
		payment.setBilltype(BillType.MobilePostpaid);
		payment.setAmount(999);
		payment.setPaymentDate(LocalDate.now());
		Mockito.when(billpaymentimpl.viewBillPayment(payment)).thenReturn(payment);
		mockMvc.perform(get("http://localhost:8080/wallet_app/payment/view")).andExpect(status().isOk());
	}
	

	@Test
	public void testCreditC() throws Exception{
		BillPayment payment = new BillPayment();
		payment.setBillId(4);
		payment.setBilltype(BillType.CreditCard);
		payment.setAmount(10000);
		payment.setPaymentDate(LocalDate.now());
		Mockito.when(billpaymentimpl.addBillPayment(payment)).thenReturn(payment);
		String json = mapper.writeValueAsString(payment);
		mockMvc.perform(post("http://localhost:8080/wallet_app/payment/add").contentType(MediaType.APPLICATION_JSON)
		.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	
	@Test
	public void testGetCreditC() throws Exception{
		BillPayment payment = new BillPayment();
		payment.setBillId(4);
		payment.setBilltype(BillType.CreditCard);
		payment.setAmount(10000);
		payment.setPaymentDate(LocalDate.now());
		Mockito.when(billpaymentimpl.viewBillPayment(payment)).thenReturn(payment);
		mockMvc.perform(get("http://localhost:8080/wallet_app/payment/view")).andExpect(status().isOk());
	}
	

	@Test
	public void testPostLIC() throws Exception{
		BillPayment payment = new BillPayment();
		payment.setBillId(5);
		payment.setBilltype(BillType.LICPremium);
		payment.setAmount(1116);
		payment.setPaymentDate(LocalDate.now());
		Mockito.when(billpaymentimpl.addBillPayment(payment)).thenReturn(payment);
		String json = mapper.writeValueAsString(payment);
		mockMvc.perform(post("http://localhost:8080/wallet_app/payment/add").contentType(MediaType.APPLICATION_JSON)
		.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	
	@Test
	public void testGetLIC() throws Exception{
		BillPayment payment = new BillPayment();
		payment.setBillId(5);
		payment.setBilltype(BillType.LICPremium);
		payment.setAmount(1116);
		payment.setPaymentDate(LocalDate.now());
		Mockito.when(billpaymentimpl.viewBillPayment(payment)).thenReturn(payment);
		mockMvc.perform(get("http://localhost:8080/wallet_app/payment/view")).andExpect(status().isOk());
	}
	

	@Test
	public void testPostLPG() throws Exception{
		BillPayment payment = new BillPayment();
		payment.setBillId(6);
		payment.setBilltype(BillType.LPG);
		payment.setAmount(650);
		payment.setPaymentDate(LocalDate.now());
		Mockito.when(billpaymentimpl.addBillPayment(payment)).thenReturn(payment);
		String json = mapper.writeValueAsString(payment);
		mockMvc.perform(post("http://localhost:8080/wallet_app/payment/add").contentType(MediaType.APPLICATION_JSON)
		.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	
	@Test
	public void testGetLPG() throws Exception{
		BillPayment payment = new BillPayment();
		payment.setBillId(5);
		payment.setBilltype(BillType.LPG);
		payment.setAmount(650);
		payment.setPaymentDate(LocalDate.now());
		Mockito.when(billpaymentimpl.viewBillPayment(payment)).thenReturn(payment);
		mockMvc.perform(get("http://localhost:8080/wallet_app/payment/view")).andExpect(status().isOk());
	}
	
	
}

