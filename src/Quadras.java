
public class Quadras {
	
	private int codigoQuadra;
	private String nomeQuadra;
	private String enderecoQuadra;
	private String tipoQuadra;
	private boolean possuiCobertura;
	private boolean possuiArquibancada;
	private boolean possuiAreaDescanso;
	private boolean estaBloqueada = false;
	
	public void cadastraQuadra(int numero, String nome, String endereco, String tipo, boolean cobertura, boolean arquibancada, boolean area) {
		setCodigoQuadra(numero);
		setNomeQuadra(nome);
		setEnderecoQuadra(endereco);
		setTipoQuadra(tipo);
		setPossuiCobertura(cobertura);
		setPossuiArquibancada(arquibancada);
		setPossuiAreaDescanso(area);
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
	
	protected String getNomeQuadra() {
		return nomeQuadra;
	}
	
	protected void setNomeQuadra(String nomeQuadra) {
		this.nomeQuadra = nomeQuadra;
	}
	
	protected String getEnderecoQuadra() {
		return enderecoQuadra;
	}
	
	protected void setEnderecoQuadra(String enderecoQuadra) {
		this.enderecoQuadra = enderecoQuadra;
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
