package testes.prw;

import prw.SistemaPrw;

import static org.junit.Assert.assertEquals;
import org.junit.*;


public class SistemaPrwTest {
	
	@Test
	public void testVotoValido() {
        SistemaPrw sistema = new SistemaPrw();
        sistema.adicionarCliente("João", "joao@email.com");
        sistema.adicionarRestaurante("Tio João", "Sinfonia Marítima");
        sistema.visitarRestaurante("joao@email.com", "Tio João");
        
        String resultado = sistema.votarPratoPreferido("joao@email.com", "Tio João");
        assertEquals("Voto registrado com sucesso!", resultado);
    }
	
		
}
