package com.customermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customermanagement.model.Customer;
import com.customermanagement.service.CustomerServiceImplementation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CustomerManagementController {

	@Autowired
	private CustomerServiceImplementation customerServiceImplementation;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer(){
		return customerServiceImplementation.getAllCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable("id") String id){
		return customerServiceImplementation.getCustomerById(id);
	}
	
	@PostMapping("/savecustomer")
	public Customer saveCustomer(@RequestBody Customer customer){
		return customerServiceImplementation.saveCustomer(customer);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Customer> deleteCustomer(@PathVariable("id") String id){
		customerServiceImplementation.deleteCustomer(id);
		return customerServiceImplementation.getAllCustomers();
	}
}
