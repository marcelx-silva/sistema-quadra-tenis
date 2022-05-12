package InterfaceDAO;

import Dominio.Quadra;
import java.util.List;

public interface QuadraDAO {
	
	List<Quadra> obterTodasQuadras();
	
	Quadra obterQuadraPeloId(int id);
	
	List<Quadra> obterQuadraHabilitadas(boolean bloqueado);
	
	boolean CadastrarQuadra(Quadra q);
	
	boolean AlterarDadosQuadra(Quadra q);
	
	boolean DeletarQuadra(int id);
	
}
