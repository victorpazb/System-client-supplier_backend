package loja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import collections.*;
import entities.*;
import exceptions.*;

public class Controller {

	private CollectionsOfObjects collections;
	private ArrayList<Purchase> allPurchases;
	private String allPurchaseString;

	public Controller() {
		this.collections = new CollectionsOfObjects();
		this.allPurchases = new ArrayList<>();
		this.allPurchaseString = "";

	}

	public void setAllPurchasesString(String allPurchases) {
		this.allPurchaseString = allPurchases;
	}

	public String getAllPurchasesString() {
		return this.allPurchaseString;
	}

	// ============================= USE CASE 1 ===================================

	public String adicionaCliente(String clientCpf, String nameClient, String email, String location) {

		ErrorChecker.adicionaCliente(clientCpf, nameClient, email, location, this.collections.getClientCollection());
		Client newClient = new Client(clientCpf, nameClient, email, location);
		this.collections.addToClientColection(clientCpf, newClient);

		return clientCpf;
	}

	public String exibeCliente(String clientCpf) {
		ErrorChecker.exibeCliente(clientCpf, this.collections.getClientCollection());
		return this.collections.getClientCollection().get(clientCpf).toString();
	}

	public String exibeClientes() {

		ArrayList<Client> list = new ArrayList<>();
		list.addAll(this.collections.getClientCollection().values());

		Collections.sort(list);

		String outPutStringOfClients = "";
		for (Client oneClient : list) {
			outPutStringOfClients += oneClient.toString() + " | ";
		}

		return outPutStringOfClients.substring(0, outPutStringOfClients.length() - 3);
	}

	/**
	 * Method that edit client attributes (name, email, location)
	 * 
	 * @param clientCpf String that is unique do each client and cant be edited
	 * 
	 * @param attribute String that represents what attribute of the client that
	 *                  will be changed (name, email or location)
	 * @param newValue  String wich will be the new value to be edited
	 */

	public void editaCliente(String clientCpf, String attribute, String newValue) {
		ErrorChecker.editaCliente(clientCpf, attribute, newValue, this.collections.getClientCollection());

		Client clientToEdit = this.collections.getClientCollection().get(clientCpf);

		switch (attribute.toLowerCase()) {
		case "nome":
			clientToEdit.setName(newValue);
			break;

		case "email":
			clientToEdit.setEmail(newValue);
			break;

		case "localizacao":
			clientToEdit.setLocation(newValue);
			break;

		}

	}

	public void removeCliente(String clientCpf) {
		ErrorChecker.removeCliente(clientCpf, this.collections.getClientCollection());
		collections.deleteClient(clientCpf);
	}

	// ============================= USE CASE 2 ===================================

	public String adicionaFornecedor(String supplierName, String supplierEmail, String supplierPhone) {

		ErrorChecker.adicionaFornecedor(supplierName, supplierEmail, supplierPhone,
				this.collections.getSupplierCollection());
		Supplier newSupplier = new Supplier(supplierName, supplierEmail, supplierPhone);

		this.collections.addToSupplierColection(supplierName, newSupplier);

		return this.collections.getSupplierCollection().get(supplierName).getName();

	}

	public String exibeFornecedor(String supplierName) {

		ErrorChecker.exibeFornecedor(supplierName, this.collections.getSupplierCollection());
		String supplierStringRepresentation = this.collections.getSupplierCollection().get(supplierName).toString();

		return supplierStringRepresentation;
	}

	public String exibeFornecedores() {

		ErrorChecker.exibeFornecedores(this.collections.getSupplierCollection());
		String allSuppliersStringRepresentation = "";

		ArrayList<Supplier> supplierSortedList = new ArrayList<>();
		supplierSortedList.addAll(this.collections.getSupplierCollection().values());
		Collections.sort(supplierSortedList);

		for (Supplier supplier : supplierSortedList) {
			allSuppliersStringRepresentation += supplier.toString() + " | "; // (length = 3 -> " | " )
		}

		return allSuppliersStringRepresentation.substring(0, allSuppliersStringRepresentation.length() - 3);
	}

