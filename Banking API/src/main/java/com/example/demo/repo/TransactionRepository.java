package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Data;
import com.example.demo.model.Transactions;





public interface TransactionRepository extends MongoRepository<Transactions, String> {

}
