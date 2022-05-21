package interfaceDAO;

import Dominio.Usuario;
import java.util.List;

public interface UsuarioDAO {
	
	List<Usuario> obterTodasUsuario();
	
	List<Usuario> obterUsuarioHabilitados(boolean habilitado);
	
	List<Usuario> obterUsuarioBloqueados(boolean bloqueado);
	
	List<Usuario> obterUsuarioPelaPermissao(String permissao);
	
	Usuario obterUsuarioPeloId(int id);
	
	boolean CadastrarUsuario(Usuario u);
	
	boolean AlterarDadosUsuario(String alterecao, int escolha);
	
	boolean HabilitarUsuario(int id, boolean bloqueado);
	
	boolean DeletarUsuario(int id);
}
