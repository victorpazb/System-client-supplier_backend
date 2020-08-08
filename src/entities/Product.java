package entities;

public abstract class Product {

	private String productName, productDescription;
	private double price;

	public Product(String productName, String productDescription, double price) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
	}

	private String editPrice(double price) {

		String priceFormated = "";
		priceFormated = String.format("%.2f", price);

		return priceFormated;
	}

	@Override
	public String toString() {

		return this.productName + " - " + this.productDescription + " - R$" + editPrice(this.price);
	};

}
