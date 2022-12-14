package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.dao.MoridoDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.entity.Morido;

@Service
public class MoridoServiceImpl implements MoridoService {

	
	private MoridoDAO moridoDAO;
	
	@Autowired
	public MoridoServiceImpl(@Qualifier("moridoDAOJdbcImpl") MoridoDAO theMoridoDAO) {
		moridoDAO = theMoridoDAO;
	}
	
	@Override
	@Transactional
	public List<Morido> findAll() {
		return moridoDAO.findAll();
	}

	@Override
	@Transactional
	public Morido findById(int theId) {
		return moridoDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Morido theMorido) {
		moridoDAO.save(theMorido);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		moridoDAO.deleteById(theId);
	}

}






