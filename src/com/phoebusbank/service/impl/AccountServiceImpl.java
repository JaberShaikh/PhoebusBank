package com.phoebusbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phoebusbank.dao.AccountDao;
import com.phoebusbank.model.Account;
import com.phoebusbank.service.AccountService;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public Account saveAccount(Account account) {
		return accountDao.saveAccount(account);
	}
	
}
