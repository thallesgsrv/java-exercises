package repareBem;

public class Reparo {
	
	private String idTextual;
	private String descricao;
	private double preco;
	
	public Reparo(String idTextual, String descricao, double preco) {
		this.idTextual = idTextual;
		this.descricao = descricao;
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	public void ajustarPreco(double percentual) {
		this.preco += this.preco * percentual;
	}

	public String getIdTextual() {
		return idTextual;
	}

	public String getDescricao() {
		return descricao;
	} 
	
	

	
}
