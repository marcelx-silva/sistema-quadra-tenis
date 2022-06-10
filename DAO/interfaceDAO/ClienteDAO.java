package interfaceDAO;

import Dominio.Cliente;
import Exceptions.ClientNotFoundException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ClienteDAO {
	
	
	//Seleciona todos os clientes
	List<Cliente> obterTodosClientes() throws IOException, SQLException;
	
	//Seleciona cliente pelo identificador
	Cliente obterClientePeloId(int id) throws ClientNotFoundException;
	
	//Seleciona clientes bloqueados ou desbloqueados
	List<Cliente> obterClienteHabilitados(boolean bloqueado) throws IOException, SQLException;
		
	//Cadastra clintes
	boolean CadastrarCliente(Cliente c);
	
	//Atualizar Dados do Cliente
	boolean AlterarDadosCliente(Cliente c,String alteracao, int escolha);
	
	//Bloquear e Desbloquear Cliente
	boolean DesabilitarCliente(Cliente c, boolean habilitado)throws ClientNotFoundException ;
	
	boolean BloquearCliente(Cliente c, boolean bloqueado) throws  ClientNotFoundException;
	
	boolean InvalidarCliente(Cliente c, boolean validado) throws  ClientNotFoundException;
	
	//Deletar cliente
	boolean DeletarCliente(int id) throws  ClientNotFoundException;
}
