package com.phoebusbank.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phoebusbank.dao.CustomerDao;
import com.phoebusbank.model.Customer;

@Transactional
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

 @Autowired
 private SessionFactory sessionFactory;
 
@Override
public Customer findCustomerById(int customer_id) {
	return (Customer) sessionFactory.getCurrentSession().createQuery("FROM Customer WHERE customer_id = " + customer_id).uniqueResult();  
}

@Override
public Customer saveCustomer(Customer customer) {
	sessionFactory.getCurrentSession().save(customer);
	sessionFactory.getCurrentSession().flush();
	sessionFactory.getCurrentSession().refresh(customer);
	return customer;
}

}