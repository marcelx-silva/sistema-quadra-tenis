<<<<<<<< HEAD:InterfacesGUI/InterfaceUsuario.java
import java.util.ArrayList;
import java.util.Scanner;
import Dominio.Usuario;

public final class InterfaceUsuario {
	
	Scanner scanner = new Scanner(System.in);
	ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
	// Implementar método que verifica se usuario tem permissão para gerir usuário
	
	public void menuUsuario() {
		
		int operadorDoMenu = 9;
		do {
			UtilidadesGUI.exibeMensagem
					(  "          + MENU USUÁRIO +\n"
					+ "\n1 [       CADASTRAR USUÁRIO        ]"
					+ "\n2 [ HABILITAR/DESABILITAR USUÁRIOS ]"
					+ "\n3 [ BLOQUEAR/DESBLOQUEAR USUÁRIOS  ]"
					+ "\n4 [         ALTERAR DADOS          ]"
					+ "\n5 [      VISUALIZAR USUÁRIOS       ]"
					+ "\n0 [         SAIR DO MENU           ]"
					+ "\nOPÇÃO: ");
			
			operadorDoMenu = scanner.nextInt();
			scanner.nextLine();
			
			switch(operadorDoMenu){
				
				case 1:
					menuCadastrarUsuario();
					break;
					
				case 2:
					menuDesabilitaUsuario();
					break;
				case 3:
					menuBloqueioUsuario();
					break;
				//case 4:
					//break;
				case 5:
					menuExibirUsuario();
					break;
				case 6:
					UtilidadesGUI.exibeMensagem("Voltando ao menu anterior!\n");
					break;
					
				default:
					UtilidadesGUI.exibeMensagem("Ainda em desenvolvimento!\n");
					break;
			}
			
		}while(operadorDoMenu != 0);
		/* Chamar método do menu principal*/
	}
		
