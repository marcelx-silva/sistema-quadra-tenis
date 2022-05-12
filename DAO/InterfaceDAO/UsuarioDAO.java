package InterfaceDAO;

import Dominio.Usuario;
import java.util.List;

public interface UsuarioDAO {
	
	List<Usuario> obterTodasUsuario();
	
	Usuario obterUsuarioPeloId(int id);
	
	List<Usuario> obterUsuarioHabilitados(boolean bloqueado);
	
	List<Usuario> obterUsuarioPelaPermissao(String permissao);
	
	boolean CadastrarUsuario(Usuario u);
	
	boolean AlterarDadosUsuario(Usuario u);
	
	boolean DeletarUsuario(int id);
}
