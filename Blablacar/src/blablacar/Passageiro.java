package blablacar;

import java.util.*;

public class Passageiro {
    private String nome;
    private String cpf;
    private String[] pontos;
    private String link;
    
    public Passageiro(String nome, String cpf, String[] pontos, String link) {
        this.nome = nome;
        this.cpf = cpf;
        this.pontos = new String[3];
        for (int i = 0; i < pontos.length; i++) {
            this.pontos[i] = pontos[i];
        }
        this.link = link != null ? link : "";
    }
    
    public Passageiro(String nome, String cpf, String[] pontos) {
        this(nome, cpf, pontos, null);	
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link != null ? link : "";
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String[] getPontos() {
        return pontos;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",
            nome, cpf,
            link.isEmpty() ? "" : link,
            pontos[0], pontos[1], pontos[2]);
    }
}