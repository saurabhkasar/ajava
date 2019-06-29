package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.ICustService;

@Controller
@RequestMapping("/admin") //view 
public class AdminController 
{
	@Autowired
	private ICustService service;

	public AdminController() 
	{		
		// TODO Auto-generated constructor stub
	}
	@GetMapping("/list")
	public String ShowCustList(Model map) 
	{
		System.out.println("in list cust");
		// save vendor under model map
		map.addAttribute("cust_list", service.listCustomers());
		return "/admin/list"; //forward view name
	}
	
}
