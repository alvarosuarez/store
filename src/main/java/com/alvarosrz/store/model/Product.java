package com.alvarosrz.store.model;

import org.springframework.util.Assert;

public class Product {

	private final String code;
	private final String name;
	private final Double price;

	public Product(String code, String name, Double price) {
		Assert.notNull(code, "code param can not be null");
		Assert.notNull(price, "price param can not be null");
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