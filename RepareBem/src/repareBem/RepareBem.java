package repareBem;

public class RepareBem {
    
    private Reparo[] reparos;
    private OrdemServico[] ordensServicos;
    private int idxReparo;
    private int idOs;
    
    public RepareBem() {
        this.reparos = new Reparo[100];
        this.ordensServicos = new OrdemServico[500];
        idxReparo = 0;
        idOs = 0;
    }
    
    public void cadastrarReparo(String id, String descricao, double preco) {
    	verificaCadastroReparo(id);
    	Reparo reparo = new Reparo(id, descricao, preco);
    	reparos[idxReparo] = reparo;
    	idxReparo++;
    }
    
    public void reajustarPrecoReparo(String idReparo, double percentual) {
        Reparo reparo = verificaReparo(idReparo);
        reparo.ajustarPreco(percentual);
    }
    
    public int cadastrarOrdemDeServico(String cliente, String telefone, String roupa) {
    	idOs++;
        OrdemServico os = new OrdemServico(idOs, cliente, telefone, roupa);
        ordensServicos[idOs - 1] = os;
        return idOs;
    }
    
    public String exibirOrdemDeServico(int idOs) {
        OrdemServico ordem = verificaOs(idOs);
        return ordem.toString();
    }
    
    public void incluirReparoOrdemDeServico(int idOS, String idReparo) {
        Reparo reparo = verificaReparo(idReparo);
        OrdemServico ordem = verificaOs(idOS);
        ordem.adicionarReparo(reparo);
    }
    
    public void mudarStatusOrdemDeServico(int idOS, String status) {
        OrdemServico ordem = verificaOs(idOS);
        ordem.setStatus(status);
    }
    
    public double obterValorOrdemServico(int idOS) {
        OrdemServico os = verificaOs(idOS);
        double valor = os.somarTotal();
        return valor;
    }
    
    public String listarOrdemDeServicoFiltrada(String status) {
        String resultado = "";
        for (OrdemServico os : ordensServicos) {
            if (os != null && os.getStatus().equals(status)) {
                resultado += os.toString() + "\n";
            }
        }
        if (resultado.equals("")) {
        	return "Não há ordens de serviço do tipo " + status;
        }
        return resultado;
    }
    
    public String listarOrdensDeServico() {
    	String resultado = "";
        for (OrdemServico os : ordensServicos) {
            if (os != null) {
                resultado += os.toString() + "\n";
            }
        }
        return resultado;
    }
    
    private Reparo verificaReparo(String idReparo) {
        for (Reparo r : reparos) {
            if (r != null && r.getIdTextual().equals(idReparo)) {
                return r;
            }
        }
        throw new IllegalArgumentException("Reparo não existente!");
    }
    
    private OrdemServico verificaOs(int idOs) {
        for (OrdemServico os : ordensServicos) {
            if (os != null && os.getId() == idOs) {
                return os;
            }
        }
        throw new IllegalArgumentException("Ordem de serviço não existente!");
    }
    
    private boolean verificaCadastroReparo(String idReparo) {
        for (Reparo r : reparos) {
            if (r != null && r.getIdTextual().equals(idReparo)) {
                throw new IllegalArgumentException("Reparo com identificador" + idReparo + " já existe!");
            }
        }
        return false;
    }
}