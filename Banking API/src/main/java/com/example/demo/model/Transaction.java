package com.example.demo.model;

public class Transaction {
	 
	/* Transactions must have from account id (String), to account id (String) and the amount
	 * transferred (Double). It is from Assignment page. This is the class which meets the requirement.
	 */
	
	private String fromAccountId;
	private String toAccountId;
	private double amount;
	
	public Transaction() {

	}
	public Transaction(String fromAccountId, String toAccountId, double amount) {
		super();
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
	}
	public String getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public String getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	

}
