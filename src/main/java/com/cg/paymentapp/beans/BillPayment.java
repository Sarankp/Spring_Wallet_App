package com.cg.paymentapp.beans;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
	
	@Entity
	@Table(name="billpayment_table")
	public class BillPayment {
		/**
		 * The BillPayment Class contains all the Entities, Variables, Constructors and
		 * all the necessary  Class methods.*/

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int billId;
		
		
		private BillType billtype;
		
		private double amount;
		
		private LocalDate paymentDate;
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="walletid")
		private Wallet wallet;
		
		/**
		 * @param billId
		 * @param wallet
		 * @param billtype
		 * @param amount
		 * @param paymentDate
		 */
	
		public BillPayment() {}
		public BillPayment(int billId,Wallet wallet,  BillType billtype, double amount, LocalDate paymentDate) {
			super();
			this.billId = billId;
			this.wallet = wallet;
			this.billtype = billtype;
			this.amount = amount;
			this.paymentDate = paymentDate;
		}
		
		
		/**
		 * @return the billId
		 * @param billId to set the billId
		 */
		public int getBillId() {
			return billId;
		}
		public void setBillId(int billId) {
			this.billId = billId;
		}
		
		/**
		 * @return the wallet
		 * @param wallet to set the wallet
		 */
		public Wallet getWallet() {
			return wallet;
		}
		public void setWallet(Wallet wallet) {
			this.wallet = wallet;
		}
		
		/**
		 * @return the billtype
		 * @param billtype to set the billtype
		 */
		public BillType getBilltype() {
			return billtype;
		}
		public void setBilltype(BillType billtype) {
			this.billtype = billtype;
		}
		
		/**
		 * @return the amount
		 * @param amount to set the amount
		 */
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		
		/**
		 * @return the paymentDate
		 * @param paymentDate to set the paymentDate
		 */
		public LocalDate getPaymentDate() {
			return paymentDate;
		}
		public void setPaymentDate(LocalDate paymentDate) {
			this.paymentDate = paymentDate;
		}
		@Override
		public String toString() {
			return "BillPayment [billId=" + billId + ", wallet=" + wallet + ", billtype=" + billtype + ", amount="
					+ amount + ", paymentDate=" + paymentDate + "]";
		}
		
		

}
