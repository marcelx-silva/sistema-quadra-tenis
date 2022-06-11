

import java.util.ArrayList;
import java.util.Scanner;
import Utilitario.UtilidadesConversao;
import Utilitario.UtilidadesGUI;
import Dominio.*;

public class GUIUsuario {
	Scanner scanner = new Scanner(System.in);
	ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
	// Implementar m�todo que verifica se usuario tem permiss�o para gerir usu�rio
	
	public void GUImenuUsuario() {
		
		int operadorDoMenu = 9;
		do {
			UtilidadesGUI.exibeMensagem
					(  "          + MENU USU�RIO +\n"
					+ "\n1 [       CADASTRAR USU�RIO        ]"
					+ "\n2 [ HABILITAR/DESABILITAR USU�RIOS ]"
					+ "\n3 [ BLOQUEAR/DESBLOQUEAR USU�RIOS  ]"
					+ "\n4 [         ALTERAR DADOS          ]"
					+ "\n5 [      VISUALIZAR USU�RIOS       ]"
					+ "\n0 [         SAIR DO MENU           ]"
					+ "\nOP��O: ");
			
			operadorDoMenu = scanner.nextInt();
			scanner.nextLine();
			
			switch(operadorDoMenu){
				
				case 1:
					GUICadastrarUsuario();
					break;
					
				case 2:
					GUIDesabilitaUsuario();
					break;
				case 3:
					GUIBloqueioUsuario();
					break;
				//case 4:
					//break;
				case 5:
					GUIExibirUsuario();
					break;
				case 6:
					UtilidadesGUI.exibeMensagem("Voltando ao menu anterior!\n");
					break;
					
				default:
					UtilidadesGUI.exibeMensagem("Ainda em desenvolvimento!\n");
					break;
			}
			
		}while(operadorDoMenu != 0);
		/* Chamar m�todo do menu principal*/
	}
		
	public void GUICadastrarUsuario() {

		try {
			
			UtilidadesGUI.exibeMensagem("Nome: ");
			String nomeUsuario = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("CPF: ");
			String cpfUsuario = scanner.nextLine();	
				
			UtilidadesGUI.exibeMensagem("Email: ");
			String emailUsuario = scanner.nextLine();
				
			UtilidadesGUI.exibeMensagem("Senha: ");
			String senhaUsuario = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("\nEscolha as Permiss�es do Usu�rio: "
										+ "\nGerir Quadras (sim/n�o): ");
			boolean acessoGestorQuadras = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
				
			UtilidadesGUI.exibeMensagem("\nGerir Usu�rios (sim/n�o): ");
			boolean acessoGestorUsuarios = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
				
			UtilidadesGUI.exibeMensagem("\nGerar/Acessar Relat�rios (sim/n�o): ");
			boolean acessoRelatorios = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
				
			UtilidadesGUI.exibeMensagem("\nPermiss�es de Zelador (sim/n�o): ");
			boolean acessoZelador = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
				
			Usuario user = new Usuario(nomeUsuario, cpfUsuario, emailUsuario, senhaUsuario, acessoGestorQuadras, acessoGestorUsuarios, acessoRelatorios, acessoZelador);
			usuarios.add(user);
				
			UtilidadesGUI.exibeMensagem("\nCadastro Realizado com Sucesso!\n");

		}catch(Exception e) {
			UtilidadesGUI.exibeMensagem("\nCadastro interrompido!\n");
		}
	}
		
		
	public void GUIExibirUsuario(){
		UtilidadesGUI.exibeMensagem("\nLista de usu�rios:\n\n");
		for(Usuario user:usuarios) {
			UtilidadesGUI.exibeMensagem("Nome: "+user.getNome()+"\n");
			UtilidadesGUI.exibeMensagem("CPF: "+user.getCpf()+"\n");
			UtilidadesGUI.exibeMensagem("Email: "+user.getEmail()+"\n");
			UtilidadesGUI.exibeMensagem("Acesso gestor quadras: "+user.isAcessoGestorQuadras()+"\n");
			UtilidadesGUI.exibeMensagem("Acesso gestor usuarios: "+user.isAcessoGestorUsuarios()+"\n");
			UtilidadesGUI.exibeMensagem("Acesso relatorios: "+user.isAcessoRelatorios()+"\n");
			UtilidadesGUI.exibeMensagem("Acesso zelador: "+user.isAcessoZelador()+"\n\n");		
		}
	}
		
		
	public void GUIDesabilitaUsuario() {
			
		UtilidadesGUI.exibeMensagem("\nDigite o CPF do Usu�rio: ");
		String cpfDigitado = scanner.nextLine();	
		Usuario thisUser;
		
		if( buscaUsuarioPor(cpfDigitado) != null ) {
			thisUser = buscaUsuarioPor(cpfDigitado);	
			UtilidadesGUI.exibeMensagem( "\n1 [     DESABILITAR O USU�RIO      ]"
									+ "\n2 [      HABILITAR O USU�RIO       ]"
									+ "\n0 [         SAIR DO MENU           ]"
									+ "\nOP��O: \"");
			int operadorDoMenu = scanner.nextInt();
			scanner.nextLine();

			switch(operadorDoMenu) {

			case 1: 
				thisUser.desabilitarUsuario();
				UtilidadesGUI.exibeMensagem( "\nUsu�rio desabilitado!\n");
				break;
	
			case 2:
				thisUser.habilitarUsuario();
				UtilidadesGUI.exibeMensagem( "\nUsu�rio habilitado!\n");
				break;
	
			case 0:
				break;
	
			default:
				UtilidadesGUI.exibeMensagem( "\nOP��O INV�LIDA!\n");
				break;
			}
		}
		else
			UtilidadesGUI.exibeMensagem("\n\nUsu�rio inexistente!\n\n");
		GUImenuUsuario();
	}	
	
	
	public void GUIBloqueioUsuario() {
			
		UtilidadesGUI.exibeMensagem("\nDigite o CPF do Usu�rio: ");
		String cpfDigitado = scanner.nextLine();	
		Usuario thisUser;
			
		if( buscaUsuarioPor(cpfDigitado) != null ) {
			thisUser = buscaUsuarioPor(cpfDigitado);
			UtilidadesGUI.exibeMensagem( "\n1 [      BLOQUEAR O USU�RIO        ]"
									+ "\n2 [     DESBLOQUEAR O USU�RIO      ]"
									+ "\n0 [         SAIR DO MENU           ]"
									+ "\nOP��O: \"");
			int operadorDoMenu = scanner.nextInt();
			scanner.nextLine();
		
			switch(operadorDoMenu) {
			
				case 1: 
					thisUser.bloquearUsuario();
					UtilidadesGUI.exibeMensagem( "\nUsu�rio bloqueado!\n");
					break;
					
				case 2:
					thisUser.desbloquearUsuario();
					UtilidadesGUI.exibeMensagem( "\nUsu�rio desbloqueado!\n");
					break;
					
				case 0:
					break;
					
				default:
					UtilidadesGUI.exibeMensagem( "\nOP��O INV�LIDA!\n");
					break;
			}
		}
		else
			UtilidadesGUI.exibeMensagem("\n\nUsu�rio inexistente!\n\n");
		GUImenuUsuario();
	}
	
	public Usuario buscaUsuarioPor(String cpfDigitado) {
		for(Usuario user:usuarios) {
			if( user.getCpf() == cpfDigitado)
				return user;
		}
		return null;
	}
}

