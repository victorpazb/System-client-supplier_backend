package entities;

import java.util.HashMap;

import collections.*;

public class Supplier implements Comparable<Supplier> {

	private String supplierName, supplierEmail, supplierPhone;
	private CollectionsOfObjects collection;
	private HashMap<String, Product> collectionOfProcts;

	public Supplier(String supplierName, String supplierEmail, String supplierPhone) {
		this.supplierName = supplierName;
		this.supplierEmail = supplierEmail;
		this.supplierPhone = supplierPhone;

		this.collection = new CollectionsOfObjects();

		this.collectionOfProcts = this.collection.getProductCollection();

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
		return this.collectionOfProcts;
	}

	public void setEmail(String newValue) {
		this.supplierEmail = newValue;
	}

	public void setPhone(String newValue) {
		this.supplierPhone = newValue;
	}

	public void adicionaProduct(String productName, String productDescription, double price) {

		SimpleProduct newProduct = new SimpleProduct(productName, productDescription, price);

		this.collectionOfProcts.put(productName + " - " + productDescription, newProduct);

	}

}
