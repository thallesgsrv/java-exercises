package blablacar;

import java.util.*;

public class Blablacar {
    private List<Passageiro> passageiros;
    private List<Viagem> viagens;
    
    public Blablacar() {
        this.passageiros = new ArrayList<>();
        this.viagens = new ArrayList<>();
    }
    
    public boolean cadastrarPassageiro(String nome, String cpf, String[] pontos, String link) {
        if (verificaCpf(cpf) != null) {
            return false;
        }
        Passageiro passageiro = new Passageiro(nome, cpf, pontos, link);
        passageiros.add(passageiro);
        return true;
    }
    
    public boolean cadastrarPassageiro(String nome, String cpf, String[] pontos) {
        if (verificaCpf(cpf) != null) {
            return false;
        }
        Passageiro passageiro = new Passageiro(nome, cpf, pontos);
        passageiros.add(passageiro);
        return true;
    }
    
    public int cadastraViagem(String nomeMotorista, String descricao, String[] rotas, String contato, int quantidadeMax) {
        Viagem viagem = new Viagem(nomeMotorista, descricao, rotas, contato, quantidadeMax);
        viagens.add(viagem);
        return viagens.size() - 1;
    }
    
    public void atualizaLink(String cpf, String novoLink) {
        Passageiro p = verificaCpf(cpf);
        if (p == null) {
            throw new IllegalArgumentException("CPF inexistente.");
        }
        p.setLink(novoLink);
    }
    
    public String[] listaPassageiros() {
        String[] resultado = new String[passageiros.size()];
        for (int i = 0; i < passageiros.size(); i++) {
            resultado[i] = passageiros.get(i).toString();
        }
        return resultado;
    }
    
    public String[] listaPassageirosInscritos(int index) {
    	  verificaIndex(index);
          List<String> resultado = new ArrayList<>();
          Viagem viagem = viagens.get(index);
          for (int i = 0; i < viagem.getQuantidadeInscritos(); i++) {
              Passageiro p = viagem.getInscrito(i);
              int comp = calculaCompatibilidade(p, viagem);
                  String link = p.getLink().isEmpty() ? "" : p.getLink();
                  resultado.add(String.format("%s,%s,%d%%", p.getNome(), link, comp));
              }
          return resultado.toArray(new String[0]);
      }
    
    public String[] listaInscritosCompativeis(int index, int compatibilidade) {
        verificaIndex(index);
        List<String> resultado = new ArrayList<>();
        Viagem viagem = viagens.get(index);
        for (int i = 0; i < viagem.getQuantidadeInscritos(); i++) {
            Passageiro p = viagem.getInscrito(i);
            int comp = calculaCompatibilidade(p, viagem);
            if (comp >= compatibilidade) {
                String link = p.getLink().isEmpty() ? "" : p.getLink();
                resultado.add(String.format("%s,%s,%d%%", p.getNome(), link, comp));
            }
        }
        return resultado.toArray(new String[0]);
    }
    
    public String[] listaPassageirosConfirmados(int index) {
        verificaIndex(index);
        Viagem viagem = viagens.get(index);
        List<String> resultado = new ArrayList<>();
        
        for (int i = 0; i < viagem.getQuantidadeInscritos(); i++) {
            if (viagem.isConfirmado(i)) {
                Passageiro p = viagem.getInscrito(i);
                int comp = calculaCompatibilidade(p, viagem);
                String link = p.getLink().isEmpty() ? "" : p.getLink();
                resultado.add(String.format("%s,%s,%d%%", p.getNome(), link, comp));
            }
        }
        return resultado.toArray(new String[0]);
    }
    
    public void solicitarVaga(String cpf, int index) {
        verificaIndex(index);
        Passageiro p = verificaCpf(cpf);
        if (p == null) {
        	throw new IllegalArgumentException("CPF inexistente");	
        }
        Viagem viagem = viagens.get(index);
        viagem.inscreverPassageiro(p);
    }
    
    public double calcularCompatibilidade(String cpf, int index) {
        Passageiro passageiro = verificaCpf(cpf);
        if (passageiro == null) {
            throw new IllegalArgumentException("CPF inexistente");
        }
        verificaIndex(index);
        return calculaCompatibilidade(passageiro, viagens.get(index));
    }
    
    private int calculaCompatibilidade(Passageiro passageiro, Viagem viagem) {
        int pontosComuns = 0;
        String[] pontosP = passageiro.getPontos();
        String[] pontosV = viagem.getRotas();
        
        for (int i = 0; i < 3 && pontosP[i] != null; i++) {
            for (int j = 0; j < 3 && pontosV[j] != null; j++) {
                if (pontosP[i].equals(pontosV[j])) {
                    pontosComuns++;
                    break;
                }
            }
        }
        
        if (pontosComuns == 1) return 30;
        if (pontosComuns == 2) return 70;
        if (pontosComuns == 3) return 100;
        return 0;
    }
    
    public String[] confirmarPassageiros(int index, int compatibilidade) {
        verificaIndex(index);
        Viagem viagem = viagens.get(index);
        
        viagem.resetarConfirmacoes();
        List<String> confirmados = new ArrayList<>();
        int vagasRestantes = viagem.getQuantidadeMax();
        
        for (int i = 0; i < viagem.getQuantidadeInscritos() && vagasRestantes > 0; i++) {
            Passageiro p = viagem.getInscrito(i);
            int comp = calculaCompatibilidade(p, viagem);
            if (comp >= compatibilidade) {
                viagem.setConfirmado(i, true);
                vagasRestantes--;
                String link = p.getLink().isEmpty() ? "" : p.getLink();
                confirmados.add(String.format("%s,%s,%d%%", p.getNome(), link, comp));
            }
        }
        
        return confirmados.toArray(new String[0]);
    }
    
    private Passageiro verificaCpf(String cpf) {
        for (Passageiro p : passageiros) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }
    
    private void verificaIndex(int index) {
        if (index < 0 || index >= viagens.size()) { 
            throw new IllegalArgumentException("Posição inválida");
        }
    }
}