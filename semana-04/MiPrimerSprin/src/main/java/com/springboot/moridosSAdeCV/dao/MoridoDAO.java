package com.springboot.moridosSAdeCV.dao;

import java.util.List;
import com.springboot.moridosSAdeCV.entity.Morido;

public interface MoridoDAO {

	List<Morido> findAll();
	
	Morido findById(int theId);
	
	void save(Morido elMorido);
	
	void deleteById(int theId);
	
}
