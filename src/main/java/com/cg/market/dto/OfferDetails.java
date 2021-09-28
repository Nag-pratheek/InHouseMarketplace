package com.cg.market.dto;

import java.time.LocalDate;

import com.cg.market.entites.Product;

public class OfferDetails {
	private int offerId;
	private boolean isAvailable;
	private LocalDate availableUpto;
	private Product prod;
	public OfferDetails() {
		super();
	}
	public OfferDetails(int offerId, boolean isAvailable, LocalDate availableUpto) {
		super();
		this.offerId = offerId;
		this.isAvailable = isAvailable;
		this.availableUpto = availableUpto;
	}
	
	public OfferDetails(int offerId, boolean isAvailable, LocalDate availableUpto, Product prod) {
		super();
		this.offerId = offerId;
		this.isAvailable = isAvailable;
		this.availableUpto = availableUpto;
		this.prod = prod;
	}
	@Override
	public String toString() {
		return "OfferDetails [offerId=" + offerId + ", isAvailable=" + isAvailable + ", availableUpto=" + availableUpto
				+ ", prod=" + prod + "]";
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