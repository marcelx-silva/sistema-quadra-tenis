
public class Usuario {
	
	private String 	nomeUsuario, 
					emailUsuario, 
					senhaUsuario;
	private int 	cpfUsuario;
					
	private boolean	estaDesabilitado,
					estaBloqueado,
					acessoGestorQuadras,
					acessoGestorUsuarios,
					acessoRelatorios,
					acessoZelador;
	
	public Usuario(int cpfDigitado) {
		this.verificarUsuario(cpfDigitado);
	}
	
	public Usuario(String nomeUsuario, int cpfUsuario, String emailUsuario, String senhaUsuario, 
			boolean acessoGestorQuadras, boolean acessoGestorUsuarios, boolean acessoRelatorios, 
			boolean acessoZelador) 
	{
		this.setNomeUsuario(nomeUsuario);
		this.setCpfUsuario(cpfUsuario);
		this.setEmailUsuario(emailUsuario);
		this.setSenhaUsuario(senhaUsuario);
		this.setAcessoGestorQuadras(acessoGestorQuadras);
		this.setAcessoGestorUsuarios(acessoGestorUsuarios);
		this.setAcessoRelatorios(acessoRelatorios);
		this.setAcessoZelador(acessoZelador);
	}

	public boolean verificarUsuario(int cpfDigitado) {
		if(cpfDigitado == this.getCpfUsuario())
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
	
	public int getCpfUsuario() {
		return cpfUsuario;
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

	public void setCpfUsuario(int codigoUsuario) {
		this.cpfUsuario = codigoUsuario;
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