package entities;

public class Client implements Comparable<Client> {

	private String cpf, name, email, location;

	public Client(String cpf, String name, String email, String location) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.location = location;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Client)
			return this.cpf.equals(((Client) obj).getCpf());

		return false;
	}

	@Override
	public String toString() {
		return this.name + " - " + this.location + " - " + this.email;
	}

	@Override
	public int compareTo(Client client) {
		if (this.name.compareTo(client.getName()) > 0) {
			return 1;
		}

		if (this.name.compareTo(client.getName()) < 0) {
			return -1;
		}
		return 0;
	}

}
