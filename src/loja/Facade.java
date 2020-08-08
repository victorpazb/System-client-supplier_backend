package loja;

import easyaccept.EasyAccept;

public class Facade {

	public static void main(String[] args) {
		args = new String[] { "loja.Facade", "testesAceitacao/use_case_1.txt", "testesAceitacao/use_case_2.txt", "testesAceitacao/use_case_3.txt"};	
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
	
	
	
	
	
	
	
	
	
}