	public void menuCadastrarUsuario() {

		try {
			
			UtilidadesGUI.exibeMensagem("Nome: ");
			String nomeUsuario = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("CPF: ");
			String cpfUsuario = scanner.nextLine();	
				
			UtilidadesGUI.exibeMensagem("Email: ");
			String emailUsuario = scanner.nextLine();
				
			UtilidadesGUI.exibeMensagem("Senha: ");
			String senhaUsuario = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("\nEscolha as Permissões do Usuário: "
										+ "\nGerir Quadras (sim/não): ");
			boolean acessoGestorQuadras = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
				
			UtilidadesGUI.exibeMensagem("\nGerir Usuários (sim/não): ");
			boolean acessoGestorUsuarios = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
				
			UtilidadesGUI.exibeMensagem("\nGerar/Acessar Relatórios (sim/não): ");
			boolean acessoRelatorios = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
				
			UtilidadesGUI.exibeMensagem("\nPermissões de Zelador (sim/não): ");
			boolean acessoZelador = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
				
			Usuario user = new Usuario(nomeUsuario, cpfUsuario, emailUsuario, senhaUsuario, acessoGestorQuadras, acessoGestorUsuarios, acessoRelatorios, acessoZelador);
			usuarios.add(user);
				
			UtilidadesGUI.exibeMensagem("\nCadastro Realizado com Sucesso!\n");

		}catch(Exception e) {
			UtilidadesGUI.exibeMensagem("\nCadastro interrompido!\n");
		}
	}
		
		
	public void menuExibirUsuario(){
		UtilidadesGUI.exibeMensagem("\nLista de usuários:\n\n");
		for(Usuario user:usuarios) {
			UtilidadesGUI.exibeMensagem("Nome: "+user.getNomeUsuario()+"\n");
			UtilidadesGUI.exibeMensagem("CPF: "+user.getCpfUsuario()+"\n");
			UtilidadesGUI.exibeMensagem("Email: "+user.getEmailUsuario()+"\n");
			UtilidadesGUI.exibeMensagem("Acesso gestor quadras: "+user.isAcessoGestorQuadras()+"\n");
			UtilidadesGUI.exibeMensagem("Acesso gestor usuarios: "+user.isAcessoGestorUsuarios()+"\n");
			UtilidadesGUI.exibeMensagem("Acesso relatorios: "+user.isAcessoRelatorios()+"\n");
			UtilidadesGUI.exibeMensagem("Acesso zelador: "+user.isAcessoZelador()+"\n\n");		
		}
	}
		
		
	public void menuDesabilitaUsuario() {
			
		UtilidadesGUI.exibeMensagem("\nDigite o CPF do Usuário: ");
		String cpfDigitado = scanner.nextLine();	
		Usuario thisUser;
		
		if( buscaUsuarioPor(cpfDigitado) != null ) {
			thisUser = buscaUsuarioPor(cpfDigitado);	
			UtilidadesGUI.exibeMensagem( "\n1 [     DESABILITAR O USUÁRIO      ]"
									+ "\n2 [      HABILITAR O USUÁRIO       ]"
									+ "\n0 [         SAIR DO MENU           ]"
									+ "\nOPÇÃO: \"");
			int operadorDoMenu = scanner.nextInt();
			scanner.nextLine();

			switch(operadorDoMenu) {

			case 1: 
				thisUser.desabilitarUsuario();
				UtilidadesGUI.exibeMensagem( "\nUsuário desabilitado!\n");
				break;
	
			case 2:
				thisUser.habilitarUsuario();
				UtilidadesGUI.exibeMensagem( "\nUsuário habilitado!\n");
				break;
	
			case 0:
				break;
	
			default:
				UtilidadesGUI.exibeMensagem( "\nOPÇÃO INVÁLIDA!\n");
				break;
			}
		}
		else
			UtilidadesGUI.exibeMensagem("\n\nUsuário inexistente!\n\n");
		menuUsuario();
	}	
	
	
	public void menuBloqueioUsuario() {
			
		UtilidadesGUI.exibeMensagem("\nDigite o CPF do Usuário: ");
		String cpfDigitado = scanner.nextLine();	
		Usuario thisUser;
			
		if( buscaUsuarioPor(cpfDigitado) != null ) {
			thisUser = buscaUsuarioPor(cpfDigitado);
			UtilidadesGUI.exibeMensagem( "\n1 [      BLOQUEAR O USUÁRIO        ]"
									+ "\n2 [     DESBLOQUEAR O USUÁRIO      ]"
									+ "\n0 [         SAIR DO MENU           ]"
									+ "\nOPÇÃO: \"");
			int operadorDoMenu = scanner.nextInt();
			scanner.nextLine();
		
			switch(operadorDoMenu) {
			
				case 1: 
					thisUser.bloquearUsuario();
					UtilidadesGUI.exibeMensagem( "\nUsuário bloqueado!\n");
					break;
					
				case 2:
					thisUser.desbloquearUsuario();
					UtilidadesGUI.exibeMensagem( "\nUsuário desbloqueado!\n");
					break;
					
				case 0:
					break;
					
				default:
					UtilidadesGUI.exibeMensagem( "\nOPÇÃO INVÁLIDA!\n");
					break;
			}
		}
		else
			UtilidadesGUI.exibeMensagem("\n\nUsuário inexistente!\n\n");
		menuUsuario();
	}
	
	public Usuario buscaUsuarioPor(String cpfDigitado) {
		for(Usuario user:usuarios) {
			if( user.getCpfUsuario() == cpfDigitado)
				return user;
		}
		return null;
	}
}
========
import java.util.ArrayList;
import java.util.Scanner;

public class GUIUsuario {
	Scanner scanner = new Scanner(System.in);
	ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
	// Implementar método que verifica se usuario tem permissão para gerir usuário
	
