package com.cg.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.market.entites.Employee;

public interface MarketDao extends JpaRepository<Employee, Integer>{
	

}
