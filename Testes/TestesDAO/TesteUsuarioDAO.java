package TestesDAO;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import implementacaoDAO.ImplUsuarioDAO;
import Dominio.Usuario;

public class TesteUsuarioDAO {

	Usuario usu = new Usuario("Nathan", "emailDoNathan@gmail.com", "senha segura");
	ImplUsuarioDAO usuDAO = new ImplUsuarioDAO();
	
	
	@Test
	public void TesteCadastroUsuario() {
		assertTrue(usuDAO.CadastrarUsuario(usu));
	}
	
	@Test
	public void TesteLoginUsuarioExistente() {
		assertTrue(usuDAO.verificaUsuario("emailDoNathan@gmail.com", "senha segura"));
	}
	
	@Test
	public void TesteLoginUsuarioNaoExistente() {
		assertFalse(usuDAO.verificaUsuario("emailDoThiago@gmail.com", "senha segura"));
	}
	
	@Test
	public void TesteDesabilitarUsuario() {
		assertTrue(usuDAO.HabilitarUsuario("emailDoNathan@gmail.com", false));
	}
	
	@Test
	public void testeHabilitarUsuario() {
		assertTrue(usuDAO.HabilitarUsuario("emailDoNathan@gmail.com", true));
	}

	@Test
	public void TesteBloquearUsuario() {
		assertTrue(usuDAO.BloquearUsuario("emailDoNathan@gmail.com", false));
	}
	
	@Test
	public void TesteBuscarUsuarioPorEmail() throws IOException {
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail("emailDoNathan@gmail.com");
		System.out.println(usuBuscado.isAcessoZelador());
		System.out.println(usu.isAcessoZelador());
		assertEquals(usuBuscado.getEmail(), usu.getEmail());
		assertEquals(usuBuscado.getNome(), usu.getNome());
		assertEquals(usuBuscado.getSenha(), usu.getSenha());
		assertEquals(usuBuscado.isAcessoGestorQuadras(), usu.isAcessoGestorQuadras());
		assertEquals(usuBuscado.isAcessoGestorUsuarios(), usu.isAcessoGestorUsuarios());
		assertEquals(usuBuscado.isAcessoRelatorios(), usu.isAcessoRelatorios());
		assertEquals(usuBuscado.isAcessoZelador(), usu.isAcessoZelador());
		assertEquals(usuBuscado.isEstaBloqueado(), usu.isEstaBloqueado());
		assertEquals(usuBuscado.isEstaDesabilitado(), usu.isEstaDesabilitado());
	}
	
	@Test
	public void testeDesbloquearUsuario() {
		assertTrue(usuDAO.BloquearUsuario("emailDoNathan@gmail.com", true));
	}
	
	@Test
	public void TesteDeletarUsuario() {
		assertTrue(usuDAO.DeletarUsuario("emailDoNathan@gmail.com"));
	}

}
