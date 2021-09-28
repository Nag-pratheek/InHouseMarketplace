package com.cg.market.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.market.dao.MarketDao;
import com.cg.market.dao.MarketDaoOffer;
import com.cg.market.dao.MarketDaoProduct;
import com.cg.market.dao.MarketDaoProposal;
import com.cg.market.dao.MarketDaoRequirement;
import com.cg.market.entites.Employee;
import com.cg.market.entites.Offer;
import com.cg.market.entites.Product;
import com.cg.market.entites.Proposal;
import com.cg.market.entites.Requirement;
import com.cg.market.exception.EmployeeNotFoundException;
import com.cg.market.exception.OfferNotFoundException;
import com.cg.market.exception.ProductNotFoundException;
import com.cg.market.exception.ProposalNotFoundException;
import com.cg.market.exception.RequirementNotFoundException;

@Service
@Transactional
public class MarketServiceImpl implements MarketService {
	@Autowired
	private MarketDao dao;
	@Autowired
	private MarketDaoProduct pDao;
	@Autowired
	private MarketDaoProposal prDao;
	@Autowired
	private MarketDaoOffer oDao;
	@Autowired
	private MarketDaoRequirement rDao;

	@Override
	public Employee findById(Integer empId) {
		Optional<Employee> optional = dao.findById(empId);
		if(!optional.isPresent()){
        	System.out.println("***error***");
            throw new EmployeeNotFoundException("Employee not found for id="+empId);
        }
		Employee emp = optional.get();
		System.out.println("employee:" + emp);
		return emp;
	}

	@Override
	public Employee register(Employee emp) {
		emp = dao.save(emp);
		System.out.println("Returning saved student: " + emp);
		return emp;
	}

	@Override
	public Product register(Product prod) {
		prod = pDao.save(prod);
		System.out.println("Returning saved product: " + prod);
		return prod;
	}

	@Override
	public Product findById1(Integer prodId) {
		Optional<Product> opt = pDao.findById(prodId);
		if(!opt.isPresent()){
        	System.out.println("***error***");
            throw new ProductNotFoundException("Product not found for id="+prodId);
        }
		Product prod = opt.get();
		System.out.println("Product: " + prod);
		return prod;
	}

	@Override
	public Product deleteById(Integer prodId) {
		Optional<Product> opt = pDao.findById(prodId);
		if (!opt.isPresent()) {
			throw new ProductNotFoundException("No Product Found for Id :" + prodId);
		}
		Product prod = opt.get();
		pDao.deleteById(prodId);
		System.out.println("Deleting the product:" + prod);
		return prod;
	}

	@Override
	public Employee deleteById1(Integer empId) {
		Optional<Employee> opt = dao.findById(empId);
		if (!opt.isPresent()) {
			throw new EmployeeNotFoundException("No Employee Found for Id :" + empId);
		}
		Employee emp = opt.get();
		dao.deleteById(empId);
		System.out.println("Deleting the employee:" + emp);
		return emp;
	}

	@Override
	public Proposal register(Proposal prop) {
		prop = prDao.save(prop);
		System.out.println("Returning saved student: " + prop);
		return prop;

	}

	@Override
	public Proposal findById2(Integer propId) {
		Optional<Proposal> opt = prDao.findById(propId);
		if(!opt.isPresent()){
        	System.out.println("***error***");
            throw new ProposalNotFoundException("proposal not found for id="+propId);
        }
		Proposal prop = opt.get();
		System.out.println("Proposal: " + prop);
		return prop;
	}

	@Override
	public Proposal deleteById2(Integer propId) {
		Optional<Proposal> opt = prDao.findById(propId);
		if (!opt.isPresent()) {
			throw new ProposalNotFoundException("No Proposal Found for Id :" + propId);
		}
		Proposal prop = opt.get();
		prDao.deleteById(propId);
		System.out.println("Deleting the proposal:" + prop);
		return prop;
	}

	@Override
	public List<Proposal> findAll() {
		System.out.println(prDao.getClass().getName());
		List<Proposal> list = prDao.findAll();
		return list;

	}

	@Override
	public List<Product> findAllProduct() {
		System.out.println(pDao.getClass().getName());
		List<Product> list = pDao.findAll();
		return list;

	}

	@Override
	public Offer register(Offer off) {
		off = oDao.save(off);
		System.out.println("Returning saved offer: " + off);
		return off;
	}

	@Override
	public Offer deleteById3(Integer offId) {
		Optional<Offer> opt = oDao.findById(offId);
		if (!opt.isPresent()) {
			throw new OfferNotFoundException("No Offer Found for Id :" + offId);
		}
		Offer off = opt.get();
		oDao.deleteById(offId);
		System.out.println("Deleting the Offer:" + off);
		return off;
	}

	@Override
	public List<Offer> findAllOffer() {
		System.out.println(oDao.getClass().getName());
		List<Offer> list = oDao.findAll();
		return list;
	}

	@Override
	public Requirement register(Requirement requ) {
		requ = rDao.save(requ);
		System.out.println("Returning saved Requirement: " + requ);
		return requ;
	
	}

	@Override
	public List<Requirement> findAllRequirement() {
		System.out.println(rDao.getClass().getName());
		List<Requirement> list = rDao.findAll();
		return list;
	}

	@Override
	public Requirement deleteById4(Integer requId) {
		Optional<Requirement> opt = rDao.findById(requId);
		if (!opt.isPresent()) {
			throw new RequirementNotFoundException("No Requirement Found for Id :" + requId);
		}
		Requirement requ = opt.get();
		rDao.deleteById(requId);
		System.out.println("Deleting the Requirement:" + requ);
		return requ;
	}
}
