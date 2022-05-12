package InterfaceDAO;

import Dominio.Cliente;
import java.util.List;

public interface ClienteDAO {
	
	
	//Seleciona todos os clientes
	List<Cliente> obterTodosClientes();
	
	//Seleciona cliente pelo identificador
	Cliente obterClientePeloId(int id);
	
	//Seleciona clientes bloqueados ou desbloqueados
	List<Cliente> obterClienteHabilitados(boolean bloqueado);
		
	//Cadastra clintes
	void CadastrarCliente(Cliente c);
	
	//Atualizar Dados do Cliente
	boolean AlterarDadosCliente(Cliente c);
	
	//Deletar cliente
	boolean DeletarCliente(int id);
}
