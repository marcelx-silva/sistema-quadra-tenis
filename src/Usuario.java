import java.util.ArrayList;

public class Usuario {
	
	private String nomeUsuario, emailUsuario, senhaUsuario;
	private int cpfUsuario;		
	private boolean	estaDesabilitado, estaBloqueado, acessoGestorQuadras, acessoGestorUsuarios, acessoRelatorios, acessoZelador;
	static ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
	
	public Usuario(String nomeUsuario, int cpfUsuario, String emailUsuario, String senhaUsuario, 
				boolean acessoGestorQuadras, boolean acessoGestorUsuarios, boolean acessoRelatorios, boolean acessoZelador) {
		this.setNomeUsuario(nomeUsuario);
		this.setCpfUsuario(cpfUsuario);
		this.setEmailUsuario(emailUsuario);
		this.setSenhaUsuario(senhaUsuario);
		this.setAcessoGestorQuadras(acessoGestorQuadras);
		this.setAcessoGestorUsuarios(acessoGestorUsuarios);
		this.setAcessoRelatorios(acessoRelatorios);
		this.setAcessoZelador(acessoZelador);
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

	protected String getNomeUsuario() {
		return nomeUsuario;
	}

	protected String getEmailUsuario() {
		return emailUsuario;
	}

	protected String getSenhaUsuario() {
		return senhaUsuario;
	}
	
	protected int getCpfUsuario() {
		return cpfUsuario;
	}

	protected void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	protected void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	protected void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	protected void setCpfUsuario(int codigoUsuario) {
		this.cpfUsuario = codigoUsuario;
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
	
	static public Usuario buscaUsuarioPor(int cpfDigitado) {
		for(Usuario user:usuarios) {
			if( user.getCpfUsuario() == cpfDigitado)
				return user;
		}
		return null;
	}
}