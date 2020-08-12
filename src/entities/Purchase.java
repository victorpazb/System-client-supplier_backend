package entities;

public class Purchase {

	private String supplierName, dateOfPurchase, productName, productDescription;
	private double priceOfPurchase;

	public Purchase(String supplierName, String dateOfPurchase, String productName, String productDescription,
			double price) {

		this.supplierName = supplierName;
		this.dateOfPurchase = dateOfPurchase;
		this.productName = productName;
		this.productDescription = productDescription;
		this.priceOfPurchase = price;
	}

	public double getPrice() {
		return this.priceOfPurchase;
	}

	public String getSupplier() {
		return this.supplierName;
	}

}
