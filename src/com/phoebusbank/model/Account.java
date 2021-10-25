package com.phoebusbank.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "ACCOUNT")
public class Account 
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_ID_SEQ")
  @SequenceGenerator(sequenceName = "PB_ACCOUNT_ID_SEQ", allocationSize = 1, name = "ACCOUNT_ID_SEQ")
  @Column(name = "ACCOUNT_ID")
  private int account_id;
	
  @Column(name = "ACCOUNT_NUMBER")
  private int account_number;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
  private Set<CustomerAccount> customer_accounts = new HashSet<CustomerAccount>();

public Account(int account_number) {
	super();
	this.account_number = account_number;
}

public Account() {
	super();
	// TODO Auto-generated constructor stub
}

public int getAccount_id() {
	return account_id;
}

public void setAccount_id(int account_id) {
	this.account_id = account_id;
}

public int getAccount_number() {
	return account_number;
}

public void setAccount_number(int account_number) {
	this.account_number = account_number;
}

public Set<CustomerAccount> getCustomer_accounts() {
	return customer_accounts;
}

public void setCustomer_accounts(Set<CustomerAccount> customer_accounts) {
	this.customer_accounts = customer_accounts;
}

@Override
public String toString() {
	return "Account [account_id=" + account_id + ", account_number=" + account_number + ", customer_accounts="
			+ customer_accounts + "]";
}

}