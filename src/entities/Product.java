package entities;

public abstract class Product implements Comparable<Product> {

	private String productName, productDescription;
	private double price;

	public Product(String productName, String productDescription, double price) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
	}
	
	public String getKey() {
		return this.productName + " - " + this.productDescription;
	}
	
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}

	private String editPrice(double price) {

		String priceFormated = "";
		priceFormated = String.format("%.2f", price);

		return priceFormated;
	}

	public String productKey() {
		return this.productName + " - " + this.productDescription;
	}

	@Override
	public int compareTo(Product otherProduct) {
		if (productKey().compareTo(otherProduct.productKey()) > 0) {
			return 1;
		} else if (productKey().compareTo(otherProduct.productKey()) < 0) {
			return -1;
		} else {
			return 0;
		}

	}

	@Override
	public boolean equals(Object otherProduct) {
		if (otherProduct instanceof Product) {
			return productKey().equals(((Product) otherProduct).productKey());
		}
		return false;

	}

	@Override
	public String toString() {

		return this.productName + " - " + this.productDescription + " - R$" + editPrice(this.price);
	};

}
