
public class Reservas extends Quadras_Reservas{
	
	
	
	private int cod_reservista;
	
	private String data_reserva;
	private String hr_inicio_reserva;
	private String hr_fim_reserva;
	
	private int modo_pagamento;
	private int parcelas; 
	
	

	
	public String selecionarModoPagamento(int modo_pagamento) {
		switch(modo_pagamento) {
		
		case 1:
			return "CR�DITO";
		case 2:
			return "D�BITO";
		case 3:
			return "DINHEIRO";
		case 4:
			return "PIX";
		default:
			return "OP��O INV�LIDA !";
		}
	}
	
	
	
	
	protected int getCod_reservista() {
		return cod_reservista;
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
	
	protected int getModo_pagamento() {
		return modo_pagamento;
	}
	
	protected int getParcelas(){
		return parcelas;
	}
	
	protected void setCod_reservista(int cod_reservista){
		this.cod_reservista = cod_reservista;
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
	
	protected void setModo_pagamento(int modo_pagamento){
		this.modo_pagamento = modo_pagamento;
	}
	
	protected void setParcelas(int parcelas){
		this.parcelas = parcelas;
	}
	
	
	
	
	
}
