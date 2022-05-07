import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestesDeUnidade {
	interfaceQuadra interfaceQua = new interfaceQuadra();
	Quadras qua = new Quadras(0,"","","",false,false,false);
	
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	
	@Test
	void testeDeCadastro() {
		
		
		interfaceQua.interfaceCadastrarQuadra();
		assertEquals("Quadra Municipal de Mogi das Cruzes", qua.getNomeQuadra());
		assertEquals(15, qua.getCodigoQuadra());
		assertEquals("Rua da Quadra", qua.getEnderecoQuadra());
		assertEquals("SAIBRO", qua.getTipoQuadra());
		assertEquals(true, qua.isPossuiCobertura());
		assertEquals(true, qua.isPossuiArquibancada());
		assertEquals(true, qua.isPossuiAreaDescanso());
		assertEquals(70,qua.getPreco_reserva());
	}
	
	@Test 
	void testeDeBloqueioDeQuadra() {
		qua.bloqueiaQuadraParaAluguel();
		assertEquals(true, qua.isEstaBloqueada());
		
		qua.desbloqueiaQuadraParaAluguel();
		assertEquals(false, qua.isEstaBloqueada());
		
	}
	
	@Test
	void testeDeDisponibilidade() {
		
		//qua.verificarDisponibilidadeQuadra("semPeriodo");	
	}
	
}
