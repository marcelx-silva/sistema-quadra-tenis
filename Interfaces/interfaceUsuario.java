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
			utilidades.exibeMensagem("MENU USU�RIO"
					+ "\n1 [       CADASTRAR USU�RIO        ]"
					+ "\n2 [ HABILITAR/DESABILITAR USU�RIOS ]"
					+ "\n3 [ BLOQUEAR/DESBLOQUEAR USU�RIOS  ]"
					+ "\n4 [         ALTERAR DADOS          ]"
					+ "\n5 [      VISUALIZAR USU�RIOS       ]"
					+ "\n6 [         SAIR DO MENU           ]"
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
