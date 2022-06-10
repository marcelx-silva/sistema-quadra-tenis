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
