
package Dominio;
import java.time.LocalDate;

public class Cliente {
	
	private String codigo;
	private String nome;
	private String email;
	private String cpf;
	private LocalDate dataNascimento;	
	private String numeroCelular;
	private boolean bloqueado = false;
	private boolean invalidado = false;
	private boolean habilitado = true;
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Cliente(String codigo, String nome,String email, String cpf, String celular, LocalDate dataNascimento, boolean bloqueado, boolean invalidado, boolean habilitado){
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.numeroCelular = celular;
		this.dataNascimento = dataNascimento;
		this.bloqueado = bloqueado;
		this.invalidado = invalidado;
		this.habilitado = habilitado;
	}
	
	public Cliente(String nome,String email, String cpf, String celular, LocalDate dataNascimento, boolean bloqueado, boolean invalidado, boolean habilitado){
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.numeroCelular = celular;
		this.dataNascimento = dataNascimento;
		this.bloqueado = bloqueado;
		this.invalidado = invalidado;
		this.habilitado = habilitado;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
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

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
}
