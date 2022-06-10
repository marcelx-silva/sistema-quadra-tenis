package queries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class QueriesManutencao {
	
	public Properties queriesManutencao = new Properties();
	
	public void consultaManutencao() throws IOException{
		
		queriesManutencao.setProperty("SELECT_ALL_FROM_MANUTENCAO", "SELECT m.man_id, m.man_desc, DATE_FORMAT(m.man_data, \"%d-%m-%Y\") \r\n"
				+ "m.man_hr_inicio, m.man_hr_fim, m.man_prev, m.man_cod_quadra "
				+ "FROM manutencao m JOIN quadra q"
				+ "ON (q.qua_id = m.man_cod_quadra)");
		
		queriesManutencao.setProperty("SELECT_ALL_FROM_MANUTENCAO_BY_DAY", "SELECT m.man_id, m.man_desc, DATE_FORMAT(m.man_data, \"%d-%m-%Y\") \r\n"
				+ "m.man_hr_inicio, m.man_hr_fim, m.man_prev, m.man_cod_quadra \r\n"
				+ "FROM manutencao m JOIN quadra q \r\n"
				+ "ON (q.qua_id = m.man_cod_quadra)"
				+ "WHERE m.man_data = ?");
		
		queriesManutencao.setProperty("SELECT_ALL_FROM_MANUTENCAO_BY_DAY_AND_TIME", "SELECT m.man_id, m.man_desc, DATE_FORMAT(m.man_data, \"%d-%m-%Y\") \r\n"
				+ "m.man_hr_inicio, m.man_hr_fim, m.man_prev, m.man_cod_quadra \r\n"
				+ "FROM manutencao m JOIN quadra q \r\n"
				+ "ON (q.qua_id = m.man_cod_quadra)"
				+ "WHERE m.man_data = ? AND m.man_hr_inicio >= ? AND m.man_hr_fim <= ?");
		
		queriesManutencao.setProperty("SELECT_ALL_FROM_MANUTENCAO_BY_INTERVAL_OF_DAYS", "SELECT m.man_id, m.man_desc, DATE_FORMAT(m.man_data, \"%d-%m-%Y\") \r\n"
				+ "m.man_hr_inicio, m.man_hr_fim, m.man_prev, m.man_cod_quadra \r\n"
				+ "FROM manutencao m JOIN quadra q \r\n"
				+ "ON (q.qua_id = m.man_cod_quadra)"
				+ "WHERE m.man_data >= ? AND m.man_data <= ?");
		
		queriesManutencao.setProperty("SELECT_ALL_FROM_MANUTENCAO_BY_ID", "SELECT m.man_id, m.man_desc, DATE_FORMAT(m.man_data, \"%d-%m-%Y\") \r\n"
				+ "m.man_hr_inicio, m.man_hr_fim, m.man_prev, m.man_cod_quadra \r\n"
				+ "FROM manutencao m JOIN quadra q \r\n"
				+ "ON (q.qua_id = m.man_cod_quadra)"
				+ "WHERE m.man_id = ?");
		
		FileOutputStream out = new FileOutputStream("QUERY_CONSULTA_MANUTENCAO.properties");
		queriesManutencao.store(out, null);
		out.close();
	}
	
	public void DMLManutencao() throws IOException{
		
		queriesManutencao.setProperty("INSERT_INTO_MANUTENCAO", "INSERT INTO manutencao(man_id, man_desc, man_data, man_hr_inicio, man_hr_fim, "
				+ "man_prev, man_cod_quadra) VALUES(?, ?, DATE(?), ?, ?, ?, ?)");

		queriesManutencao.setProperty("UPDATE_MANUTENCAO_DESC", "UPDATE manutencao SET man_desc = ? WHERE man_id = ?");
		queriesManutencao.setProperty("UPDATE_MANUTENCAO_DATA", "UPDATE manutencao SET man_data ? WHERE man_id = ?");
		queriesManutencao.setProperty("UPDATE_MANUTENCAO_HORARIO_INICIO", "UPDATE manutencao SET man_hr_inicio = ? WHERE man_id = ?");
		queriesManutencao.setProperty("UPDATE_MANUTENCAO_HORARIO_FIM", "UPDATE manutencao SET man_hr_fim = ? WHERE man_id = ?");
		
		queriesManutencao.setProperty("DELETE_FROM_MANUTENCAO_BY_ID", "DELETE FROM manutencao WHERE man_id = ?");
				
		FileOutputStream out = new FileOutputStream("DML_MANUTENCAO.properties");
		queriesManutencao.store(out, null);
		out.close();
		
	}

}
