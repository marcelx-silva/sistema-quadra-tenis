package implementacaoDAO;

import Dominio.Cliente;
import Exceptions.ClientNotFoundException;
import Utilitario.UtilidadesConversao;
import Utilitario.UtilidadesGUI;
import conexao.ConexaoBD;
import interfaceDAO.ClienteDAO;
import queries.QueriesCliente;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
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
			in.close();
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
		String codigo = rs.getString("cli_id");
		String nome = rs.getString("cli_nome");
		String email = rs.getString("cli_email");
		String cpf = rs.getString("cli_cpf");
		String celular = rs.getString("cli_celular");
		String dataNascimento = rs.getString("cli_dt_nasc");
		boolean bloqueado = rs.getBoolean("cli_bloqueado");
		boolean habilitado = rs.getBoolean("cli_habilitado");
		boolean invalidado = rs.getBoolean("cli_invalidado");
		
		LocalDate LocaldataNascimento = LocalDate.parse(dataNascimento,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		return new Cliente(codigo,nome,email,cpf,celular,LocaldataNascimento,bloqueado,habilitado,invalidado);
	}
	
	
	
	public Cliente obterClientePeloId(int id) throws ClientNotFoundException {
		
		Cliente cliente = null;
		
	try {
		
		q.consultaCliente();
		
		
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_CLIENTE.properties");
		q.queriesCliente.load(in);
		in.close();
		PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesCliente.getProperty("SELECT_ALL_FROM_CLIENT_BY_ID"));
		stmt.setInt(1,id);
		ResultSet rs = stmt.executeQuery();
		
		
		
		if(rs.next()){
			
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
			
			cliente = new Cliente(codigo,nome,email,cpf,celular,LocaldataNascimento,bloqueado,habilitado,invalidado);
			
		}else {
			throw new ClientNotFoundException("Cliente inexistente");
		}
	
		
	}catch(SQLException e) {
		e.printStackTrace();
		
	}catch(IOException io) {
		io.printStackTrace();
	}	
		
	return cliente;
		
		
		
	}
	
	
	public List<Cliente> obterClienteHabilitados(boolean bloqueado) throws IOException, SQLException{
		
		q.consultaCliente();
		List<Cliente> listaClientesBloqueados = new ArrayList<Cliente>();
		
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_CLIENTE.properties");
		q.queriesCliente.load(in);
		in.close();
		PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesCliente.getProperty("SELECT_ALL_BLOCKED_CLIENT"));
		stmt.setBoolean(1, bloqueado);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			
			String codigo = rs.getString("cli_id");
			String nome = rs.getString("cli_nome");
			String email = rs.getString("cli_email");
			String cpf = rs.getString("cli_cpf");
			String celular = rs.getString("cli_celular");
			String dataNascimento = rs.getString("cli_dt_nasc");
			boolean bloqueadod = rs.getBoolean("cli_bloqueado");
			boolean habilitado = rs.getBoolean("cli_habilitado");
			boolean invalidado = rs.getBoolean("cli_invalidado");
			
			LocalDate LocaldataNascimento = LocalDate.parse(dataNascimento,dataFormatoPadrao);
			
			Cliente cliente = new Cliente(codigo,nome,email,cpf,celular,LocaldataNascimento,bloqueadod,habilitado,invalidado);
			listaClientesBloqueados.add(cliente);
		}
		
		List<Cliente> listaClientesBloqueadoCopia = new ArrayList<Cliente>();
		listaClientesBloqueadoCopia.addAll(listaClientesBloqueados);
		
		
		
		return listaClientesBloqueadoCopia;
	}
		
	
	public boolean CadastrarCliente(Cliente c){
		
		try {
			
			q.DMLCliente();
			
			FileInputStream in_dml = new FileInputStream("QUERY_DML_CLIENTE.properties");
			FileInputStream in_select = new FileInputStream("QUERY_CONSULTA_CLIENTE.properties");
			
			q.queriesCliente.load(in_dml);
			q.queriesCliente.load(in_select);
			in_dml.close();
			in_select.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesCliente.getProperty("INSERT_INTO_CLIENT"));
			
			ResultSet rs = stmt.executeQuery();
			
			LocalDate dataNascimento = LocalDate.parse(c.getDataNascimento().toString(),dataFormatoBD);
			
			
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCpf());
			stmt.setObject(3, dataNascimento);
			stmt.setString(4, c.getEmail());
			stmt.setString(5, c.getNumeroCelular());
			stmt.setString(6, c.getNumeroFixo());
			
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
			
		}catch(IOException io) {
			io.printStackTrace();
			return false;
		}
		
		
		
	}
	
	
	public boolean AlterarDadosCliente(Cliente c,String alteracao, int escolha) {
		
		try {
			q.DMLCliente();
			FileInputStream in = new FileInputStream("DML_Cliente.properties");
			q.queriesCliente.load(in);
			in.close();
			
			PreparedStatement stmt;
			
			switch(escolha) {
			
				case 1:
					stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesCliente.getProperty("UPDATE_CLIENTE_NOME"));
					stmt.setString(1, alteracao);
					stmt.setString(2, c.getCpf());
					stmt.executeUpdate();
					break;
					
				case 2:
					stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesCliente.getProperty("UPDATE_CLIENT_EMAIL"));
					stmt.setString(1, alteracao);
					stmt.setString(2, c.getCpf());
					stmt.executeUpdate();
					break;
					
				case 3:
					stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesCliente.getProperty("UPDATE_CLIENT_PHONE"));
					stmt.setString(1, alteracao);
					stmt.setString(2, c.getCpf());
					stmt.executeUpdate();
					break;
					
				case 4:
					stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesCliente.getProperty("UPDATE_CLIENT_CELL_PHONE"));
					stmt.setString(1, alteracao);
					stmt.setString(2, c.getCpf());
					stmt.executeUpdate();
					break;
					
					
				default:
					UtilidadesGUI.exibeMensagem("Opção Inválida!");
					break;
			}
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	boolean DesabilitarCliente(String cpf, boolean habilitado) throws ClientNotFoundException {
		
		try {
			
			q.DMLCliente();
			
			FileInputStream in_dml = new FileInputStream("QUERY_DML_CLIENTE.properties");
			FileInputStream in_select = new FileInputStream("QUERY_CONSULTA_CLIENTE.properties");
			
			q.queriesCliente.load(in_dml);
			q.queriesCliente.load(in_select);
			in_dml.close();
			in_select.close();
			
			PreparedStatement stmt;
			Connection con = null;
			con = ConexaoBD.conectaBD();
			
			stmt = con.prepareStatement(q.queriesCliente.getProperty("SELECT_DISABLE_STATUS_FROM_CLIENT_BY_CPF"));
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				stmt = con.prepareStatement(q.queriesCliente.getProperty("DISABLE_CLIENT"));
				stmt.setBoolean(1, habilitado);
				stmt.setString(2,cpf);	
			}else{
				throw new ClientNotFoundException("Cliente de cpf "+cpf+" inexistente !");
			}
			
			int linhaAlterada = stmt.executeUpdate();
			
			ConexaoBD.encerrarConexaoBD(con, stmt,rs);

			
			if(linhaAlterada == 0){
				return false;
			}
			
			return true;
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(IOException io) {
			io.printStackTrace();
			return false;
		}
	}
	

	boolean BloquearCliente(String cpf, boolean bloqueado) throws ClientNotFoundException {
		
		
		try {
			
			q.DMLCliente();
			
			FileInputStream in_dml = new FileInputStream("QUERY_DML_CLIENTE.properties");
			FileInputStream in_select = new FileInputStream("QUERY_CONSULTA_CLIENTE.properties");
			
			q.queriesCliente.load(in_dml);
			q.queriesCliente.load(in_select);
			in_dml.close();
			in_select.close();
			
			PreparedStatement stmt;
			Connection con = null;
			con = ConexaoBD.conectaBD();
			
			stmt = con.prepareStatement(q.queriesCliente.getProperty("SELECT_BLOCK_STATUS_FROM_CLIENT_BY_CPF"));
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				stmt = con.prepareStatement(q.queriesCliente.getProperty("BLOCK_CLIENT"));
				stmt.setBoolean(1, bloqueado);
				stmt.setString(2,cpf);	
			}else{
				throw new ClientNotFoundException("Cliente de cpf "+cpf+" inexistente !");
			}
			
			int linhaAlterada = stmt.executeUpdate();
			
			ConexaoBD.encerrarConexaoBD(con, stmt,rs);

			
			if(linhaAlterada == 0){
				return false;
			}
			
			return true;
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(IOException io) {
			io.printStackTrace();
			return false;
		}
		
	}
	
	boolean InvalidarCliente(String cpf, boolean validado) throws  ClientNotFoundException {
		
		try {
			
			q.DMLCliente();
			
			FileInputStream in_dml = new FileInputStream("QUERY_DML_CLIENTE.properties");
			FileInputStream in_select = new FileInputStream("QUERY_CONSULTA_CLIENTE.properties");
			
			q.queriesCliente.load(in_dml);
			q.queriesCliente.load(in_select);
			in_dml.close();
			in_select.close();
			
			PreparedStatement stmt;
			Connection con = null;
			con = ConexaoBD.conectaBD();
			
			stmt = con.prepareStatement(q.queriesCliente.getProperty("SELECT_INVALID_STATUS_FROM_CLIENT_BY_CPF"));
			stmt.setString(1, cpf);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				stmt = con.prepareStatement(q.queriesCliente.getProperty("DISABLE_CLIENT"));
				stmt.setBoolean(1,validado);
				stmt.setString(2,cpf);	
			}else{
				throw new ClientNotFoundException("Cliente de cpf "+cpf+" inexistente !");
			}
			
			int linhaAlterada = stmt.executeUpdate();
			
			ConexaoBD.encerrarConexaoBD(con, stmt,rs);

			
			if(linhaAlterada == 0){
				return false;
			}
			
			return true;
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(IOException io) {
			io.printStackTrace();
			return false;
		}
		
	}
	
	
	boolean DeletarCliente(String cpf) throws  ClientNotFoundException {
		
		try {
			
			q.DMLCliente();
			
			FileInputStream in_dml = new FileInputStream("QUERY_DML_CLIENTE.properties");
			FileInputStream in_select = new FileInputStream("QUERY_CONSULTA_CLIENTE.properties");
			
			q.queriesCliente.load(in_dml);
			q.queriesCliente.load(in_select);
			in_dml.close();
			in_select.close();
			
			PreparedStatement stmt;
			Connection con = null;
			con = ConexaoBD.conectaBD();
			
			stmt = con.prepareStatement(q.queriesCliente.getProperty("SELECT_ALL_FROM_CLIENT_BY_CPF"));
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				stmt = con.prepareStatement(q.queriesCliente.getProperty("DELETE_CLIENT"));
			}else{
				throw new ClientNotFoundException("Cliente de cpf "+cpf+" inexistente !");
			}
			
			int linhaAlterada = stmt.executeUpdate();
			
			ConexaoBD.encerrarConexaoBD(con, stmt,rs);

			
			if(linhaAlterada == 0){
				return false;
			}
			
			return true;
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(IOException io) {
			io.printStackTrace();
			return false;
		}
	}

}
