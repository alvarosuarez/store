package com.alvarosrz.store.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvarosrz.store.dao.StoreDao;
import com.alvarosrz.store.model.Product;
import com.alvarosrz.store.model.StoreResponse;
import com.alvarosrz.store.model.exception.ProductNotFoundException;
import com.alvarosrz.store.service.Checkout;
import com.alvarosrz.store.service.StoreService;

/**
 * Implementación de {@link StoreService}
 * 
 * @author alvaro
 *
 */
@Service
public class StoreServiceImpl implements StoreService {

	private Checkout checkout = new Checkout();

	@Autowired
	private StoreDao storeDao;

	@Override
	public StoreResponse getPrice(Collection<String> products) {

		Double total = 0d;
		for (String code : products) {
			Product product = storeDao.findProduct(code);
			if (product == null) {
				throw new ProductNotFoundException("Product " + code + " not Found.");
			} else {
				total = total + product.getPrice();
			}
		}

		return new StoreResponse(total);
	}

}
