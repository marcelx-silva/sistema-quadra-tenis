package TestesDAO;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
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
	List<Quadra> listaQuadras = new ArrayList<Quadra>();
	
	ImplQuadraDAO quaDAO = new ImplQuadraDAO();
	
	@Before
	public void redefineQuadras() throws CourtAlreadyRegisteredException {
		quaDAO.DeletarQuadra(qua.getNome());
		quaDAO.DeletarQuadra(qua2.getNome());
		quaDAO.DeletarQuadra(qua3.getNome());
		
		quaDAO.CadastrarQuadra(qua);
		quaDAO.CadastrarQuadra(qua2);
		quaDAO.CadastrarQuadra(qua3);
	}
	
	@Test
	public void TesteCadastroQuadra() throws CourtAlreadyRegisteredException {
		quaDAO.DeletarQuadra(qua.getNome());
		assertTrue(quaDAO.CadastrarQuadra(qua));
	}
	
	
	@Test
	public void TesteBuscarTodasQuadras() throws CourtAlreadyRegisteredException, IOException, SQLException {		
		listaQuadras = quaDAO.obterTodasQuadras();	
		assertEquals(3, listaQuadras.size());
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
	
	@Test
	public void TesteHabilitarQuadra() {
		assertTrue(quaDAO.HabilitarQuadra(qua.getNome(), true));
	}
	
	@Test
	public void TesteDesabilitarQuadra() {
		assertTrue(quaDAO.HabilitarQuadra(qua.getNome(), false));
	}
	
	@Test
	public void TesteBloquearQuadra() {
		assertTrue(quaDAO.BloquearQuadra(qua.getNome(), true));
	}
	
	@Test
	public void TesteDebloquearQuadra() {
		assertTrue(quaDAO.BloquearQuadra(qua.getNome(), false));
	}
	
	@Test
	public void TesteDeletarQuadra() {
		assertTrue(quaDAO.DeletarQuadra(qua.getNome()));
	}
}
