package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.model.Transaction;
import com.example.demo.model.TransactionCollector;
import com.example.demo.model.Transactions;
import com.example.demo.model.Data;
import com.example.demo.repo.AccountRepository;
import com.example.demo.repo.TransactionRepository;


import jakarta.annotation.PostConstruct;


// I preferred to use all mapping here so I won't ad RestContoller shortcut.

@RestController
public class Controller {

	@Autowired private AccountRepository accountRepository;
	@Autowired private TransactionRepository transactionRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	@PostConstruct
	public void init() 
	{
		
	
		if(accountRepository.count() == 0) //It puts data into database if there is no element in database.When Spring Boot application starts, manage the MongoDB database initialization and insertion of test data (if no data exists) part in document. 
		{
			logger.info("Database is empty, initializing...");
			logger.info("First account is sending to database...");
			Account account1 = new Account("1111", "Jack Johns"); // Account 1
			accountRepository.save(account1);
			
			logger.info("Second account is sending to database...");
			Account account2 = new Account("2222", "Henry Williams"); // Account 2
			accountRepository.save(account2);
			
			
			
			logger.info("First transaction is sending to database...");
			Transactions transaction1 = new Transactions(account1, account2, 1500.0); // Transaction 1
			transactionRepository.save(transaction1);
			
			logger.info("Second transaction is sending to database...");
			Transactions transaction2 = new Transactions(account2, account1, 2500.0); // Transaction 2
			transactionRepository.save(transaction2);
			
			
		
		}
		
		
	}
	@PostMapping("/account/save")
	public Data<Account> saveAccount(@RequestBody Account data) 
	{
		Account accountToSave = new Account(data.getId(),data.getOwner());
		Data<Account> temp = new Data<Account>(accountToSave); // It will be packet data to send JSON message to user.
		String tempMessage = temp.getMessage();
		if(tempMessage.charAt(0) != 'E') // It won't add data if system creates error message. Therefore my database will much clearer. It controls message's first element to understand whether there is an error or not.
		{
			accountRepository.save(accountToSave);
		}
		return temp;
		
		
	}
	
	@PostMapping("/transaction/save")
	public Data<Transactions> saveTransaction(@RequestBody Transaction transaction) 
	{
		Account accFromId = null;
		Account accToId = null;
		
		List<Account> accList = accountRepository.findAll(); //It takes all element in account database
		
		for(int i = 0; i<accList.size(); i++) // It will create accounts whose from and to will equal to requested transaction.
		{
			
			if((accList.get(i).getId()).equals(transaction.getFromAccountId())) 
			{
				accFromId = accList.get(i);
			}
			else if((accList.get(i).getId()).equals(transaction.getToAccountId())) 
			{
				accToId = accList.get(i);
				
			}
		}
		Transactions dataSend = new Transactions(accFromId, accToId, transaction.getAmount()); // It sends new transaction to transactions database.
		Data<Transactions> temp = new Data<Transactions>(dataSend); // It is for JSON message.
		if(temp.getMessage().charAt(0) != 'E')
		{
			transactionRepository.save(dataSend);
		}
		
		return temp;
	}
		
		
		@GetMapping("/account/{accountId}")
		public Data<TransactionCollector> accountSummary(@PathVariable String accountId)
		{
			Transactions temp1 = null;
			Data<TransactionCollector> temp2 = new Data<TransactionCollector>();
			boolean error = true;
			double balance = 0.0;
			List<Transactions> transactionsAll = transactionRepository.findAll();
			List<Account> accountList = accountRepository.findAll();
			for(int i = 0; i<accountList.size() && error; i++)  // It checks requested account is in the database.
			{
				if(accountList.get(i).getId().equals(accountId)) 
				{
					error = false;
				}
			}
			
			
			
			
			
			List<Transactions> transactionsOut = new ArrayList<Transactions>();
			List<Transactions> transactionsIn = new ArrayList<Transactions>();
			
			for(int i = 0; i < transactionsAll.size() && !error; i++) 
			{
				Transactions temp = transactionsAll.get(i);
				Account accountTempSender = temp.getFrom(); 
				Account accountTempReciever = temp.getTo();
				if(accountId.equals(accountTempSender.getId()))  // It will distinguish sender and receiver and calculate balance.
				{
					//logger.info(accountId);
					transactionsOut.add(temp);
					balance = balance - temp.getAmount();
				}
				else if(accountId.equals(accountTempReciever.getId())) 
				{
					transactionsIn.add(temp);
					balance = balance + temp.getAmount();
					//logger.info(accountId);
				}
			}
			if(!error && transactionsOut.size() != 0) 
			{
				temp1 = transactionsOut.get(0);
				Account accountTempSender = temp1.getFrom(); 
				TransactionCollector temp = new TransactionCollector(accountTempSender.getId(), accountTempSender.getOwner(), accountTempSender.getCreateDate(),transactionsOut,transactionsIn,balance); // This is for creating requested JSON object.
				temp2 = new Data<TransactionCollector>(temp);
				
			}
			else 
			{
				temp1 =  null;
				temp2.setMessage("ERROR:account doesnt exist!");
			}
			
			
			
			return temp2;
			
		}
		
