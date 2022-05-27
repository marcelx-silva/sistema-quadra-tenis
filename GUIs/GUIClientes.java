import java.util.Scanner;
import Dominio.Cliente;

import Utilitario.UtilidadesConversao;
import Utilitario.UtilidadesGUI;
import Dominio.*;

public class GUIClientes {

Scanner scanner = new Scanner(System.in);
	
	
	void GUIMenuCliente(){
		
		Cliente cliente = new Cliente("","","","",false,false,true);
		int operadorMenu = 0;
		
		do {

			UtilidadesGUI.exibeMensagem("MENU CLIENTES"
					+ "\n1. CADASTRAR CLIENTE"
					+ "\n2. VISUALIZAR CLIENTES"
					+ "\n3. BLOQUEAR/DESBLOQUEAR CLIENTES"
					+ "\n4. ALTERAR DADOS DE CLIENTES"
					+ "\n5. SAIR DO MENU"
					+ "\nOP��O: ");
			
			operadorMenu = scanner.nextInt();
			scanner.nextLine();
			
			switch(operadorMenu) {
				case 1:
					this.GUICadastroCliente(cliente);
					break;
					
				case 2:
					this.GUIExibirCliente(cliente);
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
					UtilidadesGUI.exibeMensagem("Op��o Inv�lida!! \n"); 
					

			}
			
		}while(operadorMenu!=5);
	}
	
	void GUICadastroCliente(Cliente cliente){
		
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
	
	void GUIExibirCliente(Cliente cliente){
		
		cliente = cliente.clientes.get(0);
		
		UtilidadesGUI.exibeMensagem("Nome: " + cliente.getNome());
		UtilidadesGUI.exibeMensagem("\nEmail: " + cliente.getEmail());
		UtilidadesGUI.exibeMensagem("\nData de Nascimento: " + cliente.getDataNascimento());
		UtilidadesGUI.exibeMensagem("\nCPF: " + cliente.getCpf());
	}
}
