package com.cg.paymentapp.beans;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name="transaction_table")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "transaction_id")
	private int id;
	@Column
	private String transactionType;
	@Column
	private LocalDate transactionDate;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="wallet_id")
	public Wallet wallet;
	@Column
	private double amount;
    @Column
	private String description;
    public int getId() {
		return id;
	}
    public void setId(int id) {
		this.id = id;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", type=" + transactionType
				+ ", date=" + transactionDate + ", amount=" + amount + ", description=" + description + "]";
	}
	
}