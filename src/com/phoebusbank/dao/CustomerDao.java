package com.phoebusbank.dao;

import com.phoebusbank.model.Customer;

public interface CustomerDao {
  Customer findCustomerById(int customer_id);
  Customer saveCustomer(Customer customer);
}