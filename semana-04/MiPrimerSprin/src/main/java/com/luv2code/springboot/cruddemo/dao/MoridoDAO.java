package com.luv2code.springboot.cruddemo.dao;

import java.util.List;
import com.luv2code.springboot.cruddemo.entity.Morido;

public interface MoridoDAO {

	List<Morido> findAll();
	
	Morido findById(int theId);
	
	void save(Morido elMorido);
	
	void deleteById(int theId);
	
}
