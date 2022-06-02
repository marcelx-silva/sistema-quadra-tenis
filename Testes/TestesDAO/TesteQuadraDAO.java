package TestesDAO;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Quadra;
import Enum.TipoQuadra;
import Exceptions.CourtAlreadyRegisteredException;
import Exceptions.CourtNotFoundException;
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
	
	@Test
	public void TesteProcuraQuadraPeloNome() throws CourtNotFoundException{
		Quadra quadraBuscada = quaDAO.obterQuadraPeloNome("Quadra 1");
		assertEquals(quadraBuscada.getNome(), qua.getNome());
		assertEquals(quadraBuscada.getCodigo(), qua.getCodigo());
		assertEquals(quadraBuscada.getEndereco(), qua.getEndereco());
		assertEquals(quadraBuscada.isPossuiAreaDescanso(), qua.isPossuiAreaDescanso());
		assertEquals(quadraBuscada.isEstaBloqueada(), qua.isEstaBloqueada());
		assertEquals(quadraBuscada.isPossuiArquibancada(), qua.isPossuiArquibancada());
		assertEquals(quadraBuscada.isPossuiCobertura(), qua.isPossuiCobertura());
	}
}
