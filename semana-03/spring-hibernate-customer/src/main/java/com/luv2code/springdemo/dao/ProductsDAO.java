package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Products;

public interface ProductsDAO {

	public List<Products> getCustomers();

	public void saveCustomer(Products theCustomer);

	public Products getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
