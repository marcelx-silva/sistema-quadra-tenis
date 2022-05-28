package implementacaoDAO;

import java.util.ArrayList;
import java.util.List;

import Dominio.Usuario;
import interfaceDAO.UsuarioDAO;
import queries.QueriesUsuario;

import java.io.FileInputStream;
import java.io.IOException;
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
		
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_USUARIO");
		q.queriesUsuario.load(in);
		in.close();
		PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesUsuario.getProperty("SELECT_ALL_FROM_ALL_USUARIO"));
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
		
		List<Usuario> copiaTodosUsuarios = new ArrayList<>();
		copiaTodosUsuarios.addAll(todosUsuarios);
		
		return copiaTodosUsuarios;
	}

	@Override
	public List<Usuario> obterUsuarioHabilitados(boolean habilitado)  throws IOException, SQLException{


		q.consultarUsuario();
		List<Usuario> todosUsuariosHabilitados = new ArrayList<>();
		
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_USUARIO");
		q.queriesUsuario.load(in);
		in.close();
		PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesUsuario.getProperty("SELECT_ALL_FROM_USUARIO_HABILITADO"));
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
		
		List<Usuario> copiaTodosUsuariosHabilitados = new ArrayList<>();
		copiaTodosUsuariosHabilitados.addAll(todosUsuariosHabilitados);
		
		return copiaTodosUsuariosHabilitados;
	}

	@Override
	public List<Usuario> obterUsuarioBloqueados(boolean bloqueado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> obterUsuarioPelaPermissao(String permissao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obterUsuarioPeloId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Usuario obterUsuarioPeloEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean CadastrarUsuario(Usuario u){
		
		try {
			q.DMLUsuario();
			FileInputStream in = new FileInputStream("DML_USUARIO.properties");
			q.queriesUsuario.load(in);
			in.close();
		
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesUsuario.getProperty("INSERT_INTO_USUARIO"));

			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getSenha());

			stmt.executeUpdate();
			
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
	public boolean AlterarDadosUsuario(String alterecao, int escolha) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean HabilitarUsuario(String email, boolean habilitado) {
		
		try {
			q.DMLUsuario();
			FileInputStream in = new FileInputStream("DML_USUARIO.properties");
			q.queriesUsuario.load(in);
			in.close();
		
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesUsuario.getProperty("DISABLE_USU_BY_EMAIL"));

			stmt.setBoolean(1, habilitado);
			stmt.setString(2, email);

			stmt.executeUpdate();
			
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
		
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesUsuario.getProperty("BLOCK_USU_BY_EMAIL"));

			stmt.setBoolean(1, bloqueado);
			stmt.setString(2, email);

			stmt.executeUpdate();
			
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
		
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesUsuario.getProperty("DELETE_USUARIO_BY_EMAIL"));

			stmt.setString(1, email);

			stmt.executeUpdate();
			
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
	public boolean verificaUsuario(String user, String senha) {
		
		boolean conseguiuLogar = false;
		
		try {
			q.consultarUsuario();
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesUsuario.getProperty("SELECT_ALL_FROM_USUARIO_BY_USU_EMAIL_AND_USU_SENHA"));
			
			stmt.setString(1, user);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				String emailBD = rs.getString("usu_email");
				String senhaBD = rs.getString("usu_senha");
				boolean bloqueado = rs.getBoolean("usu_bloqueado");
				
				if(emailBD.contentEquals(user) && senhaBD.contentEquals(senha) && !bloqueado) {
					conseguiuLogar = true;
				}
			}

			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return conseguiuLogar;
	}
}
