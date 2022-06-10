package TestesDAO;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import Dominio.Cliente;
import Dominio.Quadra;
import Dominio.Reserva;
import Enum.TipoPagamento;
import Enum.TipoQuadra;
import implementacaoDAO.ImplReservaDAO;

public class TesteReservaDAO {

	DateTimeFormatter dataFormatoPadrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter horarioFormatoPadrao = DateTimeFormatter.ofPattern("HH:mm");
    DateTimeFormatter dataFormatoBD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter horarioFormatoBD = DateTimeFormatter.ofPattern("HH:mm:ss");
    
	Quadra qua = new Quadra("366", "Quadra 1","Rua 1",TipoQuadra.SAIBRO, true, true, true);	
	Cliente cliente = new Cliente("1", "Nathan", "emailDoNathan@gmail.com", "123.456.789-10", "912345-6789", LocalDate.parse("26/12/2002",dataFormatoPadrao), false, false, true);
	Reserva r = new Reserva("3", qua, cliente, LocalDate.parse("17/06/2022", dataFormatoPadrao), LocalTime.parse("12:00", horarioFormatoPadrao), LocalTime.parse("14:00", horarioFormatoPadrao), TipoPagamento.PIX, "1");
	ImplReservaDAO reservaDAO = new ImplReservaDAO();
	
	@Test
	public void testeCadastraReserva() {	
		assertTrue(reservaDAO.CadastrarReserva(r));
	}
	
	@Test
	public void testeRegistraEntradaCliente() {
		assertTrue(reservaDAO.registrarEntradaCliente(r));
	}

	@Test
	public void testeRegistraSaidaCliente() {
		assertTrue(reservaDAO.registrarSaidaCliente(r));
	}
}
