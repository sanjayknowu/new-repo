package com.customermanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.customermanagement.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	// Method to get Customer By String Id
	Customer findByid(String id);
	
	
	
}