	public void GUImenuUsuario() {
		
		int operadorDoMenu = 9;
		do {
			UtilidadesGUI.exibeMensagem
					(  "          + MENU USUÁRIO +\n"
					+ "\n1 [       CADASTRAR USUÁRIO        ]"
					+ "\n2 [ HABILITAR/DESABILITAR USUÁRIOS ]"
					+ "\n3 [ BLOQUEAR/DESBLOQUEAR USUÁRIOS  ]"
					+ "\n4 [         ALTERAR DADOS          ]"
					+ "\n5 [      VISUALIZAR USUÁRIOS       ]"
					+ "\n0 [         SAIR DO MENU           ]"
					+ "\nOPÇÃO: ");
			
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
		/* Chamar método do menu principal*/
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
			
			UtilidadesGUI.exibeMensagem("\nEscolha as Permissões do Usuário: "
										+ "\nGerir Quadras (sim/não): ");
			boolean acessoGestorQuadras = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
				
			UtilidadesGUI.exibeMensagem("\nGerir Usuários (sim/não): ");
			boolean acessoGestorUsuarios = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
				
			UtilidadesGUI.exibeMensagem("\nGerar/Acessar Relatórios (sim/não): ");
			boolean acessoRelatorios = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
				
			UtilidadesGUI.exibeMensagem("\nPermissões de Zelador (sim/não): ");
			boolean acessoZelador = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
				
			Usuario user = new Usuario(nomeUsuario, cpfUsuario, emailUsuario, senhaUsuario, acessoGestorQuadras, acessoGestorUsuarios, acessoRelatorios, acessoZelador);
			usuarios.add(user);
				
			UtilidadesGUI.exibeMensagem("\nCadastro Realizado com Sucesso!\n");

		}catch(Exception e) {
			UtilidadesGUI.exibeMensagem("\nCadastro interrompido!\n");
		}
	}
		
		
	public void GUIExibirUsuario(){
		UtilidadesGUI.exibeMensagem("\nLista de usuários:\n\n");
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
			
		UtilidadesGUI.exibeMensagem("\nDigite o CPF do Usuário: ");
		String cpfDigitado = scanner.nextLine();	
		Usuario thisUser;
		
		if( buscaUsuarioPor(cpfDigitado) != null ) {
			thisUser = buscaUsuarioPor(cpfDigitado);	
			UtilidadesGUI.exibeMensagem( "\n1 [     DESABILITAR O USUÁRIO      ]"
									+ "\n2 [      HABILITAR O USUÁRIO       ]"
									+ "\n0 [         SAIR DO MENU           ]"
									+ "\nOPÇÃO: \"");
			int operadorDoMenu = scanner.nextInt();
			scanner.nextLine();

			switch(operadorDoMenu) {

			case 1: 
				thisUser.desabilitarUsuario();
				UtilidadesGUI.exibeMensagem( "\nUsuário desabilitado!\n");
				break;
	
			case 2:
				thisUser.habilitarUsuario();
				UtilidadesGUI.exibeMensagem( "\nUsuário habilitado!\n");
				break;
	
			case 0:
				break;
	
			default:
				UtilidadesGUI.exibeMensagem( "\nOPÇÃO INVÁLIDA!\n");
				break;
			}
		}
		else
			UtilidadesGUI.exibeMensagem("\n\nUsuário inexistente!\n\n");
		GUImenuUsuario();
	}	
	
	
	public void GUIBloqueioUsuario() {
			
		UtilidadesGUI.exibeMensagem("\nDigite o CPF do Usuário: ");
		String cpfDigitado = scanner.nextLine();	
		Usuario thisUser;
			
		if( buscaUsuarioPor(cpfDigitado) != null ) {
			thisUser = buscaUsuarioPor(cpfDigitado);
			UtilidadesGUI.exibeMensagem( "\n1 [      BLOQUEAR O USUÁRIO        ]"
									+ "\n2 [     DESBLOQUEAR O USUÁRIO      ]"
									+ "\n0 [         SAIR DO MENU           ]"
									+ "\nOPÇÃO: \"");
			int operadorDoMenu = scanner.nextInt();
			scanner.nextLine();
		
			switch(operadorDoMenu) {
			
				case 1: 
					thisUser.bloquearUsuario();
					UtilidadesGUI.exibeMensagem( "\nUsuário bloqueado!\n");
					break;
					
				case 2:
					thisUser.desbloquearUsuario();
					UtilidadesGUI.exibeMensagem( "\nUsuário desbloqueado!\n");
					break;
					
				case 0:
					break;
					
				default:
					UtilidadesGUI.exibeMensagem( "\nOPÇÃO INVÁLIDA!\n");
					break;
			}
		}
		else
			UtilidadesGUI.exibeMensagem("\n\nUsuário inexistente!\n\n");
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
>>>>>>>> Development:GUIs/GUIUsuario.java
