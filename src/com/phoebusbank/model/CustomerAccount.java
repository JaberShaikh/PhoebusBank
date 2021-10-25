package com.phoebusbank.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.phoebusbank.model.Customer;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

@Entity
@Table(name = "CUSTOMERACCOUNTS")
public class CustomerAccount 
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMERACCOUNT_ID_SEQ")
  @SequenceGenerator(sequenceName = "PB_CUSTOMERACCOUNT_ID_SEQ", allocationSize = 1, name = "CUSTOMERACCOUNT_ID_SEQ")
  @Column(name = "CUSTOMER_ACCOUNT_ID")
  private int customer_account_id;
	
  @Column(name = "ACCOUNT_ID")
  private int account_id;

  @Column(name = "CUSTOMER_ID")
  private int customer_id;

  @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
  @JoinColumn(name = "CUSTOMER_ID", insertable = false, updatable = false)  
  private Customer customer;

  @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
  @JoinColumn(name = "ACCOUNT_ID", insertable = false, updatable = false)  
  private Account account;

public int getCustomer_account_id() {
	return customer_account_id;
}

public void setCustomer_account_id(int customer_account_id) {
	this.customer_account_id = customer_account_id;
}

public int getAccount_id() {
	return account_id;
}

public void setAccount_id(int account_id) {
	this.account_id = account_id;
}

public int getCustomer_id() {
	return customer_id;
}

public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public Account getAccount() {
	return account;
}

public void setAccount(Account account) {
	this.account = account;
}

@Override
public String toString() {
	return "CustomerAccount [customer_account_id=" + customer_account_id + ", account_id=" + account_id
			+ ", customer_id=" + customer_id + ", customer=" + customer + ", account=" + account + "]";
}
  
}