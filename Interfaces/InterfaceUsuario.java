import java.util.ArrayList;
import java.util.Scanner;

public final class InterfaceUsuario {
	
	Scanner scanner = new Scanner(System.in);
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
	// Implementar m�todo que verifica se usuario tem permiss�o para gerir usu�rio
	
	public void menuUsuario() {
		
		int operadorDoMenu = 9;
		do {
			utilidades.exibeMensagem
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
			
			utilidades.exibeMensagem("\nEscolha as Permiss�es do Usu�rio: "
										+ "\nGerir Quadras (sim/n�o): ");
			boolean acessoGestorQuadras = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
				
			utilidades.exibeMensagem("\nGerir Usu�rios (sim/n�o): ");
			boolean acessoGestorUsuarios = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
				
			utilidades.exibeMensagem("\nGerar/Acessar Relat�rios (sim/n�o): ");
			boolean acessoRelatorios = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
				
			utilidades.exibeMensagem("\nPermiss�es de Zelador (sim/n�o): ");
			boolean acessoZelador = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
				
			Usuario user = new Usuario(nomeUsuario, cpfUsuario, emailUsuario, senhaUsuario, acessoGestorQuadras, acessoGestorUsuarios, acessoRelatorios, acessoZelador);
			usuarios.add(user);
				
			utilidades.exibeMensagem("\nCadastro Realizado com Sucesso!\n");

		}catch(Exception e) {
			utilidades.exibeMensagem("\nCadastro interrompido!\n");
		}
	}
		
		
	public void menuExibirUsuario(){
		utilidades.exibeMensagem("\nLista de usu�rios:\n\n");
		for(Usuario user:usuarios) {
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
			
		utilidades.exibeMensagem("\nDigite o CPF do Usu�rio: ");
		int cpfDigitado = Integer.parseInt(scanner.nextLine());	
		Usuario thisUser;
		
		if( buscaUsuarioPor(cpfDigitado) != null ) {
			thisUser = buscaUsuarioPor(cpfDigitado);	
			utilidades.exibeMensagem( "\n1 [     DESABILITAR O USU�RIO      ]"
									+ "\n2 [      HABILITAR O USU�RIO       ]"
									+ "\n0 [         SAIR DO MENU           ]"
									+ "\nOP��O: \"");
			int operadorDoMenu = scanner.nextInt();
			scanner.nextLine();

			switch(operadorDoMenu) {

			case 1: 
				thisUser.desabilitarUsuario();
				utilidades.exibeMensagem( "\nUsu�rio desabilitado!\n");
				break;
	
			case 2:
				thisUser.habilitarUsuario();
				utilidades.exibeMensagem( "\nUsu�rio habilitado!\n");
				break;
	
			case 0:
				break;
	
			default:
				utilidades.exibeMensagem( "\nOP��O INV�LIDA!\n");
				break;
			}
		}
		else
			utilidades.exibeMensagem("\n\nUsu�rio inexistente!\n\n");
		menuUsuario();
	}	
	
	
	public void menuBloqueioUsuario() {
			
		utilidades.exibeMensagem("\nDigite o CPF do Usu�rio: ");
		int cpfDigitado = Integer.parseInt(scanner.nextLine());	
		Usuario thisUser;
			
		if( buscaUsuarioPor(cpfDigitado) != null ) {
			thisUser = buscaUsuarioPor(cpfDigitado);
			utilidades.exibeMensagem( "\n1 [      BLOQUEAR O USU�RIO        ]"
									+ "\n2 [     DESBLOQUEAR O USU�RIO      ]"
									+ "\n0 [         SAIR DO MENU           ]"
									+ "\nOP��O: \"");
			int operadorDoMenu = scanner.nextInt();
			scanner.nextLine();
		
			switch(operadorDoMenu) {
			
				case 1: 
					thisUser.bloquearUsuario();
					utilidades.exibeMensagem( "\nUsu�rio bloqueado!\n");
					break;
					
				case 2:
					thisUser.desbloquearUsuario();
					utilidades.exibeMensagem( "\nUsu�rio desbloqueado!\n");
					break;
					
				case 0:
					break;
					
				default:
					utilidades.exibeMensagem( "\nOP��O INV�LIDA!\n");
					break;
			}
		}
		else
			utilidades.exibeMensagem("\n\nUsu�rio inexistente!\n\n");
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
