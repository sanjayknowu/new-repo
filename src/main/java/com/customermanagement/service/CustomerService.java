package com.customermanagement.service;

import java.util.List;

import com.customermanagement.model.Customer;

public interface CustomerService {

	public Customer getCustomerById(String id);
	
	public List<Customer> getAllCustomers();
	
	public Customer saveCustomer(Customer customer);
	
	public void deleteCustomer(String id);
	
}
