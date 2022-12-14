package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Morido;

@Repository
public class MoridoDAOHibernateImpl implements MoridoDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public MoridoDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Morido> findAll() {
		System.out.println("MoridoDAOHibernateImpl");
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Morido> theQuery =
				currentSession.createQuery("from Morido", Morido.class);
		
		// execute query and get result list
		List<Morido> moridos = theQuery.getResultList();
		
		// return the results		
		return moridos;
	}


	@Override
	public Morido findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Morido theMorido =
				currentSession.get(Morido.class, theId);
		
		// return the employee
		return theMorido;
	}


	@Override
	public void save(Morido theMorido) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theMorido);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Morido where id=:id");
		
		theQuery.setParameter("id", theId);
		
		theQuery.executeUpdate();
	}

}







