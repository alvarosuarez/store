package com.alvarosrz.store.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import com.alvarosrz.store.model.CheckoutProduct;
import com.alvarosrz.store.model.PricingRules;
import com.alvarosrz.store.model.Product;

/**
 * @author alvaro
 *
 */
public class Checkout {

	private Map<String, CheckoutProduct> products;

	private PricingRules pricingRules;

	public Checkout(PricingRules pricingRules) {
		this.pricingRules = pricingRules;
	}

	public void scan(Product product) {
		Assert.notNull(product, "Param product can not be null");

		if (products.containsKey(product.getCode())) {
			CheckoutProduct checkoutProduct = products.get(product.getCode());
			checkoutProduct.addUnit(getNewProductPrice(checkoutProduct));
		} else {
			products.put(product.getCode(), new CheckoutProduct(product));
		}

	}

	public void init() {
		products = new HashMap<>();
	}

	public Double getAmount() {
		Double amount = 0d;

		for (CheckoutProduct product : products.values()) {
			amount += product.getTotalprice();
		}

		return amount;
	}

	private Double getNewProductPrice(CheckoutProduct checkoutProduct) {
		return pricingRules.getNewProductPrice(checkoutProduct);
	}

}
