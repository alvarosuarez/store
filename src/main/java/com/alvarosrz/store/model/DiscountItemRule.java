package com.alvarosrz.store.model;

/**
 * @author alvaro
 *
 */
public class DiscountItemRule extends PricingRule {

	private double price;

	public DiscountItemRule(String code, int units, double price) {
		super(code, units);
		this.price = price;
	}

	@Override
	protected Double getNewProductAmount(CheckoutProduct product) {
		if (isMultipleOf(product.getUnits() + 1)) {
			return product.getProductPrice() - getSubstractionAmount(product);
		}
		return product.getProductPrice();
	}

	private Double getSubstractionAmount(CheckoutProduct product) {
		return getUnits() * (product.getProductPrice() - price);
	}

	private boolean isMultipleOf(int value) {
		return (value % getUnits()) == 0;
	}

}
