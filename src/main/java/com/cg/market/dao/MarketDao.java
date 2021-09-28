package com.cg.market.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.market.entites.Employee;
import com.cg.market.entites.Product;

public interface MarketDao extends JpaRepository<Employee, Integer>{

//	Product save(Product prod);

//	Optional<Product> getById(Integer prodId);
	

}
