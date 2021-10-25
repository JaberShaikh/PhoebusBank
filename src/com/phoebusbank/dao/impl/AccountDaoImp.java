package com.phoebusbank.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phoebusbank.dao.AccountDao;
import com.phoebusbank.model.Account;

@Transactional
@Repository("accountDao")
public class AccountDaoImp implements AccountDao {

  @Autowired
  private SessionFactory sessionFactory;

@Override
public Account saveAccount(Account account) {
	sessionFactory.getCurrentSession().save(account);
	sessionFactory.getCurrentSession().flush();
	sessionFactory.getCurrentSession().refresh(account);
	return account;
}
  
}
