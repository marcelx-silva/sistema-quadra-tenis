
package Dominio;
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
	
	public Cliente(String codigo, String nome,String email, String cpf, String dataNascimento, boolean bloqueado, boolean invalidado, boolean habilitado){
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.bloqueado = bloqueado;
		this.invalidado = invalidado;
		this.habilitado = habilitado;
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
	
	public String getCodigo() {
		return codigo;

	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;

	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}
	
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	
	public boolean isInvalidado() {
		return invalidado;
	}

	public void setInvalidado(boolean invalidado) {
		this.invalidado = invalidado;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
}
