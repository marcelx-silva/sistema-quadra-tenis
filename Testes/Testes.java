import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testes {
	interfaceQuadra interfaceQua = new interfaceQuadra();
	Quadras qua = new Quadras();
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	
	@Test
	void testeDeCadastro() {
		
		interfaceQua.interfaceCadastrarQuadra(qua);
		assertEquals("Quadra Municipal de Mogi das Cruzes", qua.getNomeQuadra());
		assertEquals("Rua da Quadra", qua.getEnderecoQuadra());
		assertEquals(15, qua.getCodigoQuadra());
		assertEquals("SAIBRO", qua.getTipoQuadra());
		assertEquals(true, qua.isPossuiCobertura());
		assertEquals(true, qua.isPossuiArquibancada());
		assertEquals(true, qua.isPossuiAreaDescanso());
	}

}
