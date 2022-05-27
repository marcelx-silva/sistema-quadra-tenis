package Dominio;

import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import Enum.TipoQuadra;

public class Quadra{
	
	private String codigo;
	private String nome;
	private String endereco;

	private TipoQuadra tipo;
	private boolean possuiCobertura;
	private boolean possuiArquibancada;
	private boolean possuiAreaDescanso;
	private boolean estaBloqueada = false;
	
	public Quadra(String codigo, String nome, TipoQuadra tipo, boolean cobertura) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setTipo(tipo);
	}
	

	public Quadra(String codigo, String nome, String endereco, TipoQuadra tipo, boolean cobertura, boolean arquibancada, boolean descanso) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTipo(tipo);
		this.setPossuiCobertura(cobertura);
		this.setPossuiArquibancada(arquibancada);
		this.setPossuiAreaDescanso(descanso);
	}
	
	public Quadra(String nome, String endereco, TipoQuadra tipo, boolean cobertura, boolean arquibancada, boolean descanso, boolean bloqueado) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTipo(tipo);
		this.setPossuiCobertura(cobertura);
		this.setPossuiArquibancada(arquibancada);
		this.setPossuiAreaDescanso(descanso);
		this.setEstaBloqueada(bloqueado);
	}

	public Quadra(String codigo,String nome, String endereco, int tipo, boolean cobertura, boolean arquibancada, boolean descanso, boolean bloqueado) {
		this.setCodigo(codigo);	
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTipo(identificaTipoQuadra(tipo));
		this.setPossuiCobertura(cobertura);
		this.setPossuiArquibancada(arquibancada);
		this.setPossuiAreaDescanso(descanso);
		this.setEstaBloqueada(bloqueado);
	}
	
	public static ArrayList<Quadra> procuraQuadras(String dia, String horarioInicio, String horarioFim, 
			String tipo, boolean cobertura, boolean arquibancada, boolean areaDescanso){
		
		ArrayList<Quadra> Quadras = new ArrayList<Quadra>();
		
		return Quadras;
		
	}
	
	public static String[][] procuraQuadrasCadastradas(){
				
		int colunaTeste = 8;
		int linhaTeste = 2;
		String[][] quadras;
		
		String[][] exemploRetornoBD = {{"01", "nome1", "tipo1", "endereco1", "cobertura1", "arquibancada1", "descanco1", "status1"},
				{"02", "nome2", "tipo2", "endereco2", "cobertura2", "arquibancada2", "descanco2", "status2"}};
	

		quadras = new String[linhaTeste][colunaTeste];
		
		for (int linha=0; linha < linhaTeste; linha++) {
			for (int coluna=0; coluna < colunaTeste; coluna++) { 
				quadras[linha][coluna] = exemploRetornoBD[linha][coluna]; 				
			}
		}
		
		return quadras;
	}
	
	public String[][] verificaDisponibilidadeQuadra(int quantidadeDias) {
		//hashmap
		int aberturaSemana = 6;
		int fechamentoSemana = 22;
		int periodosTempo = (24 - ((24 - fechamentoSemana) + aberturaSemana)) * 2; 
		
		String[][] disponibilidade = new String[quantidadeDias][periodosTempo];
		ArrayList<String> horariosReservados = Reserva.horariosAgendamento(codigo);
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


	public void cadastraQuadra(String numero, String nome, String endereco, TipoQuadra tipo, boolean cobertura, boolean arquibancada, boolean area) {
		setCodigo(numero);
		setNome(nome);
		setEndereco(endereco);
		setTipo(tipo);
		setPossuiCobertura(cobertura);
		setPossuiArquibancada(arquibancada);
		setPossuiAreaDescanso(area);
	}


	public boolean verificaNumeroQuadra(int numero) {
		return (numero == Integer.parseInt(this.getCodigo()));
	}


	public void bloqueiaQuadraParaAluguel() {
		this.setEstaBloqueada(true);
	}

	public void desbloqueiaQuadraParaAluguel() {
		this.setEstaBloqueada(false);
	}


	public TipoQuadra identificaTipoQuadra(int identificador) {
		switch (identificador) {
		case 1:
			return TipoQuadra.SAIBRO;

		case 2:
			return TipoQuadra.SUPERFICIE_SINTETICA;

		case 3:
			return TipoQuadra.CIMENTO;

		case 4:
			return TipoQuadra.BEACH_TENNIS;
			
		default:
			return TipoQuadra.INVALIDO;
		}
	}

	public BigDecimal getPrecoReservaTempoMinimo() {
		if(this.isPossuiCobertura())
			return new BigDecimal("70");
		else
			return new BigDecimal("40");
	}
	
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public TipoQuadra getTipo() {
		return tipo;
	}


	public void setTipo(TipoQuadra tipo) {
		this.tipo = tipo;

	}

	public boolean isPossuiCobertura() {
		return possuiCobertura;
	}

	public void setPossuiCobertura(boolean possuiCobertura) {
		this.possuiCobertura = possuiCobertura;
	}

	public boolean isPossuiArquibancada() {
		return possuiArquibancada;
	}


	public void setPossuiArquibancada(boolean possuiArquibancada) {
		this.possuiArquibancada = possuiArquibancada;
	}

	public boolean isPossuiAreaDescanso() {
		return possuiAreaDescanso;
	}


	public void setPossuiAreaDescanso(boolean possuiAreaDescanso) {
		this.possuiAreaDescanso = possuiAreaDescanso;
	}

	public boolean isEstaBloqueada() {
		return estaBloqueada;
	}


	public void setEstaBloqueada(boolean estaBloqueada) {
		this.estaBloqueada = estaBloqueada;
	}
	
}
