package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustDAO;
import com.app.pojos.Customer;
@Service
@Transactional
public class CustServiceImpl implements ICustService 
{
	@Autowired
	private ICustDAO dao;
	
	@Override
	public List<Customer> listCustomers() 
	{
		// TODO Auto-generated method stub
		return dao.listCustomers();
	}

}
