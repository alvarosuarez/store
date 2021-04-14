package com.alvarosrz.store.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.alvarosrz.store.service.Checkout;

public class CheckoutTests {

	private Checkout checkout;

	@Before
	public void before() {
		checkout = new Checkout();
		checkout.init();
	}

	@Test
	public void whenCheckoutIsEmpty_noAmount() {
		// GIVEN
		Double expected = 0d;

		// WHEN
		Double result = checkout.getAmount();

		// THEN
		Assert.assertEquals(expected, result);
	}

	@Test
	public void whenScanAProduct_productAmount() {
		// GIVEN
		Product product = new Product("C1", "D1", 5.5d);
		Double expected = product.getPrice();

		// WHEN
		checkout.scan(product);

		// THEN
		Assert.assertEquals(expected, checkout.getAmount());
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenScanANullProduct_fail() {
		// GIVEN
		Product product = null;

		// WHEN
		checkout.scan(product);
	}

}
