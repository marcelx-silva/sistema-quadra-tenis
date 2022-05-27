package TestesDominio;
import static org.junit.Assert.*;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import org.junit.Test;


import Dominio.Cliente;

public class TesteCliente {

	DateTimeFormatter dataFormatoPadrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	Cliente cli = new Cliente("Leandro","emailDoLeandro@gmail.com","123.456.789-10", "91234-5678", LocalDate.of(2010, 10, 10), false, false, true);
	
	@Test
	public void testeDeCadastroCliente() {	
		assertEquals("Leandro", cli.getNome());
		assertEquals("emailDoLeandro@gmail.com", cli.getEmail());
		assertEquals("123.456.789-10", cli.getCpf());
		assertEquals("91234-5678", cli.getNumeroCelular());
		assertEquals("10/10/2010", cli.getDataNascimento().format(dataFormatoPadrao));
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
