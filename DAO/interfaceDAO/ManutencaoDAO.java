package interfaceDAO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import Dominio.Manutencao;

public interface ManutencaoDAO {

	List<Manutencao> obterTodasManutencoes();
	
	List<Manutencao> obterManutencoesPorPeriodo(LocalDate dataInicio, LocalDate dataFim);
	
	List<Manutencao> obterManutencoesPorData(LocalDate data);
	
	Manutencao obterManutencaoPeloId(int id);
	
	boolean cadastrarManutencao(Manutencao m);
	
	boolean alterarDataManutencao(Manutencao m, LocalDate data, LocalTime horarioInicio, LocalTime horarioFIm);
	
	boolean deletarManutencao(Manutencao m);
}
