package entities;

public class Purchase implements Comparable<Purchase> {

	private String supplierName, dateOfPurchase, productName, productDescription, clientCpf, clientName,
			listarComprasSelector;
	private double priceOfPurchase;

	public Purchase(String supplierName, String dateOfPurchase, String productName, String productDescription,
			double price, String clientCpf, String clientName) {

		this.supplierName = supplierName;
		this.dateOfPurchase = dateOfPurchase;
		this.productName = productName;
		this.productDescription = productDescription;
		this.priceOfPurchase = price;
		this.clientCpf = clientCpf;
		this.clientName = clientName;
		this.listarComprasSelector = "";
	}

	public void setListarComprasSelector(String criterio) {
		this.listarComprasSelector = criterio;
	}

	public String getClientName() {
		return this.clientName;
	};

	public String getListarComprasCriterio() {
		return this.listarComprasSelector;
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

		switch (this.listarComprasSelector) {

		case "Cliente":
			this.listarComprasSelector = "";
			return this.clientName + ", " + this.supplierName + ", " + this.productDescription + ", "
					+ this.dateOfPurchase;

		case "Forncedor":
			this.listarComprasSelector = "";
			return this.supplierName + ", " + this.clientName + ", " + this.productDescription + ", "
					+ this.dateOfPurchase;

		case "Data":
			this.listarComprasSelector = "";
			return this.dateOfPurchase.replace("-", "/") + ", " + this.clientName + ", " + this.supplierName + ", "
					+ this.productDescription;

		default:
			return this.productName + " - " + this.dateOfPurchase.replace("/", "-");
		}

	}

	@Override
	public int compareTo(Purchase otherPurchase) {

		if (!this.dateOfPurchase.equals(otherPurchase.getDate())) {
			return this.productName.compareTo(otherPurchase.getName());
		}

		return this.productDescription.compareTo(otherPurchase.getDescription()) * (-1);

	}
}
