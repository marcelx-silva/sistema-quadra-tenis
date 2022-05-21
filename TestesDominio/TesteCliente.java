import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class TesteCliente {

	Cliente cli = new Cliente("Leandro","emailDoLeandro@gmail.com", "123.456.789-10", "10/10/2010", false, false, true);

	@Test
	public void testeDeCadastroCliente() {	
		assertEquals("Leandro", cli.getNome());
		assertEquals("emailDoLeandro@gmail.com", cli.getEmail());
		assertEquals("123.456.789-10", cli.getCpf());
		assertEquals("10/10/2010", cli.getDataNascimento());
		assertFalse(cli.isBloqueado());
		assertFalse(cli.isInvalidado());
		assertTrue(cli.isHabilitado());
	}
	
	@Test
	public void testeDeBloqueioDeCliente() {
		cli.bloqueiaCliente();
		assertTrue(cli.isBloqueado());
	}
	
	@Test
	public void testeDeDesbloqueioDeCliente() {
		cli.desbloqueiaCliente();
		assertFalse(cli.isBloqueado());
	}

}
