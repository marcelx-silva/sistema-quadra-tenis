import java.util.Scanner;

public class Acesso {
	
	Scanner scanner = new Scanner(System.in);
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	
	private String senhaDigitada;
	private int cpfDigitado;
	Usuario u;
	
	
	protected void setCpfDigitado(int cpf){
		cpfDigitado = cpf;
	}
	
	protected void setSenhaDigitada(String senha) {
		senhaDigitada = senha;
	}
	
	protected String getSenhaDigitada() {
		return senhaDigitada;
	}
	
	protected boolean UsuarioAutenticado(){
		u = Usuario.buscaUsuarioPor(cpfDigitado);
		
		if(u != null )
			if( getSenhaDigitada().equals( u.getSenhaUsuario()))
				return true;
		return false;
	}
	
	protected Usuario getUsuarioAtual() {
		return u;
	}
	
}
