package com.phoebusbank.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phoebusbank.dao.CustomerAccountDao;
import com.phoebusbank.model.CustomerAccount;

@Transactional
@Repository("customerAccountDao")
public class CustomerAccountDaoImpl implements CustomerAccountDao {

 @Autowired
 private SessionFactory sessionFactory;
 
@Override
public void saveCustomerAccount(int customer_id, int account_id) {
	CustomerAccount customer_account = new CustomerAccount();
	customer_account.setCustomer_id(customer_id);
	customer_account.setAccount_id(account_id);
	sessionFactory.getCurrentSession().save(customer_account);
}

}