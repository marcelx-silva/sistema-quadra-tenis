import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import Dominio.Quadra;
import Enum.TipoQuadra;

class TestesQuadra {
	
	Quadra qua = new Quadra("15","Quadra Municipal de Mogi das Cruzes","Rua da Quadra",TipoQuadra.SAIBRO,true,true,true);
	
	@Test
	void testeDeCadastroQuadra() throws IOException {	
		assertEquals("Quadra Municipal de Mogi das Cruzes", qua.getNome());
		assertEquals("15", qua.getCodigo());
		assertEquals("Rua da Quadra", qua.getEndereco());
		assertEquals(TipoQuadra.SAIBRO, qua.getTipo());
		assertEquals(true, qua.isPossuiCobertura());
		assertEquals(true, qua.isPossuiArquibancada());
		assertEquals(true, qua.isPossuiAreaDescanso());
	}
	
	@Test 
	void testeDeBloqueioDeQuadra() {
		qua.bloqueiaQuadraParaAluguel();
		assertTrue(qua.isEstaBloqueada());		
	}	
	
	@Test
	void testeDeDesbloqueioDeQuadra() {
		qua.desbloqueiaQuadraParaAluguel();
		assertFalse(qua.isEstaBloqueada());
	}
	
	@Test void testeDePrecoReservaComCobertura() {
		assertEquals(70, qua.getPrecoReserva());
	}
	
	@Test void testeDePrecoReservaSemCobertura() {
		qua.setPossuiCobertura(false);
		assertEquals(40, qua.getPrecoReserva());
	}
}
