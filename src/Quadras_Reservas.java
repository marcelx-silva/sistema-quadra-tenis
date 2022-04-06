public class Quadras_Reservas {
	private int codigoQuadra;
	
	private String tipoQuadra;
	private boolean possuiCobertura;
	private boolean possuiArquibancada;
	private boolean possuiAreaDescanso;
	private boolean estaBloqueada = false;
	
	public boolean verificaNumeroQuadra(int numero) {
		if(numero == this.getCodigoQuadra()) {
			return true;
		}else
			return false;
	}
	
	public String identificaTipoQuadra(int identificador) {
		switch(identificador) {
		case 1:
			return "SAIBRO";
			
		case 2:
			return "SUPERFÍCIE SINTÉTICA";
			
		case 3:
			return "CIMENTO";
			
		case 4:
			return "BEACH TENNIS";
			
		default:
			return "OPÇÃO INVÁLIDA";
		}
	}
	
	
	
	protected int getCodigoQuadra() {
		return codigoQuadra;
	}
	
	protected void setCodigoQuadra(int codigoQuadra) {
		this.codigoQuadra = codigoQuadra;
	}
	
	
	protected String getTipoQuadra() {
		return tipoQuadra;
	}
	
	protected void setTipoQuadra(String tipoQuadra) {
		this.tipoQuadra = tipoQuadra;
	}
	
	protected boolean isPossuiCobertura() {
		return possuiCobertura;
	}
	
	protected void setPossuiCobertura(boolean possuiCobertura) {
		this.possuiCobertura = possuiCobertura;
	}
	
	protected boolean isPossuiArquibancada() {
		return possuiArquibancada;
	}
	
	protected void setPossuiArquibancada(boolean possuiArquibancada) {
		this.possuiArquibancada = possuiArquibancada;
	}
	
	protected boolean isPossuiAreaDescanso() {
		return possuiAreaDescanso;
	}
	
	protected void setPossuiAreaDescanso(boolean possuiAreaDescanso) {
		this.possuiAreaDescanso = possuiAreaDescanso;
	}
	
	protected boolean isEstaBloqueada() {
		return estaBloqueada;
	}
	
	protected void setEstaBloqueada(boolean estaBloqueada) {
		this.estaBloqueada = estaBloqueada;
	}
}
	


