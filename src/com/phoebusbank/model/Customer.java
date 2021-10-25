package com.phoebusbank.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_ID_SEQ")
  @SequenceGenerator(sequenceName = "PB_CUSTOMER_ID_SEQ", allocationSize = 1, name = "CUSTOMER_ID_SEQ")
  @Column(name = "CUSTOMER_ID")
  private int customer_id;
  
  @Column(name = "FIRSTNAME")
  private String firstname;

  @Column(name = "SURNAME")
  private String surname;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
  private Set<CustomerAccount> customer_accounts = new HashSet<CustomerAccount>();

public int getCustomer_id() {
	return customer_id;
}

public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getSurname() {
	return surname;
}

public void setSurname(String surname) {
	this.surname = surname;
}

public Set<CustomerAccount> getCustomer_accounts() {
	return customer_accounts;
}

public void setCustomer_accounts(Set<CustomerAccount> customer_accounts) {
	this.customer_accounts = customer_accounts;
}

@Override
public String toString() {
	return "Customer [customer_id=" + customer_id + ", firstname=" + firstname + ", surname=" + surname
			+ ", customer_accounts=" + customer_accounts + "]";
}
  
}