	public void editaFornecedor(String supplierName, String attributeToChange, String newValue) {

		ErrorChecker.editaFornecedor(supplierName, attributeToChange, newValue,
				this.collections.getSupplierCollection());

		Supplier supplierToBeEdited = this.collections.getSupplierCollection().get(supplierName);

		switch (attributeToChange.toLowerCase()) {

		case "email":
			supplierToBeEdited.setEmail(newValue);
			break;

		case "telefone":
			supplierToBeEdited.setPhone(newValue);
			break;

		}
	}

	public void removeFornecedor(String supplierName) {

		ErrorChecker.removeFornecedor(supplierName, this.collections.getSupplierCollection());
		this.collections.getSupplierCollection().remove(supplierName);
	}

	// ========================= USE CASE 3 =================================

	private String productKey(String productName, String productDescription) {
		return productName.trim() + " - " + productDescription.trim();
	}

	public void adicionaProduto(String supplierName, String productName, String productDescription, double price) {

		ErrorChecker.adicionaProduto(supplierName, productName, productDescription, price,
				this.collections.getSupplierCollection());
		Supplier supplier = this.collections.getSupplierCollection().get(supplierName);
		supplier.adicionaProduct(productName, productDescription, price);
	}

	public String exibeProduto(String productName, String productDescription, String supplierName) {
		ErrorChecker.exibeProduto(productName, productDescription, supplierName,
				this.collections.getSupplierCollection());

		Supplier supplier = this.collections.getSupplierCollection().get(supplierName);
		String productKey = productName + " - " + productDescription;
		Product product = supplier.getSupplierProducts().get(productKey);

		return product.toString();
	}

	public String exibeProdutosFornecedor(String supplierName) {

		ErrorChecker.exibeProdutosFornecedor(supplierName, this.collections.getSupplierCollection());

		Supplier supplier = this.collections.getSupplierCollection().get(supplierName);
		ArrayList<Product> productsOfSupplier = new ArrayList<>();
		productsOfSupplier.addAll(supplier.getSupplierProducts().values());

		Collections.sort(productsOfSupplier);

		String outComeStringOfProductsOfSupplier = "";

		for (Product product : productsOfSupplier) {
			outComeStringOfProductsOfSupplier += supplier.getName() + " - ";
			outComeStringOfProductsOfSupplier += product.toString() + " | ";
		}

		return outComeStringOfProductsOfSupplier.substring(0, outComeStringOfProductsOfSupplier.length() - 3);
	}

	public String exibeProdutos() {

		String outcomeStringOfAllProductsInSystem = "";
		ArrayList<Supplier> sortedSuppliers = new ArrayList<>();
		sortedSuppliers.addAll(this.collections.getSupplierCollection().values());

		Collections.sort(sortedSuppliers);

		for (Supplier supplier : sortedSuppliers) {
			ArrayList<Product> sortedProducts = new ArrayList<>();

			HashMap<String, Product> mapWithProductsOfASupplier = new HashMap<>();
			mapWithProductsOfASupplier = this.collections.getSupplierCollection().get(supplier.getName())
					.getSupplierProducts();

			sortedProducts.addAll(mapWithProductsOfASupplier.values());

			Collections.sort(sortedProducts);

			for (Product product : sortedProducts) {
				outcomeStringOfAllProductsInSystem += supplier.getName() + " - ";
				outcomeStringOfAllProductsInSystem += product.toString() + " | ";
			}

		}

		return outcomeStringOfAllProductsInSystem.substring(0, outcomeStringOfAllProductsInSystem.length() - 3);
	}

	public void edidaProduto(String productName, String productDescription, String supplierName, double newPrice) {

		ErrorChecker.editaProduto(productName, productDescription, supplierName, newPrice,
				this.collections.getSupplierCollection());

		Supplier supplier = this.collections.getSupplierCollection().get(supplierName);
		Product product = supplier.getSupplierProducts().get(productKey(productName, productDescription));

		product.setPrice(newPrice);

	}

