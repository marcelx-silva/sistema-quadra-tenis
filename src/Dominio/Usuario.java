package Dominio;

import java.util.ArrayList;
import Utilitario.UtilidadesConversao;
import Utilitario.UtilidadesGUI;

public class Usuario {	
	
	private String nome, email, senha, codigo;	
	private boolean	estaDesabilitado, estaBloqueado, acessoGestorQuadras, acessoGestorUsuarios, acessoRelatorios, acessoZelador;
	private Usuario userAtual;
	static ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
	
	
	public Usuario(String cpfDigitado) {
		this.verificarUsuario(cpfDigitado);
	}
	
	public Usuario(String codigo, String nome, String email, String senha, boolean acessoGestorQuadras, boolean acessoGestorUsuarios, boolean acessoRelatorios, boolean acessoZelador) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
		this.setAcessoGestorQuadras(acessoGestorQuadras);
		this.setAcessoGestorUsuarios(acessoGestorUsuarios);
		this.setAcessoRelatorios(acessoRelatorios);
		this.setAcessoZelador(acessoZelador);
	}
	
	public Usuario(String nome, String email, String senha, boolean acessoGestorQuadras, boolean acessoGestorUsuarios, boolean acessoRelatorios, boolean acessoZelador) {
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
		this.setAcessoGestorQuadras(acessoGestorQuadras);
		this.setAcessoGestorUsuarios(acessoGestorUsuarios);
		this.setAcessoRelatorios(acessoRelatorios);
		this.setAcessoZelador(acessoZelador);
	}
	
	public boolean verificarUsuario(String login) {
		return (login == this.getEmail());
	}
	
	public void desabilitarUsuario() {
		this.setEstaDesabilitado(true);
	}
	
	public void habilitarUsuario() {
		this.setEstaDesabilitado(false);
	}
	
	public void bloquearUsuario() {
		this.setEstaBloqueado(true);
	}
	
	public void desbloquearUsuario() {
		this.setEstaBloqueado(false);
	}
	
	public void alteraUsuario(String alteracao, int operador) {
		switch(operador) {
		
			case 1:
				this.setNome(alteracao);
				break;
				
			case 2:
				this.setEmail(alteracao);
				break;
				
			case 3:
				this.setSenha(alteracao);
				break;
				
			case 4:
				this.setAcessoGestorQuadras(UtilidadesConversao.transformaString(alteracao));
				break;
				
			case 5:
				this.setAcessoGestorUsuarios(UtilidadesConversao.transformaString(alteracao));
				break;
				
			case 6:
				this.setAcessoRelatorios(UtilidadesConversao.transformaString(alteracao));
				break;
				
			case 7:
				this.setAcessoZelador(UtilidadesConversao.transformaString(alteracao));
				break;
				
			default:
				UtilidadesGUI.exibeMensagem("Opção Inválida!");
				break;
		}
	}
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public boolean isEstaDesabilitado() {
		return estaDesabilitado;
	}

	public boolean isEstaBloqueado() {
		return estaBloqueado;
	}
	
	public void setEstaDesabilitado(boolean estaDesabilitado) {
		this.estaDesabilitado = estaDesabilitado;
	}

	public void setEstaBloqueado(boolean estaBloqueado) {
		this.estaBloqueado = estaBloqueado;
	}
	
	public boolean isAcessoGestorQuadras() {
		return acessoGestorQuadras;
	}

	public boolean isAcessoGestorUsuarios() {
		return acessoGestorUsuarios;
	}

	public boolean isAcessoRelatorios() {
		return acessoRelatorios;
	}
	
	public boolean isAcessoZelador() {
		return acessoZelador;
	}
	
	public void setAcessoGestorQuadras(boolean acessoGestorQuadras) {  
		this.acessoGestorQuadras = acessoGestorQuadras;
	}
	
	public void setAcessoGestorUsuarios(boolean acessoGestorUsuarios) {
		this.acessoGestorUsuarios = acessoGestorUsuarios;
	}

	public void setAcessoRelatorios(boolean acessoRelatorios) {
		this.acessoRelatorios = acessoRelatorios;
	}

	public void setAcessoZelador(boolean acessoZelador) {
		this.acessoZelador = acessoZelador;
	}
	
	public void adicionarUsuario(Usuario user) {
		usuarios.add(user);
	}
	
	static public ArrayList<Usuario> getLista(){
		return usuarios;
	}
	
	static public Usuario buscaUsuarioPor(String email) {
		for(Usuario user:usuarios) {
			if(user.getEmail() == email)
				return user;
		}
		return null;
	}
	
	 public boolean UsuarioAutenticado(String cpfDigitado, String senhaDigitada){
		userAtual = Usuario.buscaUsuarioPor(cpfDigitado);
		
		if(userAtual != null )
			if( senhaDigitada.equals(userAtual.getSenha()))
				return true;
		return false;
	}
	
	 public Usuario getUsuarioAtual() {
		return userAtual;
	}
}