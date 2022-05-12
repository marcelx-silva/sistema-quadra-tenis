import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestesDeQuadra {
	
	Quadra qua = new Quadra(15,"Quadra Municipal de Mogi das Cruzes","Rua da Quadra",TipoQuadra.SAIBRO,true,true,true);
	
	@Test
	void testeDeCadastroQuadra() {	
		assertEquals("Quadra Municipal de Mogi das Cruzes", qua.getNomeQuadra());
		assertEquals(15, qua.getCodigoQuadra());
		assertEquals("Rua da Quadra", qua.getEnderecoQuadra());
		assertEquals(TipoQuadra.SAIBRO, qua.getTipoQuadra());
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
