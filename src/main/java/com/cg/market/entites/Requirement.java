package com.cg.market.entites;

import java.time.LocalDate;
import java.util.List;

public class Requirement {
	
	private int reqId;
	private boolean isFulfilled;
	private LocalDate fulfilledOn;
	private List<Proposal> proposals;
	
	public Requirement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Requirement(int reqId, boolean isFulfilled, LocalDate fulfilledOn, List<Proposal> proposals) {
		super();
		this.reqId = reqId;
		this.isFulfilled = isFulfilled;
		this.fulfilledOn = fulfilledOn;
		this.proposals = proposals;
	}

	@Override
	public String toString() {
		return "Requirement [reqId=" + reqId + ", isFulfilled=" + isFulfilled + ", fulfilledOn=" + fulfilledOn
				+ ", proposals=" + proposals + "]";
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public boolean isFulfilled() {
		return isFulfilled;
	}

	public void setFulfilled(boolean isFulfilled) {
		this.isFulfilled = isFulfilled;
	}

	public LocalDate getFulfilledOn() {
		return fulfilledOn;
	}

	public void setFulfilledOn(LocalDate fulfilledOn) {
		this.fulfilledOn = fulfilledOn;
	}

	public List<Proposal> getProposals() {
		return proposals;
	}

	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}

	
}
