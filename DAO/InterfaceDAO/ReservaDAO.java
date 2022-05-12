package InterfaceDAO;

import java.util.List;
import Dominio.Reserva;

public interface ReservaDAO {
	
	List<Reserva> obterTodasReservas();
	
	Reserva obterReservaPeloId(int id);
	
	Reserva obterReservaPelaData(String data);
	
	List<Reserva> obterReservasPeloDia(String data);
	
	boolean CadastrarReserva(Reserva r);
	
	boolean AlterarDadosReserva(Reserva r);
	
	boolean DeletarReserva(int id);
	

}
