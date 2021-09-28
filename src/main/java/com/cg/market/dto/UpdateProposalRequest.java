package com.cg.market.dto;

import java.time.LocalDate;

import com.cg.market.entites.Employee;
import com.cg.market.entites.Product;

public class UpdateProposalRequest {

	private int propId;
	private String proposal;
	private double amount;
	private LocalDate proposalDate;
	private boolean isAccepted;
	private Employee emp;
	private Product prod;
	public UpdateProposalRequest() {
		super();
	}
	public UpdateProposalRequest(int propId, String proposal, double amount, LocalDate proposalDate, boolean isAccepted,
			Employee emp, Product prod) {
		super();
		this.propId = propId;
		this.proposal = proposal;
		this.amount = amount;
		this.proposalDate = proposalDate;
		this.isAccepted = isAccepted;
		this.emp = emp;
		this.prod = prod;
	}
	@Override
	public String toString() {
		return "UpdateProposalRequest [propId=" + propId + ", proposal=" + proposal + ", amount=" + amount
				+ ", proposalDate=" + proposalDate + ", isAccepted=" + isAccepted + ", emp=" + emp + ", prod=" + prod
				+ "]";
	}
	public int getPropId() {
		return propId;
	}
	public void setPropId(int propId) {
		this.propId = propId;
	}
	public String getProposal() {
		return proposal;
	}
	public void setProposal(String proposal) {
		this.proposal = proposal;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getProposalDate() {
		return proposalDate;
	}
	public void setProposalDate(LocalDate proposalDate) {
		this.proposalDate = proposalDate;
	}
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
	}


}
