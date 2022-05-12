package Dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import Enum.TipoPagamento;
import Enum.TipoQuadra;


public class Reserva{
	
	
	public static ArrayList<String> horariosReservas(int codigoQuadra){
		
		//Teste
        DateTimeFormatter horarioFormatoPadrao = DateTimeFormatter.ofPattern("HH:mm");
		ArrayList<String> listaReservas = new ArrayList<String>();
		
		LocalDateTime horarioEx = LocalDateTime.now();//.plusDays(1);
		
		listaReservas.add(horarioEx.minusHours(0).minusMinutes(30).withMinute(0).format(horarioFormatoPadrao).toString());
		listaReservas.add(horarioEx.minusHours(15).minusMinutes(12).withMinute(0).format(horarioFormatoPadrao).toString());
		listaReservas.add(horarioEx.minusHours(18).minusMinutes(50).withMinute(0).format(horarioFormatoPadrao).toString());
		listaReservas.add(horarioEx.minusHours(8).minusMinutes(30).withMinute(0).format(horarioFormatoPadrao).toString());
		listaReservas.add(horarioEx.minusHours(6).withMinute(0).format(horarioFormatoPadrao).toString());
		listaReservas.add(horarioEx.minusHours(2).withMinute(0).format(horarioFormatoPadrao).toString());
		
		return listaReservas;
	}
		
	private Cliente cliente;
	private String dataReserva;
	private String horarioInicioReserva;
	private String horarioFimReserva;
	private TipoPagamento modoPagamento;
	private int parcelas; 
	private Quadra quadra;
	
	public Reserva(Quadra quadra,Cliente cliente,String dataReserva, String horarioInicioReserva, String horarioFimReserva, TipoPagamento modoPagamento, int parcelas){
		this.quadra = quadra;
		this.cliente = cliente;
		this.dataReserva = dataReserva;
		this.horarioInicioReserva = horarioInicioReserva;
		this.horarioFimReserva = horarioFimReserva;
		this.modoPagamento = modoPagamento;
		this.parcelas = parcelas;
	}
	
	public BigDecimal calcularParcela(double preco_reserva,int parcela) {
		BigDecimal prc_res = new BigDecimal(String.valueOf(preco_reserva));
		BigDecimal prl = new BigDecimal(String.valueOf(parcela));
		return prc_res.divide(prl, 2, RoundingMode.UP);
		
	}
	
	public void cadastrarReserva(String cpfCliente,String nomeCliente, String dataReserva, String horarioInicioReserva, String horarioFimReserva, TipoPagamento modoPagamento, int quantidadeParcelas, int codigoQuadra, String nomeQuadra, TipoQuadra tipoQuadra, boolean temCobertura){
		cliente.setNomeCliente(nomeCliente);
		cliente.setCpfCliente(cpfCliente);
		setDataReserva(dataReserva);
		setHorarioInicioReserva(horarioInicioReserva);
		setHorarioFimReserva(horarioFimReserva);
		setModoPagamento(modoPagamento);
		setParcelas(quantidadeParcelas);		
		quadra.setCodigoQuadra(codigoQuadra);
		quadra.setNomeQuadra(nomeQuadra);
		quadra.setTipoQuadra(tipoQuadra);

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

	protected Cliente getCliente() {
		Cliente c = cliente;
		return c;
	}
	
	protected void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	protected String getDataReserva() {
		return dataReserva;
	}

	protected void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
	}

	protected String getHorarioInicioReserva() {
		return horarioInicioReserva;
	}

	protected void setHorarioInicioReserva(String horarioInicioReserva) {
		this.horarioInicioReserva = horarioInicioReserva;
	}

	protected String getHorarioFimReserva() {
		return horarioFimReserva;
	}

	protected void setHorarioFimReserva(String horarioFimReserva) {
		this.horarioFimReserva = horarioFimReserva;
	}

	protected TipoPagamento getModoPagamento() {
		return modoPagamento;
	}

	protected void setModoPagamento(TipoPagamento modoPagamento) {
		this.modoPagamento = modoPagamento;
	}

	protected int getParcelas() {
		return parcelas;
	}

	protected void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	protected Quadra getQuadra() {
		Quadra q = quadra;
		return q;
	}

	protected void setQuadra(Quadra quadra) {
		this.quadra = quadra;
	}
}