package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.pojos.Vendor;

@Service //to tell SC that this comp contains B.L
@Transactional //to automate tx management
public class VendorServiceImpl implements IVendorService {
	//dependency
	@Autowired
	private IVendorDao dao;
	
	@Override
	public Vendor validateUser(String email, String pass) {
		// TODO Auto-generated method stub
		return dao.validateUser(email, pass);
	}

	@Override
	public List<Vendor> listVendors() {
		// TODO Auto-generated method stub
		return dao.listVendors();
	}
	

}
