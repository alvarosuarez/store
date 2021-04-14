package com.alvarosrz.store.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author alvaro
 *
 */
public class PricingRules {

	private Collection<PricingRule> rules = new ArrayList<>();

	public void addRule(PricingRule rule) {
		rules.add(rule);
	}

	public Collection<PricingRule> getRules() {
		return rules;
	}

	public Double getNewProductPrice(CheckoutProduct checkoutProduct) {
		PricingRule rule = getProductCodeRule(checkoutProduct.getProductCode());
		if (rule == null) {
			return checkoutProduct.getProductPrice();
		}

		return rule.getNewProductAmount(checkoutProduct);
	}

	/**
	 * Este desarrollo solamente plantea una regla de descuento por cada tipo de
	 * producto
	 */
	public PricingRule getProductCodeRule(String code) {
		for (PricingRule pricingRule : rules) {
			if (pricingRule.getCode().equals(code)) {
				return pricingRule;
			}
		}
		return null;
	}
}
