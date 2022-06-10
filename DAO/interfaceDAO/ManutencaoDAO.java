package interfaceDAO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import Dominio.Manutencao;
import Exceptions.MaintenanceNotFoundException;

public interface ManutencaoDAO {

	List<Manutencao> obterTodasManutencoes();
	
	List<Manutencao> obterManutencoesPorPeriodoDeDias(LocalDate dataInicio, LocalDate dataFim);
	
	List<Manutencao> obterManutencoesPorData(LocalDate data);
	
	List<Manutencao> obterManutencoesPorDataHorario(LocalDate data, LocalTime horarioInicioM, LocalTime horarioFimM);
	
	Manutencao obterManutencaoPeloId(String id) throws MaintenanceNotFoundException;
	
	boolean cadastrarManutencao(Manutencao m);
	
	boolean alterarDataManutencao(Manutencao m, LocalDate data, LocalTime horarioInicio, LocalTime horarioFIm);
	
	boolean deletarManutencao(int id);
}
