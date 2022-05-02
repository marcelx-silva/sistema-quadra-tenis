import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Quadras{
	
	private int codigoQuadra;
	private String nomeQuadra;
	private String enderecoQuadra;

	private String tipoQuadra;
	private boolean possuiCobertura;
	private boolean possuiArquibancada;
	private boolean possuiAreaDescanso;
	private boolean estaBloqueada = false;
	private double preco_reserva;

	
	
	public static ArrayList<Quadras> procuraQuadras(String dia, String horarioInicio, String horarioFim, 
			String tipo, boolean cobertura, boolean arquibancada, boolean areaDescanso){
		
		ArrayList<Quadras> Quadras = new ArrayList<Quadras>();
		
		return Quadras;
		
	}
	
	public String[][] verificaDisponibilidadeQuadra(int quantidadeDias) {
		//hashmap
		int aberturaSemana = 6;
		int fechamentoSemana = 22;
		int periodosTempo = (24 - ((24 - fechamentoSemana) + aberturaSemana)) * 2; 
		
		String[][] disponibilidade = new String[quantidadeDias][periodosTempo];
		ArrayList<String> horariosReservados = Reservas.horariosReservas(codigoQuadra);
		DateTimeFormatter horarioFormatoPadrao = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime horario = LocalDateTime.now();
		
		//DateTimeFormatter dataFormatoPadrao = DateTimeFormatter.ofPattern("dd/mm/yy");
		
   
		if (horario.getMinute()%30!=0){
            horario = horario.minusMinutes(horario.getMinute()-30).plusMinutes(30);
        }
		
		if (horario.isBefore(horario.withHour(aberturaSemana))){
			horario = horario.withHour(aberturaSemana);
		} else if (horario.isAfter(horario.withHour(fechamentoSemana))){
			horario = horario.plusDays(1).withHour(aberturaSemana);
		}
        
		for (int dia=0; dia<quantidadeDias; dia++){
			for (int intervalo=0; intervalo<periodosTempo; intervalo++){
				if (horario.isAfter(horario.withHour(fechamentoSemana)) | horario.isEqual(horario.withHour(fechamentoSemana))) {
					break;
				}
				if (!horariosReservados.contains(horario.format(horarioFormatoPadrao).toString())) {
					disponibilidade[dia][intervalo] = horario.format(horarioFormatoPadrao).toString();
				}
                horario = horario.plusMinutes(30);
			} 

			horario = horario.plusDays(1);
			horario = horario.withHour(aberturaSemana);
		}
        	
		return disponibilidade;  
	}
		

	public void cadastraQuadra(int numero, String nome, String endereco, String tipo, boolean cobertura,
			boolean arquibancada, boolean area) {
		setCodigoQuadra(numero);
		setNomeQuadra(nome);
		setEnderecoQuadra(endereco);
		setTipoQuadra(tipo);
		setPossuiCobertura(cobertura);
		setPossuiArquibancada(arquibancada);
		setPossuiAreaDescanso(area);
		setPreco_reserva(cobertura);
	}
<<<<<<< HEAD
	
	
=======

	public boolean verificaNumeroQuadra(int numero) {
		if (numero == this.getCodigoQuadra()) {
			return true;
		} else
			return false;
	}

>>>>>>> main
	public void bloqueiaQuadraParaAluguel() {
		this.setEstaBloqueada(true);
	}

	public void desbloqueiaQuadraParaAluguel() {
		this.setEstaBloqueada(false);
	}
<<<<<<< HEAD
	
=======
>>>>>>> main

	public String identificaTipoQuadra(int identificador) {
		switch (identificador) {
		case 1:
			return "SAIBRO";

		case 2:
			return "SUPERFICIE SINTETICA";

		case 3:
			return "CIMENTO";

		case 4:
			return "BEACH TENNIS";

		default:
			return "OPCAO INVALIDA";
		}
	}
<<<<<<< HEAD
	protected double getPreco_reserva() {
		return preco_reserva;
	}
	
	protected void setPreco_reserva(boolean cobertura) {
		if(cobertura) {
			this.preco_reserva = 70.00;
		}else {
			this.preco_reserva = 40.00;
		}
	}
	
	
=======

>>>>>>> main
	protected int getCodigoQuadra() {
		return codigoQuadra;
	}

	private void setCodigoQuadra(int codigoQuadra) {
		this.codigoQuadra = codigoQuadra;
	}

	protected String getNomeQuadra() {
		return nomeQuadra;
	}

	private void setNomeQuadra(String nomeQuadra) {
		this.nomeQuadra = nomeQuadra;
	}

	protected String getEnderecoQuadra() {
		return enderecoQuadra;
	}

	private void setEnderecoQuadra(String enderecoQuadra) {
		this.enderecoQuadra = enderecoQuadra;
	}

	protected String getTipoQuadra() {
		return tipoQuadra;
	}

<<<<<<< HEAD
	protected void setTipoQuadra(String tipoQuadra) {
=======
	private void setTipoQuadra(String tipoQuadra) {
>>>>>>> main
		this.tipoQuadra = tipoQuadra;
	}

	protected boolean isPossuiCobertura() {
		return possuiCobertura;
	}

<<<<<<< HEAD
	protected void setPossuiCobertura(boolean possuiCobertura) {
=======
	private void setPossuiCobertura(boolean possuiCobertura) {
>>>>>>> main
		this.possuiCobertura = possuiCobertura;
	}

	protected boolean isPossuiArquibancada() {
		return possuiArquibancada;
	}

<<<<<<< HEAD
	protected void setPossuiArquibancada(boolean possuiArquibancada) {
=======
	private void setPossuiArquibancada(boolean possuiArquibancada) {
>>>>>>> main
		this.possuiArquibancada = possuiArquibancada;
	}

	protected boolean isPossuiAreaDescanso() {
		return possuiAreaDescanso;
	}

<<<<<<< HEAD
	protected void setPossuiAreaDescanso(boolean possuiAreaDescanso) {
=======
	private void setPossuiAreaDescanso(boolean possuiAreaDescanso) {
>>>>>>> main
		this.possuiAreaDescanso = possuiAreaDescanso;
	}

	protected boolean isEstaBloqueada() {
		return estaBloqueada;
	}

<<<<<<< HEAD
	protected void setEstaBloqueada(boolean estaBloqueada) {
=======
	private void setEstaBloqueada(boolean estaBloqueada) {
>>>>>>> main
		this.estaBloqueada = estaBloqueada;
	}
	
}
