package prw;

import java.util.*;

public class SistemaPrw {
    
    private Restaurante[] restaurantes;
    private Cliente[] clientes;
    private int numRestaurantes;
    private int numClientes;
    
    public SistemaPrw() {
        this.restaurantes = new Restaurante[50];
        this.clientes = new Cliente[100];
        this.numRestaurantes = 0;
        this.numClientes = 0;
    }
    
    public void adicionarRestaurante(String nome, String prato) {
        if (verificaNomeRestaurante(nome) != null) {
            throw new IllegalArgumentException("Esse restaurante já está cadastrado!");
        }
        if (numRestaurantes >= restaurantes.length) {
            throw new IllegalStateException("Limite de restaurantes atingido!");
        }
        Restaurante restaurante = new Restaurante(nome, prato);
        restaurantes[numRestaurantes] = restaurante;
        numRestaurantes++;
    }
    
    public void adicionarCliente(String nome, String email) {
        if (verificaEmailCliente(email) != null) {
            throw new IllegalArgumentException("Usuário já cadastrado!");
        }
        if (numClientes >= clientes.length) {
            throw new IllegalStateException("Limite de clientes atingido!");
        }
        Cliente cliente = new Cliente(nome, email);
        clientes[numClientes] = cliente;
        numClientes++;
    }
    
    public void visitarRestaurante(String emailCliente, String nomeRestaurante) {
        Cliente cliente = verificaEmailCliente(emailCliente);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado: " + emailCliente);
        }
        
        Restaurante restaurante = verificaNomeRestaurante(nomeRestaurante);
        if (restaurante == null) {
            throw new IllegalArgumentException("Restaurante não encontrado: " + nomeRestaurante);
        }
        
        restaurante.adicionarClienteEmVisitados(cliente);
    }
    
    public String[] listarClientesRestaurante(String nomeRestaurante) {
        Restaurante restaurante = verificaNomeRestaurante(nomeRestaurante);
        if (restaurante == null) {
            throw new IllegalArgumentException("Restaurante não encontrado: " + nomeRestaurante);
        }
        return restaurante.listaVisitados();
    }
    
    public String votarPratoPreferido(String emailCliente, String nomeRestaurante) {
        Cliente cliente = verificaEmailCliente(emailCliente);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado: " + emailCliente);
        }
        
        Restaurante restaurante = verificaNomeRestaurante(nomeRestaurante);
        if (restaurante == null) {
            throw new IllegalArgumentException("Restaurante não encontrado: " + nomeRestaurante);
        }
        
        if (restaurante.clienteVisitou(emailCliente)) {
            String prato = restaurante.getPrato();
            cliente.setPratoPreferido(prato);
            restaurante.adicionarVoto();
            return "Voto registrado com sucesso!";
        }
        return "Voto não registrado";
    }
    
    public String melhorPrato() {
        if (numRestaurantes == 0) {
            return "Nenhum restaurante cadastrado";
        }
        
        int maior = 0;
        String nomeRestaurante = "";
        String melhorPrato = "";
        
        for (int i = 0; i < numRestaurantes; i++) {
            Restaurante r = restaurantes[i];
            int votos = r.getVotos();
            
            if (votos > maior) {
                maior = votos;
                nomeRestaurante = r.getNome();
                melhorPrato = r.getPrato();
            }
        }
        
        if (maior == 0) {
            return "Nenhum voto registrado ainda";
        }
        
        return "Melhor prato: " + melhorPrato + " Restaurante: " + nomeRestaurante;
    }
    
    private Cliente verificaEmailCliente(String email) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].getEmail().equals(email)) {
                return clientes[i];
            }
        }
        return null;
    }
    
    private Restaurante verificaNomeRestaurante(String nome) {
        for (int i = 0; i < numRestaurantes; i++) {
            if (restaurantes[i].getNome().equals(nome)) {
                return restaurantes[i];
            }
        }
        return null;
    }
}