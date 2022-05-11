import java.util.Scanner;

public final class interfaceCliente {
	
	Scanner scanner = new Scanner(System.in);
	
	void interfaceMenuCliente(){
		
		Clientes cliente = new Clientes("","","","",false);
		int operadorMenu = 0;
		
		do {

			UtilidadesSimplificadas.exibeMensagem("MENU CLIENTES"
					+ "\n1. CADASTRAR CLIENTE"
					+ "\n2. VISUALIZAR CLIENTES"
					+ "\n3. BLOQUEAR/DESBLOQUEAR CLIENTES"
					+ "\n4. ALTERAR DADOS DE CLIENTES"
					+ "\n5. SAIR DO MENU"
					+ "\nOPÇÃO: ");
			
			operadorMenu = scanner.nextInt();
			scanner.nextLine();
			
			switch(operadorMenu) {
				case 1:
					UtilidadesSimplificadas.exibeMensagem("Em Desenvolvimento!\n");
					break;
				case 2:
					UtilidadesSimplificadas.exibeMensagem("Em Desenvolvimento!\n");
					break;
				case 3:
					UtilidadesSimplificadas.exibeMensagem("Em Desenvolvimento!\n");
					break;
				case 4:
					UtilidadesSimplificadas.exibeMensagem("Em Desenvolvimento!\n");
					break;
				case  5:
					UtilidadesSimplificadas.exibeMensagem("Voltando ao menu anterior!\n");
					break;
				default:
					UtilidadesSimplificadas.exibeMensagem("Opção Inválida!! \n"); 
					

			}
			
		}while(operadorMenu!=5);
	}
			
		
}
