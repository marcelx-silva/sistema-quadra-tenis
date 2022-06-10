package implementacaoDAO;

import Dominio.Cliente;
import conexao.ConexaoBD;
import interfaceDAO.ClienteDAO;
import queries.QueriesCliente;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ImpClienteDAO implements ClienteDAO {
	
	QueriesCliente q = new QueriesCliente();
	
	DateTimeFormatter dataFormatoPadrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter horarioFormatoPadrao = DateTimeFormatter.ofPattern("HH:mm");
    DateTimeFormatter dataFormatoBD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter horarioFormatoBD = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	
	public List<Cliente> obterTodosClientes()  throws IOException, SQLException{
			
			
			q.consultaCliente();
			List<Cliente> listaClientes = new ArrayList<Cliente>();
			
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_CLIENTE.properties");
			q.queriesCliente.load(in);
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesCliente.getProperty("SELECT_ALL_FROM_ALL_CLIENTE"));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				String codigo = rs.getString("cli_id");
				String nome = rs.getString("cli_nome");
				String email = rs.getString("cli_email");
				String cpf = rs.getString("cli_cpf");
				String celular = rs.getString("cli_celular");
				String dataNascimento = rs.getString("cli_dt_nasc");
				boolean bloqueado = rs.getBoolean("cli_bloqueado");
				boolean habilitado = rs.getBoolean("cli_habilitado");
				boolean invalidado = rs.getBoolean("cli_invalidado");
				
				LocalDate LocaldataNascimento = LocalDate.parse(dataNascimento,dataFormatoPadrao);
				
				Cliente cliente = new Cliente(codigo,nome,email,cpf,celular,LocaldataNascimento,bloqueado,habilitado,invalidado);
				listaClientes.add(cliente);
			}
			
			List<Cliente> listaClientesCopia = new ArrayList<Cliente>();
			listaClientesCopia.addAll(listaClientes);
			
			
			
			return listaClientesCopia;
		
		
		
			
	}
	
	public Cliente montaCliente(ResultSet rs) throws SQLException {
		String nome = rs.getString("cli_nome");
		String email = rs.getString("cli_email");
		String cpf = rs.getString("cli_cpf");
		String celular = rs.getString("cli_celular");
		String dataNascimento = rs.getString("cli_dt_nasc");
		boolean bloqueado = rs.getBoolean("cli_bloqueado");
		boolean invalidado = rs.getBoolean("cli_invalidado");
		
		LocalDate LocaldataNascimento = LocalDate.parse(dataNascimento,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		return new Cliente(nome, email, cpf, celular, LocaldataNascimento, bloqueado, invalidado);
	}
	
	
	
	Cliente obterClientePeloId(int id) {
		
		
	}
	
	
	List<Cliente> obterClienteHabilitados(boolean bloqueado){
		
	}
		
	
	void CadastrarCliente(Cliente c) {
		
	}
	
	
	boolean AlterarDadosCliente(String alteracao, int escolha) {
		
	}
	
	
	boolean DesabilitarCliente(int id, boolean habilitado) {
		
	}
	
	boolean BloquearCliente(int id, boolean bloqueado) {
		
	}
	
	boolean InvalidarCliente(int id, boolean validado) {
		
	}
	
	
	boolean DeletarCliente(int id) {
		
	}

}
