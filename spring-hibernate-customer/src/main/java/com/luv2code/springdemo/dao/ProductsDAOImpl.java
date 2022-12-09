package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Products;

@Repository
public class ProductsDAOImpl implements ProductsDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Products> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Products> theQuery = 
				currentSession.createQuery("from Products order by name",
											Products.class);
                System.out.println("theQuery = " + theQuery);
		// execute query and get result list
		List<Products> products = theQuery.getResultList();
				
		// return the results		
		return products;
	}

	@Override
	public void saveCustomer(Products theProduct) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theProduct);
		
	}

	@Override
	public Products getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Products theCustomer = currentSession.get(Products.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Products where id=:productsId");
		theQuery.setParameter("productsId", theId);
		
		theQuery.executeUpdate();		
	}

}











