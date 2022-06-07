package queries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class QueriesManutencao {
	
	Properties queriesManutencao = new Properties();
	
	protected void consultaManutencao() throws IOException{
		
		queriesManutencao.setProperty("SELECT_ALL_FROM_MANUTENCAO", "SELECT m.man_id, m.man_desc, DATE_FORMAT(m.man_data, \"%d-%m-%Y\") \r\n"
				+ "m.man_hr_inicio, m.man_hr_fim, m.man_prev, m.man_cod_quadra "
				+ "FROM manutencao m JOIN quadra q"
				+ "ON (q.qua_id = m.man_cod_quadra)");
		
		queriesManutencao.setProperty("SELECT_ALL_FROM_MANUTENCAO_BY_DAY", "SELECT m.man_id, m.man_desc, DATE_FORMAT(m.man_data, \"%d-%m-%Y\") \r\n"
				+ "m.man_hr_inicio, m.man_hr_fim, m.man_prev, m.man_cod_quadra \r\n"
				+ "FROM manutencao m JOIN quadra q \r\n"
				+ "ON (q.qua_id = m.man_cod_quadra)"
				+ "WHERE DAY(m.man_data) = ?");
		
		queriesManutencao.setProperty("SELECT_ALL_FROM_MANUTENCAO_BY_DAY_AND_TIME", "SELECT m.man_id, m.man_desc, DATE_FORMAT(m.man_data, \"%d-%m-%Y\") \r\n"
				+ "m.man_hr_inicio, m.man_hr_fim, m.man_prev, m.man_cod_quadra \r\n"
				+ "FROM manutencao m JOIN quadra q \r\n"
				+ "ON (q.qua_id = m.man_cod_quadra)"
				+ "WHERE DAY(m.man_data) = ? AND m.man_hr_inicio >= ? AND m.man_hr_fim <= ?");
		
		queriesManutencao.setProperty("SELECT_ALL_FROM_MANUTENCAO_BY_INTERVAL_OF_DAYS", "SELECT m.man_id, m.man_desc, DATE_FORMAT(m.man_data, \"%d-%m-%Y\") \r\n"
				+ "m.man_hr_inicio, m.man_hr_fim, m.man_prev, m.man_cod_quadra \r\n"
				+ "FROM manutencao m JOIN quadra q \r\n"
				+ "ON (q.qua_id = m.man_cod_quadra)"
				+ "WHERE m.man_data >= ? AND m.man_data <= ?");
		
		FileOutputStream out = new FileOutputStream("QUERY_CONSULTA_MANUTENCAO.properties");
		queriesManutencao.store(out, null);
		out.close();
	}

}
