package Dominio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Enum.TipoPagamento;
import Enum.TipoQuadra;
import java.time.LocalTime;
import java.time.LocalDate;

public class Reserva extends Agendamento{
	
	private TipoPagamento modoPagamento;
	private String parcelas;
	private Cliente cliente;	
	
	public Reserva(String codigo, Quadra quadra, Cliente cliente,LocalDate data, LocalTime horarioInicio, LocalTime horarioFim, TipoPagamento modoPagamento, String parcelas){
		super(codigo, quadra, data, horarioInicio, horarioFim);
		this.modoPagamento = modoPagamento;
		this.parcelas = parcelas;
	}
	
	public Reserva(Quadra quadra, Cliente cliente,LocalDate data, LocalTime horarioInicio, LocalTime horarioFim, TipoPagamento modoPagamento, String parcelas){
		super(quadra, data, horarioInicio, horarioFim);
		this.modoPagamento = modoPagamento;
		this.parcelas = parcelas;
	}
	
	public String calcularParcela(boolean coberta,int parcela) {
		BigDecimal prc_res;
		if(!coberta)
			prc_res = new BigDecimal(String.valueOf("40"));
		else
			prc_res = new BigDecimal(String.valueOf("70"));
		BigDecimal prl = new BigDecimal(String.valueOf(parcela));
		return prc_res.divide(prl, 2, RoundingMode.UP).toString();
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoPagamento getModoPagamento() {
		return modoPagamento;
	}

	public void setModoPagamento(TipoPagamento modoPagamento) {
		this.modoPagamento = modoPagamento;
	}

	public String getParcelas() {
		return parcelas;
	}

	public void setParcelas(String parcelas) {
		this.parcelas = parcelas;
	}	
}
