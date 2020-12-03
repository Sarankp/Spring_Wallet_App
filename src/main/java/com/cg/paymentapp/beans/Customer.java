package com.cg.paymentapp.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan(basePackages = {"com.cg.paymentapp.entity"})
@Entity
@Table(name="Customer_table")
public class Customer {
	@Column	
	private String name;
	@Id
	@NotEmpty(message = "Phone number is required")
	@Pattern(regexp="^[0-9]{10}",message="Mobile number is invalid")
	private String mobileNo; 
	@Column
	@NotEmpty(message = "Password is required")
	@Pattern(regexp="^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&-+=])(?=\\S+$).{8,20}$", message = "Invalid Password!!!")
	private String password;
   @OneToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="walletId")
   private Wallet wallet;
	
		public Customer() {
		}
		
		public Customer(String name, String mobileNo, String password, Wallet wallet) {
			super();
			this.name = name;
			this.mobileNo = mobileNo;
			this.password = password;
			this.wallet = wallet;
		}
		
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
		
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		public Wallet getWallet() {
			return wallet;
		}


		public void setWallet(Wallet wallet) {
			this.wallet = wallet;
		}

		@Override
		public String toString() {
		return "Customer name=" + name + ", mobileNo=" + mobileNo;
				//+", Wallet="+wallet;
						 
				}

}
