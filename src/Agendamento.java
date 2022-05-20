import java.time.LocalDate;
import java.time.LocalTime;

public class Agendamento {

	private Quadra quadra;
	private Cliente cliente;
	private LocalDate data;
	private LocalTime horarioInicio;
	private LocalTime horarioFim;
	
	public Agendamento(Quadra q, Cliente c, LocalDate data, LocalTime horarioInicio, LocalTime horarioFim) {
		
	}

	protected Quadra getQuadra() {
		return quadra;
	}

	protected void setQuadra(Quadra quadra) {
		this.quadra = quadra;
	}

	protected Cliente getCliente() {
		return cliente;
	}

	protected void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	protected LocalDate getData() {
		return data;
	}

	protected void setData(LocalDate data) {
		this.data = data;
	}

	protected LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	protected void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	protected LocalTime getHorarioFim() {
		return horarioFim;
	}

	protected void setHorarioFim(LocalTime horarioFim) {
		this.horarioFim = horarioFim;
	}
	
}
