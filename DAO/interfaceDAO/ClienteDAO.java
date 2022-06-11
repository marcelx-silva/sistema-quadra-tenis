package interfaceDAO;

import Dominio.Cliente;
import Exceptions.ClientNotFoundException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ClienteDAO {
	
	
	List<Cliente> obterTodosClientes() throws IOException, SQLException;
	
	Cliente obterClientePeloCPF(String cpf) throws ClientNotFoundException;
	
	Cliente obterClientePeloCpf(String cpf) throws ClientNotFoundException;
	
	List<Cliente> obterClienteHabilitados(boolean bloqueado) throws IOException, SQLException;
		
	boolean CadastrarCliente(Cliente c);
	
	boolean AlterarDadosCliente(Cliente c,String alteracao, int escolha);
	
	boolean DesabilitarCliente(String cpf, boolean habilitado)throws ClientNotFoundException ;
	
	boolean BloquearCliente(String cpf, boolean bloqueado) throws  ClientNotFoundException;
	
	boolean InvalidarCliente(String cpf, boolean validado) throws  ClientNotFoundException;
	
	boolean DeletarCliente(String cpf) throws  ClientNotFoundException;
}
