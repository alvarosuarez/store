package com.alvarosrz.store.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alvarosrz.store.model.StoreResponse;
import com.alvarosrz.store.model.exception.ProductNotFoundException;
import com.alvarosrz.store.service.StoreService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreServiceImplTests {

	@Autowired
	StoreService service;

	@Test
	public void whenAskForPrice_shouldReturnIt() {
		// GIVEN
		Collection<String> products = new ArrayList<>();
		products.add("VOUCHER");
		products.add("TSHIRT");
		products.add("PANTS");
		StoreResponse expected = new StoreResponse(32.5);

		// WHEN
		StoreResponse response = service.getPrice(products);

		// THEN
		Assert.assertEquals(expected.getTotal(), response.getTotal());
	}

	@Test(expected = ProductNotFoundException.class)
	public void whenAskForPriceWithNotFoundProduct_shouldReturnException() {
		// GIVEN
		Collection<String> products = new ArrayList<>();
		products.add("OTHER");

		// WHEN
		service.getPrice(products);
	}

}
