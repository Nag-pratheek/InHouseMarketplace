package com.cg.market.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.market.dto.CreateEmployeeRequest;
import com.cg.market.dto.EmployeeDetails;
import com.cg.market.entites.Employee;
import com.cg.market.entites.User;
import com.cg.market.service.MarketService;
import com.cg.market.util.EmployeeUtil;

@RestController
@RequestMapping("/market")
@Validated
public class MarketController {
	
	@Autowired
	private MarketService mService;
	@Autowired
	private EmployeeUtil empUtil;
	@GetMapping("/by/id/{empid}")
	public EmployeeDetails fetchEmployee(@PathVariable("empid") Integer empId) {
		System.out.println("employee fetch id:"+ empId);
		Employee emp= mService.findById(empId);
		//new Employee("Pavan", "Analyst","Shivmoga", new User("1234"));
		EmployeeDetails details = empUtil.toDetails(emp);
		return details;
	}
		@ResponseStatus(HttpStatus.CREATED)
		@PostMapping("/add")
		public EmployeeDetails add(@RequestBody @Valid CreateEmployeeRequest requestData) {
			System.out.println("req data: "+ requestData);
			Employee emp = new Employee(requestData.getEmpName(), requestData.getDeptName(), requestData.getLocation());
			System.out.println("Emoloyee came: "+ emp);
			emp = mService.register(emp);
			EmployeeDetails details = empUtil.toDetails(emp);
			return details;
		}
		
		public EmployeeDetails update() {
	
}
}