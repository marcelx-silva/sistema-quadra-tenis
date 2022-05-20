import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Agendamento {

	private Quadra quadra;
	private Cliente cliente;
	private LocalDate data;
	private LocalTime horarioInicio;
	private LocalTime horarioFim;
	
	public Agendamento(Quadra q, Cliente c, LocalDate data, LocalTime horarioInicio, LocalTime horarioFim) {
		this.setQuadra(q);
		this.setCliente(c);
		this.setData(data);
		this.setHorarioInicio(horarioInicio);
		this.setHorarioFim(horarioFim);
	}

	public static ArrayList<String> horariosAgendamento(String codigoQuadra){
		
		//Teste
        DateTimeFormatter horarioFormatoPadrao = DateTimeFormatter.ofPattern("HH:mm");
		ArrayList<String> listaAgendamentos = new ArrayList<String>();
		
		LocalDateTime horarioEx = LocalDateTime.now();//.plusDays(1);
		
		listaAgendamentos.add(horarioEx.minusHours(0).minusMinutes(30).withMinute(0).format(horarioFormatoPadrao).toString());
		listaAgendamentos.add(horarioEx.minusHours(15).minusMinutes(12).withMinute(0).format(horarioFormatoPadrao).toString());
		listaAgendamentos.add(horarioEx.minusHours(18).minusMinutes(50).withMinute(0).format(horarioFormatoPadrao).toString());
		listaAgendamentos.add(horarioEx.minusHours(8).minusMinutes(30).withMinute(0).format(horarioFormatoPadrao).toString());
		listaAgendamentos.add(horarioEx.minusHours(6).withMinute(0).format(horarioFormatoPadrao).toString());
		listaAgendamentos.add(horarioEx.minusHours(2).withMinute(0).format(horarioFormatoPadrao).toString());
		
		return listaAgendamentos;
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
