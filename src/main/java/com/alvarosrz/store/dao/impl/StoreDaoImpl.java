package com.alvarosrz.store.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.alvarosrz.store.dao.StoreDao;
import com.alvarosrz.store.model.Product;

@Repository
public class StoreDaoImpl implements StoreDao {

	@SuppressWarnings("serial")
	private final Map<String, Product> products = new HashMap<String, Product>() {
		{
			put("VOUCHER", new Product("VOUCHER", "Gift Card", 5.00));
			put("TSHIRT", new Product("TSHIRT", "Summer T-Shirt", 20.00));
			put("PANTS", new Product("PANTS", "Summer Pants", 7.50));
		}
	};

	@Override
	public Product findProduct(String code) {
		return products.get(code);
	}

}
