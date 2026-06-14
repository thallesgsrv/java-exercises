package blablacar;

import java.util.*;

public class Viagem {
    private String nomeMotorista;
    private String descricao;
    private String[] rotas;
    private String contato;
    private int quantidadeMax;
    private List<Passageiro> inscritos;
    private boolean[] confirmados;
    
    public Viagem(String nomeMotorista, String descricao, String[] rotas, String contato, int quantidadeMax) {
        this.nomeMotorista = nomeMotorista;
        this.descricao = descricao;
        this.rotas = new String[3];
        for (int i = 0; i < rotas.length && i < 3; i++) {
            this.rotas[i] = rotas[i];
        }
        this.contato = contato;
        this.quantidadeMax = quantidadeMax;
        this.inscritos = new ArrayList<>();
        this.confirmados = new boolean[quantidadeMax]; 
    }

    public String getNomeMotorista() {
    	return nomeMotorista; 
    	}
    public String getDescricao() {
    	return descricao; 
    	}
    public String[] getRotas() { 
    	return rotas; 
    	}
    public String getContato() {
    	return contato; 
    	}
    public int getQuantidadeMax() { 
    	return quantidadeMax;
    	}
    
    public String[] getInscritos() {
        String[] resultado = new String[inscritos.size()];
        for (int i = 0; i < inscritos.size(); i++) {
            resultado[i] = inscritos.get(i).toString();
        }
        return resultado;
    }
    
    public String[] getConfirmados() {
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < inscritos.size(); i++) {
            if (confirmados[i]) {
                Passageiro p = inscritos.get(i);
                lista.add(p.toString());
            }
        }
        return lista.toArray(new String[0]);
    }
    
    public int getQuantidadeInscritos() {
        return inscritos.size();
    }
    
    public boolean inscreverPassageiro(Passageiro passageiro) {
        if (!isInscrito(passageiro.getCpf())) {
            inscritos.add(passageiro);
            return true;
        }
        return false;
    }
    
    public boolean isInscrito(String cpf) {
        for (Passageiro p : inscritos) {
            if (p.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isConfirmado(int posicao) {
        if (posicao >= 0 && posicao < inscritos.size()) {
            return confirmados[posicao];
        }
        return false;
    }
    
    public void setConfirmado(int posicao, boolean confirmado) {
        if (posicao >= 0 && posicao < inscritos.size()) {
            confirmados[posicao] = confirmado;
        }
    }
    
    public void resetarConfirmacoes() {
        for (int i = 0; i < inscritos.size(); i++) {
            confirmados[i] = false;
        }
    }
    
    public Passageiro getInscrito(int posicao) {
        if (posicao >= 0 && posicao < inscritos.size()) {
            return inscritos.get(posicao);
        }
        return null;
    }
}