package Dominio;
import java.time.LocalDate;
import java.time.LocalTime;

public class Manutencao extends Agendamento{

	private boolean preventiva;
	private String descricao;

	public Manutencao(Quadra q, LocalDate data, LocalTime horarioInicio, LocalTime horarioFim) {
		super(q, data, horarioInicio, horarioFim);
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
