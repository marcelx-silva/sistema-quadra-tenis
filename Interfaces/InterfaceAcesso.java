import java.util.Scanner;

public final class InterfaceAcesso {

	Scanner scanner = new Scanner(System.in);
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	Acesso acess = new Acesso();
	
	protected void realizarAcesso(){
		
		utilidades.exibeMensagem("Digite o CPF do usuário ");
		acess.setCpfDigitado(Integer.parseInt(scanner.nextLine()));
		utilidades.exibeMensagem("Digite a senha do usuário ");
		acess.setSenhaDigitada(scanner.nextLine());
		
		if(acess.UsuarioAutenticado()) {
			utilidades.exibeMensagem("Usuário autenticado. \n\nBem vindo!");
			//chamar metodo da interface menu principal
		}
		else {
			utilidades.exibeMensagem("Usuário ou senha incorreta\nTente novamente\n\n");
			realizarAcesso();
		}		
	}		
}

