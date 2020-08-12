package entities;

import java.util.ArrayList;

public class ComboProduct extends Product implements Comparable<Product> {

	private String comboName, comboDescription;

	private double discountFactor;

	private ArrayList<Product> productsOfCombo2;

	public ComboProduct(String comboName, String comboDescription, double discountFactor, String prductsOfCombo,
			ArrayList<Product> productsOfCombo2) {

		super(comboName, comboDescription, 0);

		this.discountFactor = discountFactor;

		this.productsOfCombo2 = productsOfCombo2;

		this.setPrice(calculatingPriceWithDiscount(this.discountFactor));

	}


	/**
	 * Calculates the price of the combo with NO discount. Just adding the price of
	 * products that compose it
	 * 
	 * @return double - price with NO discount
	 */
	private double calculatingPriceWithoutDiscount() {
		double priceWithoutDiscount = 0;

		for (Product product : this.productsOfCombo2) {
			priceWithoutDiscount += product.getPrice();
		}
		return priceWithoutDiscount;
	}

	private double calculatingPriceWithDiscount(double discountFactor) {

		double priceWithDiscount = 0;
		double priceWithoutDiscount = calculatingPriceWithoutDiscount();

		priceWithDiscount = priceWithoutDiscount * (1 - discountFactor);

		return priceWithDiscount;
	}




}
