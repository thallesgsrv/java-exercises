package testes.repareBem;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import repareBem.Reparo;

public class ReparoTest {
    
    private Reparo reparo;
    
    @Before
    public void setUp() {
        reparo = new Reparo("Cueca furada de joão", "tapar os fundo", 50.0);
    }
    
    @Test
    public void testReajustarPrecoComAumento() {
        reparo.ajustarPreco(0.20);
        assertEquals(60.0, reparo.getPreco(), 0.01);
    }
    
    @Test
    public void testReajustarPrecoComDesconto() {
        reparo.ajustarPreco(-0.10);
        assertEquals(45.0, reparo.getPreco(), 0.01);
    }
    
    @Test
    public void testReajustarPrecoSemAlteracao() {
        reparo.ajustarPreco(0.0);
        assertEquals(50.0, reparo.getPreco(), 0.01);
    }
}