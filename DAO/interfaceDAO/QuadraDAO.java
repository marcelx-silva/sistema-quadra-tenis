package interfaceDAO;

import Dominio.Quadra;
import Exceptions.CourtAlreadyRegisteredException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public interface QuadraDAO {
	
	List<Quadra> obterTodasQuadras() throws IOException, SQLException;
	
	List<Quadra> obterQuadrasHabilitadas(boolean habilitado) throws IOException, SQLException;
	
	List<Quadra> obterQuadraBloqueadas(boolean bloqueado);
	
	Quadra obterQuadraPeloId(int id);
	
	boolean CadastrarQuadra(Quadra q) throws CourtAlreadyRegisteredException;
	
	boolean AlterarDadosQuadra(String alteracao, int escolha);
	
	boolean HabilitarQuadra(int id, boolean habilitado);
	
	boolean BloquearQuadra(int id, boolean bloqueado);
	
	boolean DeletarQuadra(int id);
	
}
