import java.util.Scanner;

public final class InterfaceUsuario {
	
	Scanner scanner = new Scanner(System.in);
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	// Implementar m�todo que verifica se usuario tem permiss�o para gerir usuário
	
	public void menuUsuario() {
		
		int operadorDoMenu = 9;
		do {
			utilidades.exibeMensagem
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
					utilidades.exibeMensagem("Voltando ao menu anterior!\n");
					break;
					
				default:
					utilidades.exibeMensagem("Ainda em desenvolvimento!\n");
					break;
			}
			
		}while(operadorDoMenu != 0);
		/* Chamar m�todo do menu principal*/
	}
		
	public void menuCadastrarUsuario() {

		try {
			
			utilidades.exibeMensagem("Nome: ");
			String nomeUsuario = scanner.nextLine();
			
			utilidades.exibeMensagem("CPF: ");
			int cpfUsuario = Integer.parseInt(scanner.nextLine());	
				
			utilidades.exibeMensagem("Email: ");
			String emailUsuario = scanner.nextLine();
				
			utilidades.exibeMensagem("Senha: ");
			String senhaUsuario = scanner.nextLine();
			
			utilidades.exibeMensagem("\nEscolha as Permissões do Usuário: "
										+ "\nGerir Quadras (sim/não): ");
			boolean acessoGestorQuadras = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
				
			utilidades.exibeMensagem("\nGerir Usuários (sim/não): ");
			boolean acessoGestorUsuarios = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
				
			utilidades.exibeMensagem("\nGerar/Acessar Relatórios (sim/não): ");
			boolean acessoRelatorios = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
				
			utilidades.exibeMensagem("\nPermissões de Zelador (sim/não): ");
			boolean acessoZelador = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
				
			Usuario user = new Usuario(nomeUsuario, cpfUsuario, emailUsuario, senhaUsuario, acessoGestorQuadras, acessoGestorUsuarios, acessoRelatorios, acessoZelador);
			user.adicionarUsuario(user);
				
			utilidades.exibeMensagem("\nCadastro Realizado com Sucesso!\n");

		}catch(Exception e) {
			utilidades.exibeMensagem("\nCadastro interrompido!\n");
		}
	}
		
	public void menuExibirUsuario(){
		utilidades.exibeMensagem("\nLista de usuários:\n\n");
		for(Usuario user:Usuario.getLista()) {
			utilidades.exibeMensagem("Nome: "+user.getNomeUsuario()+"\n");
			utilidades.exibeMensagem("CPF: "+user.getCpfUsuario()+"\n");
			utilidades.exibeMensagem("Email: "+user.getEmailUsuario()+"\n");
			utilidades.exibeMensagem("Acesso gestor quadras: "+user.isAcessoGestorQuadras()+"\n");
			utilidades.exibeMensagem("Acesso gestor usuarios: "+user.isAcessoGestorUsuarios()+"\n");
			utilidades.exibeMensagem("Acesso relatorios: "+user.isAcessoRelatorios()+"\n");
			utilidades.exibeMensagem("Acesso zelador: "+user.isAcessoZelador()+"\n\n");		
		}
	}		
		
	public void menuDesabilitaUsuario() {
			
		utilidades.exibeMensagem("\nDigite o CPF do Usuário: ");
		Usuario user = Usuario.buscaUsuarioPor(Integer.parseInt(scanner.nextLine()));	
		
			if( user != null ) {
				utilidades.exibeMensagem( "\n1 [     DESABILITAR O USUÁRIO      ]"
										+ "\n2 [      HABILITAR O USUÁRIO       ]"
										+ "\n0 [         SAIR DO MENU           ]"
										+ "\nOPÇÃO: \"");
			int operadorDoMenu = scanner.nextInt();
			scanner.nextLine();

			switch(operadorDoMenu) {

			case 1: 
				user.desabilitarUsuario();
				utilidades.exibeMensagem( "\nUsuário desabilitado!\n");
				break;
	
			case 2:
				user.habilitarUsuario();
				utilidades.exibeMensagem( "\nUsuário habilitado!\n");
				break;
	
			case 0:
				break;
	
			default:
				utilidades.exibeMensagem( "\nOPÇÃO INVÁLIDA!\n");
				break;
			}
		}
		else
			utilidades.exibeMensagem("\n\nUsuário inexistente!\n\n");
		menuUsuario();
	}	
	
	
	public void menuBloqueioUsuario() {
			
		utilidades.exibeMensagem("\nDigite o CPF do Usuário: ");
		Usuario user = Usuario.buscaUsuarioPor(Integer.parseInt(scanner.nextLine()));	
		
		if( user != null ) {
			utilidades.exibeMensagem( "\n1 [      BLOQUEAR O USUÁRIO        ]"
									+ "\n2 [     DESBLOQUEAR O USUÁRIO      ]"
									+ "\n0 [         SAIR DO MENU           ]"
									+ "\nOPÇÃO: \"");
			int operadorDoMenu = scanner.nextInt();
			scanner.nextLine();
		
			switch(operadorDoMenu) {
			
				case 1: 
					user.bloquearUsuario();
					utilidades.exibeMensagem( "\nUsuário bloqueado!\n");
					break;
					
				case 2:
					user.desbloquearUsuario();
					utilidades.exibeMensagem( "\nUsuário desbloqueado!\n");
					break;
					
				case 0:
					break;
					
				default:
					utilidades.exibeMensagem( "\nOPÇÃO INVÁLIDA!\n");
					break;
			}
		}
		else
			utilidades.exibeMensagem("\n\nUsuário inexistente!\n\n");
		menuUsuario();
	}
	
	
	
}
