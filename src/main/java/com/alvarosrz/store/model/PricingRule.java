package com.alvarosrz.store.model;

/**
 * @author alvaro
 *
 */
public abstract class PricingRule {

	private String code;
	private int units;

	public PricingRule(String code, int units) {
		this.code = code;
		this.units = units;
	}

	protected abstract Double getNewProductAmount(CheckoutProduct product);

	public String getCode() {
		return code;
	}

	public int getUnits() {
		return units;
	}

}
