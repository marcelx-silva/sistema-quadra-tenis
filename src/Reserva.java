
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;

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
	
	private String codigo;
	private Cliente cliente;
	private LocalDate data;
	private LocalTime horarioInicio;
	private LocalTime horarioFim;
	private TipoPagamento modoPagamento;
	private int parcelas; 
	private Quadra quadra;
	
	public Reserva(String codigo, Quadra quadra,Cliente cliente,LocalDate data, LocalTime horarioInicio, LocalTime horarioFim, TipoPagamento modoPagamento, int parcelas){
		this.quadra = quadra;
		this.cliente = cliente;
		this.data = data;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.modoPagamento = modoPagamento;
		this.parcelas = parcelas;
	}
	
	public Reserva(Quadra quadra,Cliente cliente,LocalDate data, LocalTime horarioInicio, LocalTime horarioFim, TipoPagamento modoPagamento, int parcelas){
		this.quadra = quadra;
		this.cliente = cliente;
		this.data = data;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.modoPagamento = modoPagamento;
		this.parcelas = parcelas;
	}
	
	public BigDecimal calcularParcela(double preco_reserva,int parcela) {
		BigDecimal prc_res = new BigDecimal(String.valueOf(preco_reserva));
		BigDecimal prl = new BigDecimal(String.valueOf(parcela));
		return prc_res.divide(prl, 2, RoundingMode.UP);
		
	}
	
	public void cadastrarReserva(String cpfCliente,String nomeCliente, LocalDate dataReserva, LocalTime horarioInicioReserva, LocalTime horarioFimReserva, TipoPagamento modoPagamento, int quantidadeParcelas, String codigoQuadra, String nomeQuadra, TipoQuadra tipoQuadra, boolean temCobertura){
		cliente.setNome(nomeCliente);
		cliente.setCpf(cpfCliente);
		setData(dataReserva);
		setHorarioInicio(horarioInicioReserva);
		setHorarioFim(horarioFimReserva);
		setModoPagamento(modoPagamento);
		setParcelas(quantidadeParcelas);		
		quadra.setCodigo(codigoQuadra);
		quadra.setNome(nomeQuadra);
		quadra.setTipo(tipoQuadra);

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

	
	protected String getCodigo() {
		return codigo;
	}

	protected void setCodigo(String codigo) {
		this.codigo = codigo;
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

	protected LocalTime getHorarioFimReserva() {
		return horarioFim;
	}

	protected void setHorarioFim(LocalTime horarioFim) {
		this.horarioFim = horarioFim;
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
		return quadra;
	}

	protected void setQuadra(Quadra quadra) {
		this.quadra = quadra;
	}
}