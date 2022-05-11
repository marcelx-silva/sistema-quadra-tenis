
public class Clientes {
	
	private String nome_cliente;
	private String email_cliente;
	private String cpf_cliente;
	private String data_nascimento;	
	private boolean bloqueado = false;
	
	
	public Clientes(String nome_cliente,String email_cliente, String cpf_cliente, String data_nascimento, boolean bloqueado){
		this.nome_cliente = nome_cliente;
		this.email_cliente = email_cliente;
		this.cpf_cliente = cpf_cliente;
		this.data_nascimento = data_nascimento;
		this.bloqueado = bloqueado;
	}
	
	public void cadastrarCliente(String nome_cliente,String email_cliente, String cpf_cliente, String data_nascimento) {
		this.setNome_cliente(nome_cliente);
		this.setEmail_cliente(email_cliente);
		this.setCpf_cliente(cpf_cliente);
		this.setData_nascimento(data_nascimento);
	}
	
	public void bloqueiaCliente() {
		this.setBloqueado(true);
	}

	public void desbloqueiaCliente() {
		this.setBloqueado(false);
	}
	
	
	protected String getNome_cliente() {
		return nome_cliente;
	}
	protected void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	protected String getEmail_cliente() {
		return email_cliente;
	}
	protected void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	protected String getCpf_cliente() {
		return cpf_cliente;
	}
	protected void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}
	protected String getData_nascimento() {
		return data_nascimento;
	}
	protected void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	protected boolean isBloqueado() {
		return bloqueado;
	}
	protected void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	
	

}
