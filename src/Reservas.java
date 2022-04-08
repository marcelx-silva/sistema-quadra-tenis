

public class Reservas {
	
	private String nome_reservista;
	private String data_reserva;
	private String hr_inicio_reserva;
	private String hr_fim_reserva;
	private String modo_pagamento;
	private double preco_reserva;
	private int parcelas; 
	
	private Quadras quadra;
	
	public Reservas(String nome_reservista,String data_reserva, String hr_inicio_reserva, String hr_fim_reserva, String modo_pagamento, int parcelas, double preco_reserva, Quadras quadra){
		this.nome_reservista = nome_reservista;
		this.data_reserva = data_reserva;
		this.hr_inicio_reserva = hr_inicio_reserva;
		this.hr_fim_reserva = hr_fim_reserva;
		this.modo_pagamento = modo_pagamento;
		this.parcelas = parcelas;
		this.preco_reserva = preco_reserva;
		this.quadra = quadra;
	}
	
	public void cadastrarReserva(String nm_reservista, String dt_reserva, String hr_ini_reserva, String hr_fim_reserva, String md_pag, int quant_parcelas, double preco_reserva, Quadras quadra){
		setNome_reservista(nm_reservista);
		setData_reserva(dt_reserva);
		setHr_inicio_reserva(hr_ini_reserva);
		setHr_fim_reserva(hr_fim_reserva);
		setModo_pagamento(md_pag);
		setParcelas(quant_parcelas);
		setPreco_reserva(preco_reserva);
		setQuadras(quadra);
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
	
	protected void setPreco_reserva(double preco_reserva) {
		 this.preco_reserva = preco_reserva;
	}
	
	
	protected double getPreco_reserva(Quadras quadra) {
		if(quadra.isPossuiCobertura()) {
			this.preco_reserva = 70.00;
		}else {
			this.preco_reserva = 40.00;
		}
		
		return this.preco_reserva;
	}
	
	protected Quadras getQuadras() {
		return this.quadra;
	}
	
	
	protected String getNome_reservista() {
		return nome_reservista;
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
	
	protected void setQuadras(Quadras quadra){
		this.quadra = quadra;
	}
	
	
	
	
}
