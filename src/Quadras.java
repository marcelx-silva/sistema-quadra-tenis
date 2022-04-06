
public class Quadras extends Quadras_Reservas {
	
	
	private String nomeQuadra;
	private String enderecoQuadra;

	
	public void cadastraQuadra(int numero, String nome, String endereco, String tipo, boolean cobertura, boolean arquibancada, boolean area) {
		setCodigoQuadra(numero);
		setNomeQuadra(nome);
		setEnderecoQuadra(endereco);
		setTipoQuadra(tipo);
		setPossuiCobertura(cobertura);
		setPossuiArquibancada(arquibancada);
		setPossuiAreaDescanso(area);
	}
	
	
	public void bloqueiaQuadraParaAluguel() {
		this.setEstaBloqueada(true);
	}
	
	public void desbloqueiaQuadraParaAluguel() {
		this.setEstaBloqueada(false);
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
	
}
