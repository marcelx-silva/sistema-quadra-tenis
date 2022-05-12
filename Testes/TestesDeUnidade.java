import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestesDeUnidade {
	
	Quadras qua = new Quadras(15,"Quadra Municipal de Mogi das Cruzes","Rua da Quadra","SAIBRO",true,true,true);
	Clientes cli = new Clientes("Leandro","emailDoLeandro@gmail.com", "123.456.789-10", "10/10/2010", false);
	Usuario usu = new Usuario("Nathan", "132.456.879-10", "emailDoNathan@gmail.com", "senha segura", false, true, false, false);
	
	@Test
	void testeDeCadastroQuadra() {	
		assertEquals("Quadra Municipal de Mogi das Cruzes", qua.getNomeQuadra());
		assertEquals(15, qua.getCodigoQuadra());
		assertEquals("Rua da Quadra", qua.getEnderecoQuadra());
		assertEquals("SAIBRO", qua.getTipoQuadra());
		assertEquals(true, qua.isPossuiCobertura());
		assertEquals(true, qua.isPossuiArquibancada());
		assertEquals(true, qua.isPossuiAreaDescanso());
	}
	
	@Test
	void testeDeCadastroCliente() {	
		assertEquals("Leandro", cli.getNomeCliente());
		assertEquals("emailDoLeandro@gmail.com", cli.getEmailCliente());
		assertEquals("123.456.789-10", cli.getCpfCliente());
		assertEquals("10/10/2010", cli.getDataNascimento());
		assertEquals(false, cli.isBloqueado());
	}
	
	@Test
	void testeDeCadastroUsuario() {	
		assertEquals("Nathan", usu.getNomeUsuario());
		assertEquals("emailDoNathan@gmail.com", usu.getEmailUsuario());
		assertEquals("132.456.879-10", usu.getCpfUsuario());
		assertEquals("emailDoNathan@gmail.com", usu.getEmailUsuario());
		assertEquals("senha segura", usu.getSenhaUsuario());
		assertFalse(usu.isAcessoGestorQuadras());
		assertTrue(usu.isAcessoGestorUsuarios());
		assertFalse(usu.isAcessoRelatorios());
		assertFalse(usu.isAcessoZelador());
	}
	
	@Test
	void testeDeBloqueioDeCliente() {
		cli.bloqueiaCliente();
		assertTrue(cli.isBloqueado());
	}
	
	@Test
	void testeDeDesbloqueioDeCliente() {
		cli.desbloqueiaCliente();
		assertFalse(cli.isBloqueado());
	}
	
	@Test
	void testeDeBloqueioDeUsuario() {
		usu.bloquearUsuario();
		assertTrue(usu.isEstaBloqueado());
	}
	
	@Test
	void testeDeDesbloqueioDeUsuario() {
		usu.desbloquearUsuario();
		assertFalse(usu.isEstaBloqueado());
	}
	
	@Test
	void testeVerificaUsuarioExistente() {
		assertTrue(usu.verificarUsuario("132.456.879-10"));
	}
	
	@Test
	void testeVerificaUsuarioNaoExistente() {
		assertFalse(usu.verificarUsuario("133.456.879-10"));
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
