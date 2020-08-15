package loja;

import easyaccept.EasyAccept;

public class Facade {

	public static void main(String[] args) {
		args = new String[] { "loja.Facade", "testesAceitacao/use_case_1.txt", "testesAceitacao/use_case_2.txt",
				"testesAceitacao/use_case_3.txt", "testesAceitacao/use_case_4.txt", "testesAceitacao/use_case_5.txt", "testesAceitacao/use_case_6.txt", "testesAceitacao/use_case_7.txt" };
		EasyAccept.main(args);
	}

	// ============================= USE CASE 1 ===================================

	Controller controle = new Controller();

	public String adicionaCliente(String clientCpf, String nameClient, String email, String location) {
		return controle.adicionaCliente(clientCpf, nameClient, email, location);
	}

	public String exibeCliente(String clientCpf) {
		return controle.exibeCliente(clientCpf);
	}

	public String exibeClientes() {
		return controle.exibeClientes();
	}

	public void editaCliente(String clientCpf, String attribute, String newValue) {
		controle.editaCliente(clientCpf, attribute, newValue);
	}

	public void removeCliente(String clientCpf) {
		controle.removeCliente(clientCpf);
	}

	// ============================= USE CASE 2 ===================================

	public String adicionaFornecedor(String supplierName, String supplierEmail, String supplierPhone) {
		return controle.adicionaFornecedor(supplierName, supplierEmail, supplierPhone);
	}

	public String exibeFornecedor(String supplierName) {
		return controle.exibeFornecedor(supplierName);
	}

	public String exibeFornecedores() {
		return controle.exibeFornecedores();
	}

	public void editaFornecedor(String supplierName, String attributeToChange, String newValue) {
		controle.editaFornecedor(supplierName, attributeToChange, newValue);
	}

	public void removeFornecedor(String supplierName) {
		controle.removeFornecedor(supplierName);
	}

	// ============================ USE CASE 3 =================================

	public void adicionaProduto(String supplierName, String productName, String productDescription, double price) {
		controle.adicionaProduto(supplierName, productName, productDescription, price);
	}

	public String exibeProduto(String productName, String productDescription, String supplierName) {
		return controle.exibeProduto(productName, productDescription, supplierName);
	}

	public String exibeProdutosFornecedor(String supplierName) {
		return controle.exibeProdutosFornecedor(supplierName);
	}

	public String exibeProdutos() {
		return controle.exibeProdutos();
	}

	public void editaProduto(String productName, String productDescription, String supplierName, double newPrice) {
		controle.edidaProduto(productName, productDescription, supplierName, newPrice);
	}

	public void removeProduto(String productName, String productDescription, String supplierName) {
		controle.removeProduto(productName, productDescription, supplierName);
	}

	// =============================== USE CASE 4 ===============================

	public void adicionaCombo(String supplierName, String comboName, String comboDescription, double discountFactor,
			String productsOfCombo) {
		controle.adicionaCombo(supplierName, comboName, comboDescription, discountFactor, productsOfCombo);
	}

	public void editaCombo(String comboName, String comboDescription, String supplierName, double newDiscountFactor) {
		controle.editaCombo(comboName, comboDescription, supplierName, newDiscountFactor);
	}

	// =============================== USE CASE 5 ===============================

	public void adicionaCompra(String clientCpf, String supplierName, String date, String productName,
			String productDescription) {
		controle.adicionaCompra(clientCpf, supplierName, date, productName, productDescription);
	}
	
	public String getDebito(String clientCpf, String supplierName) {
		return controle.getDebito(clientCpf, supplierName);
	}
	
	public String exibeContas(String clientCpf, String supplierName) {
		return controle.exibeContas(clientCpf, supplierName);
	}
	
	public String exibeContasClientes(String clientCpf) {
		return controle.exibeContasClientes(clientCpf);
	}
	
	//============================== USE CASE 6 =====================================
	
	public void realizaPagamento(String clientCpf, String supplierName) {
		controle.realizaPagamento(clientCpf, supplierName);
	}
	
	// ========================= USE CASE 7 ==========================================
	
	public void ordenaPor(String criterio) {
		controle.ordenaPor(criterio);
	}
	
	public String listarCompras() {
		return controle.listarCompras();
	}

}