package com.springboot.moridosSAdeCV.service;

import java.util.List;

import com.springboot.moridosSAdeCV.entity.Morido;

public interface MoridoService {

	public List<Morido> findAll();
	
	public Morido findById(int theId);
	
	public void save(Morido theEmployee);
	
	public void deleteById(int theId);
	
}
