package com.alvarosrz.store.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.util.Assert;

import com.alvarosrz.store.model.Product;

/**
 * @author alvaro
 *
 */
public class Checkout {

	private Collection<Product> products;

	private Double amount;

	public Checkout() {

	}

	public void scan(Product product) {
		Assert.notNull(product, "Param product can not be null");

		products.add(product);
		amount += product.getPrice();
	}

	public void init() {
		amount = 0d;
		products = new ArrayList<>();
	}

	public Double getAmount() {
		return amount;
	}

}
