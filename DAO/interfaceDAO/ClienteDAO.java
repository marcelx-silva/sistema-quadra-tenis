package interfaceDAO;

import Dominio.Cliente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ClienteDAO {
	
	
	//Seleciona todos os clientes
	List<Cliente> obterTodosClientes() throws IOException, SQLException;
	
	//Seleciona cliente pelo identificador
	Cliente obterClientePeloId(int id);
	
	//Seleciona clientes bloqueados ou desbloqueados
	List<Cliente> obterClienteHabilitados(boolean bloqueado);
		
	//Cadastra clintes
	void CadastrarCliente(Cliente c);
	
	//Atualizar Dados do Cliente
	boolean AlterarDadosCliente(String alteracao, int escolha);
	
	//Bloquear e Desbloquear Cliente
	boolean DesabilitarCliente(int id, boolean habilitado);
	
	boolean BloquearCliente(int id, boolean bloqueado);
	
	boolean InvalidarCliente(int id, boolean validado);
	
	//Deletar cliente
	boolean DeletarCliente(int id);
}
