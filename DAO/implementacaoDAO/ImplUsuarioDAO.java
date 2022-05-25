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
		List<Usuario> todosUsuarios = new ArrayList<>();
		
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_USUARIO");
		q.queriesUsuario.load(in);
		in.close();
		PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesUsuario.getProperty("SELECT_ALL_FROM_ALL_USUARIO"));
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Usuario usu = new Usuario("", "", "", "", false, false, false, false);
			
			usu.setCodigo(rs.getString("usu_id"));
			usu.setNome(rs.getString("usu_nome"));
			usu.setEmail(rs.getString("usu_email"));
			usu.setSenha(rs.getString("usu_senha"));
			usu.setAcessoGestorQuadras(rs.getBoolean("usu_acesso_gestor_quadra"));
			usu.setAcessoGestorUsuarios(rs.getBoolean("usu_acesso_gestor_usuario"));
			usu.setAcessoRelatorios(rs.getBoolean("usu_acesso_relatorio"));
			usu.setAcessoZelador(rs.getBoolean("usu_acesso_zelador"));
			
			todosUsuarios.add(usu);
		}
		
		List<Usuario> copiaTodosUsuarios = new ArrayList<>();
		copiaTodosUsuarios.addAll(todosUsuarios);
		
		return copiaTodosUsuarios;
	}

	@Override
	public List<Usuario> obterUsuarioHabilitados(boolean habilitado) {
		// TODO Auto-generated method stub
		return null;
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
	public boolean CadastrarUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AlterarDadosUsuario(String alterecao, int escolha) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean HabilitarUsuario(int id, boolean bloqueado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeletarUsuario(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
