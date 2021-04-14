package com.alvarosrz.store.model;

public class StoreResponse {

	private final Double total;

	public StoreResponse(Double total) {
		this.total = total;
	}

	public String getTotal() {
		return total.toString() + " €";
	}
}