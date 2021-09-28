package com.cg.market.dto;

import java.time.LocalDate;
import java.util.List;

import com.cg.market.entites.Product;
import com.cg.market.entites.Proposal;

public class CreateOfferRequest {
	private int offerId;
	private boolean isAvailable;
	private LocalDate availableUpto;
	private Product prod;
	public CreateOfferRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateOfferRequest(int offerId, boolean isAvailable, LocalDate availableUpto) {
		super();
		this.offerId = offerId;
		this.isAvailable = isAvailable;
		this.availableUpto = availableUpto;
	}
	
	public CreateOfferRequest(int offerId, boolean isAvailable, LocalDate availableUpto, Product prod) {
		super();
		this.offerId = offerId;
		this.isAvailable = isAvailable;
		this.availableUpto = availableUpto;
		this.prod = prod;
	}
	@Override
	public String toString() {
		return "CreateOfferRequest [offerId=" + offerId + ", isAvailable=" + isAvailable + ", availableUpto="
				+ availableUpto + ", prod=" + prod + "]";
	}
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public LocalDate getAvailableUpto() {
		return availableUpto;
	}
	public void setAvailableUpto(LocalDate availableUpto) {
		this.availableUpto = availableUpto;
	}
	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
	}
}