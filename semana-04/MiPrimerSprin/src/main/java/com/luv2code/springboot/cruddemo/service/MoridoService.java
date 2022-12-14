package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Morido;

public interface MoridoService {

	public List<Morido> findAll();
	
	public Morido findById(int theId);
	
	public void save(Morido theEmployee);
	
	public void deleteById(int theId);
	
}
