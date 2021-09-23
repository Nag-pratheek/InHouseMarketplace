package com.cg.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.market.dto.EmployeeDetails;
import com.cg.market.entites.Employee;
import com.cg.market.service.MarketService;

@RestController
@RequestMapping("/market")
@Validated
public class MarketController {
	
	@Autowired
	private MarketService mService;
	
	@GetMapping("/by/id/{id}")
	public EmployeeDetails fetchEmployee(@PathVariable("empid") Integer empId) {
		System.out.println("employee fetch id:"+ empId);
		Employee emp=mService.findById(empId);
		return null;
	
}
}