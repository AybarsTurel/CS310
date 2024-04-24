package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

/*
 * It is class for Account Summary. This one is additional class because we need to store different lists and return it into JSON object. It basically helps to create expected JSON.
 */

public class TransactionCollector {
	
	private String id;
	private String owner;
	private LocalDateTime createDate;
	private List<Transactions> transactionsOut;
	private List<Transactions> transactionsIn;
	private double balance;

	
	public TransactionCollector() 
	{
	}
	
	
	public TransactionCollector(String id, String owner, LocalDateTime createDate, List<Transactions> transactionsOut, List<Transactions> transactionsIn, double balance) {
		super();
		this.setId(id);
		this.setOwner(owner);
		this.setCreateDate(createDate);
		this.transactionsOut = transactionsOut;
		this.transactionsIn = transactionsIn;
		this.balance = balance;
		
	}
	
	
	

	public List<Transactions> getTransactionsOut() {
		return transactionsOut;
	}
	public void setTransactionsOut(List<Transactions> transactionsOut) {
		this.transactionsOut = transactionsOut;
	}
	public List<Transactions> getTransactionsIn() {
		return transactionsIn;
	}
	public void setTransactionsIn(List<Transactions> transactionsIn) {
		this.transactionsIn = transactionsIn;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public LocalDateTime getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}


	
	
	
	
	

}
