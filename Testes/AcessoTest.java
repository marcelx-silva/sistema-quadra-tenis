
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class AcessoTest {

	@Test
	void AutenticarTestIsTrue() {
		Acesso acess = new Acesso();
		
		Usuario user = new Usuario("admin", 0001, "", "admin", true, true, true, true);
		user.adicionarUsuario(user);
		acess.setCpfDigitado(0001);
		acess.setSenhaDigitada("admin");
		
		Assert.assertTrue( acess.UsuarioAutenticado());
	}

	@Test
	void AutenticarTestIsFalse() {
		Acesso acess = new Acesso();
		
		Usuario user = new Usuario("admin", 0001, "", "admin", true, true, true, true);
		user.adicionarUsuario(user);
		acess.setCpfDigitado(0001);
		acess.setSenhaDigitada("senhafalsa");
		
		Assert.assertFalse( acess.UsuarioAutenticado());
	}
}
