package gui;
import java.util.Scanner;

import Utilitario.UtilidadesConversao;
import Utilitario.UtilidadesGUI;
import Dominio.*;

public class GUIAcesso {

	Scanner scanner = new Scanner(System.in);
	Usuario userAtual;
	
	protected void realizarAcesso(){
		
		UtilidadesGUI.exibeMensagem("Digite o CPF do usuário ");
		int cpfDigitado = Integer.parseInt(scanner.nextLine());
		UtilidadesGUI.exibeMensagem("Digite a senha do usuário ");
		String senhaDigitada = scanner.nextLine();
		
		if(userAtual.UsuarioAutenticado(cpfDigitado, senhaDigitada)) {
			UtilidadesGUI.exibeMensagem("Usuário autenticado. \n\nBem vindo!");
			//chamar metodo da interface menu principal
		}
		else {
			UtilidadesGUI.exibeMensagem("Usuário ou senha incorreta\nTente novamente\n\n");
			realizarAcesso();
		}		
	}		
	
}
