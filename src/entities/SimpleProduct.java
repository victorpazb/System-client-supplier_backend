package entities;

public class SimpleProduct extends Product  {
	
	
	

	public SimpleProduct(String productName, String productDescription, double productPrice) {
		super(productName, productDescription, productPrice);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	public double getPrice() {
		return super.getPrice();
	}

}
