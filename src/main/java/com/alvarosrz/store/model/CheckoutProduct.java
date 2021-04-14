package com.alvarosrz.store.model;

public class CheckoutProduct {

	private final Product product;
	private int units;
	private Double totalprice;

	public CheckoutProduct(Product product) {
		this.product = product;
		this.units = 1;
		this.totalprice = product.getPrice();
	}

	public void addUnit(Double price) {
		this.units += 1;
		this.totalprice += price;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public int getUnits() {
		return units;
	}

	public Product getProduct() {
		return product;
	}

	public Double getProductPrice() {
		return product != null ? product.getPrice() : null;
	}

	public String getProductCode() {
		return product != null ? product.getCode() : null;
	}

}