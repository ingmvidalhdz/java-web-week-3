package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Products;

public interface ProductsService {

	public List<Products> getCustomers();

	public void saveCustomer(Products theProduct);

	public Products getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
