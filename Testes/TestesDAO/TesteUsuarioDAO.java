package TestesDAO;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import implementacaoDAO.ImplUsuarioDAO;
import Dominio.Usuario;
import Exceptions.UserAlreadyRegisteredException;

public class TesteUsuarioDAO {

	Usuario usu = new Usuario("Nathan", "emailDoNathan@gmail.com", "senha segura");
	ImplUsuarioDAO usuDAO = new ImplUsuarioDAO();
	
	@Before
	public void redefineUsuario() throws UserAlreadyRegisteredException{
		usuDAO.DeletarUsuario("emailDoNathan@gmail.com");
		usuDAO.CadastrarUsuario(usu);
	}
	
	@Test
	public void TesteCadastroUsuario() throws UserAlreadyRegisteredException {
		usuDAO.DeletarUsuario("emailDoNathan@gmail.com");
		assertTrue(usuDAO.CadastrarUsuario(usu));
	}
	
	@Test(expected=UserAlreadyRegisteredException.class)
	public void TesteCadastroUsuarioDuplicado() throws UserAlreadyRegisteredException{
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
	public void TesteBuscarUsuarioPorEmail() throws IOException {
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail("emailDoNathan@gmail.com");
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
	public void testeDesbloquearUsuario() {
		assertTrue(usuDAO.BloquearUsuario("emailDoNathan@gmail.com", true));
	}
	
	@Test
	public void TesteDeletarUsuario() {
		assertTrue(usuDAO.DeletarUsuario("emailDoNathan@gmail.com"));
	}

	@Test
	public void TesteAlteraNome() throws IOException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "Nathan Alterado", 1));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail("emailDoNathan@gmail.com");
		assertNotEquals(usu.getNome(), usuBuscado.getNome());
	}

	@Test
	public void TesteAlteraSenha() throws IOException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "nova senha", 3));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail("emailDoNathan@gmail.com");
		assertNotEquals(usu.getSenha(), usuBuscado.getSenha());
	}
	
	@Test
	public void TesteDarPermissãoGestorQuadra() throws IOException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "Sim", 4));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail("emailDoNathan@gmail.com");
		assertTrue(usuBuscado.isAcessoGestorQuadras());
	}
	
	@Test
	public void TesteTirarPermissãoGestorQuadra() throws IOException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "Não", 4));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail("emailDoNathan@gmail.com");
		assertFalse(usuBuscado.isAcessoGestorQuadras());
	}
	
	@Test
	public void TesteDarPermissãoGestorUsuario() throws IOException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "Sim", 5));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail("emailDoNathan@gmail.com");
		assertTrue(usuBuscado.isAcessoGestorUsuarios());
	}
	
	@Test
	public void TesteTirarPermissãoGestorUsuario() throws IOException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "Não", 5));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail("emailDoNathan@gmail.com");
		assertFalse(usuBuscado.isAcessoGestorUsuarios());
	}
	
	@Test
	public void TesteDarPermissãoRelatorio() throws IOException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "Sim", 6));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail("emailDoNathan@gmail.com");
		assertTrue(usuBuscado.isAcessoRelatorios());
	}
	
	@Test
	public void TesteTirarPermissãoRelatorio() throws IOException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "Não", 6));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail("emailDoNathan@gmail.com");
		assertFalse(usuBuscado.isAcessoRelatorios());
	}
	
	@Test
	public void TesteDarPermissãoZelador() throws IOException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "Sim", 7));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail("emailDoNathan@gmail.com");
		assertTrue(usuBuscado.isAcessoZelador());
	}
	
	@Test
	public void TesteTirarPermissãoZelador() throws IOException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "Não", 7));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail("emailDoNathan@gmail.com");
		assertFalse(usuBuscado.isAcessoZelador());
	}

}
