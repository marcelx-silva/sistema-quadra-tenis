package TestesDAO;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Dominio.Manutencao;
import Dominio.Quadra;
import Enum.TipoQuadra;
import Exceptions.MaintenanceNotFoundException;
import implementacaoDAO.ImplManutencaoDAO;

public class TesteManutencaoDAO {

	DateTimeFormatter dataFormatoPadrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter horarioFormatoPadrao = DateTimeFormatter.ofPattern("HH:mm");
    DateTimeFormatter dataFormatoBD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter horarioFormatoBD = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    List<Manutencao> listaManutencoes = new ArrayList();
    
    // Objetos utilizados
    Quadra qua = new Quadra("1", "Quadra Teste Reserva","Rua 1",TipoQuadra.SAIBRO, true, true, true);
    Manutencao m1 = new Manutencao("1", qua, LocalDate.of(2022, 6, 21), LocalTime.of(12, 0), LocalTime.of(14, 0), false, "Manutenção Teste");
    Manutencao m2 = new Manutencao("2", qua, LocalDate.of(2022, 6, 21), LocalTime.of(17, 30), LocalTime.of(19, 0), false, "Manutenção Teste 2");
    Manutencao m3 = new Manutencao("3", qua, LocalDate.of(2022, 6, 23), LocalTime.of(13, 30), LocalTime.of(17, 0), false, "Manutenção Teste 3");
    Manutencao m4 = new Manutencao("4", qua, LocalDate.of(2022, 6, 27), LocalTime.of(11, 0), LocalTime.of(15, 0), false, "Manutenção Teste 4");
    
    
    ImplManutencaoDAO manutencaoDAO = new ImplManutencaoDAO();
    
	@Test
	public void testeCadastraManutencao() {
		assertTrue(manutencaoDAO.cadastrarManutencao(m1));
	}

	@Test
	public void testeObterManutencaoPeloID() throws MaintenanceNotFoundException {
		Manutencao mTeste = manutencaoDAO.obterManutencaoPeloId(m1.getCodigo()); 
		assertEquals(mTeste.getData(), m1.getData());
		assertEquals(mTeste.getHorarioInicio(), m1.getHorarioInicio());
		assertEquals(mTeste.getHorarioFim(), m1.getHorarioFim());
		assertEquals(mTeste.getDescricao(), m1.getDescricao());
	}
	
	@Test
	public void testeObterManutencoesPorDataHorario() {
		listaManutencoes = manutencaoDAO.obterManutencoesPorDataHorario(LocalDate.of(2022, 6, 21), LocalTime.of(12, 0), LocalTime.of(14, 0));
		assertEquals(1, listaManutencoes.size());
	}
	
	@Test
	public void testeObterManutencoesPorData() {
		listaManutencoes = manutencaoDAO.obterManutencoesPorData(LocalDate.of(2022, 6, 21));
		assertEquals(2, listaManutencoes.size());
	}
	
	@Test
	public void testeObterManutencoesPorPeridoDeDias() {
		listaManutencoes = manutencaoDAO.obterManutencoesPorPeriodoDeDias(LocalDate.of(2022, 6, 21), LocalDate.of(2022, 6, 23));
		assertEquals(3, listaManutencoes.size());
	}
	
	@Test
	public void testeMudarDataManutencao() throws MaintenanceNotFoundException {
		manutencaoDAO.alterarDataManutencao(m4, "28/06/2022", 2);
		m4 = manutencaoDAO.obterManutencaoPeloId(m4.getCodigo());
		assertEquals(m4.getData(), LocalDate.of(2022, 6, 28));
	}
	
	@Test
	public void testeMudarHorarioInicio() throws MaintenanceNotFoundException {
		manutencaoDAO.alterarDataManutencao(m4, "12:00", 3);
		m4 = manutencaoDAO.obterManutencaoPeloId(m4.getCodigo());
		assertEquals(m4.getHorarioInicio(), LocalTime.of(12, 0));
	}
	
	@Test
	public void testeMudarHorarioFim() throws MaintenanceNotFoundException {
		manutencaoDAO.alterarDataManutencao(m4, "13:00", 4);
		m4 = manutencaoDAO.obterManutencaoPeloId(m4.getCodigo());
		assertEquals(m4.getHorarioFim(), LocalTime.of(13, 0));
	}
}
