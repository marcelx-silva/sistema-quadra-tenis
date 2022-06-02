package TestesDAO;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Quadra;
import Enum.TipoQuadra;
import Exceptions.CourtAlreadyRegisteredException;
import implementacaoDAO.ImplQuadraDAO;

public class TesteQuadraDAO {

	Quadra qua = new Quadra("Quadra 1","Rua 1",TipoQuadra.SAIBRO,true,true,true, false);
	Quadra qua2 = new Quadra("Quadra 2","Rua 1",TipoQuadra.SAIBRO,true,true,true, false);
	Quadra qua3 = new Quadra("Quadra 3","Rua 1",TipoQuadra.SAIBRO,true,true,true, false);
	
	ImplQuadraDAO quaDAO = new ImplQuadraDAO();
	
	@Test
	public void TesteCadastroQuadra() throws CourtAlreadyRegisteredException {
		assertTrue(quaDAO.CadastrarQuadra(qua));
	}

}
