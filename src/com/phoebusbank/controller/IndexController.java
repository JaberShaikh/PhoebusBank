package com.phoebusbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.phoebusbank.model.Account;
import com.phoebusbank.model.Customer;
import com.phoebusbank.service.AccountService;
import com.phoebusbank.service.CustomerAccountService;
import com.phoebusbank.service.CustomerService;

@Controller
public class IndexController 
{
  
  @Autowired
  AccountService accountService;

  @Autowired
  CustomerAccountService customerAccountService;

  @Autowired
  CustomerService customerService;
	
 @RequestMapping(value = {"/","/home"}, method = {RequestMethod.GET,RequestMethod.POST})
 public String welcomePage() 
 {
 	 return "welcome";
 }

 @RequestMapping(value = {"/customer_registration"}, method = RequestMethod.POST)
 public String customerRegistration(ModelMap model)
 {
	 model.addAttribute("customer", new Customer());
	 
 	 return "registration";
 }

 @RequestMapping(value = {"/search_customer"}, method = RequestMethod.POST)
 public String searchCustomer(ModelMap model,
		 @RequestParam(value = "customer_id", required = false, defaultValue = "0") String customer_id)
 {
	if(isNumeric(customer_id))
		model.addAttribute("search_customer_result", customerService.findCustomerById(Integer.valueOf(customer_id)));
	else
		 model.addAttribute("search_customer_result", null);
 	 return "search";
 }
 
 @RequestMapping(value = {"/save_customer"}, method = RequestMethod.POST)
 public String saveCustomer(ModelMap model,
		 @ModelAttribute("customer") Customer customer, 
		 @RequestParam(value = "account_number") String account_number) 
 {
	 customer = customerService.saveCustomer(customer);
	 Account account = new Account(Integer.valueOf(account_number));
	 account = accountService.saveAccount(account);
	 customerAccountService.saveCustomerAccount(customer.getCustomer_id(), account.getAccount_id());
	 
	 model.addAttribute("customer", customer);

	 return "registration_success";
 }
 
	@SuppressWarnings("unused")
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}	
}