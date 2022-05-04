import java.util.ArrayList;
import java.util.Scanner;

public final class InterfaceUsuario {
	
	Scanner scanner = new Scanner(System.in);
	ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
	// Implementar método que verifica se usuario tem permissão para gerir usuário
	
	public void menuUsuario() {
		
		int operadorDoMenu = 9;
		do {
			UtilidadesSimplificadas.exibeMensagem
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
					UtilidadesSimplificadas.exibeMensagem("Voltando ao menu anterior!\n");
					break;
					
				default:
					UtilidadesSimplificadas.exibeMensagem("Ainda em desenvolvimento!\n");
					break;
			}
			
		}while(operadorDoMenu != 0);
		/* Chamar método do menu principal*/
	}
		
	public void menuCadastrarUsuario() {

		try {
			
			UtilidadesSimplificadas.exibeMensagem("Nome: ");
			String nomeUsuario = scanner.nextLine();
			
			UtilidadesSimplificadas.exibeMensagem("CPF: ");
			int cpfUsuario = Integer.parseInt(scanner.nextLine());	
				
			UtilidadesSimplificadas.exibeMensagem("Email: ");
			String emailUsuario = scanner.nextLine();
				
			UtilidadesSimplificadas.exibeMensagem("Senha: ");
			String senhaUsuario = scanner.nextLine();
			
			UtilidadesSimplificadas.exibeMensagem("\nEscolha as Permissões do Usuário: "
										+ "\nGerir Quadras (sim/não): ");
			boolean acessoGestorQuadras = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
				
			UtilidadesSimplificadas.exibeMensagem("\nGerir Usuários (sim/não): ");
			boolean acessoGestorUsuarios = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
				
			UtilidadesSimplificadas.exibeMensagem("\nGerar/Acessar Relatórios (sim/não): ");
			boolean acessoRelatorios = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
				
			UtilidadesSimplificadas.exibeMensagem("\nPermissões de Zelador (sim/não): ");
			boolean acessoZelador = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
				
			Usuario user = new Usuario(nomeUsuario, cpfUsuario, emailUsuario, senhaUsuario, acessoGestorQuadras, acessoGestorUsuarios, acessoRelatorios, acessoZelador);
			usuarios.add(user);
				
			UtilidadesSimplificadas.exibeMensagem("\nCadastro Realizado com Sucesso!\n");

		}catch(Exception e) {
			UtilidadesSimplificadas.exibeMensagem("\nCadastro interrompido!\n");
		}
	}
		
		
	public void menuExibirUsuario(){
		UtilidadesSimplificadas.exibeMensagem("\nLista de usuários:\n\n");
		for(Usuario user:usuarios) {
			UtilidadesSimplificadas.exibeMensagem("Nome: "+user.getNomeUsuario()+"\n");
			UtilidadesSimplificadas.exibeMensagem("CPF: "+user.getCpfUsuario()+"\n");
			UtilidadesSimplificadas.exibeMensagem("Email: "+user.getEmailUsuario()+"\n");
			UtilidadesSimplificadas.exibeMensagem("Acesso gestor quadras: "+user.isAcessoGestorQuadras()+"\n");
			UtilidadesSimplificadas.exibeMensagem("Acesso gestor usuarios: "+user.isAcessoGestorUsuarios()+"\n");
			UtilidadesSimplificadas.exibeMensagem("Acesso relatorios: "+user.isAcessoRelatorios()+"\n");
			UtilidadesSimplificadas.exibeMensagem("Acesso zelador: "+user.isAcessoZelador()+"\n\n");		
		}
	}
		
		
	public void menuDesabilitaUsuario() {
			
		UtilidadesSimplificadas.exibeMensagem("\nDigite o CPF do Usuário: ");
		int cpfDigitado = Integer.parseInt(scanner.nextLine());	
		Usuario thisUser;
		
		if( buscaUsuarioPor(cpfDigitado) != null ) {
			thisUser = buscaUsuarioPor(cpfDigitado);	
			UtilidadesSimplificadas.exibeMensagem( "\n1 [     DESABILITAR O USUÁRIO      ]"
									+ "\n2 [      HABILITAR O USUÁRIO       ]"
									+ "\n0 [         SAIR DO MENU           ]"
									+ "\nOPÇÃO: \"");
			int operadorDoMenu = scanner.nextInt();
			scanner.nextLine();

			switch(operadorDoMenu) {

			case 1: 
				thisUser.desabilitarUsuario();
				UtilidadesSimplificadas.exibeMensagem( "\nUsuário desabilitado!\n");
				break;
	
			case 2:
				thisUser.habilitarUsuario();
				UtilidadesSimplificadas.exibeMensagem( "\nUsuário habilitado!\n");
				break;
	
			case 0:
				break;
	
			default:
				UtilidadesSimplificadas.exibeMensagem( "\nOPÇÃO INVÁLIDA!\n");
				break;
			}
		}
		else
			UtilidadesSimplificadas.exibeMensagem("\n\nUsuário inexistente!\n\n");
		menuUsuario();
	}	
	
	
	public void menuBloqueioUsuario() {
			
		UtilidadesSimplificadas.exibeMensagem("\nDigite o CPF do Usuário: ");
		int cpfDigitado = Integer.parseInt(scanner.nextLine());	
		Usuario thisUser;
			
		if( buscaUsuarioPor(cpfDigitado) != null ) {
			thisUser = buscaUsuarioPor(cpfDigitado);
			UtilidadesSimplificadas.exibeMensagem( "\n1 [      BLOQUEAR O USUÁRIO        ]"
									+ "\n2 [     DESBLOQUEAR O USUÁRIO      ]"
									+ "\n0 [         SAIR DO MENU           ]"
									+ "\nOPÇÃO: \"");
			int operadorDoMenu = scanner.nextInt();
			scanner.nextLine();
		
			switch(operadorDoMenu) {
			
				case 1: 
					thisUser.bloquearUsuario();
					UtilidadesSimplificadas.exibeMensagem( "\nUsuário bloqueado!\n");
					break;
					
				case 2:
					thisUser.desbloquearUsuario();
					UtilidadesSimplificadas.exibeMensagem( "\nUsuário desbloqueado!\n");
					break;
					
				case 0:
					break;
					
				default:
					UtilidadesSimplificadas.exibeMensagem( "\nOPÇÃO INVÁLIDA!\n");
					break;
			}
		}
		else
			UtilidadesSimplificadas.exibeMensagem("\n\nUsuário inexistente!\n\n");
		menuUsuario();
	}
	
	public Usuario buscaUsuarioPor(int cpfDigitado) {
		for(Usuario user:usuarios) {
			if( user.getCpfUsuario() == cpfDigitado)
				return user;
		}
		return null;
	}
}
