package com.cg.market.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.market.dto.CreateEmployeeRequest;
import com.cg.market.dto.CreateOfferRequest;
import com.cg.market.dto.CreateProductRequest;
import com.cg.market.dto.CreateProposalRequest;
import com.cg.market.dto.CreateRequirementRequest;
import com.cg.market.dto.EmployeeDetails;
import com.cg.market.dto.OfferDetails;
import com.cg.market.dto.ProductDetails;
import com.cg.market.dto.ProposalDetails;
import com.cg.market.dto.RequirementDetails;
import com.cg.market.dto.UpdateEmployeeRequest;
import com.cg.market.dto.UpdateOfferRequest;
import com.cg.market.dto.UpdateProductRequest;
import com.cg.market.dto.UpdateProposalRequest;
import com.cg.market.dto.UpdateRequirementRequest;
import com.cg.market.entites.Employee;
import com.cg.market.entites.Offer;
import com.cg.market.entites.Product;
import com.cg.market.entites.Proposal;
import com.cg.market.entites.Requirement;
import com.cg.market.service.MarketService;
import com.cg.market.util.EmployeeUtil;
import com.cg.market.util.OfferUtil;
import com.cg.market.util.ProductUtil;
import com.cg.market.util.ProposalUtil;
import com.cg.market.util.RequirementUtil;

@RestController
@RequestMapping("/market")
@Validated
public class MarketController {

