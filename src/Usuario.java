
public class Usuario {
	
	private String 	nomeUsuario, 
					emailUsuario, 
					senhaUsuario;
	private int 	codigoUsuario;
					
	private boolean	estaDesabilitado,
					estaBloqueado,
					acessoGestorQuadras,
					acessoGestorUsuarios,
					acessoRelatorios,
					acessoZelador;
	
	public Usuario() {
		
	}
	
	public Usuario(int codigoUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario, 
			boolean acessoGestorQuadras, boolean acessoGestorUsuarios, boolean acessoRelatorios, 
			boolean acessoZelador) 
	{
		setCodigoUsuario(codigoUsuario);
		setNomeUsuario(nomeUsuario);
		setEmailUsuario(emailUsuario);
		setSenhaUsuario(senhaUsuario);
		setAcessoGestorQuadras(acessoGestorQuadras);
		setAcessoGestorUsuarios(acessoGestorUsuarios);
		setAcessoRelatorios(acessoRelatorios);
		setAcessoZelador(acessoZelador);
	}

	public boolean verificarUsuario(int codigoDigitado) {
		if(codigoDigitado == this.getCodigoUsuario())
			return true;
		else
			return false;
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

	

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	
	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
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
	
}