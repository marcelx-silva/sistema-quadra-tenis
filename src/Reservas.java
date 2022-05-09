
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Reservas{
	
	
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
	
	Quadras quadra = new Quadras(0,"","","",false,false,false);
	
	

	private String nome_reservista;
	private String cpf_usuario;

	
	private String data_reserva;
	private String hr_inicio_reserva;
	private String hr_fim_reserva;
	private String modo_pagamento;
	private int parcelas; 
	
	private Quadras codigoQuadra;
	
	public Reservas(Quadras cod_quadra,String cpf_usuario,String nome_reservista,String data_reserva, String hr_inicio_reserva, String hr_fim_reserva, String modo_pagamento, int parcelas){
		this.codigoQuadra = cod_quadra;
		this.cpf_usuario = cpf_usuario;
		this.nome_reservista = nome_reservista;
		this.data_reserva = data_reserva;
		this.hr_inicio_reserva = hr_inicio_reserva;
		this.hr_fim_reserva = hr_fim_reserva;
		this.modo_pagamento = modo_pagamento;
		this.parcelas = parcelas;
	}
	

	
	public BigDecimal calcularParcela(double preco_reserva,int parcela) {
		BigDecimal prc_res = new BigDecimal(String.valueOf(preco_reserva));
		BigDecimal prl = new BigDecimal(String.valueOf(parcela));
		return prc_res.divide(prl, 2, RoundingMode.UP);
		
	}
	
	public void cadastrarReserva(String cpf_usu,String nm_reservista, String dt_reserva, String hr_ini_reserva, String hr_fim_reserva, String md_pag, int quant_parcelas, int cod_qua){
		setCpf_usuario(cpf_usu);
		setNome_reservista(nm_reservista);
		setData_reserva(dt_reserva);
		setHr_inicio_reserva(hr_ini_reserva);
		setHr_fim_reserva(hr_fim_reserva);
		setModo_pagamento(md_pag);
		setParcelas(quant_parcelas);		
		//setCodigoQuadra(cod_qua);

	}
	

	public String selecionarModoPagamento(int modo_pagamento) {
		switch(modo_pagamento) {
		
		case 1:
			return "CRÉDITO";
		case 2:
			return "DÉBITO";
		case 3:
			return "DINHEIRO";
		case 4:
			return "PIX";
		default:
			return "OPÇÃO INVÁLIDA !";
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
	
	protected String getNome_reservista() {
		return nome_reservista;
	}

	protected String getCpf_usuario() {
		return cpf_usuario;
	}
	

	protected Quadras getCodigoQuadra() {
		return codigoQuadra;
	}
	
	protected String getData_reserva(){
		return data_reserva;
	}
	
	protected String getHr_inicio_reserva() {
		return hr_inicio_reserva;
	}
	
	protected String getHr_fim_reserva() {
		return hr_fim_reserva;
	}
	
	protected String getModo_pagamento() {
		return modo_pagamento;
	}
	
	protected int getParcelas(){
		return parcelas;
	}
	
	
	protected void setNome_reservista(String nome_reservista){
		this.nome_reservista = nome_reservista;
	}

	
	protected void setData_reserva(String data_reserva){
		this.data_reserva = data_reserva;
	}
	
	protected void setHr_inicio_reserva(String hr_inicio_reserva){
		this.hr_inicio_reserva = hr_inicio_reserva;
	}
	
	protected void setHr_fim_reserva(String hr_fim_reserva){
		this.hr_fim_reserva = hr_fim_reserva;
	}
	
	protected void setModo_pagamento(String modo_pagamento){
		this.modo_pagamento = modo_pagamento;
	}
	
	protected void setParcelas(int parcelas){
		this.parcelas = parcelas;
	}
		
	protected void setCpf_usuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}
	
	
	protected void setCodigoQuadra(Quadras cod_quadra) {
		this.codigoQuadra = cod_quadra;
	}
	
}


	



