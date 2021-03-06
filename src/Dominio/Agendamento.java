package Dominio;
import java.time.LocalDate;
import java.time.LocalTime;

public class Agendamento {

	private String codigo;
	private Quadra quadra;
	private LocalDate data;
	private LocalTime horarioInicio;
	private LocalTime horarioFim;
	
	public Agendamento(String codigo, Quadra q, LocalDate data, LocalTime horarioInicio, LocalTime horarioFim) {
		this.setCodigo(codigo);
		this.setQuadra(q);
		this.setData(data);
		this.setHorarioInicio(horarioInicio);
		this.setHorarioFim(horarioFim);
	}
		
	public Agendamento(Quadra q, LocalDate data, LocalTime horarioInicio, LocalTime horarioFim) {
		this.setQuadra(q);
		this.setData(data);
		this.setHorarioInicio(horarioInicio);
		this.setHorarioFim(horarioFim);
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Quadra getQuadra() {
		return quadra;
	}

	public void setQuadra(Quadra quadra) {
		this.quadra = quadra;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalTime getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(LocalTime horarioFim) {
		this.horarioFim = horarioFim;
	}
	
}
