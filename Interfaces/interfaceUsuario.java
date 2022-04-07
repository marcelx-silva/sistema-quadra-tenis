import java.util.Scanner;

public final class interfaceUsuario {
	
	Scanner scanner = new Scanner(System.in);
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	Usuario usuario = new Usuario();
	
	public interfaceUsuario() {
		
	}

	public void menulUsuario() {
		int operadorDoMenu = 0;
		do {
			utilidades.exibeMensagem("MENU USUÁRIO"
					+ "\n1 [       CADASTRAR USUÁRIO        ]"
					+ "\n2 [ HABILITAR/DESABILITAR USUÁRIOS ]"
					+ "\n3 [ BLOQUEAR/DESBLOQUEAR USUÁRIOS  ]"
					+ "\n4 [         ALTERAR DADOS          ]"
					+ "\n5 [      VISUALIZAR USUÁRIOS       ]"
					+ "\n6 [         SAIR DO MENU           ]"
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
					
				case 6:
					utilidades.exibeMensagem("Voltando ao menu anterior!\n");
					break;
					
				default:
					utilidades.exibeMensagem("Ainda em desenvolvimento!\n");
					break;
			}
			
		}while(operadorDoMenu != 6);
		
		
		//Usuario usuario = new Usuario();
	}
}
