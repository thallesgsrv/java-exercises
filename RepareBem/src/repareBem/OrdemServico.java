package repareBem;

public class OrdemServico {
    
    private int id;
    private String cliente;
    private String telefone;
    private String nomePeca;
    private String status;
    private Reparo[] reparosOS;
    private int quantReparos;
    
    public OrdemServico(int idOs, String cliente, String telefone, String nomePeca) {
        this.id = idOs;
        this.cliente = cliente;
        this.telefone = telefone;
        this.nomePeca = nomePeca;
        status = "Não iniciado";
        reparosOS = new Reparo[10];
        quantReparos = 0;
    }
    
    public void adicionarReparo(Reparo reparo) {
        verificaReparo(reparo);
        reparosOS[quantReparos] = reparo;
        quantReparos++;
    }
    
    public double somarTotal() {
        double total = 0;
        for (Reparo r : reparosOS) {
            if (r != null) {
                total += r.getPreco();
            }
        }
        return total;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getCliente() {
        return cliente;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public String getNomePeca() {
        return nomePeca;
    }
    
    public int getId() {
        return id;
    }
    
    private boolean verificaReparo(Reparo reparo) {
        for (Reparo r : reparosOS) {
            if (r != null && r.getIdTextual().equals(reparo.getIdTextual())) {
                throw new IllegalArgumentException("Esse reparo já foi cadastrado!");
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        double total = somarTotal();
        return "#" + id + "; cliente: " + cliente + "; roupa: " + nomePeca + "; reparos: " + 
        quantReparos + "; total: R$" + String.format("%.2f", total);
    }
}