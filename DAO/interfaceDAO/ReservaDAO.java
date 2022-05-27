package interfaceDAO;

import java.util.List;
import Dominio.Reserva;

public interface ReservaDAO {
	
	List<Reserva> obterTodasReservas();
	
	List<Reserva> obterReservaPelaData(String data);
	
	Reserva obterReservaPeloId(int id);
	
	List<Reserva> obterReservasPeloDia(String data);
	
	boolean CadastrarReserva(Reserva r);
	
	boolean AlterarDadosReserva(String alteracao, int escolha);
	
	boolean DeletarReserva(int id);
	

}