	public void removeProduto(String productName, String productDescription, String supplierName) {

		ErrorChecker.removeProduto(productName, productDescription, supplierName,
				this.collections.getSupplierCollection());

		Supplier supplier = this.collections.getSupplierCollection().get(supplierName); // GET SUPPLIER
		String productKey = productKey(productName, productDescription); // GET PRODCUT KEY

		supplier.getSupplierProducts().remove(productKey); // REMOVE PRODUCT

	}

	// =============================== USE CASE 4 ===============================

	public void adicionaCombo(String supplierName, String comboName, String comboDescription, double discountFactor,
			String productsOfCombo) {

		ErrorChecker.adicionaCombo(supplierName, comboName.trim(), comboDescription.trim(), discountFactor,
				productsOfCombo, this.collections.getSupplierCollection());

		Supplier supplier = this.collections.getSupplierCollection().get(supplierName);
		supplier.addCombo(comboName, comboDescription, discountFactor, productsOfCombo);

	}

	public void editaCombo(String comboName, String comboDescription, String supplierName, double newDiscountFactor) {
		ErrorChecker.editaCombo(comboName, comboDescription, supplierName, newDiscountFactor,
				this.collections.getSupplierCollection());

		Supplier supplier = this.collections.getSupplierCollection().get(supplierName);
		String comboKey = comboName + " - " + comboDescription;

		Product combo = supplier.getSupplierProducts().get(comboKey);

		if (combo instanceof ComboProduct) {
			((ComboProduct) combo).setFactor(newDiscountFactor);
		}

	}

	// =============================== USE CASE 5 ===============================

	private double priceOfPurchase(String productName, String productDescription, String supplierName) {
		double price = 0;
		Supplier supplier = this.collections.getSupplierCollection().get(supplierName);

		if (supplier.getSupplierProducts().containsKey(productName + " - " + productDescription)) {
			price = supplier.getSupplierProducts().get(productName + " - " + productDescription).getPrice();
		}

		return price;
	}

	public void adicionaCompra(String clientCpf, String supplierName, String dateOfPurchase, String productName,
			String productDescription) {

		ErrorChecker.adicionaCombo(clientCpf, supplierName, dateOfPurchase, productName, productDescription,
				this.collections.getClientCollection(), this.collections.getProductCollection(),
				this.collections.getSupplierCollection());

		Client client = this.collections.getClientCollection().get(clientCpf);
		client.addPurchase(supplierName, dateOfPurchase, productName, productDescription,
				priceOfPurchase(productName, productDescription, supplierName));

	}

	public String getDebito(String clientCpf, String supplierName) {
		ErrorChecker.getDebito(clientCpf, supplierName, this.collections.getClientCollection(),
				this.collections.getSupplierCollection());

		Client client = this.collections.getClientCollection().get(clientCpf);

		return client.getDebito(supplierName);

	}

	public String exibeContas(String clientCpf, String supplierName) {

		ErrorChecker.exibeContas(clientCpf, supplierName, this.collections.getClientCollection(),
				this.collections.getSupplierCollection());
		Client client = collections.getClientCollection().get(clientCpf);

		return client.exibeConta(supplierName);

	}

	public String exibeContasClientes(String clientCpf) {

		ErrorChecker.exibeContasClientes(clientCpf, this.collections.getClientCollection());

		Client client = collections.getClientCollection().get(clientCpf);
		return client.exibeContas();
	}

	// ========================= USE CASE 6 ==========================

	public void realizaPagamento(String clientCpf, String supplierName) {

		ErrorChecker.realizaPagamento(clientCpf, supplierName, this.collections.getClientCollection(),
				this.collections.getSupplierCollection());

		Client client = this.collections.getClientCollection().get(clientCpf);
		client.realizaPagamento(supplierName);
	}

	// ========================= USE CASE 7 =============================