		@GetMapping("/transaction/to/{accountId}")
		public Data<List<Transactions>> listIncomingTransactions(@PathVariable String accountId)
		{
			
			boolean error = true;
			List<Transactions> transactionsAll = transactionRepository.findAll();
			List<Account> accountList = accountRepository.findAll();
			
			for(int i = 0; i<accountList.size() && error; i++) // It checks whether requested account in db or not.
			{
				if(accountList.get(i).getId().equals(accountId)) 
				{
					error = false;
				}
			}
			
			
			
			
			
			List<Transactions> transactionsTo = new ArrayList<Transactions>();
			
			
			for(int i = 0; i < transactionsAll.size() && !error; i++) 
			{
				Transactions temp = transactionsAll.get(i);
				Account accountTempReciever = temp.getTo();
				
				if(accountId.equals(accountTempReciever.getId())) // It looks every transaction one by one and get the account whose to id equal to requested one and store it.
				{
					transactionsTo.add(temp);
					//logger.info(accountId);
				}
			}
			
			
			Data<List<Transactions>> temp1 = new Data<List<Transactions>>(transactionsTo); // It is for JSON object.
			if(transactionsTo.size() == 0) 
			{
				temp1.setMessage("ERROR:account doesn't exist!");
				temp1.setData(null);
			}
			else 
			{
				temp1.setMessage("SUCCESS");
				
			}
			
			
			return temp1;
			
		}
		
		@GetMapping("/transaction/from/{accountId}")
		public Data<List<Transactions>> listOutgoingTransactions(@PathVariable String accountId)
		{
			
			boolean error = true; //It checks there is account with this Id.
			List<Transactions> transactionsAll = transactionRepository.findAll();
			List<Account> accountList = accountRepository.findAll();
			
			for(int i = 0; i<accountList.size() && error; i++) 
			{
				if(accountList.get(i).getId().equals(accountId)) 
				{
					error = false;
				}
			}
			
			
			
			
			
			List<Transactions> transactionsFrom = new ArrayList<Transactions>();
			
			
			for(int i = 0; i < transactionsAll.size() && !error; i++) 
			{
				Transactions temp = transactionsAll.get(i);
				Account accountTempSender = temp.getFrom();
				
				if(accountId.equals(accountTempSender.getId())) // It looks every transaction one by one and get the account whose from id equal to requested one and store it.
				{
					transactionsFrom.add(temp);
					//logger.info(accountId);
				}
			}
			
			
			Data<List<Transactions>> temp1 = new Data<List<Transactions>>(transactionsFrom); // It creates JSON message.
			if(transactionsFrom.size() == 0) 
			{
				temp1.setMessage("ERROR:account doesn't exist!");
				temp1.setData(null);
			}
			else 
			{
				temp1.setMessage("SUCCESS");
				
			}
			
			
			return temp1;
			
		}
	
}
