package com.springdemo.service;

import java.util.List;

import com.springdemo.model.Morido;

public interface CustomerService {

	public List<Morido> getCustomers();

	public void saveCustomer(Morido theCustomer);

	public Morido getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