	public void ordenaPor(String criterio) {

		for (Client client : this.collections.getClientCollection().values()) {
			for (ArrayList<Purchase> purchaseList : client.getClientPurchaseControl().values()) {
				for (Purchase purchase : purchaseList) {
					if (!this.allPurchases.contains(purchase)) {
						this.allPurchases.add(purchase);
					}

				}
			}
		}

		String saida = "";
		switch (criterio.trim()) {

		case "Cliente":

			Collections.sort(this.allPurchases, new Comparator<Purchase>() {

				@Override
				public int compare(Purchase purchase1, Purchase purchase2) {

					String comparatorString = purchase1.getSupplier() + purchase1.getDescription()
							+ purchase1.getDate();

					String comparatorString2 = purchase2.getSupplier() + purchase2.getDescription()
							+ purchase2.getDate();

					return (purchase1.getClientName() + comparatorString)
							.compareTo(purchase2.getClientName() + comparatorString2);
				}

			});

			for (Purchase purchase : this.allPurchases) {

				purchase.setListarComprasSelector(criterio);
				saida += purchase.toString() + " | ";
			}

			setAllPurchasesString(saida);

			break;

		case "Fornecedor":

			Collections.sort(this.allPurchases, new Comparator<Purchase>() {

				// (<cliente>, <desc_prod>, <data_compra>;

				@Override
				public int compare(Purchase purchase1, Purchase purchase2) {

					String comparatorString = purchase1.getClientName() + purchase1.getDescription()
							+ purchase1.getDate();

					String comparatorString2 = purchase2.getClientName() + purchase2.getDescription()
							+ purchase2.getDate();

					return (purchase1.getSupplier() + comparatorString)
							.compareTo(purchase2.getSupplier() + comparatorString2);
				}

			});

			for (Purchase purchase : this.allPurchases) {
				purchase.setListarComprasSelector(criterio);
				saida += purchase.toString() + " | ";
			}

			setAllPurchasesString(saida);
			break;

		case "Data":

			Collections.sort(this.allPurchases, new Comparator<Purchase>() {

				@Override
				public int compare(Purchase purchase1, Purchase purchase2) {

					if (purchase1.getDate().substring(6).compareTo(purchase2.getDate().substring(6)) < 0) {
						return -1;
					} else if (purchase1.getDate().substring(6).compareTo(purchase2.getDate().substring(6)) > 0) {
						return 1;
					} else {
						if (purchase1.getDate().substring(3, 4).compareTo(purchase2.getDate().substring(3, 4)) < 0) {
							return -1;
						} else if (purchase1.getDate().substring(3, 4)
								.compareTo(purchase2.getDate().substring(3, 4)) > 0) {
							return 1;
						} else {
							if (purchase1.getDate().substring(0, 2)
									.compareTo(purchase2.getDate().substring(0, 2)) < 0) {
								return -1;
							} else if (purchase1.getDate().substring(0, 2)
									.compareTo(purchase2.getDate().substring(0, 2)) > 0)
								return 1;
							else {

								/**
								 * The criterion used for the tiebreaker if the dates are strictly equal is the
								 * concatenation of clientName + supplierName + purchaseDescription
								 */
								String stringDesempate = purchase1.getClientName() + purchase1.getSupplier()
										+ purchase1.getDescription();
								String stringDesempate2 = purchase2.getClientName() + purchase2.getSupplier()
										+ purchase2.getDescription();

								if (stringDesempate.compareTo(stringDesempate2) < 0) {
									return -1;
								} else if (stringDesempate.compareTo(stringDesempate2) > 0) {
									return 1;
								} else {
									return 0;
								}
							}
						}
					}
				}

			});

			for (Purchase purchase : this.allPurchases) {

				purchase.setListarComprasSelector(criterio);
				saida += purchase.toString() + " | ";

			}

			setAllPurchasesString(saida);
			break;

		default:
			ErrorChecker.ordenaPor(criterio);

		}

	}

	public String listarCompras() {
		return this.allPurchaseString.substring(0, this.allPurchaseString.length() - 3);
	}
}
