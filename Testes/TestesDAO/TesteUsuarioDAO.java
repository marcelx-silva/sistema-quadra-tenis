package TestesDAO;

import static org.junit.Assert.*;

import org.junit.Test;

import implementacaoDAO.ImplUsuarioDAO;
import Dominio.Usuario;

public class TesteUsuarioDAO {

	Usuario usu = new Usuario("Nathan", "emailDoNathan@gmail.com", "senha segura", false, false, false, false);
	ImplUsuarioDAO usuDAO = new ImplUsuarioDAO();
	
	@Test
	public void TesteCadastroUsuario() {
		assertTrue(usuDAO.CadastrarUsuario(usu));
	}

}
