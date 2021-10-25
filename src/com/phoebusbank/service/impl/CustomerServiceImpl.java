package com.phoebusbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phoebusbank.dao.CustomerDao;
import com.phoebusbank.model.Customer;
import com.phoebusbank.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

 @Autowired
 private CustomerDao customerDao;

@Override
public Customer findCustomerById(int customer_id) {
	return customerDao.findCustomerById(customer_id);
}

@Override
public Customer saveCustomer(Customer customer) {
	return customerDao.saveCustomer(customer);
}

}