import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Usuario;

public class TesteUsuario {

	Usuario usu = new Usuario("Nathan", "132.456.879-10", "emailDoNathan@gmail.com", "senha segura", false, false, false, false);

	@Test
	public void testeDeCadastroUsuario() {	
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
	public void testeDeBloqueioDeUsuario() {
		usu.bloquearUsuario();
		assertTrue(usu.isEstaBloqueado());
	}
	
	@Test
	public void testeDeDesbloqueioDeUsuario() {
		usu.desbloquearUsuario();
		assertFalse(usu.isEstaBloqueado());
	}
	
	@Test
	public void testeVerificaUsuarioExistente() {
		assertTrue(usu.verificarUsuario("132.456.879-10"));
	}
	
	@Test
	public void testeVerificaUsuarioNaoExistente() {
		assertFalse(usu.verificarUsuario("133.456.879-10"));
	}
	
	@Test
	public void testeMudarNomeUsuario() {
		usu.alteraUsuario("Nathan Soares", 1);
		assertEquals("Nathan Soares", usu.getNome());
	}
	
	@Test
	public void testeMudarCPFUsuario() {
		usu.alteraUsuario("111.456.879-10", 2);
		assertEquals("111.456.879-10", usu.getCpf());
	}
	
	@Test
	public void testeMudarEmailUsuario() {
		usu.alteraUsuario("emailNovo@gmail.com", 3);
		assertEquals("emailNovo@gmail.com", usu.getEmail());
	}
	
	@Test
	public void testeMudarSenhaUsuario() {
		usu.alteraUsuario("senha mais segura ainda", 4);
		assertEquals("senha mais segura ainda", usu.getSenha());
	}
	
	@Test
	public void darAcessoGestorQuadras() {
		usu.alteraUsuario("sim", 5);
		assertTrue(usu.isAcessoGestorQuadras());
	}
	
	@Test
	public void retirarAcessoGestorQuadras() {
		usu.alteraUsuario("n�o", 5);
		assertFalse(usu.isAcessoGestorQuadras());
	}
	
	@Test
	public void darAcessoGestorUsuario() {
		usu.alteraUsuario("sim", 6);
		assertTrue(usu.isAcessoGestorUsuarios());
	}
	
	@Test
	public void retirarAcessoGestorUsuario() {
		usu.alteraUsuario("n�o", 6);
		assertFalse(usu.isAcessoGestorUsuarios());
	}
	
	@Test
	public void darAcessoRelatorio() {
		usu.alteraUsuario("sim", 7);
		assertTrue(usu.isAcessoRelatorios());
	}
	
	@Test
	public void retirarAcessoRelatorio() {
		usu.alteraUsuario("n�o", 7);
		assertFalse(usu.isAcessoRelatorios());
	}
	
	@Test
	public void darAcessoZelador() {
		usu.alteraUsuario("sim", 8);
		assertTrue(usu.isAcessoZelador());
	}
	
	@Test
	public void retirarAcessoZelador() {
		usu.alteraUsuario("n�o", 8);
		assertFalse(usu.isAcessoZelador());
	}
	
	@Test
	public void AutenticarTestIsTrue() {
		
		Usuario user = new Usuario("admin", "0001", "", "admin", true, true, true, true);
		user.adicionarUsuario(user);
		assertTrue( user.UsuarioAutenticado("0001", "admin"));
	}

	@Test
	public void AutenticarTestIsFalse() {
		
		Usuario user = new Usuario("admin", "0001", "", "admin", true, true, true, true);
		user.adicionarUsuario(user);
		assertFalse( user.UsuarioAutenticado("0001", "senhafalsa"));
	}

}
