package prw;

import java.util.*;

public class Restaurante {
	
	private String nome;
	private String prato;
	private List<Cliente> visitados;
	private int votos;
	
	public Restaurante(String nome, String prato) {
		this.nome = nome;
		this.prato = prato;
		this.visitados = new ArrayList<>();
		this.votos = 0;
	}

	public String getNome() {
		return nome;
	}

	public String getPrato() {
		return prato;
	}

	public List<Cliente> getVisitados() {
		return visitados;
	}

	public int getVotos() {
		return votos;
	}
	
	public void adicionarClienteEmVisitados(Cliente cliente) {
		String emailCliente = cliente.getEmail();
		if (verificaVisitados(emailCliente) == null) {
			visitados.add(cliente);
		}
	}
	
	public String[] listaVisitados() {
		String[] resultado = new String[visitados.size()];
		for(int i = 0; i < visitados.size(); i++) {
			Cliente c = visitados.get(i);
			resultado[i] = "Cliente: " + c.getNome() + ", Prato preferido: " + c.getPratoPreferido();
		}
		return resultado;
	}
	
	public void adicionarVoto() {
		votos++;
	}
	
	public boolean clienteVisitou(String email) {
		return verificaVisitados(email) != null;
	}
	
	private Cliente verificaVisitados(String email) {
		for (Cliente c : visitados) {
			if(c.getEmail().equals(email)) {
				return c;
			}
		}
		return null;
	}
}