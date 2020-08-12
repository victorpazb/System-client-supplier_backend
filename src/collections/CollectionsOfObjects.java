package collections;
import java.util.HashMap;
import entities.*;

public class CollectionsOfObjects {

	private HashMap<String, Client> clientCollection;
	private HashMap<String, Supplier> supplierCollection;
	private HashMap<String, Product> productCollection;
	private HashMap<String, Purchase> purchaseCollection;

	public CollectionsOfObjects() {
		this.clientCollection = new HashMap<>();
		this.supplierCollection = new HashMap<>();
		this.productCollection = new HashMap<>();
		this.purchaseCollection =  new HashMap<>();
	}

	// ON CLIENT COLLECTION

	public HashMap<String, Client> getClientCollection() {
		return this.clientCollection;
	}

	public void addToClientColection(String clientName, Client newClient) {
		this.clientCollection.put(clientName, newClient);
	}

	public void deleteClient(String cpf) {
		this.clientCollection.remove(cpf);
	}

	
	// SUPPLIER COLLECTION
	public HashMap<String, Supplier> getSupplierCollection() {
		return this.supplierCollection;
	}

	public void addToSupplierColection(String supplierName, Supplier newClient) {
		this.supplierCollection.put(supplierName, newClient);
	}

	public void deleteSupplier(String nameOfSupplier) {
		this.supplierCollection.remove(nameOfSupplier);
	}
	
	// PRODUCT COLLECTION
	
	public HashMap<String, Product> getProductCollection() {
		return this.productCollection;
	}
	
	public void addToProductColection(String productName, String productDescription, Product newProduct) {
		this.productCollection.put(productName + " - " + productDescription, newProduct);
	}
	
	public void deleteProduct(String keyOfProduct) {
		this.productCollection.remove(keyOfProduct);
	}
	
	// PURSCHASE COLLECTION
	
	public HashMap<String, Purchase> getPurchaseCollection(){
		return this.purchaseCollection;
	}
	
	public void addToPurchaseColection(String purchaseKey, Purchase newPurchase) {
		this.purchaseCollection.put(purchaseKey, newPurchase);
	}
	
	public void deletePurchase(String purchaseKey) {
		this.purchaseCollection.remove(purchaseKey);
	}

}
