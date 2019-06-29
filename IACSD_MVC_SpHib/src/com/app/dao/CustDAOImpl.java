package com.app.dao;
import com.app.pojos.Customer;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustDAOImpl implements ICustDAO 
{

	@Autowired // byType
	private SessionFactory sf;
	
	public CustDAOImpl() 
	{
		System.out.println("In cnstr of " + getClass().getName());
		// TODO Auto-generated constructor stub
	}	

	@Override
	public List<Customer> listCustomers() 
	{
		String jpql = "select c from Customer c where c.city=:city";
		return sf.getCurrentSession().
				createQuery(jpql, Customer.class).
				setParameter("city", "Customer").getResultList();
	}

}
