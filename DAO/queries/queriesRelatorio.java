package queries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class queriesRelatorio {

	public Properties queriesRelatorio = new Properties();
	
	public void consultaRelatorios() throws IOException{

		queriesRelatorio.setProperty("RECEIPT_BY_QUA_ID_AND_INTERVAL_OF_DAYS", "SELECT AVG(r.res_valor) 'res_valor', q.qua_nome, q.qua_id, q.qua_nome, q.qua_endereco, q.qua_id_tipo, "
				+ "q.qua_cobertura, q.qua_arquibancada, q.qua_area_descanso\r\n"
				+ "FROM reserva r JOIN forma_pagamento fp\r\n"
				+ "ON (r.res_id_forma_pagamento = fp.fp_id)\r\n"
				+ "JOIN quadra q\r\n"
				+ "ON (r.res_id_quadra = q.qua_id)\r\n"
				+ "WHERE q.qua_id = ? AND r.res_data >= ? AND r.res_data <= ?");
		
		queriesRelatorio.setProperty("RECEIPT_BY_INTERVAL_OF_DAYS", "SELECT AVG(res_valor) 'res_valor'\r\n"
				+ "FROM reserva\r\n"
				+ "WHERE res_data >= ? AND res_data <= ?");
		
		queriesRelatorio.setProperty("RECEIPT_BY_DAY", "SELECT AVG(res_valor) 'res_valor'\r\n"
				+ "FROM reserva\r\n"
				+ "WHERE res_data = ?");
		
		queriesRelatorio.setProperty("RESERVATION_BY_DAY_OF_WEEK", "SELECT COUNT(r.res_id), q.qua_nome, q.qua_id, q.qua_nome, q.qua_endereco, q.qua_id_tipo,"
				+ "q.qua_cobertura, q.qua_arquibancada, q.qua_area_descanso, DAYOFWEEK(r.res_data)\r\n"
				+ "FROM reserva r JOIN quadra q\r\n"
				+ "ON(r.res_id_quadra = q.qua_id)\r\n"
				+ "GROUP BY DAYOFWEEK(r.res_data); ");
		
		FileOutputStream out = new FileOutputStream("QUERY_RELATORIOS.properties");
		queriesRelatorio.store(out, null);
		out.close();
	}
}
