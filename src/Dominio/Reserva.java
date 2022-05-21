package Dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
<<<<<<< HEAD:src/Dominio/Reserva.java
import Enum.TipoPagamento;
import Enum.TipoQuadra;
=======
import java.time.LocalTime;
import java.time.LocalDate;
>>>>>>> Development:src/Reserva.java

public class Reserva extends Agendamento{
	
	private String codigo;
	private TipoPagamento modoPagamento;
	private int parcelas;
	
	public Reserva(String codigo, Quadra quadra,Cliente cliente,LocalDate data, LocalTime horarioInicio, LocalTime horarioFim, TipoPagamento modoPagamento, int parcelas){
		super(quadra, cliente, data, horarioInicio, horarioFim);
		this.codigo = codigo;
		this.modoPagamento = modoPagamento;
		this.parcelas = parcelas;
	}
	
	public Reserva(Quadra quadra,Cliente cliente,LocalDate data, LocalTime horarioInicio, LocalTime horarioFim, TipoPagamento modoPagamento, int parcelas){
		super(quadra, cliente, data, horarioInicio, horarioFim);
		this.modoPagamento = modoPagamento;
		this.parcelas = parcelas;
	}
	
	public BigDecimal calcularParcela(double preco_reserva,int parcela) {
		BigDecimal prc_res = new BigDecimal(String.valueOf(preco_reserva));
		BigDecimal prl = new BigDecimal(String.valueOf(parcela));
		return prc_res.divide(prl, 2, RoundingMode.UP);
		
	}
	
	public void cadastrarReserva(String cpfCliente,String nomeCliente, LocalDate dataReserva, LocalTime horarioInicioReserva, LocalTime horarioFimReserva, TipoPagamento modoPagamento, int quantidadeParcelas, String codigoQuadra, String nomeQuadra, TipoQuadra tipoQuadra, boolean temCobertura){
		super.getCliente().setNome(nomeCliente);
		super.getCliente().setCpf(cpfCliente);
		setData(dataReserva);
		setHorarioInicio(horarioInicioReserva);
		setHorarioFim(horarioFimReserva);
		setModoPagamento(modoPagamento);
		setParcelas(quantidadeParcelas);		
		super.getQuadra().setCodigo(codigoQuadra);
		super.getQuadra().setNome(nomeQuadra);
		super.getQuadra().setTipo(tipoQuadra);

	}
	

	public TipoPagamento selecionarModoPagamento(int modo_pagamento) {
		switch(modo_pagamento) {
		
		case 1:
			return TipoPagamento.CREDITO;
			
		case 2:
			return TipoPagamento.DEBITO;
			
		case 3:
			return TipoPagamento.DINHEIRO;
			
		case 4:
			return TipoPagamento.PIX;
			
		default:
			return TipoPagamento.INVALIDO;
		}
	}

	public int parcelarReserva(int parcelas) {
		switch(parcelas) {
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 4;
		default:
			return 0;
		}
	}

<<<<<<< HEAD:src/Dominio/Reserva.java
	public Cliente getCliente() {
		Cliente c = cliente;
		return c;
	}
=======
>>>>>>> Development:src/Reserva.java
	
	protected String getCodigo() {
		return codigo;
	}

<<<<<<< HEAD:src/Dominio/Reserva.java

	public String getDataReserva() {
		return dataReserva;
	}

	protected void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
	}

	public String getHorarioInicioReserva() {
		return horarioInicioReserva;
	}

	protected void setHorarioInicioReserva(String horarioInicioReserva) {
		this.horarioInicioReserva = horarioInicioReserva;
	}

	public String getHorarioFimReserva() {
		return horarioFimReserva;
	}

	protected void setHorarioFimReserva(String horarioFimReserva) {
		this.horarioFimReserva = horarioFimReserva;
=======
	protected void setCodigo(String codigo) {
		this.codigo = codigo;
>>>>>>> Development:src/Reserva.java
	}

	public TipoPagamento getModoPagamento() {
		return modoPagamento;
	}

	protected void setModoPagamento(TipoPagamento modoPagamento) {
		this.modoPagamento = modoPagamento;
	}

	public int getParcelas() {
		return parcelas;
	}

	protected void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
<<<<<<< HEAD:src/Dominio/Reserva.java

	public Quadra getQuadra() {
		Quadra q = quadra;
		return q;
	}

	protected void setQuadra(Quadra quadra) {
		this.quadra = quadra;
	}
=======
>>>>>>> Development:src/Reserva.java
}