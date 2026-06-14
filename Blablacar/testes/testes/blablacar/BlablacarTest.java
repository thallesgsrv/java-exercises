package testes.blablacar;

import org.junit.Test;
import blablacar.Blablacar;
import static org.junit.Assert.*;

public class BlablacarTest {
    
    @Test
    public void testaCompatibilidade() {
        System.out.println("=== INICIANDO TESTE ===");
        
        // Criar sistema
        Blablacar blablacar = new Blablacar();
        
        // Cadastrar passageiro
        String[] pontos = {"PP", "Cineminha com a gata", "Banda"};
        boolean cadastrou = blablacar.cadastrarPassageiro("Augusto", "123456789-00", pontos, "augustochupaengole@gmail.com");
        System.out.println("Passageiro cadastrado: " + cadastrou);
        
        // Cadastrar viagem
        String[] pontosV = {"Massachusetz", "Londres", "PP"};
        int index = blablacar.cadastraViagem("Arlindo", "Gosto de rebolar pros crias.", pontosV, "arlindogostosao@gmail.com", 3);
        System.out.println("Viagem cadastrada no índice: " + index);
        
        // Solicitar vaga
        blablacar.solicitarVaga("123456789-00", index);
        System.out.println("Vaga solicitada");
        
        // Calcular compatibilidade
        System.out.println("Chamando calcularCompatibilidade...");
        double resultado = blablacar.calcularCompatibilidade("123456789-00", index);
        System.out.println("Resultado obtido: " + resultado);
        
        // Verificar
        assertEquals("Deveria ser 30% de compatibilidade", 30.0, resultado, 0.01);
        
        System.out.println("=== TESTE PASSOU ===");
    }
}