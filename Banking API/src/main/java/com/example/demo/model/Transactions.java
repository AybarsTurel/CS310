package com.example.demo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


/*
 *  This class created to get transactions or put transactions to database. Therefore, it includes references and ids.
 * 	It is additional class and its different than requested class in document. It helps me the put data into DB. 
 * */


@Document
public class Transactions 
{

	
	
		@Id private String id;
		
		@DBRef private Account from;
		
		@DBRef private Account to;
		
		private LocalDateTime createDate;
		
		private Double amount;
		
		
		
		




		public Transactions() {
			
			
		}
		
		public Transactions(String id, Account from, Account to, LocalDateTime createDate, Double amount) {
			super();
			this.id = id;
			this.from = from;
			this.to = to;
			this.createDate = createDate;
			this.amount = amount;
		}

		
		
		
		public Transactions(Account from, Account to, LocalDateTime createDate, Double amount) {
			super();
			this.from = from;
			this.to = to;
			this.createDate =LocalDateTime.now();
			this.amount = amount;
			
		}




		public Transactions(String id, Account from, Account to) {
			super();
			this.id = id;
			this.from = from;
			this.to = to;
		}
		
		

		public Transactions(String id, Account from, Account to, Double amount) {
			super();
			this.id = id;
			this.from = from;
			this.to = to;
			this.amount = amount;
		}

		public Transactions(Account from, Account to, Double amount) {
			super();
			this.from = from;
			this.to = to;
			this.setCreateDate(LocalDateTime.now());
			this.setAmount(amount);
			
		}



		public Transactions(Account from, Account to) {
			super();
			this.from = from;
			this.to = to;
		}

		



		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Account getFrom() {
			return from;
		}

		public void setFrom(Account from) {
			this.from = from;
		}

		public Account getTo() {
			return to;
		}

		public void setTo(Account to) {
			this.to = to;
		}



		public Double getAmount() {
			return amount;
		}



		public void setAmount(Double amount) {
			this.amount = amount;
		}



		public LocalDateTime getCreateDate() {
			return createDate;
		}



		public void setCreateDate(LocalDateTime createDate) {
			this.createDate = createDate;
		}
		
		
		
		
}
