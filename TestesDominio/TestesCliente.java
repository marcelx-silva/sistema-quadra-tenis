import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dominio.Cliente;

class TestesCliente {

	Cliente cli = new Cliente("Leandro","emailDoLeandro@gmail.com", "123.456.789-10", "10/10/2010", false, false, true);

	@Test
	void testeDeCadastroCliente() {	
		assertEquals("Leandro", cli.getNome());
		assertEquals("emailDoLeandro@gmail.com", cli.getEmail());
		assertEquals("123.456.789-10", cli.getCpf());
		assertEquals("10/10/2010", cli.getDataNascimento());
		assertFalse(cli.isBloqueado());
		assertFalse(cli.isInvalidado());
		assertTrue(cli.isHabilitado());
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

}
