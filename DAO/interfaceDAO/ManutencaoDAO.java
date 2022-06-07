package interfaceDAO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import Dominio.Manutencao;

public interface ManutencaoDAO {

	List<Manutencao> obterTodasManutencoes();
	
	List<Manutencao> obterManutencoesPorPeriodoDeDias(LocalDate dataInicio, LocalDate dataFim);
	
	List<Manutencao> obterManutencoesPorData(LocalDate data);
	
	List<Manutencao> obterManutencoesPorDataHorario(LocalDate data, LocalDate dataInicio, LocalDate dataFim);
	
	Manutencao obterManutencaoPeloId(int id);
	
	boolean cadastrarManutencao(Manutencao m);
	
	boolean alterarDataManutencao(Manutencao m, LocalDate data, LocalTime horarioInicio, LocalTime horarioFIm);
	
	boolean deletarManutencao(Manutencao m);
}
