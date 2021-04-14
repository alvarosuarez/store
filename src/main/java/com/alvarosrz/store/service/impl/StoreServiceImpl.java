package com.alvarosrz.store.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.alvarosrz.store.model.StoreResponse;
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

	@Override
	public StoreResponse getPrice(Collection<String> products) {
		return new StoreResponse(1d);
	}

}
