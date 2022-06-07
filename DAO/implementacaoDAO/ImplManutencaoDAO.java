package implementacaoDAO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import Dominio.Manutencao;
import interfaceDAO.ManutencaoDAO;

public class ImplManutencaoDAO implements ManutencaoDAO {

	@Override
	public List<Manutencao> obterTodasManutencoes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Manutencao> obterManutencoesPorPeriodoDeDias(LocalDate dataInicio, LocalDate dataFim) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Manutencao> obterManutencoesPorData(LocalDate data) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Manutencao> obterManutencoesPorDataHorario(LocalDate data,LocalDate dataInicio, LocalDate dataFim) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manutencao obterManutencaoPeloId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cadastrarManutencao(Manutencao m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarDataManutencao(Manutencao m, LocalDate data, LocalTime horarioInicio, LocalTime horarioFIm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarManutencao(Manutencao m) {
		// TODO Auto-generated method stub
		return false;
	}

}
