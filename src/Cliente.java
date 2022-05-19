import java.util.ArrayList;

public class Cliente {
	
	private String nomeCliente;
	private String emailCliente;
	private String cpfCliente;
	private String dataNascimento;	
	private boolean bloqueado = false;
	
	ArrayList <Cliente> clientes = new ArrayList<Cliente>();
	
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
		clientes.add(this);
	}
	
	public void bloqueiaCliente() {
		this.setBloqueado(true);
	}

	public void desbloqueiaCliente() {
		this.setBloqueado(false);
	}
	
	protected String getNomeCliente() {
		return nomeCliente;
	}

	protected void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	protected String getEmailCliente() {
		return emailCliente;
	}

	protected void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	protected String getCpfCliente() {
		return cpfCliente;
	}

	protected void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	protected String getDataNascimento() {
		return dataNascimento;
	}

	protected void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	protected boolean isBloqueado() {
		return bloqueado;
	}
	
	protected void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
}
