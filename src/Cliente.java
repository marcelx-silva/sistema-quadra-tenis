import java.util.ArrayList;

public class Cliente {
	
	private String codigo;
	private String nome;
	private String email;
	private String cpf;
	private String dataNascimento;	
	private boolean bloqueado = false;
	private boolean invalidado = false;
	private boolean habilitado = true;


	ArrayList <Cliente> clientes = new ArrayList<Cliente>();
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Cliente(String nome,String email, String cpf, String dataNascimento, boolean bloqueado, boolean invalidado, boolean habilitado){
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.bloqueado = bloqueado;
		this.invalidado = invalidado;
		this.habilitado = habilitado;
	}
	
	public void cadastrarCliente(String nome,String email, String cpf, String dataNascimento) {
		this.setNome(nome);
		this.setEmail(email);
		this.setCpf(cpf);
		this.setDataNascimento(dataNascimento);
		clientes.add(this);
	}
	
	public void bloqueiaCliente() {
		this.setBloqueado(true);
	}

	public void desbloqueiaCliente() {
		this.setBloqueado(false);
	}
	
	protected String getCodigo() {
		return codigo;
	}

	protected void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected String getCpf() {
		return cpf;
	}

	protected void setCpf(String cpf) {
		this.cpf = cpf;
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
	
	protected boolean isInvalidado() {
		return invalidado;
	}

	protected void setInvalidado(boolean invalidado) {
		this.invalidado = invalidado;
	}

	protected boolean isHabilitado() {
		return habilitado;
	}

	protected void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
}
