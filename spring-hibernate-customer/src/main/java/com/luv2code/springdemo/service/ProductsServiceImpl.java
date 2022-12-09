package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Products;
import com.luv2code.springdemo.dao.ProductsDAO;

@Service
public class ProductsServiceImpl implements ProductsService {

	// need to inject customer dao
	@Autowired
	private ProductsDAO customerDAO;
	
	@Override
	@Transactional
	public List<Products> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Products theProduct) {

		customerDAO.saveCustomer(theProduct);
	}

	@Override
	@Transactional
	public Products getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}
}





