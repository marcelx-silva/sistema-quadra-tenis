package Dominio;
import java.time.LocalDate;
import java.time.LocalTime;

public class Manutencao extends Agendamento{

	public Manutencao(Quadra q, Cliente c, LocalDate data, LocalTime horarioInicio, LocalTime horarioFim) {
		super(q, c, data, horarioInicio, horarioFim);
	}
	
}
