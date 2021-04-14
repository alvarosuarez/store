package com.alvarosrz.store.model;

/**
 * @author alvaro
 *
 */
public class FreeItemRule extends PricingRule {

	public FreeItemRule(String code, int units) {
		super(code, units);
	}

	@Override
	protected Double getNewProductAmount(CheckoutProduct product) {
		if (!isMultipleOf(product.getUnits()) && isMultipleOf(product.getUnits() + 1)) {
			return 0d;
		}
		return product.getProductPrice();
	}

	private boolean isMultipleOf(int value) {
		return (value % getUnits()) == 0;
	}

}
