import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestesUsuario {

	Usuario usu = new Usuario("Nathan", "132.456.879-10", "emailDoNathan@gmail.com", "senha segura", false, false, false, false);

	@Test
	void testeDeCadastroUsuario() {	
		assertEquals("Nathan", usu.getNome());
		assertEquals("emailDoNathan@gmail.com", usu.getEmail());
		assertEquals("132.456.879-10", usu.getCpf());
		assertEquals("emailDoNathan@gmail.com", usu.getEmail());
		assertEquals("senha segura", usu.getSenha());
		assertFalse(usu.isAcessoGestorQuadras());
		assertFalse(usu.isAcessoGestorUsuarios());
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
	
	@Test
	void testeMudarNomeUsuario() {
		usu.alteraUsuario("Nathan Soares", 1);
		assertEquals("Nathan Soares", usu.getNome());
	}
	
	@Test
	void testeMudarCPFUsuario() {
		usu.alteraUsuario("111.456.879-10", 2);
		assertEquals("111.456.879-10", usu.getCpf());
	}
	
	@Test
	void testeMudarEmailUsuario() {
		usu.alteraUsuario("emailNovo@gmail.com", 3);
		assertEquals("emailNovo@gmail.com", usu.getEmail());
	}
	
	@Test
	void testeMudarSenhaUsuario() {
		usu.alteraUsuario("senha mais segura ainda", 4);
		assertEquals("senha mais segura ainda", usu.getSenha());
	}
	
	@Test
	void darAcessoGestorQuadras() {
		usu.alteraUsuario("sim", 5);
		assertTrue(usu.isAcessoGestorQuadras());
	}
	
	@Test
	void retirarAcessoGestorQuadras() {
		usu.alteraUsuario("não", 5);
		assertFalse(usu.isAcessoGestorQuadras());
	}
	
	@Test
	void darAcessoGestorUsuario() {
		usu.alteraUsuario("sim", 6);
		assertTrue(usu.isAcessoGestorUsuarios());
	}
	
	@Test
	void retirarAcessoGestorUsuario() {
		usu.alteraUsuario("não", 6);
		assertFalse(usu.isAcessoGestorUsuarios());
	}
	
	@Test
	void darAcessoRelatorio() {
		usu.alteraUsuario("sim", 7);
		assertTrue(usu.isAcessoRelatorios());
	}
	
	@Test
	void retirarAcessoRelatorio() {
		usu.alteraUsuario("não", 7);
		assertFalse(usu.isAcessoRelatorios());
	}
	
	@Test
	void darAcessoZelador() {
		usu.alteraUsuario("sim", 8);
		assertTrue(usu.isAcessoZelador());
	}
	
	@Test
	void retirarAcessoZelador() {
		usu.alteraUsuario("não", 8);
		assertFalse(usu.isAcessoZelador());
	}

}
