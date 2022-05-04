import java.util.ArrayList;
import java.util.Scanner;

public final class InterfaceUsuario {
	
	Scanner scanner = new Scanner(System.in);
	ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
	// Implementar m�todo que verifica se usuario tem permiss�o para gerir usu�rio
	
	public void menuUsuario() {
		
		int operadorDoMenu = 9;
		do {
			UtilidadesSimplificadas.exibeMensagem
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
		/* Chamar m�todo do menu principal*/
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
			
			UtilidadesSimplificadas.exibeMensagem("\nEscolha as Permiss�es do Usu�rio: "
										+ "\nGerir Quadras (sim/n�o): ");
			boolean acessoGestorQuadras = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
				
			UtilidadesSimplificadas.exibeMensagem("\nGerir Usu�rios (sim/n�o): ");
			boolean acessoGestorUsuarios = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
				
			UtilidadesSimplificadas.exibeMensagem("\nGerar/Acessar Relat�rios (sim/n�o): ");
			boolean acessoRelatorios = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
				
			UtilidadesSimplificadas.exibeMensagem("\nPermiss�es de Zelador (sim/n�o): ");
			boolean acessoZelador = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
				
			Usuario user = new Usuario(nomeUsuario, cpfUsuario, emailUsuario, senhaUsuario, acessoGestorQuadras, acessoGestorUsuarios, acessoRelatorios, acessoZelador);
			usuarios.add(user);
				
			UtilidadesSimplificadas.exibeMensagem("\nCadastro Realizado com Sucesso!\n");

		}catch(Exception e) {
			UtilidadesSimplificadas.exibeMensagem("\nCadastro interrompido!\n");
		}
	}
		
		
	public void menuExibirUsuario(){
		UtilidadesSimplificadas.exibeMensagem("\nLista de usu�rios:\n\n");
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
			
		UtilidadesSimplificadas.exibeMensagem("\nDigite o CPF do Usu�rio: ");
		int cpfDigitado = Integer.parseInt(scanner.nextLine());	
		Usuario thisUser;
		
		if( buscaUsuarioPor(cpfDigitado) != null ) {
			thisUser = buscaUsuarioPor(cpfDigitado);	
			UtilidadesSimplificadas.exibeMensagem( "\n1 [     DESABILITAR O USU�RIO      ]"
									+ "\n2 [      HABILITAR O USU�RIO       ]"
									+ "\n0 [         SAIR DO MENU           ]"
									+ "\nOP��O: \"");
			int operadorDoMenu = scanner.nextInt();
			scanner.nextLine();

			switch(operadorDoMenu) {

			case 1: 
				thisUser.desabilitarUsuario();
				UtilidadesSimplificadas.exibeMensagem( "\nUsu�rio desabilitado!\n");
				break;
	
			case 2:
				thisUser.habilitarUsuario();
				UtilidadesSimplificadas.exibeMensagem( "\nUsu�rio habilitado!\n");
				break;
	
			case 0:
				break;
	
			default:
				UtilidadesSimplificadas.exibeMensagem( "\nOP��O INV�LIDA!\n");
				break;
			}
		}
		else
			UtilidadesSimplificadas.exibeMensagem("\n\nUsu�rio inexistente!\n\n");
		menuUsuario();
	}	
	
	
	public void menuBloqueioUsuario() {
			
		UtilidadesSimplificadas.exibeMensagem("\nDigite o CPF do Usu�rio: ");
		int cpfDigitado = Integer.parseInt(scanner.nextLine());	
		Usuario thisUser;
			
		if( buscaUsuarioPor(cpfDigitado) != null ) {
			thisUser = buscaUsuarioPor(cpfDigitado);
			UtilidadesSimplificadas.exibeMensagem( "\n1 [      BLOQUEAR O USU�RIO        ]"
									+ "\n2 [     DESBLOQUEAR O USU�RIO      ]"
									+ "\n0 [         SAIR DO MENU           ]"
									+ "\nOP��O: \"");
			int operadorDoMenu = scanner.nextInt();
			scanner.nextLine();
		
			switch(operadorDoMenu) {
			
				case 1: 
					thisUser.bloquearUsuario();
					UtilidadesSimplificadas.exibeMensagem( "\nUsu�rio bloqueado!\n");
					break;
					
				case 2:
					thisUser.desbloquearUsuario();
					UtilidadesSimplificadas.exibeMensagem( "\nUsu�rio desbloqueado!\n");
					break;
					
				case 0:
					break;
					
				default:
					UtilidadesSimplificadas.exibeMensagem( "\nOP��O INV�LIDA!\n");
					break;
			}
		}
		else
			UtilidadesSimplificadas.exibeMensagem("\n\nUsu�rio inexistente!\n\n");
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
