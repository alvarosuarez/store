package com.alvarosrz.store.model;

public class Product {

	private final String code;
	private final String name;
	private final Double price;

	public Product(String code, String name, Double price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}
}