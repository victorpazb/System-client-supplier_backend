package exceptions;

import java.util.HashMap;
import entities.*;

public interface ErrorChecker {

	// =================== USE CASE 1 ========================

	static void adicionaCliente(String cpfClient, String clientName, String email, String location,
			HashMap<String, Client> clientCollection) {

		if (cpfClient.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}

		if (cpfClient.equals("") || cpfClient == null) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}

		if (clientName.equals("") || clientName == null) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}

		if (email.equals("") || email == null) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}

		if (location.equals("") || location == null) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}

		if (clientCollection.containsKey(cpfClient)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}

	}

	static void exibeCliente(String clientCpf, HashMap<String, Client> collectionOfClients) {

		if (clientCpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir cliente: cpf invalido.");
		}

		if (clientCpf.equals("") || clientCpf == null) {
			throw new IllegalArgumentException("Erro ao exibir cliente: cpf nao pode ser vazio ou nulo.");
		}

		if (!collectionOfClients.containsKey(clientCpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}

	}

	static void editaCliente(String clientCpf, String attribute, String newValue,
			HashMap<String, Client> collectionOfClients) {

		if (attribute.equals("") || attribute == null) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}

		if (newValue.equals("") || newValue == null) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}

		if (!attribute.toLowerCase().equals("nome") && !attribute.toLowerCase().equals("email")
				&& !attribute.toLowerCase().equals("localizacao")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}

		if (!collectionOfClients.containsKey(clientCpf)) {
			throw new NullPointerException("Erro na edicao do cliente: cliente nao existe.");
		}

	}

	static void removeCliente(String clientCpf, HashMap<String, Client> collectionOfClients) {
		if (clientCpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao excluir cliente: cpf invalido.");
		}

		if (clientCpf.equals("") || clientCpf == null) {
			throw new IllegalArgumentException("Erro ao excluir cliente: cpf nao pode ser vazio ou nulo.");
		}

		if (!collectionOfClients.containsKey(clientCpf)) {
			throw new NullPointerException("Erro ao excluir cliente: cliente nao existe.");
		}

	}

	// ================= USE CASE 2 ==========================

	static void adicionaFornecedor(String nome, String email, String telefone,
			HashMap<String, Supplier> supplierCollection) {

		if (nome.equals("") || nome == null) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}

		if (email.equals("") || email == null) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}

		if (telefone.equals("") || telefone == null) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}

		if (supplierCollection.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: fornecedor ja existe.");
		}
	}

	static void exibeFornecedor(String supplierName, HashMap<String, Supplier> supplierCollection) {
		if (supplierName.equals("") || supplierName == null) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
		}

		if (!supplierCollection.containsKey(supplierName)) {
			throw new NullPointerException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}

	}

	static void exibeFornecedores(HashMap<String, Supplier> supplierCollection) {

		if (supplierCollection.isEmpty()) {
			throw new NullPointerException("Erro na exibicao dos fornecedores: nenhum fornecedor castrado.");
		}

	}

	static void editaFornecedor(String supplierName, String attributeToChange, String newValue,
			HashMap<String, Supplier> supplierCollection) {
		if (attributeToChange.equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}

		if (attributeToChange.equals("") || attributeToChange == null) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}

		if (!attributeToChange.equals("email") && !attributeToChange.equals("telefone")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}

		if (newValue.equals("") || newValue == null) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}

		if (!supplierCollection.containsKey(supplierName)) {
			throw new NullPointerException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}

	}

	static void removeFornecedor(String supplierName, HashMap<String, Supplier> supplierCollection) {

		if (supplierName.equals("") || supplierName == null) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}

		if (!supplierCollection.containsKey(supplierName)) {
			throw new NullPointerException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}

	}

	// ============================= USE CASE 3 =============================

	static void adicionaProduto(String supplierName, String productName, String productDescription, double price,
			HashMap<String, Supplier> supplierCollection) {

		// SUPPLIER ERROR

		if (supplierName.equals("") || supplierName == null) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");

		} else if (!supplierCollection.containsKey(supplierName)) {
			throw new NullPointerException("Erro no cadastro de produto: fornecedor nao existe.");
		}

		if (productName.equals("") || productName == null) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}

		if (productDescription.equals("") || productDescription == null) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}

		if (price < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}

		if (supplierCollection.get(supplierName).getSupplierProducts()
				.containsKey(productName + " - " + productDescription)) {
			throw new NullPointerException("Erro no cadastro de produto: produto ja existe.");
		}
	}

	static void exibeProduto(String productName, String productDescription, String supplierName,
			HashMap<String, Supplier> supplierCollection) {

		if (productName.trim().equals("") || productName == null) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}

		if (productDescription.trim().equals("") || productDescription == null) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}

		if (supplierName.trim().equals("") || supplierName == null) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (!supplierCollection.containsKey(supplierName)) {
			throw new NullPointerException("Erro na exibicao de produto: fornecedor nao existe.");
		}

		if (supplierCollection.get(supplierName).getSupplierProducts().isEmpty() || !supplierCollection
				.get(supplierName).getSupplierProducts().containsKey(productName + " - " + productDescription)) {
			throw new NullPointerException("Erro na exibicao de produto: produto nao existe.");
		}

	}

	static void exibeProdutosFornecedor(String supplierName, HashMap<String, Supplier> supplierCollection) {

		if (supplierName.trim().equals("") || supplierName == null) {
			throw new IllegalArgumentException("EXIBINDO PRODUTOS DO FORNECEDOR: NOME FORNECEDOR VAZIO OU NULO.");
		}

		if (!supplierCollection.containsKey(supplierName)) {
			throw new NullPointerException("EXIBINDO PRODUTOS DO FORNECEDOR: FORNECEDOR NAO EXISTE!");
		}

	}

	static void editaProduto(String productName, String productDescription, String supplierName, double newPrice,
			HashMap<String, Supplier> supplierCollection) {

		if (productName.trim().equals("") || productName == null) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}

		if (productDescription.trim().equals("") || productDescription == null) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}

		if (supplierName.trim().equals("") || supplierName == null) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (newPrice < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}

		if (!supplierCollection.containsKey(supplierName)) {
			throw new NullPointerException("Erro na edicao de produto: fornecedor nao existe.");
		}

	}

	static void removeProduto(String productName, String productDescription, String supplierName,
			HashMap<String, Supplier> supplierCollection) {

		if (productName.trim().equals("") || productName == null) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}

		if (productDescription.trim().equals("") || productDescription == null) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}

		if (supplierName.trim().equals("") || supplierName == null) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		
		
		
		if (!supplierCollection.containsKey(supplierName)) {
			throw new NullPointerException("Erro na remocao de produto: fornecedor nao existe.");

		 } else {

			Supplier supplier = supplierCollection.get(supplierName);
			String productKey = productName + " - " + productDescription;

			if (!supplier.getSupplierProducts().containsKey(productKey)) {
				throw new NullPointerException("Erro na remocao de produto: produto nao existe.");
			}
		}

	}
	
	
	// =============================== USE CASE 4 ===============================

}
