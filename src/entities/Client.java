package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


import collections.*;

public class Client implements Comparable<Client> {

	private String cpf, name, email, location;
	private CollectionsOfObjects collection;
	private HashMap<String, Purchase> purchaseCollection;

	public Client(String cpf, String name, String email, String location) {

		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.location = location;
		this.collection = new CollectionsOfObjects();
		this.purchaseCollection = this.collection.getPurchaseCollection();
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public HashMap<String, Purchase> getPurchaseCollection() {
		return this.purchaseCollection;
	}

	public void addPurchase(String supplierName, String dateOfPurchase, String productName, String productDescription,
			double priceOfPurchase) {

		Purchase newPurchase = new Purchase(supplierName, dateOfPurchase, productName, productDescription,
				priceOfPurchase);

		this.purchaseCollection.put(productName + " - " + productDescription, newPurchase);

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Client)
			return this.cpf.equals(((Client) obj).getCpf());

		return false;
	}

	@Override
	public String toString() {
		return this.name + " - " + this.location + " - " + this.email;
	}

	@Override
	public int compareTo(Client client) {
		if (this.name.compareTo(client.getName()) > 0) {
			return 1;
		}

		if (this.name.compareTo(client.getName()) < 0) {
			return -1;
		}
		return 0;
	}

	public String getDebito(String supplierName) {

		double debit = 0;
		for (Purchase purchase : this.purchaseCollection.values()) {
			if (purchase.getSupplier().equals(supplierName)) {
				debit += purchase.getPrice();
			}
		}

		return String.format("%.2f", debit).replace(",", ".");

	}

	public String exibeConta(String supplierName) {

		ArrayList<Purchase> purchaseList = new ArrayList<>();
		purchaseList.addAll(this.purchaseCollection.values());
		Collections.sort(purchaseList);

		String clientPurchasesBySupplier = "Cliente: " + this.name + " | " + supplierName + " | ";

		for (Purchase purchase : purchaseList) {
			if (purchase.getSupplier().equals(supplierName)) {
				clientPurchasesBySupplier += purchase.toString() + " | ";
			}
		}

		return clientPurchasesBySupplier.substring(0, clientPurchasesBySupplier.length() - 3);

	}

	public String exibeContas() {
		return "pensar!";
	}
}
