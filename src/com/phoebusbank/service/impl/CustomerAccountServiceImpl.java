package com.phoebusbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phoebusbank.dao.CustomerAccountDao;
import com.phoebusbank.service.CustomerAccountService;

@Service("customerAccountService")
@Transactional
public class CustomerAccountServiceImpl implements CustomerAccountService {

 @Autowired
 private CustomerAccountDao customerAccountDao;
 
@Override
public void saveCustomerAccount(int customer_id, int account_id) {
	customerAccountDao.saveCustomerAccount(customer_id, account_id);
}

}