package com.alvarosrz.store.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.alvarosrz.store.dao.StoreDao;
import com.alvarosrz.store.dao.impl.StoreDaoImpl;
import com.alvarosrz.store.model.Product;

public class StoreDaoImplTests {

	StoreDao dao;

	@Before
	public void before() {
		dao = new StoreDaoImpl();
	}

	@Test
	public void whenFind_shouldReturnAnExistingProduct() {
		// GIVEN
		String code = "VOUCHER";
		Product expected = new Product("VOUCHER", "Gift Card", 5.00);

		// WHEN
		Product product = dao.findProduct(code);

		// THEN
		Assert.assertEquals(expected.getCode(), product.getCode());
		Assert.assertEquals(expected.getName(), product.getName());
		Assert.assertEquals(expected.getPrice(), product.getPrice());
	}

	@Test
	public void whenFind_shouldNotReturnAProduct() {
		// GIVEN
		String code = "OTHER";

		// WHEN
		Product product = dao.findProduct(code);

		// THEN
		Assert.assertNull(product);
	}

}
