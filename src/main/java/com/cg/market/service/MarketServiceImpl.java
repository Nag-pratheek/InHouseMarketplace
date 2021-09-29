package com.cg.market.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.market.dao.ILoginDao;
import com.cg.market.dao.MarketDao;
import com.cg.market.dao.MarketDaoOffer;
import com.cg.market.dao.MarketDaoProduct;
import com.cg.market.dao.MarketDaoProposal;
import com.cg.market.dao.MarketDaoRequirement;
import com.cg.market.dto.UserDetails;
import com.cg.market.entites.Employee;
import com.cg.market.entites.Offer;
import com.cg.market.entites.Product;
import com.cg.market.entites.Proposal;
import com.cg.market.entites.Requirement;
import com.cg.market.exception.AuthenticationFailedException;
import com.cg.market.exception.EmployeeAlreadyExistsException;
import com.cg.market.exception.EmployeeNotFoundException;
import com.cg.market.exception.OfferAlreadyExistsException;
import com.cg.market.exception.OfferNotFoundException;
import com.cg.market.exception.ProductAlreadyExistsException;
import com.cg.market.exception.ProductNotFoundException;
import com.cg.market.exception.ProposalAlreadyExistsException;
import com.cg.market.exception.ProposalNotFoundException;
import com.cg.market.exception.RequirementNotFoundException;
import com.cg.market.exception.RequirementAlreadyExistsException;

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
	@Autowired
	private ILoginDao lDao;

	@Override
	public Employee findById(Integer empId) {
		Optional<Employee> optional = dao.findById(empId);
		if (!optional.isPresent()) {
			System.out.println("***error***");
			throw new EmployeeNotFoundException("Employee not found for id=" + empId);
		}
		Employee emp = optional.get();
		System.out.println("employee:" + emp);
		return emp;
	}

	@Override
	public Employee register(Employee emp) {
		boolean exists = emp.getEmpId() != null && dao.existsById(emp.getEmpId());
		if (exists) {
			throw new EmployeeAlreadyExistsException("Employee already exists for id=" + emp.getEmpId());
		}
		emp = dao.save(emp);
		System.out.println("Returning saved student: " + emp);
		return emp;
	}

	@Override
	public Product register(Product prod) {
		boolean exists = prod.getProdId() != null && pDao.existsById(prod.getProdId());
		if (exists) {
			throw new ProductAlreadyExistsException("Product already exists for id=" + prod.getProdId());
		}
		prod = pDao.save(prod);
		System.out.println("Returning saved product: " + prod);
		return prod;
	}

	@Override
	public Product findById1(Integer prodId) {
		Optional<Product> opt = pDao.findById(prodId);
		if (!opt.isPresent()) {
			System.out.println("***error***");
			throw new ProductNotFoundException("Product not found for id=" + prodId);
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
		boolean exists = prop.getPropId() != null && pDao.existsById(prop.getPropId());
		if (exists) {
			throw new ProposalAlreadyExistsException("Proposal already exists for id=" + prop.getPropId());
		}
		prop = prDao.save(prop);
		System.out.println("Returning saved student: " + prop);
		return prop;

	}

	@Override
	public Proposal findById2(Integer propId) {
		Optional<Proposal> opt = prDao.findById(propId);
		if (!opt.isPresent()) {
			System.out.println("***error***");
			throw new ProposalNotFoundException("proposal not found for id=" + propId);
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
		boolean exists = off.getOfferId() != null && oDao.existsById(off.getOfferId());
		if (exists) {
			throw new OfferAlreadyExistsException("Offer already exists for id=" + off.getOfferId());
		}
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
		boolean exists = requ.getReqId() != null && rDao.existsById(requ.getReqId());
		if (exists) {
			throw new RequirementAlreadyExistsException("Requirement already exists for id=" + requ.getReqId());
		}
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

	@Override
	public Proposal update(Proposal prop) {
		boolean isAccepted = prop.getIsAccepted();
		if (isAccepted) {
			prDao.save(prop);
		} else {
			throw new ProposalNotFoundException("Proposal has not been accepted");
		}
		return prop;
	}

	@Override
	public Offer update(Offer off) {
		boolean isAvailable = off.isAvailable();
		if (!isAvailable) {
			oDao.save(off);
		} else {
			throw new OfferNotFoundException("Offer has not been accepted");
		}
		return off;
	}

	@Override
	public Requirement update(Requirement requ) {
		boolean isFulfilled = requ.isFulfilled();
		if (isFulfilled) {
			rDao.save(requ);
		} else {
			throw new RequirementNotFoundException("Requirement has not been updated");
		}
		return requ;
	}

	@Override
	public Product update(Product prod) {
		pDao.save(prod);
		return prod;
	}

	@Override
	public Employee update(Employee emp) {
		dao.save(emp);
		return emp;
	}

	@Override
	public String login(UserDetails userDetails) {
		String role = "";
		Optional<UserDetails> op = lDao.findById(userDetails.getUsername());
		if (!op.isPresent()) {
			throw new AuthenticationFailedException("No User found for username=" + userDetails.getUsername());
		}
		UserDetails uDetails = op.get();
		if (!userDetails.getPassword().equals(uDetails.getPassword())) {
			throw new AuthenticationFailedException(
					"Authentification failed for username=" + userDetails.getUsername());
		}
		role = uDetails.getUserRole();
		return role;
	}

}
