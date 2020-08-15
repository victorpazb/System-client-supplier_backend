package entities;

public class Purchase implements Comparable<Purchase> {

	private String supplierName, dateOfPurchase, productName, productDescription, clientCpf;
	private double priceOfPurchase;

	public Purchase(String supplierName, String dateOfPurchase, String productName, String productDescription,
			double price, String clientCpf) {

		this.supplierName = supplierName;
		this.dateOfPurchase = dateOfPurchase;
		this.productName = productName;
		this.productDescription = productDescription;
		this.priceOfPurchase = price;
		this.clientCpf = clientCpf;
	}

	public double getPrice() {
		return this.priceOfPurchase;
	}

	public String getClientCpf() {
		return this.clientCpf;
	}

	public String getSupplier() {
		return this.supplierName;
	}

	public String getName() {
		return this.productName;
	}

	public String getDate() {
		return this.dateOfPurchase;
	}

	public String getDescription() {
		return this.productDescription;
	}

	@Override
	public String toString() {
		return this.productName + " - " + this.dateOfPurchase.replace("/", "-");
	}

	public String toString2() {
		return this.productDescription + ", " + this.dateOfPurchase;
	}

	@Override
	public int compareTo(Purchase otherPurchase) {

		if (!this.dateOfPurchase.equals(otherPurchase.getDate())) {
			return this.productName.compareTo(otherPurchase.getName());
		}

		return this.productDescription.compareTo(otherPurchase.getDescription()) * (-1);

	}
}
