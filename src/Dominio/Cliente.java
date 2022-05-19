package Dominio;

public class Cliente {
	
	private String nomeCliente;
	private String emailCliente;
	private String cpfCliente;
	private String dataNascimento;	
	private boolean bloqueado = false;
	
	public Cliente(String nomeCliente, String cpfCliente) {
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
	}
	
	public Cliente(String nomeCliente,String emailCliente, String cpfCliente, String dataNascimento, boolean bloqueado){
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
		this.cpfCliente = cpfCliente;
		this.dataNascimento = dataNascimento;
		this.bloqueado = bloqueado;
	}
	
	public void cadastrarCliente(String nomeCliente,String emailCliente, String cpfCliente, String dataNascimento) {
		this.setNomeCliente(nomeCliente);
		this.setEmailCliente(emailCliente);
		this.setCpfCliente(cpfCliente);
		this.setDataNascimento(dataNascimento);
	}
	
	public void bloqueiaCliente() {
		this.setBloqueado(true);
	}

	public void desbloqueiaCliente() {
		this.setBloqueado(false);
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	protected void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	protected void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	protected void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	protected void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}
	
	protected void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
}
