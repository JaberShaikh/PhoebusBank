package com.phoebusbank.service;

import com.phoebusbank.model.Customer;

public interface CustomerService {
	  Customer findCustomerById(int customer_id);
	  Customer saveCustomer(Customer customer);
}