
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
					+ "\n2. VISUALIZAR CLIENTE PELO CPF"
					+ "\n3. VISUALIZAR TODOS OS CLIENTES"
					+ "\n4. BLOQUEAR/DESBLOQUEAR CLIENTES"
					+ "\n5. ALTERAR DADOS DE CLIENTES"
					+ "\n6. DELETAR CLIENTE"
					+ "\n7. SAIR DO MENU"
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
					this.GUIExibirTodosClientes();
					break;
					
				case 4:
					this.GUIBloquearCliente(cliente);
					break;
					
				case 5:
					this.GUIAlterarDadosCliente(cliente);
					break;
				case 6:
					this.GUIDeletarCliente(cliente);
					break;
				case 7:
					UtilidadesGUI.exibeMensagem("Saindo... \n");
					break;
					
				default:
					UtilidadesGUI.exibeMensagem("Op��o Inv�lida!! \n"); 
					

			}
			
		}while(operadorMenu!=6);
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
				UtilidadesGUI.exibeMensagem("Nome: "+c.getNome()
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
	
	void GUIAlterarDadosCliente(Cliente cliente) {
		
		String cpf;
		int opcao = -1;
		
		try {
			UtilidadesGUI.exibeMensagem("CPF do cliente: ");
			cpf = scanner.nextLine();
			
			cliente = clienteDAO.obterClientePeloCPF(cpf);
			
			do {	
				
				UtilidadesGUI.exibeMensagem("Qual dado você deseja alterar do Cliente: \n\n"+cliente.getNome());
				UtilidadesGUI.exibeMensagem("1 - Nome\n2 - Email\n3 - Numero do celular\n0 - Sair");
				
				switch(opcao) {
				
				case 1:
					UtilidadesGUI.exibeMensagem("Alteração do nome do Cliente\n\n");
					UtilidadesGUI.exibeMensagem("Novo nome do cliente");
					alterarDado(cliente,opcao);
					break;
				case 2:
					UtilidadesGUI.exibeMensagem("Alteração do Email do Cliente\n\n");
					UtilidadesGUI.exibeMensagem("Novo email do cliente");
					alterarDado(cliente,opcao);
					break;
				case 3:
					UtilidadesGUI.exibeMensagem("Alteração do Telefone do Cliente\n\n");
					UtilidadesGUI.exibeMensagem("Novo telefone do cliente");
					alterarDado(cliente,opcao);
				}
				
			}while(opcao!=0);
			VisualizarDados(cliente);
		}catch(ClientNotFoundException e) {
			
		}
	}
	
	void GUIBloquearCliente(Cliente cliente) {
		
		try {
			String cpf;
			boolean resposta;
			
			
			
			UtilidadesGUI.exibeMensagem("Bloquear/Desbloquear Clientes:\n\n");
			UtilidadesGUI.exibeMensagem("Entre com o CPF do cliente que deseja bloquear/desbloquear:\n");
			cpf = scanner.nextLine();
			
			cliente = clienteDAO.obterClientePeloCPF(cpf);
			VisualizarDados(cliente);
		
			UtilidadesGUI.exibeMensagem("Bloquear/Desbloquear (sim/não)");
			resposta = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
			clienteDAO.BloquearCliente(cliente.getCpf(), resposta);
			
			
			
			UtilidadesGUI.exibeMensagem("");
		} catch (ClientNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	void GUIDeletarCliente(Cliente cliente) {
		try {
			String cpf;
			boolean resposta;
			boolean deletado;
			
			
			
			UtilidadesGUI.exibeMensagem("Deletar Clientes:\n\n");
			UtilidadesGUI.exibeMensagem("Entre com o CPF do cliente que deseja deletar:\n");
			cpf = scanner.nextLine();
			
			cliente = clienteDAO.obterClientePeloCPF(cpf);
			VisualizarDados(cliente);
		
			UtilidadesGUI.exibeMensagem("Deseja Deletar ? (sim/não)");
			resposta = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
			
			if(resposta) {
				deletado  = clienteDAO.DeletarCliente(cliente.getCpf());
				
				if(deletado) {
					UtilidadesGUI.exibeMensagem("Cliente deletado!");
				}
			}
				
			else
				UtilidadesGUI.exibeMensagem("Cliente não deletado!");
			
			
			
			UtilidadesGUI.exibeMensagem("");
		} catch (ClientNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void alterarDado(Cliente cliente,int escolha) {
		
		String alteracao;
		alteracao = scanner.nextLine();
		alteracao = alteracao.replaceAll("\\s","");
		
		if(alteracao.isEmpty()) {
			UtilidadesGUI.exibeMensagem("CAMPO VAZIO !!!");
		}else {
			boolean alterado = clienteDAO.AlterarDadosCliente(cliente, alteracao, escolha);
			
			if(alterado)
				UtilidadesGUI.exibeMensagem("Alterado com sucesso !");
			else
				UtilidadesGUI.exibeMensagem("Erro! Alteração não foi possível");
			
		}
		
	}
	
	void VisualizarDados(Cliente cliente) {
		UtilidadesGUI.exibeMensagem("Nome: "+cliente.getNome()
		+"Data de Nascimento: "+cliente.getDataNascimento()
		+"CPF: "+cliente.getCpf()
		+"Email: "+cliente.getEmail()
		+"Celular: "+cliente.getNumeroCelular());
	}
	
	

}
