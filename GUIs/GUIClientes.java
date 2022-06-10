
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Dominio.Cliente;
import Exceptions.ClientNotFoundException;
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
			for(Cliente c: clienteDAO.obterTodosClientes()) {
				System.out.println("Nome: "+c.getNome()
				+"Data de Nascimento: "+c.getDataNascimento()
				+"CPF: "+c.getCpf()
				+"Email: "+c.getEmail()
				+"Celular: "+c.getNumeroCelular());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void GUIExibirCliente(Cliente cliente){
		try {
			String cpf;
			UtilidadesGUI.exibeMensagem("Pesquisa de Clientes:\n\n");
			UtilidadesGUI.exibeMensagem("Entre com o CPF do cliente que deseja visualizar as informações:\n");
			cpf = scanner.nextLine();
			
			cliente = clienteDAO.obterClientePeloCPF(cpf);
			
			VisualizarDados(cliente);
			
		} catch (ClientNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	void VisualizarDados(Cliente cliente) {
		System.out.println("Nome: "+cliente.getNome()
		+"Data de Nascimento: "+cliente.getDataNascimento()
		+"CPF: "+cliente.getCpf()
		+"Email: "+cliente.getEmail()
		+"Celular: "+cliente.getNumeroCelular());
	}
	
	
	void GUIAlterarDadosCliente(Cliente cliente) {
		
	}
}
