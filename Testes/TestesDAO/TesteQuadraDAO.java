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

	Quadra qua = new Quadra("Quadra 1","Rua 1",TipoQuadra.SAIBRO,true, true, true, false);
	Quadra qua2 = new Quadra("Quadra 2","Rua 1",TipoQuadra.SAIBRO,true, true, true, false);
	Quadra qua3 = new Quadra("Quadra 3","Rua 1",TipoQuadra.SAIBRO,true, true, true, false);
	//public Quadra(String nome, String endereco, TipoQuadra tipo, boolean cobertura, boolean arquibancada, boolean descanso, boolean bloqueado)
	Quadra quadraAuxiliar = null;
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
	
	@Test(expected=CourtAlreadyRegisteredException.class)
	public void TesteCadastroQuadraDuplicado() throws CourtAlreadyRegisteredException {
		assertTrue(quaDAO.CadastrarQuadra(qua));
	}
	
	@Test
	public void TesteBuscarTodasQuadras() throws IOException, SQLException {		
		listaQuadras = quaDAO.obterTodasQuadras();	
		assertEquals(3, listaQuadras.size());
	}
	
	@Test
	public void TesteBuscarTodasQuadrasBloqueadas() throws IOException, SQLException {		
		quaDAO.BloquearQuadra("Quadra 2", true);
		listaQuadras = quaDAO.obterQuadraBloqueadas(true);
		assertEquals(1, listaQuadras.size());
	}
	
	@Test
	public void TesteBuscarTodasQuadrasHabilitadas() throws IOException, SQLException {	
		quaDAO.HabilitarQuadra("Quadra 2", false);
		listaQuadras = quaDAO.obterQuadrasHabilitadas(true);
		assertEquals(2, listaQuadras.size());
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
	
	@Test(expected=CourtNotFoundException.class)
	public void TesteBuscarQuadraInexistente() throws CourtNotFoundException{
		 Quadra quadraInexistente = quaDAO.obterQuadraPeloNome("Quadra que não existe");
	}
	
	@Test
	public void TesteMudarNome() throws CourtNotFoundException {
		quaDAO.AlterarDadosQuadra(qua, "Quadra 1 Alterada", 1);
		quadraAuxiliar = quaDAO.obterQuadraPeloNome("Quadra 1 Alterada");
		assertEquals(quadraAuxiliar.getNome(), "Quadra 1 Alterada");
		quaDAO.DeletarQuadra("Quadra 1 Alterada");
	}
	
	@Test
	public void TesteMudarEndereco() throws CourtNotFoundException {
		quaDAO.AlterarDadosQuadra(qua, "Rua 2", 2);
		quadraAuxiliar = quaDAO.obterQuadraPeloNome("Quadra 1");
		assertEquals(quadraAuxiliar.getEndereco(), "Rua 2");
	}
	
	@Test
	public void TesteTirarCobertura() throws CourtNotFoundException {
		quaDAO.AlterarDadosQuadra(qua, "Não", 3);
		quadraAuxiliar = quaDAO.obterQuadraPeloNome("Quadra 1");
		assertFalse(quadraAuxiliar.isPossuiCobertura());
	}
	
	@Test
	public void TesteDarCobertura() throws CourtNotFoundException {
		quaDAO.AlterarDadosQuadra(qua, "Sim", 3);
		quadraAuxiliar = quaDAO.obterQuadraPeloNome("Quadra 1");
		assertTrue(quadraAuxiliar.isPossuiCobertura());
	}
	
	@Test
	public void TesteTirarArquibancada() throws CourtNotFoundException {
		quaDAO.AlterarDadosQuadra(qua, "Não", 4);
		quadraAuxiliar = quaDAO.obterQuadraPeloNome("Quadra 1");
		assertFalse(quadraAuxiliar.isPossuiArquibancada());
	}
	
	@Test
	public void TesteDarArquibancada() throws CourtNotFoundException {
		quaDAO.AlterarDadosQuadra(qua, "Sim", 4);
		quadraAuxiliar = quaDAO.obterQuadraPeloNome("Quadra 1");
		assertTrue(quadraAuxiliar.isPossuiArquibancada());
	}
	
	@Test
	public void TesteTirarAreaDescanso() throws CourtNotFoundException {
		quaDAO.AlterarDadosQuadra(qua, "Não", 5);
		quadraAuxiliar = quaDAO.obterQuadraPeloNome("Quadra 1");
		assertFalse(quadraAuxiliar.isPossuiAreaDescanso());
	}
	
	@Test
	public void TesteDarAreaDescanso() throws CourtNotFoundException {
		quaDAO.AlterarDadosQuadra(qua, "Sim", 5);
		quadraAuxiliar = quaDAO.obterQuadraPeloNome("Quadra 1");
		assertTrue(quadraAuxiliar.isPossuiAreaDescanso());
	}
	
	@Test
	public void TesteMudarTipoParaSaibro() throws CourtNotFoundException {
		quaDAO.AlterarDadosQuadra(qua, "1", 6);
		quadraAuxiliar = quaDAO.obterQuadraPeloNome("Quadra 1");
		assertEquals(TipoQuadra.SAIBRO, quadraAuxiliar.getTipo());
	}
	
	@Test
	public void TesteMudarTipoParaSuperficieSintetica() throws CourtNotFoundException {
		quaDAO.AlterarDadosQuadra(qua, "2", 6);
		quadraAuxiliar = quaDAO.obterQuadraPeloNome("Quadra 1");
		assertEquals(TipoQuadra.SUPERFICIE_SINTETICA, quadraAuxiliar.getTipo());
	}
	
	@Test
	public void TesteMudarTipoParaCimento() throws CourtNotFoundException {
		quaDAO.AlterarDadosQuadra(qua, "3", 6);
		quadraAuxiliar = quaDAO.obterQuadraPeloNome("Quadra 1");
		assertEquals(TipoQuadra.CIMENTO, quadraAuxiliar.getTipo());
	}
	
	@Test
	public void TesteMudarTipoParaBeachTennis() throws CourtNotFoundException {
		quaDAO.AlterarDadosQuadra(qua, "4", 6);
		quadraAuxiliar = quaDAO.obterQuadraPeloNome("Quadra 1");
		assertEquals(TipoQuadra.BEACH_TENNIS, quadraAuxiliar.getTipo());
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
