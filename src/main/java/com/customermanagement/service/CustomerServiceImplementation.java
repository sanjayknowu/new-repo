package com.customermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customermanagement.model.Customer;
import com.customermanagement.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation  implements CustomerService{
	
	@Autowired
	private CustomerRepository  customerRepository;

	@Override
	public Customer getCustomerById(String id) {
		// TODO Auto-generated method stub
		return customerRepository.findByid(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(String id) {
		
		customerRepository.deleteById(id);
		
	}

	
	
}