	@Autowired
	private MarketService mService;
	@Autowired
	private EmployeeUtil empUtil;
	@Autowired
	private ProductUtil prodUtil;
	@Autowired
	private ProposalUtil propUtil;
	@Autowired
	private OfferUtil offUtil;
	@Autowired
	private RequirementUtil reqUtil;
	@GetMapping("/by/empid/{empid}")
	public EmployeeDetails fetchEmployee(@PathVariable("empid") Integer empId) {
		System.out.println("employee fetch id:" + empId);
		Employee emp = mService.findById(empId);
		EmployeeDetails details = empUtil.toDetails(emp);
		return details;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("employee/add")
	public EmployeeDetails add(@RequestBody @Valid CreateEmployeeRequest requestData) {
		System.out.println("req data: " + requestData);
		Employee emp = new Employee(requestData.getEmpName(), requestData.getDeptName(), requestData.getLocation());
		System.out.println("Emoloyee came: " + emp);
		emp = mService.register(emp);
		EmployeeDetails details = empUtil.toDetails(emp);
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("employee/update")
	public EmployeeDetails update(@RequestBody @Valid UpdateEmployeeRequest updateData) {
		System.out.println("update data: " + updateData);
		Employee emp = new Employee(updateData.getEmpId(), updateData.getEmpName(), updateData.getDeptName(),
				updateData.getLocation());
		System.out.println("Employee updated:" + emp);
		emp = mService.register(emp);
		EmployeeDetails details = empUtil.toDetails(emp);
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("employee/delete/{empid}")
	public EmployeeDetails deleteEmployee(@PathVariable("empid") Integer empId) {
		System.out.println("delete data: " + empId);
		Employee emp = mService.deleteById1(empId);
		EmployeeDetails details = empUtil.toDetails(emp);
		return details;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("product/add")
	public ProductDetails add(@RequestBody @Valid CreateProductRequest requestData) {
		System.out.println("Req data: " + requestData);
		Product prod = new Product(requestData.getTitle(), requestData.getDecription(), requestData.getCategory(),
				requestData.getPrice(), requestData.getDate(), requestData.getEmp());
		System.out.println("Product came: " + prod);
		prod = mService.register(prod);
		ProductDetails details = prodUtil.toDetails(prod);
		return details;
	}

	@GetMapping("/by/prodid/{prodid}")
	public ProductDetails fetchProduct(@PathVariable("prodid") Integer prodId) {
		System.out.println("Product fetch id:" + prodId);
		Product prod = mService.findById1(prodId);
		ProductDetails details = prodUtil.toDetails(prod);
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("product/update")
	public ProductDetails update(@RequestBody @Valid UpdateProductRequest updateData) {
		System.out.println("update data: " + updateData);
		Product prod = new Product(updateData.getProdId(), updateData.getTitle(), updateData.getDescription(),
				updateData.getCategory(), updateData.getPrice(), updateData.getDate(), updateData.getEmp());
		System.out.println("Product updated:" + prod);
		prod = mService.register(prod);
		ProductDetails details = prodUtil.toDetails(prod);
		return details;
	}

		@GetMapping("product/getall")
		public List<ProductDetails> fetchAllProduct() {
			List<Product> products = mService.findAllProduct();
			List<ProductDetails> response = prodUtil.toDetails(products);
			return response;
		}
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("product/delete/{prodid}")
	public ProductDetails delete(@PathVariable("prodid") Integer prodId) {
		System.out.println("delete data: " + prodId);
		Product prod = mService.deleteById(prodId);
		ProductDetails details = prodUtil.toDetails(prod);
		return details;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("proposal/add")
	public ProposalDetails add(@RequestBody @Valid CreateProposalRequest requestData) {
		System.out.println("Req data: " + requestData);
		Proposal prop = new Proposal(requestData.getPropId(), requestData.getProposal(), requestData.getAmount(),
				requestData.getProposalDate(), requestData.isAccepted(), requestData.getEmp(), requestData.getProd());
		System.out.println("Proposal came: " + prop);
		prop = mService.register(prop);
		ProposalDetails details = propUtil.toDetails(prop);
		return details;
	}

	@GetMapping("/by/propid/{propid}")
	public ProposalDetails fetchProposal(@PathVariable("propid") Integer propId) {
		System.out.println("Proposal fetch id:" + propId);
		Proposal prop = mService.findById2(propId);
		ProposalDetails details = propUtil.toDetails(prop);
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("proposal/delete/{propid}")
	public ProposalDetails deleteProposal(@PathVariable("propid") Integer propId) {
		System.out.println("delete data: " + propId);
		Proposal prop = mService.deleteById2(propId);
		ProposalDetails details = propUtil.toDetails(prop);
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("proposal/update")
	public ProposalDetails update(@RequestBody @Valid UpdateProposalRequest updateData) {
		System.out.println("update data: " + updateData);
		Proposal prop = new Proposal(updateData.getPropId(), updateData.getProposal(), updateData.getAmount(),
				updateData.getProposalDate(), updateData.isAccepted(), updateData.getEmp(), updateData.getProd());
		System.out.println("Proposal updated:" + prop);
		prop = mService.update(prop);
		ProposalDetails details = propUtil.toDetails(prop);
		return details;
	}

		@GetMapping("proposal/getall")
		public List<ProposalDetails> fetchAll() {
			List<Proposal> proposals = mService.findAll();
			List<ProposalDetails> response = propUtil.toDetails(proposals);
			return response;
		}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("offer/add")
	public OfferDetails add(@RequestBody @Valid CreateOfferRequest requestData) {
		System.out.println("Req data: " + requestData);
		Offer off = new Offer(requestData.getOfferId(), requestData.isAvailable(), requestData.getAvailableUpto(),requestData.getProd());
		System.out.println("Offer came: " + off);
		off = mService.register(off);
		OfferDetails details = offUtil.toDetails(off);
		return details;
	}
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("offer/update")
	public OfferDetails updateOffer(@RequestBody @Valid UpdateOfferRequest updateData) {
		System.out.println("update data: " + updateData);
		Offer off = new Offer(updateData.getOfferId(),updateData.isAvailable(),updateData.getAvailableUpto() , updateData.getProd());
		System.out.println("Offer updated:" + off);
		off = mService.update(off);
		OfferDetails details = offUtil.toDetails(off);
		return details;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("offer/delete/{offid}")
	public OfferDetails deleteOffer(@PathVariable("offid") Integer offId) {
		System.out.println("delete data: " + offId);
		Offer off = mService.deleteById3(offId);
		OfferDetails details = offUtil.toDetails(off);
		return details;
	}
	@GetMapping("offer/getall")
	public List<OfferDetails> fetchAllOffer() {
		List<Offer> offers = mService.findAllOffer();
		List<OfferDetails> response = offUtil.toDetails(offers);
		return response;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("requirement/add")
	public RequirementDetails add(@RequestBody @Valid CreateRequirementRequest requestData) {
		System.out.println("Req data: " + requestData);
		Requirement requ = new Requirement(requestData.getReqId(), requestData.isFulfilled(), requestData.getFulfilledOn(), requestData.getProd());
		System.out.println("Requirement came: " + requ);
		requ = mService.register(requ);
		RequirementDetails details = reqUtil.toDetails(requ);
		return details;
	}
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("requirement/update")
	public RequirementDetails updateRequirement(@RequestBody @Valid UpdateRequirementRequest updateData) {
		System.out.println("update data: " + updateData);
		Requirement requ = new Requirement(updateData.getReqId(), updateData.isFulfilled(), updateData.getFulfilledOn(), updateData.getProd());
		System.out.println("Requirement updated:" + requ);
		requ = mService.update(requ);
		RequirementDetails details = reqUtil.toDetails(requ);
		return details;
	}
	@GetMapping("requirement/getall")
	public List<RequirementDetails> fetchAllRequirement() {
		List<Requirement> requirements = mService.findAllRequirement();
		List<RequirementDetails> response = reqUtil.toDetails(requirements);
		return response;
	}
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("requirement/delete/{requid}")
	public RequirementDetails deleteRequirement(@PathVariable("requid") Integer requId) {
		System.out.println("delete data: " + requId);
		Requirement requ = mService.deleteById4(requId);
		RequirementDetails details = reqUtil.toDetails(requ);
		return details;
	}
	
}