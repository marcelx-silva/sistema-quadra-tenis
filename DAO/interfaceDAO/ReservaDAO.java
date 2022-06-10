package interfaceDAO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import Dominio.Reserva;

public interface ReservaDAO {
	
	List<Reserva> obterTodasReservas();
	
	List<Reserva> obterReservaPorPeriodo(LocalDate data, LocalTime horarioInicio, LocalTime horarioFim);

	List<Reserva> obterReservasPeloDia(LocalDate data);
	
	List<Reserva> obterReservasPorPeriodoDeDias(LocalDate dataInicio, LocalDate dataFim);
	
	Reserva obterReservaPeloId(int id);
	
	boolean registrarPagamento(Reserva r);
	
	boolean registrarEntradaCliente(Reserva r);
	
	boolean registrarSaidaCliente(Reserva r);
	
	boolean CadastrarReserva(Reserva r);
	
	boolean DeletarReserva(int id);
	

}
