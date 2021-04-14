package com.alvarosrz.store.service;

import java.util.Collection;

import com.alvarosrz.store.model.StoreResponse;

/**
 * Define una interfaz para el servicio de CarPooling
 * 
 * @author alvaro
 *
 */
public interface StoreService {

	/**
	 * Calcula el precio de una serie de productos recibidos.
	 * 
	 * @param products productos a vender
	 * @return Objeto {@link StoreResponse} con el precio total de la venta
	 */
	StoreResponse getPrice(Collection<String> products);

}
