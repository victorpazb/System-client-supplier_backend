package entities;

import java.util.ArrayList;

import java.util.HashMap;

import collections.*;

public class Supplier implements Comparable<Supplier> {

	private String supplierName, supplierEmail, supplierPhone;
	private CollectionsOfObjects collection;
	private HashMap<String, Product> collectionOfProducts;

	public Supplier(String supplierName, String supplierEmail, String supplierPhone) {
		this.supplierName = supplierName;
		this.supplierEmail = supplierEmail;
		this.supplierPhone = supplierPhone;

		this.collection = new CollectionsOfObjects();

		this.collectionOfProducts = this.collection.getProductCollection();

	}

	@Override
	public String toString() {
		return this.supplierName + " - " + this.supplierEmail + " - " + this.supplierPhone;
	}

	public String getName() {
		return this.supplierName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Supplier) {
			return ((Supplier) obj).getName() == this.supplierName;
		}
		return false;
	}

	@Override
	public int compareTo(Supplier otherSupplier) {
		if (otherSupplier.getName().compareTo(this.supplierName) < 0) {
			return 1;
		} else if (otherSupplier.getName().compareTo(this.supplierName) > 0) {
			return -1;
		} else {
			return 0;
		}

	}

	public HashMap<String, Product> getSupplierProducts() {
		return this.collectionOfProducts;
	}

	public void setEmail(String newValue) {
		this.supplierEmail = newValue;
	}

	public void setPhone(String newValue) {
		this.supplierPhone = newValue;
	}

	public void adicionaProduct(String productName, String productDescription, double price) {

		SimpleProduct newProduct = new SimpleProduct(productName, productDescription, price);

		collection.addToProductColection(productName, productDescription, newProduct);

	}

	public void addCombo(String comboName, String comboDescription, double discountFactor, String productsOfCombo) {

		String comboKey = comboName.trim() + " - " + comboDescription.trim(); // in the map of products the key is:
																				// "NAME - DESCRIPTION"

		ArrayList<Product> listOfProducts = new ArrayList<>(); // ArrayList to put the products thtat will compose de
																// the combo

		String[] productsKeyList = productsOfCombo.split(", "); // the combo keys are separeted for a comma and space ",
																// "

		for (String productKey : productsKeyList) {
			if (this.collectionOfProducts.containsKey(productKey)) {
				listOfProducts.add(this.collectionOfProducts.get(productKey));
			}
		}

		ComboProduct newCombo = new ComboProduct(comboName, comboDescription, discountFactor, productsOfCombo,
				listOfProducts);

		collection.addToProductColection(comboName, comboDescription, newCombo);

	}

}
