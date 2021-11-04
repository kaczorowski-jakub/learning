package com.os.udemy.spring.crm.dao;

import java.util.List;

import com.os.udemy.spring.crm.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public void deleteCustomer(int theId);
}
