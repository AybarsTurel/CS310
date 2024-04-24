package com.example.demo.model;


/*
 * It is the class that put data into packages. It helps to create JSON object with message.
 */

public class Data<T> {
	

	private String message;
	private T data;
	
	
	public Data() {
		
	}
	
	public Data(T data) {
		super();
		if(data instanceof Transactions) // These statements find the class data in and check accordingly. As mentioned in document there are several data types such as transactions, account and they have different conditions to check.
		{
			message = Checker((Transactions)data);
			if(message.charAt(0) == 'E') // This check messages first latter and if it is E, it will understand data is problematic and turn data packet into null.
			{
				data = null;
				
			}
		}
		else if(data instanceof Account)
		{
			message = Checker((Account)data);
			if(message.charAt(0) == 'E') 
			{
				data = null;
				
			}
		}
		else if(data instanceof TransactionCollector)
		{
			message = Checker((TransactionCollector)data);
			if(message.charAt(0) == 'E') 
			{
				data = null;
				
			}
		}
		
		
		
		this.message = message;
		this.data = data;
	}
	
	// Classes below is controlling variables in data packages such as id, amount etc. There are three different classes.

	public String Checker(Transactions data) // It check elements in transaction class
	{
		String message;
		if((data.getTo() == null || data.getFrom() == null) && (data.getAmount() != 0.0) ) 
		{
			message = "ERROR: account id";
			data = null;
			
			
		}
		else if((data.getFrom() == null || data.getTo() == null || data.getAmount() == 0.0))  // It checks elements in class especially for amount.
		{
			message = "ERROR:missing fields";
			data = null;
		}
		else 
		{
			
			message = "SUCCESS";
			
			
		}
		return message;
	}
	
	public String Checker(Account data)  // It checks account id
	{
		String message;
		if(data.getId() == null || data.getOwner() == null) 
		{
			message = "ERROR:missing fields";
			data = null;
		}
		else 
		{
			
			message = "SUCCESS";
			
			
		}
		return message;
	}
	public String Checker(TransactionCollector data) // It checks for search operation. If there is no transaction for requested account it will give error message.
	{
		String message;
		if(data.getTransactionsIn().size() == 0 && data.getTransactionsOut().size() == 0) 
		{
			message = "ERROR:account doesnt exist!";
			data = null;
		}
		else 
		{
			
			message = "SUCCESS";
			
			
		}
		return message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	

}
