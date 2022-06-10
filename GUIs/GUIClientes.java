
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Dominio.Cliente;


import Utilitario.UtilidadesConversao;
import Utilitario.UtilidadesGUI;
import implementacaoDAO.ImpClienteDAO;



public class GUIClientes {

	Scanner scanner = new Scanner(System.in);
	ImpClienteDAO clienteDAO = new ImpClienteDAO();
	
	
	void GUIMenuCliente(){
		
		LocalDate dataNascimento = LocalDate.now();
		Cliente cliente = new Cliente("","","","","","",dataNascimento,false,false,true);
		
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
		String cel;
		
		UtilidadesGUI.exibeMensagem("Nome do Cliente:");
		nome = scanner.nextLine();
		
		UtilidadesGUI.exibeMensagem("Email:");
		email = scanner.nextLine();
	
		UtilidadesGUI.exibeMensagem("Data de Nascimento:");
		data_nascimento = scanner.nextLine();
		
		LocalDate dataNascimento = LocalDate.parse(data_nascimento,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		UtilidadesGUI.exibeMensagem("CPF: ");
		cpf = scanner.nextLine();
		
		UtilidadesGUI.exibeMensagem("Numero do Celular");
		cel = scanner.nextLine();
		
		cliente = new Cliente(nome,email,cel,cpf,dataNascimento);
		
		clienteDAO.CadastrarCliente(cliente);
	}
	
	void GUIExibirTodosClientes() {
		try {
			clienteDAO.obterTodosClientes();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void GUIExibirCliente(Cliente cliente){
		
		cliente = cliente.clientes.get(0);
		
		UtilidadesGUI.exibeMensagem("Nome: " + cliente.getNome());
		UtilidadesGUI.exibeMensagem("\nEmail: " + cliente.getEmail());
		UtilidadesGUI.exibeMensagem("\nData de Nascimento: " + cliente.getDataNascimento());
		UtilidadesGUI.exibeMensagem("\nCPF: " + cliente.getCpf());
	}
}
