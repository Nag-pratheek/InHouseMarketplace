package com.cg.market.service;

import java.util.List;

import com.cg.market.entites.Employee;
import com.cg.market.entites.Offer;
import com.cg.market.entites.Product;
import com.cg.market.entites.Proposal;

public interface MarketService {

	Employee findById(Integer empId);

	Employee register(Employee emp);

	Product register(Product prod);

	Product findById1(Integer prodId);

	Product deleteById(Integer prodId);

	Employee deleteById1(Integer empId);

	Proposal register(Proposal prop);

	Proposal findById2(Integer propId);

	Proposal deleteById2(Integer propId);

	List<Proposal> findAll();

	List<Product> findAllProduct();

	Offer register(Offer off);

	Offer deleteById3(Integer offId);

	List<Offer> findAllOffer();

}
