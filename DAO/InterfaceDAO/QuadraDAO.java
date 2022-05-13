package InterfaceDAO;

import Dominio.Quadra;
import java.util.List;

public interface QuadraDAO {
	
	List<Quadra> obterTodasQuadras();
	
	List<Quadra> obterQuadraHabilitadas(boolean bloqueado);
	
	Quadra obterQuadraPeloId(int id);
	
	boolean CadastrarQuadra(Quadra q);
	
	boolean AlterarDadosQuadra(Quadra q);
	
	boolean HabilitarQuadra(int id, boolean bloqueado);
	
	boolean DeletarQuadra(int id);
	
}
