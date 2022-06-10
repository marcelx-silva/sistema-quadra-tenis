package implementacaoDAO;

import Dominio.Cliente;
import Exceptions.ClientNotFoundException;
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
			
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesCliente.getProperty("SELECT_ALL_FROM_ALL_CLIENTE"));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Cliente cliente = montaCliente(rs);
				listaClientes.add(cliente);
			}
			
			ConexaoBD.encerrarConexaoBD(con, stmt, rs);
			
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
	
	
	
	public Cliente obterClientePeloId(int id) throws ClientNotFoundException {
		
		Cliente cliente = null;
		
	try {
		
		q.consultaCliente();
		
		
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_CLIENTE.properties");
		q.queriesCliente.load(in);
		in.close();
		
		Connection con =  ConexaoBD.conectaBD();
		PreparedStatement stmt = con.prepareStatement(q.queriesCliente.getProperty("SELECT_ALL_FROM_CLIENT_BY_ID"));
		stmt.setInt(1,id);
		ResultSet rs = stmt.executeQuery();
		
		
		
		if(rs.next()){
			
			cliente = montaCliente(rs);
			
		}else {
			throw new ClientNotFoundException("Cliente inexistente");
		}
		
		ConexaoBD.encerrarConexaoBD(con,stmt,rs);
	
		
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
			
			Cliente cliente = montaCliente(rs);
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
			
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesCliente.getProperty("INSERT_INTO_CLIENT"));
			
			
			LocalDate dataNascimento = LocalDate.parse(c.getDataNascimento().toString(),dataFormatoBD);
			
			
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCpf());
			stmt.setObject(3, dataNascimento);
			stmt.setString(4, c.getEmail());
			stmt.setString(5, c.getNumeroCelular());
			
			int linhaAlterada =  stmt.executeUpdate();
			
			ConexaoBD.encerrarConexaoBD(con,stmt);
			
			if(linhaAlterada == 0) {
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
	
	
	public boolean AlterarDadosCliente(Cliente c,String alteracao, int escolha) {
		
		try {
			q.DMLCliente();
			FileInputStream in = new FileInputStream("DML_Cliente.properties");
			q.queriesCliente.load(in);
			in.close();
			
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt;
			
			int linhaAlterada = 0;
			
			switch(escolha) {
			
				case 1:
					stmt = con.prepareStatement(q.queriesCliente.getProperty("UPDATE_CLIENTE_NOME"));
					stmt.setString(1, alteracao);
					stmt.setString(2, c.getCpf());
					linhaAlterada =  stmt.executeUpdate();
					ConexaoBD.encerrarConexaoBD(con, stmt);
					break;
					
				case 2:
					stmt = con.prepareStatement(q.queriesCliente.getProperty("UPDATE_CLIENT_EMAIL"));
					stmt.setString(1, alteracao);
					stmt.setString(2, c.getCpf());
					linhaAlterada = stmt.executeUpdate();
					ConexaoBD.encerrarConexaoBD(con, stmt);
					break;
					
				case 3:
					stmt = con.prepareStatement(q.queriesCliente.getProperty("UPDATE_CLIENT_CELL_PHONE"));
					stmt.setString(1, alteracao);
					stmt.setString(2, c.getCpf());
					stmt.executeUpdate();
					ConexaoBD.encerrarConexaoBD(con, stmt);
					break;
					
					
				default:
					UtilidadesGUI.exibeMensagem("Opção Inválida!");
					break;
			}
			
			
			
			if(linhaAlterada == 0) {
				return false;
			}
			
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean DesabilitarCliente(String cpf, boolean habilitado) throws ClientNotFoundException {
		
		try {
			
			q.DMLCliente();
			
			FileInputStream in_dml = new FileInputStream("QUERY_DML_CLIENTE.properties");
			FileInputStream in_select = new FileInputStream("QUERY_CONSULTA_CLIENTE.properties");
			
			q.queriesCliente.load(in_dml);
			q.queriesCliente.load(in_select);
			in_dml.close();
			in_select.close();
			
			PreparedStatement stmt;
			Connection con = ConexaoBD.conectaBD();
			
			stmt = con.prepareStatement(q.queriesCliente.getProperty("SELECT_DISABLE_STATUS_FROM_CLIENT_BY_CPF"));
			stmt.setString(1, cpf);
			
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
	

	public boolean BloquearCliente(String cpf, boolean bloqueado) throws ClientNotFoundException {
		
		
		try {
			
			q.DMLCliente();
			
			FileInputStream in_dml = new FileInputStream("QUERY_DML_CLIENTE.properties");
			FileInputStream in_select = new FileInputStream("QUERY_CONSULTA_CLIENTE.properties");
			
			q.queriesCliente.load(in_dml);
			q.queriesCliente.load(in_select);
			in_dml.close();
			in_select.close();
			
			PreparedStatement stmt;
			Connection con = ConexaoBD.conectaBD();
			
			stmt = con.prepareStatement(q.queriesCliente.getProperty("SELECT_BLOCK_STATUS_FROM_CLIENT_BY_CPF"));
			stmt.setString(1, cpf);
			
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
	
	public boolean InvalidarCliente(String cpf, boolean validado) throws  ClientNotFoundException {
		
		try {
			
			q.DMLCliente();
			
			FileInputStream in_dml = new FileInputStream("QUERY_DML_CLIENTE.properties");
			FileInputStream in_select = new FileInputStream("QUERY_CONSULTA_CLIENTE.properties");
			
			q.queriesCliente.load(in_dml);
			q.queriesCliente.load(in_select);
			in_dml.close();
			in_select.close();
			
			PreparedStatement stmt;
			Connection con = ConexaoBD.conectaBD();
			
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
	
	
	public boolean DeletarCliente(String cpf) throws  ClientNotFoundException {
		
		try {
			
			q.DMLCliente();
			
			FileInputStream in_dml = new FileInputStream("QUERY_DML_CLIENTE.properties");
			FileInputStream in_select = new FileInputStream("QUERY_CONSULTA_CLIENTE.properties");
			
			q.queriesCliente.load(in_dml);
			q.queriesCliente.load(in_select);
			in_dml.close();
			in_select.close();
			
			PreparedStatement stmt;
			Connection con = ConexaoBD.conectaBD();
			
			stmt = con.prepareStatement(q.queriesCliente.getProperty("SELECT_ALL_FROM_CLIENT_BY_CPF"));
			stmt.setString(1, cpf);
			
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
