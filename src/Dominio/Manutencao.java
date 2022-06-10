package Dominio;
import java.time.LocalDate;
import java.time.LocalTime;

public class Manutencao extends Agendamento{

	private boolean preventiva;
	private String descricao;

	public Manutencao(String codigo, Quadra q, LocalDate data, LocalTime horarioInicio, LocalTime horarioFim, boolean prev, String descricao) {
		super(codigo, q, data, horarioInicio, horarioFim);
		this.setPreventiva(prev);
		this.setDescricao(descricao);
	}
	
	public Manutencao(Quadra q, LocalDate data, LocalTime horarioInicio, LocalTime horarioFim, boolean prev, String descricao) {
		super(q, data, horarioInicio, horarioFim);
		this.setPreventiva(prev);
		this.setDescricao(descricao);
	}
	
	public boolean isPreventiva() {
		return preventiva;
	}

	public void setPreventiva(boolean preventiva) {
		this.preventiva = preventiva;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
