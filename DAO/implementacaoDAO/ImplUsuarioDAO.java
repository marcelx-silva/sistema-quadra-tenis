package implementacaoDAO;

import java.util.ArrayList;
import java.util.List;

import Dominio.Usuario;
import Exceptions.BlockedUserException;
import Exceptions.UserAlreadyRegisteredException;
import Exceptions.UserNotFoundException;
import Exceptions.WrongUserOrPasswordException;
import Utilitario.UtilidadesConversao;
import Utilitario.UtilidadesGUI;
import interfaceDAO.UsuarioDAO;
import queries.QueriesUsuario;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import conexao.ConexaoBD;

public class ImplUsuarioDAO implements UsuarioDAO {

	QueriesUsuario q = new QueriesUsuario();
	
	@Override
	public List<Usuario> obterTodasUsuario() throws IOException, SQLException{

		q.consultarUsuario();
		List<Usuario> todosUsuarios = new ArrayList<>();
		
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_USUARIO.properties");
		q.queriesUsuario.load(in);
		in.close();
		Connection con =  ConexaoBD.conectaBD();
		PreparedStatement stmt = con.prepareStatement(q.queriesUsuario.getProperty("SELECT_ALL_FROM_ALL_USUARIO"));
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			String codigo = rs.getString("usu_id");
			String nome = rs.getString("usu_nome");
			String email = rs.getString("usu_email");
			String senha = rs.getString("usu_senha");
			boolean acessoGestorQuadra = rs.getBoolean("usu_acesso_gestor_quadra");
			boolean acessoGestorUsuario = rs.getBoolean("usu_acesso_gestor_usuario");
			boolean acessoRelatorio = rs.getBoolean("usu_acesso_relatorio");
			boolean acessoZelador = rs.getBoolean("usu_acesso_zelador");
			Usuario usu = new Usuario(codigo, nome, email, senha, acessoGestorQuadra, acessoGestorUsuario, acessoRelatorio, acessoZelador);
			
			todosUsuarios.add(usu);
		}
		
		ConexaoBD.encerrarConexaoBD(con, stmt, rs);
		
		List<Usuario> copiaTodosUsuarios = new ArrayList<>();
		copiaTodosUsuarios.addAll(todosUsuarios);
		
