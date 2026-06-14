package prw;

public class Cliente {
	
	private String nome;
	private String email;
	private String pratoPreferido;
	
	public Cliente(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.pratoPreferido = "Prato preferido não definido";
	}

	public String getPratoPreferido() {
		return pratoPreferido;
	}

	public void setPratoPreferido(String pratoPreferido) {
		this.pratoPreferido = pratoPreferido;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
}