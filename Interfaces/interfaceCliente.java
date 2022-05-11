import java.util.Scanner;

public final class interfaceCliente {
	
	Scanner scanner = new Scanner(System.in);
	
	void interfaceMenuCliente(){
		
		Clientes cliente = new Clientes("","","","",false);
		int operadorMenu = 0;
		
		do {

			UtilidadesGUI.exibeMensagem("MENU CLIENTES"
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
					this.interfaceCadastroCliente(cliente);
					break;
				case 2:
					UtilidadesGUI.exibeMensagem("Em Desenvolvimento!\n");
					break;
				case 3:
					UtilidadesGUI.exibeMensagem("Em Desenvolvimento!\n");
					break;
				case 4:
					UtilidadesGUI.exibeMensagem("Em Desenvolvimento!\n");
					break;
				case  5:
					UtilidadesGUI.exibeMensagem("Voltando ao menu anterior!\n");
					break;
				default:
					UtilidadesGUI.exibeMensagem("Opção Inválida!! \n"); 
					

			}
			
		}while(operadorMenu!=5);
	}
	
	void interfaceCadastroCliente(Clientes cliente){
		
		String nome;
		String email;
		String data_nascimento;
		String cpf;
		
		UtilidadesGUI.exibeMensagem("Nome do Cliente:");
		nome = scanner.nextLine();
		
		UtilidadesGUI.exibeMensagem("Email:");
		email = scanner.nextLine();
	
		UtilidadesGUI.exibeMensagem("Data de Nascimento:");
		data_nascimento = scanner.nextLine();
		
		UtilidadesGUI.exibeMensagem("CPF: ");
		cpf = scanner.nextLine();
		
		cliente.cadastrarCliente(nome, email, cpf, data_nascimento);
		
		
	}
			
		
}
