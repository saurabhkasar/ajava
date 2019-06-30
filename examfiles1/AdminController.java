package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.IVendorService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	// dependency
	@Autowired
	private IVendorService service;

	public AdminController() {
		System.out.println("in constr of " + getClass().getName());
	}

	@GetMapping("/list")
	public String showVendorList(Model map) {
		System.out.println("in list vendor");
		// save vendor under model map
		map.addAttribute("vendor_list", service.listVendors());
		return "/admin/list"; //forward view name
	}

}
