package com.springdemo.service;

import java.util.List;

import com.springdemo.model.Morido;

public interface CustomerService {

	public List<Morido> getMoridos();

	public void saveMorido(Morido theCustomer);

	public Morido getMorido(int theId);

	public void deleteMorido(int theId);
	
}
