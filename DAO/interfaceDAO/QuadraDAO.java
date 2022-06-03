package interfaceDAO;

import Dominio.Quadra;
import Exceptions.CourtAlreadyRegisteredException;
import Exceptions.CourtNotFoundException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public interface QuadraDAO {
	
	List<Quadra> obterTodasQuadras() throws IOException, SQLException;
	
	List<Quadra> obterQuadrasHabilitadas(boolean habilitado) throws IOException, SQLException;
	
	List<Quadra> obterQuadraBloqueadas(boolean bloqueado);
	
	Quadra obterQuadraPeloNome(String nome) throws CourtNotFoundException ;
	
	boolean CadastrarQuadra(Quadra q) throws CourtAlreadyRegisteredException;
	
	boolean AlterarDadosQuadra(Quadra qua, String alteracao, int escolha);
	
	boolean HabilitarQuadra(String nome, boolean habilitado);
	
	boolean BloquearQuadra(String nomed, boolean bloqueado);
	
	boolean DeletarQuadra(String nome);
	
}
