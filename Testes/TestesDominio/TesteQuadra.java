package TestesDominio;
import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Test;

import Dominio.Quadra;
import Enum.TipoQuadra;

public class TesteQuadra {

Quadra qua = new Quadra("15","Quadra Municipal de Mogi das Cruzes","Rua da Quadra",TipoQuadra.SAIBRO,true,true,true);
	
	@Test
	public void testeDeCadastroQuadra() throws IOException {	
		assertEquals("Quadra Municipal de Mogi das Cruzes", qua.getNome());
		assertEquals("15", qua.getCodigo());
		assertEquals("Rua da Quadra", qua.getEndereco());
		assertEquals(TipoQuadra.SAIBRO, qua.getTipo());
		assertEquals(true, qua.isPossuiCobertura());
		assertEquals(true, qua.isPossuiArquibancada());
		assertEquals(true, qua.isPossuiAreaDescanso());
	}
	
	@Test 
	public void testeDeBloqueioDeQuadra() {
		qua.bloqueiaQuadraParaAluguel();
		assertTrue(qua.isEstaBloqueada());		
	}	
	
	@Test
	public void testeDeDesbloqueioDeQuadra() {
		qua.desbloqueiaQuadraParaAluguel();
		assertFalse(qua.isEstaBloqueada());
	}
	
	@Test 
	public void testeDePrecoReservaComCobertura() {
		assertEquals(new BigDecimal("70"), qua.getPrecoReservaTempoMinimo());
	}
	
	@Test 
	public void testeDePrecoReservaSemCobertura() {
		qua.setPossuiCobertura(false);
		assertEquals(new BigDecimal("40"), qua.getPrecoReservaTempoMinimo());
	}

}
