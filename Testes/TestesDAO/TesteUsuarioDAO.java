package TestesDAO;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import implementacaoDAO.ImplUsuarioDAO;
import Dominio.Usuario;
import Exceptions.BlockedUserException;
import Exceptions.UserAlreadyRegisteredException;
import Exceptions.UserNotFoundException;
import Exceptions.WrongUserOrPasswordException;

public class TesteUsuarioDAO {

	Usuario usu = new Usuario("Nathan", "emailDoNathan@gmail.com", "senha segura");
	ImplUsuarioDAO usuDAO = new ImplUsuarioDAO();
	
	@Before
	public void redefineUsuario() throws UserAlreadyRegisteredException{
		usuDAO.DeletarUsuario(usu.getEmail());
		usuDAO.CadastrarUsuario(usu);
	}
	
	@Test
	public void TesteCadastroUsuario() throws UserAlreadyRegisteredException {
		usuDAO.DeletarUsuario(usu.getEmail());
		assertTrue(usuDAO.CadastrarUsuario(usu));
	}
	
	@Test(expected=UserAlreadyRegisteredException.class)
	public void TesteCadastroUsuarioDuplicado() throws UserAlreadyRegisteredException{
		assertTrue(usuDAO.CadastrarUsuario(usu));
	}
	
	@Test
	public void TesteLoginUsuarioExistente() throws WrongUserOrPasswordException, BlockedUserException {
		assertTrue(usuDAO.verificaUsuario(usu.getEmail(), usu.getSenha()));
	}
	
	@Test(expected=WrongUserOrPasswordException.class)
	public void TesteLoginUsuarioNaoExistente() throws WrongUserOrPasswordException, BlockedUserException {
		usuDAO.verificaUsuario("emailDoThiago@gmail.com", "senha segura");
	}
	
	@Test(expected=BlockedUserException.class)
	public void TesteLoginUsuarioExistenteBloqueado() throws WrongUserOrPasswordException, BlockedUserException {
		usuDAO.BloquearUsuario(usu.getEmail(), true);
		assertTrue(usuDAO.verificaUsuario(usu.getEmail(), usu.getSenha()));
	}
	
	@Test
	public void TesteBuscarUsuarioPorEmail() throws IOException, UserNotFoundException {
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail(usu.getEmail());
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
		assertTrue(usuDAO.HabilitarUsuario(usu.getEmail(), false));
	}
	
	@Test
	public void testeHabilitarUsuario() {
		assertTrue(usuDAO.HabilitarUsuario(usu.getEmail(), true));
	}

	@Test
	public void TesteBloquearUsuario() {
		assertTrue(usuDAO.BloquearUsuario(usu.getEmail(), false));
	}
	
	@Test
	public void testeDesbloquearUsuario() {
		assertTrue(usuDAO.BloquearUsuario(usu.getEmail(), true));
	}
	
	@Test
	public void TesteDeletarUsuario() {
		assertTrue(usuDAO.DeletarUsuario(usu.getEmail()));
	}

	@Test
	public void TesteAlteraNome() throws IOException, UserNotFoundException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "Nathan Alterado", 1));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail(usu.getEmail());
		assertNotEquals(usu.getNome(), usuBuscado.getNome());
	}

	@Test
	public void TesteAlteraSenha() throws IOException, UserNotFoundException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "nova senha", 3));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail(usu.getEmail());
		assertNotEquals(usu.getSenha(), usuBuscado.getSenha());
	}
	
	@Test
	public void TesteDarPermiss??oGestorQuadra() throws IOException, UserNotFoundException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "Sim", 4));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail(usu.getEmail());
		assertTrue(usuBuscado.isAcessoGestorQuadras());
	}
	
	@Test
	public void TesteTirarPermiss??oGestorQuadra() throws IOException, UserNotFoundException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "N??o", 4));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail(usu.getEmail());
		assertFalse(usuBuscado.isAcessoGestorQuadras());
	}
	
	@Test
	public void TesteDarPermiss??oGestorUsuario() throws IOException, UserNotFoundException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "Sim", 5));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail(usu.getEmail());
		assertTrue(usuBuscado.isAcessoGestorUsuarios());
	}
	
	@Test
	public void TesteTirarPermiss??oGestorUsuario() throws IOException, UserNotFoundException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "N??o", 5));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail(usu.getEmail());
		assertFalse(usuBuscado.isAcessoGestorUsuarios());
	}
	
	@Test
	public void TesteDarPermiss??oRelatorio() throws IOException, UserNotFoundException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "Sim", 6));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail(usu.getEmail());
		assertTrue(usuBuscado.isAcessoRelatorios());
	}
	
	@Test
	public void TesteTirarPermiss??oRelatorio() throws IOException, UserNotFoundException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "N??o", 6));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail(usu.getEmail());
		assertFalse(usuBuscado.isAcessoRelatorios());
	}
	
	@Test
	public void TesteDarPermiss??oZelador() throws IOException, UserNotFoundException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "Sim", 7));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail(usu.getEmail());
		assertTrue(usuBuscado.isAcessoZelador());
	}
	
	@Test
	public void TesteTirarPermiss??oZelador() throws IOException, UserNotFoundException {
		assertTrue(usuDAO.AlterarDadosUsuario(usu, "N??o", 7));
		Usuario usuBuscado = usuDAO.obterUsuarioPeloEmail(usu.getEmail());
		assertFalse(usuBuscado.isAcessoZelador());
	}

}
