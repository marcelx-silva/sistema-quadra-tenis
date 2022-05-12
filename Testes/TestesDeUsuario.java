import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestesDeUsuario {
	
	Usuario usu = new Usuario("Nathan", "132.456.879-10", "emailDoNathan@gmail.com", "senha segura", false, true, false, false);

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

}
