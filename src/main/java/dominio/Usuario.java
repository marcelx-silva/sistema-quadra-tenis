package dominio;
import java.util.ArrayList;

public class Usuario {
		
	private String nome, email, senha, cpf, codigo;	
	private boolean	estaDesabilitado, estaBloqueado, acessoGestorQuadras, acessoGestorUsuarios, acessoRelatorios, acessoZelador;
	private Usuario userAtual;
	static ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
	
	
	public Usuario(String cpfDigitado) {
		this.verificarUsuario(cpfDigitado);
	}
	
	public Usuario(String codigo, String nome, String cpf, String email, String senha, boolean acessoGestorQuadras, boolean acessoGestorUsuarios, boolean acessoRelatorios, boolean acessoZelador) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setSenha(senha);
		this.setAcessoGestorQuadras(acessoGestorQuadras);
		this.setAcessoGestorUsuarios(acessoGestorUsuarios);
		this.setAcessoRelatorios(acessoRelatorios);
		this.setAcessoZelador(acessoZelador);
	}
	
	public Usuario(String nome, String cpf, String email, String senha, boolean acessoGestorQuadras, boolean acessoGestorUsuarios, boolean acessoRelatorios, boolean acessoZelador) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setSenha(senha);
		this.setAcessoGestorQuadras(acessoGestorQuadras);
		this.setAcessoGestorUsuarios(acessoGestorUsuarios);
		this.setAcessoRelatorios(acessoRelatorios);
		this.setAcessoZelador(acessoZelador);
	}
	
	public boolean verificarUsuario(String cpfDigitado) {
		return (cpfDigitado == this.getCpf());
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
				this.setCpf(alteracao);
				break;
				
			case 3:
				this.setEmail(alteracao);
				break;
				
			case 4:
				this.setSenha(alteracao);
				break;
				
			case 5:
				this.setAcessoGestorQuadras(UtilidadesConversao.transformaString(alteracao));
				break;
				
			case 6:
				this.setAcessoGestorUsuarios(UtilidadesConversao.transformaString(alteracao));
				break;
				
			case 7:
				this.setAcessoRelatorios(UtilidadesConversao.transformaString(alteracao));
				break;
				
			case 8:
				this.setAcessoZelador(UtilidadesConversao.transformaString(alteracao));
				break;
				
			default:
				UtilidadesGUI.exibeMensagem("Op��o Inv�lida!");
				break;
		}
	}
	
	protected String getNome() {
		return nome;
	}

	protected String getEmail() {
		return email;
	}

	protected String getSenha() {
		return senha;
	}
	
	protected String getCpf() {
		return cpf;
	}

	protected String getCodigo() {
		return codigo;
	}

	protected void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected void setSenha(String senha) {
		this.senha = senha;
	}

	protected void setCpf(String cpf) {
		this.cpf = cpf;
	}


	protected boolean isEstaDesabilitado() {
		return estaDesabilitado;
	}

	protected boolean isEstaBloqueado() {
		return estaBloqueado;
	}
	
	protected void setEstaDesabilitado(boolean estaDesabilitado) {
		this.estaDesabilitado = estaDesabilitado;
	}

	protected void setEstaBloqueado(boolean estaBloqueado) {
		this.estaBloqueado = estaBloqueado;
	}
	
	protected boolean isAcessoGestorQuadras() {
		return acessoGestorQuadras;
	}

	protected boolean isAcessoGestorUsuarios() {
		return acessoGestorUsuarios;
	}

	protected boolean isAcessoRelatorios() {
		return acessoRelatorios;
	}
	
	protected boolean isAcessoZelador() {
		return acessoZelador;
	}
	
	protected void setAcessoGestorQuadras(boolean acessoGestorQuadras) {  
		this.acessoGestorQuadras = acessoGestorQuadras;
	}
	
	protected void setAcessoGestorUsuarios(boolean acessoGestorUsuarios) {
		this.acessoGestorUsuarios = acessoGestorUsuarios;
	}

	protected void setAcessoRelatorios(boolean acessoRelatorios) {
		this.acessoRelatorios = acessoRelatorios;
	}

	protected void setAcessoZelador(boolean acessoZelador) {
		this.acessoZelador = acessoZelador;
	}
	
	public void adicionarUsuario(Usuario user) {
		usuarios.add(user);
	}
	
	static public ArrayList<Usuario> getLista(){
		return usuarios;
	}
	
	static public Usuario buscaUsuarioPor(String cpfDigitado) {
		for(Usuario user:usuarios) {
			if(user.getCpf() == cpfDigitado)
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
	
	protected Usuario getUsuarioAtual() {
		return userAtual;
	}
	
}