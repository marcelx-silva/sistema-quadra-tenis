public class Usuario {
	
	private String nomeUsuario, emailUsuario, senhaUsuario, cpfUsuario;	
	private boolean	estaDesabilitado, estaBloqueado, acessoGestorQuadras, acessoGestorUsuarios, acessoRelatorios, acessoZelador;
	
	public Usuario(String cpfDigitado) {
		this.verificarUsuario(cpfDigitado);
	}
	
	public Usuario(String nomeUsuario, String cpfUsuario, String emailUsuario, String senhaUsuario, boolean acessoGestorQuadras, boolean acessoGestorUsuarios, boolean acessoRelatorios, boolean acessoZelador) {
		this.setNomeUsuario(nomeUsuario);
		this.setCpfUsuario(cpfUsuario);
		this.setEmailUsuario(emailUsuario);
		this.setSenhaUsuario(senhaUsuario);
		this.setAcessoGestorQuadras(acessoGestorQuadras);
		this.setAcessoGestorUsuarios(acessoGestorUsuarios);
		this.setAcessoRelatorios(acessoRelatorios);
		this.setAcessoZelador(acessoZelador);
	}
	
	public boolean verificarUsuario(String cpfDigitado) {
		return (cpfDigitado == this.getCpfUsuario());
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
	
	protected String getCpfUsuario() {
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

	protected void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
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
	
}