		return copiaTodosUsuarios;
	}

	@Override
	public List<Usuario> obterUsuarioHabilitados(boolean habilitado)  throws IOException, SQLException{


		q.consultarUsuario();
		List<Usuario> todosUsuariosHabilitados = new ArrayList<>();
		
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_USUARIO.properties");
		q.queriesUsuario.load(in);
		in.close();
		Connection con =  ConexaoBD.conectaBD();
		PreparedStatement stmt = con.prepareStatement(q.queriesUsuario.getProperty("SELECT_ALL_FROM_USUARIO_HABILITADO"));
		stmt.setBoolean(1, habilitado);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
				
			String codigo = rs.getString("usu_id");
			String nome = rs.getString("usu_nome");
			String email = rs.getString("usu_email");
			String senha = rs.getString("usu_senha");
			boolean acessoGestorQuadra = rs.getBoolean("usu_acesso_gestor_quadra");
			boolean acessoGestorUsuario = rs.getBoolean("usu_acesso_gestor_usuario");
			boolean acessoRelatorio = rs.getBoolean("usu_acesso_relatorio");
			boolean acessoZelador = rs.getBoolean("usu_acesso_zelador");
			Usuario usu = new Usuario(codigo, nome, email, senha, acessoGestorQuadra, acessoGestorUsuario, acessoRelatorio, acessoZelador); 
			
			todosUsuariosHabilitados.add(usu);
		}
		
		ConexaoBD.encerrarConexaoBD(con, stmt, rs);
		
		List<Usuario> copiaTodosUsuariosHabilitados = new ArrayList<>();
		copiaTodosUsuariosHabilitados.addAll(todosUsuariosHabilitados);
		
		return copiaTodosUsuariosHabilitados;
	}

	@Override
	public List<Usuario> obterUsuarioBloqueados(boolean bloqueado) throws IOException, SQLException{
		q.consultarUsuario();
		List<Usuario> todosUsuariosBloqueados = new ArrayList<>();
		
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_USUARIO.properties");
		q.queriesUsuario.load(in);
		in.close();
		Connection con =  ConexaoBD.conectaBD();
		PreparedStatement stmt = con.prepareStatement(q.queriesUsuario.getProperty("SELECT_ALL_FROM_USUARIO_BY_USU_BLOQUEADO"));
		stmt.setBoolean(1, bloqueado);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
				
			String codigo = rs.getString("usu_id");
			String nome = rs.getString("usu_nome");
			String email = rs.getString("usu_email");
			String senha = rs.getString("usu_senha");
			boolean acessoGestorQuadra = rs.getBoolean("usu_acesso_gestor_quadra");
			boolean acessoGestorUsuario = rs.getBoolean("usu_acesso_gestor_usuario");
			boolean acessoRelatorio = rs.getBoolean("usu_acesso_relatorio");
			boolean acessoZelador = rs.getBoolean("usu_acesso_zelador");
			Usuario usu = new Usuario(codigo, nome, email, senha, acessoGestorQuadra, acessoGestorUsuario, acessoRelatorio, acessoZelador); 
			
			todosUsuariosBloqueados.add(usu);
		}
		
		ConexaoBD.encerrarConexaoBD(con, stmt, rs);
		
		List<Usuario> copiaTodosUsuariosBloqueados = new ArrayList<>();
		copiaTodosUsuariosBloqueados.addAll(todosUsuariosBloqueados);
		
		return copiaTodosUsuariosBloqueados;
	}
	
	@Override
	public Usuario obterUsuarioPeloEmail(String emailBuscado) throws IOException, UserNotFoundException {
		
		q.consultarUsuario();
		Usuario usu = null;
		
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_USUARIO.properties");
		q.queriesUsuario.load(in);
		in.close();
		
		try {
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesUsuario.getProperty("SELECT_ALL_FROM_USUARIO_BY_EMAIL"));
			stmt.setString(1, emailBuscado);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
					
				String nome = rs.getString("usu_nome");
				String email = rs.getString("usu_email");
				String senha = rs.getString("usu_senha");
				boolean acessoGestorQuadra = rs.getBoolean("usu_acesso_gestor_quadra");
				boolean acessoGestorUsuario = rs.getBoolean("usu_acesso_gestor_usuario");
				boolean acessoRelatorio = rs.getBoolean("usu_acesso_relatorio");
				boolean acessoZelador = rs.getBoolean("usu_acesso_zelador");
				usu = new Usuario(nome, email, senha, acessoGestorQuadra, acessoGestorUsuario, acessoRelatorio, acessoZelador); 
				
			}else {
				throw new UserNotFoundException("Não foi encontrado nenhum usuário cadastrado com o email digitado!");
			}
			
			ConexaoBD.encerrarConexaoBD(con, stmt, rs);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return usu;
	}

	@Override
	public boolean CadastrarUsuario(Usuario u) throws UserAlreadyRegisteredException{
		
		try {
			q.DMLUsuario();
			q.consultarUsuario();
			FileInputStream in = new FileInputStream("DML_USUARIO.properties");
			FileInputStream in2 = new FileInputStream("QUERY_CONSULTA_USUARIO.properties");
			q.queriesUsuario.load(in);
			q.queriesUsuario.load(in2);
			in.close();
			in2.close();
			
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesUsuario.getProperty("SELECT_ALL_FROM_USUARIO_BY_EMAIL"));
			stmt.setString(1, u.getEmail());
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				throw new UserAlreadyRegisteredException("Usuário já cadastrado!", u.getEmail());
			}
		
			stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesUsuario.getProperty("INSERT_INTO_USUARIO"));

			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getSenha());

			stmt.executeUpdate();
			
			ConexaoBD.encerrarConexaoBD(con, stmt, rs);
			return true;
			
		}catch(SQLException e) {

			e.printStackTrace();
			return false;
			
		}catch(IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean AlterarDadosUsuario(Usuario u, String alteracao, int escolha) {
		try {
			q.DMLUsuario();
			FileInputStream in = new FileInputStream("DML_USUARIO.properties");
			q.queriesUsuario.load(in);
			in.close();
			
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = null;
			
			switch(escolha) {
			
				case 1:
					stmt = con.prepareStatement(q.queriesUsuario.getProperty("UPDATE_USU_NOME"));
					stmt.setString(1, alteracao);
					stmt.setString(2, u.getEmail());
					stmt.executeUpdate();
					break;
					
				case 2:
					stmt = con.prepareStatement(q.queriesUsuario.getProperty("UPDATE_USU_EMAIL"));
					stmt.setString(1, alteracao);
					stmt.setString(2, u.getEmail());
					stmt.executeUpdate();
					break;
					
				case 3:
					stmt = con.prepareStatement(q.queriesUsuario.getProperty("UPDATE_USU_SENHA"));
					stmt.setString(1, alteracao);
					stmt.setString(2, u.getEmail());
					stmt.executeUpdate();
					break;
					
				case 4:
					stmt = con.prepareStatement(q.queriesUsuario.getProperty("UPDATE_USU_ACESSO_GESTOR_QUADRA"));
					stmt.setBoolean(1, UtilidadesConversao.transformaString(alteracao));
					stmt.setString(2, u.getEmail());
					stmt.executeUpdate();
					break;
					
				case 5:
					stmt = con.prepareStatement(q.queriesUsuario.getProperty("UPDATE_USU_ACESSO_GESTOR_USUARIO"));
					stmt.setBoolean(1, UtilidadesConversao.transformaString(alteracao));
					stmt.setString(2, u.getEmail());
					stmt.executeUpdate();
					break;
					
				case 6:
					stmt = con.prepareStatement(q.queriesUsuario.getProperty("UPDATE_USU_ACESSO_RELATORIO"));
					stmt.setBoolean(1, UtilidadesConversao.transformaString(alteracao));
					stmt.setString(2, u.getEmail());
					stmt.executeUpdate();
					break;
					
				case 7:
					stmt = con.prepareStatement(q.queriesUsuario.getProperty("UPDATE_USU_ACESSO_ZELADOR"));
					stmt.setBoolean(1, UtilidadesConversao.transformaString(alteracao));
					stmt.setString(2, u.getEmail());
					stmt.executeUpdate();
					break;
					
				default:
					UtilidadesGUI.exibeMensagem("Opção Inválida!");
					break;
			}
			ConexaoBD.encerrarConexaoBD(con, stmt);
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean HabilitarUsuario(String email, boolean habilitado) {
		
		try {
			q.DMLUsuario();
			FileInputStream in = new FileInputStream("DML_USUARIO.properties");
			q.queriesUsuario.load(in);
			in.close();
		
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesUsuario.getProperty("DISABLE_USU_BY_EMAIL"));

			stmt.setBoolean(1, habilitado);
			stmt.setString(2, email);

			stmt.executeUpdate();
			
			ConexaoBD.encerrarConexaoBD(con, stmt);
			return true;
			
		}catch(SQLException e) {

			e.printStackTrace();
			return false;
			
		}catch(IOException e) {

			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean BloquearUsuario(String email, boolean bloqueado) {
		
		try {
			q.DMLUsuario();
			FileInputStream in = new FileInputStream("DML_USUARIO.properties");
			q.queriesUsuario.load(in);
			in.close();
		
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesUsuario.getProperty("BLOCK_USU_BY_EMAIL"));

			stmt.setBoolean(1, bloqueado);
			stmt.setString(2, email);

			stmt.executeUpdate();
			
			ConexaoBD.encerrarConexaoBD(con, stmt);
			return true;
			
		}catch(SQLException e) {

			e.printStackTrace();
			return false;
			
		}catch(IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean DeletarUsuario(String email) {
		try {
			q.DMLUsuario();
			FileInputStream in = new FileInputStream("DML_USUARIO.properties");
			q.queriesUsuario.load(in);
			in.close();
		
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesUsuario.getProperty("DELETE_USUARIO_BY_EMAIL"));

			stmt.setString(1, email);

			stmt.executeUpdate();
			
			ConexaoBD.encerrarConexaoBD(con, stmt);
			return true;
			
		}catch(SQLException e) {

			e.printStackTrace();
			return false;
			
		}catch(IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean verificaUsuario(String user, String senha) throws WrongUserOrPasswordException, BlockedUserException{
		
		boolean conseguiuLogar = false;
		
		try {
			q.consultarUsuario();
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_USUARIO.properties");
			q.queriesUsuario.load(in);
			in.close();
			
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesUsuario.getProperty("VERIFY_USU_EMAIL_AND_USU_SENHA"));
			
			stmt.setString(1, user);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				if(!rs.getBoolean("usu_bloqueado")) {
					conseguiuLogar = true;
				}else {
					throw new BlockedUserException("Credenciais correspondem a um usuário bloqueado!");
				}
			}else {
				throw new WrongUserOrPasswordException("Email e/ou senha estão errados!");
			}
			
			ConexaoBD.encerrarConexaoBD(con, stmt, rs);

			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return conseguiuLogar;
	}
}
