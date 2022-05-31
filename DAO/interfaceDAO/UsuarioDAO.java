package interfaceDAO;

import Dominio.Usuario;
import Exceptions.UserAlreadyRegisteredException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {
	
	List<Usuario> obterTodasUsuario() throws IOException, SQLException;
	
	List<Usuario> obterUsuarioHabilitados(boolean habilitado) throws IOException, SQLException;
	
	List<Usuario> obterUsuarioBloqueados(boolean bloqueado) throws IOException, SQLException;
	
	List<Usuario> obterUsuarioPelaPermissao(String permissao) throws IOException, SQLException;
	
	Usuario obterUsuarioPeloId(int id) throws IOException, SQLException;
	
	Usuario obterUsuarioPeloEmail(String email) throws IOException;
	
	boolean CadastrarUsuario(Usuario u) throws IOException, UserAlreadyRegisteredException;
	
	boolean AlterarDadosUsuario(String alterecao, int escolha);
	
	boolean BloquearUsuario(String email, boolean bloqueado);
	
	boolean HabilitarUsuario(String email, boolean habilitado);
	
	boolean DeletarUsuario(String email);
	
	boolean verificaUsuario(String user, String senha);
}
