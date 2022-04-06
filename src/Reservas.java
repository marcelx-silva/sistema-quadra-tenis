
public class Reservas extends Quadras_Reservas{
	
	
	
	private String cod_reservista;
	
	private String data_reserva;
	private String hr_inicio_reserva;
	private String hr_fim_reserva;
	
	private int modo_pagamento;
	private int parcelas; 
	
	
	
	
	protected String getCod_reservista() {
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
	
	protected void setCod_reservista(String cod_reservista){
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
