import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dominio.Cliente;

class TestesCliente {
	
	Cliente cli = new Cliente("Leandro","emailDoLeandro@gmail.com", "123.456.789-10", "10/10/2010", false);

	@Test
	void testeDeCadastroCliente() {	
		assertEquals("Leandro", cli.getNomeCliente());
		assertEquals("emailDoLeandro@gmail.com", cli.getEmailCliente());
		assertEquals("123.456.789-10", cli.getCpfCliente());
		assertEquals("10/10/2010", cli.getDataNascimento());
		assertEquals(false, cli.isBloqueado());
		
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
