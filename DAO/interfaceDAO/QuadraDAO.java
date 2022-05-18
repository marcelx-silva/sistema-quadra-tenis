package interfaceDAO;

import Dominio.Quadra;
import java.util.List;

public interface QuadraDAO {
	
	List<Quadra> obterTodasQuadras();
	
	List<Quadra> obterQuadraHabilitadas(boolean habilitado);
	
	List<Quadra> obterQuadraBloqueadas(boolean bloqueado);
	
	Quadra obterQuadraPeloId(int id);
	
	boolean CadastrarQuadra(Quadra q);
	
	boolean AlterarDadosQuadra(String alteracao, int escolha);
	
	boolean HabilitarQuadra(int id, boolean habilitado);
	
	boolean BloquearQuadra(int id, boolean bloqueado);
	
	boolean DeletarQuadra(int id);
	
}
