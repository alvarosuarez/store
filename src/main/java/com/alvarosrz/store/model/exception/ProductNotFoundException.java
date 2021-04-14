package com.alvarosrz.store.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción para indicar que no existe el producto
 * 
 * @author alvaro
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7694225475936147241L;

	public ProductNotFoundException(String message) {
		super(message);
	}

}
