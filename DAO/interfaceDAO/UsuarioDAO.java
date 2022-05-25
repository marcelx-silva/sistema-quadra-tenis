package interfaceDAO;

import Dominio.Usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {
	
	List<Usuario> obterTodasUsuario() throws IOException, SQLException;
	
	List<Usuario> obterUsuarioHabilitados(boolean habilitado) throws IOException, SQLException;
	
	List<Usuario> obterUsuarioBloqueados(boolean bloqueado) throws IOException, SQLException;
	
	List<Usuario> obterUsuarioPelaPermissao(String permissao) throws IOException, SQLException;
	
	Usuario obterUsuarioPeloId(int id) throws IOException, SQLException;
	
	boolean CadastrarUsuario(Usuario u);
	
	boolean AlterarDadosUsuario(String alterecao, int escolha);
	
	boolean HabilitarUsuario(int id, boolean bloqueado);
	
	boolean DeletarUsuario(int id);
}
