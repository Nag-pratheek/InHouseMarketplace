package com.cg.market.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.market.dao.MarketDao;
import com.cg.market.entites.Employee;

@Service
@Transactional
public class MarketServiceImpl implements MarketService{
	@Autowired
	private MarketDao dao;
	@Override
	public Employee findById(Integer empId) {
		Optional<Employee> optional =dao.findById(empId);
		Employee emp =optional.get();
		System.out.println("employee:"+emp);
		return emp;
	}
	@Override
	public Employee register(Employee emp) {
		emp = dao.save(emp);
		System.out.println("Returning saved student: "+ emp);
		return emp;
	}

}
