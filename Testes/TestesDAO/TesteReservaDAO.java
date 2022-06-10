package TestesDAO;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dominio.Cliente;
import Dominio.Quadra;
import Dominio.Reserva;
import Enum.TipoPagamento;
import Enum.TipoQuadra;
import Exceptions.ClientNotFoundException;
import Exceptions.CourtAlreadyRegisteredException;
import implementacaoDAO.ImpClienteDAO;
import implementacaoDAO.ImplQuadraDAO;
import implementacaoDAO.ImplReservaDAO;

public class TesteReservaDAO {

	DateTimeFormatter dataFormatoPadrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter horarioFormatoPadrao = DateTimeFormatter.ofPattern("HH:mm");
    DateTimeFormatter dataFormatoBD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter horarioFormatoBD = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    //Objetos Cadastrados no BD
    Quadra qua = new Quadra("1", "Quadra Teste Reserva","Rua 1",TipoQuadra.SAIBRO, true, true, true);	
	Cliente cliente = new Cliente("1", "Nathan", "emailDoNathan@gmail.com", "123.456.789-10", "912345-6789", LocalDate.parse("26/12/2002",dataFormatoPadrao), false, false, true);
	Reserva r = new Reserva("1", qua, cliente, LocalDate.parse("17/06/2022", dataFormatoPadrao), LocalTime.parse("12:00", horarioFormatoPadrao), LocalTime.parse("14:00", horarioFormatoPadrao), TipoPagamento.PIX, "1");
	
	/*
	Reserva r2 = new Reserva("2", qua, cliente, LocalDate.parse("17/06/2022", dataFormatoPadrao), LocalTime.parse("14:30", horarioFormatoPadrao), LocalTime.parse("16:00", horarioFormatoPadrao), TipoPagamento.DEBITO, "4");
	Reserva r3 = new Reserva("3", qua, cliente, LocalDate.parse("20/06/2022", dataFormatoPadrao), LocalTime.parse("16:00", horarioFormatoPadrao), LocalTime.parse("18:00", horarioFormatoPadrao), TipoPagamento.DEBITO, "4");
	*/
	
	List<Reserva> listaReservas = new ArrayList();
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
	
	@Test 
	public void testeBuscarReservasPorID() {
		Reserva res = reservaDAO.obterReservaPeloId(Integer.parseInt(r.getCodigo()));
		assertEquals(res.getCodigo(), r.getCodigo());
		assertEquals(res.getData(), r.getData());
		assertEquals(res.getHorarioInicio(), r.getHorarioInicio());
		assertEquals(res.getHorarioFim(), r.getHorarioFim());
		assertEquals(res.getModoPagamento(), r.getModoPagamento());
	}
	
	@Test
	public void testeRegistrarPagamento() {
		assertTrue(reservaDAO.registrarPagamento(r));
	}
	
	@Test
	public void testeBuscarReservaPorDia() {
		listaReservas = reservaDAO.obterReservasPeloDia(LocalDate.of(2022, 6, 17));
		assertEquals(1, listaReservas.size());
	}
	
	@Test
	public void testeBuscarReservaPorPeriodoDeDias() {
		listaReservas = reservaDAO.obterReservasPorPeriodoDeDias(LocalDate.of(2022, 6, 17), LocalDate.of(2022, 6, 19));
		assertEquals(2, listaReservas.size());
	}
	
	@Test
	public void testeBuscarReservaPorPeriodoEmUmDia() {
		listaReservas = reservaDAO.obterReservaPorPeriodo(LocalDate.of(2022, 6, 17), LocalTime.of(12, 0), LocalTime.of(18, 0));
		assertEquals(2, listaReservas.size());
	}
}
