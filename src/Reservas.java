import java.math.BigDecimal;
import java.math.RoundingMode;

public class Reservas{
	
	Quadras quadra = new Quadras();
	
	

	private String nome_reservista;
	private String cpf_usuario;

	
	private String data_reserva;
	private String hr_inicio_reserva;
	private String hr_fim_reserva;
	private String modo_pagamento;
	private int parcelas; 
	
	private boolean cobertura = false;
	private String nome_quadra;
	private int cod_quadra;
	private String tipo_quadra;

	
	public Reservas(int cod_quadra,String nome_quadra, String tipo_quadra,String cpf_usuario,String nome_reservista,String data_reserva, String hr_inicio_reserva, String hr_fim_reserva, String modo_pagamento, int parcelas, boolean cobertura){
		this.cod_quadra = cod_quadra;
		this.nome_quadra = nome_quadra;
		this.tipo_quadra = tipo_quadra;
		this.cpf_usuario = cpf_usuario;
		this.nome_reservista = nome_reservista;
		this.data_reserva = data_reserva;
		this.hr_inicio_reserva = hr_inicio_reserva;
		this.hr_fim_reserva = hr_fim_reserva;
		this.modo_pagamento = modo_pagamento;
		this.parcelas = parcelas;
		this.cobertura = cobertura;
	}
	

	
	public BigDecimal calcularParcela(double preco_reserva,int parcela) {
		BigDecimal prc_res = new BigDecimal(String.valueOf(preco_reserva));
		BigDecimal prl = new BigDecimal(String.valueOf(parcela));
		return prc_res.divide(prl, 2, RoundingMode.UP);
		
	}
	
	public void cadastrarReserva(String cpf_usu,String nm_reservista, String dt_reserva, String hr_ini_reserva, String hr_fim_reserva, String md_pag, int quant_parcelas, boolean cobertura, int cod_qua, String nm_qua, String tipo_qua){
		setCpf_usuario(cpf_usu);
		setNome_reservista(nm_reservista);
		setData_reserva(dt_reserva);
		setHr_inicio_reserva(hr_ini_reserva);
		setHr_fim_reserva(hr_fim_reserva);
		setModo_pagamento(md_pag);
		setParcelas(quant_parcelas);
		setCobertura(cobertura);		
		setCod_quadra(cod_qua);
		setNome_quadra(nm_qua);
		setTipo_quadra(tipo_qua);
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
	
	protected String getNome_quadra() {
		return nome_quadra; 
	}
	
	protected String getTipo_quadra() {
		return tipo_quadra;
	}
	
	protected int getCod_quadra() {
		return cod_quadra;
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
	
	protected boolean isCobertura() {
		return cobertura;
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
		
	protected void setCobertura(boolean cobertura) {
		this.cobertura = cobertura;
	}
	
	protected void setCpf_usuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}
	
	protected void setNome_quadra(String nome_quadra) {
		this.nome_quadra = nome_quadra; 
	}
	
	protected void setTipo_quadra(String tipo_quadra) {
		this.tipo_quadra = tipo_quadra;
	}
	
	protected void setCod_quadra(int cod_quadra) {
		this.cod_quadra = cod_quadra;
	}
	

	
	
}
