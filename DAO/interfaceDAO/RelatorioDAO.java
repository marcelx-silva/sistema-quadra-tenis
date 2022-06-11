package interfaceDAO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

import Dominio.Quadra;

public interface RelatorioDAO {

	BigDecimal receitaPorDia(LocalDate data);
	
	BigDecimal receitaPorPeridoDeDia(LocalDate dataInicio, LocalDate dataFim);
	
	BigDecimal receitaPorPeridoDeDiaEQuadra(Quadra q, LocalDate dataInicio, LocalDate dataFim);
	
	HashMap<String, Integer> usoDasQuadrasPorDiaDaSemana(LocalDate dataInicio, LocalDate dataFim);
}
