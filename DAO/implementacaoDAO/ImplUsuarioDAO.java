package implementacaoDAO;

import java.util.List;

import Dominio.Usuario;
import interfaceDAO.UsuarioDAO;

public class ImplUsuarioDAO implements UsuarioDAO {

	@Override
	public List<Usuario> obterTodasUsuario() {
		// TODO Auto-generated method stub
		return null;
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
