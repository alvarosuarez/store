package com.alvarosrz.store.dao;

import com.alvarosrz.store.model.Product;

/**
 * @author alvaro
 *
 */
public interface StoreDao {

	/**
	 * Devuelve un {@link Product} a partir del código
	 * 
	 * @param code código del producto
	 * @return Objeto {@link Product} con la información
	 */
	Product findProduct(String code);

}
