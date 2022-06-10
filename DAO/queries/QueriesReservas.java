package queries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class QueriesReservas {

	Properties queriesReserva = new Properties();
	
	public void consultaReserva() throws IOException{
		
		queriesReserva.setProperty("SELECT_ALL_FROM_RESERVA", "SELECT r.res_id, r.res_id_cliente, r.res_hr_inicio, r.res_hr_fim, \r \n"
				+ "r.res_data, fp.fp_nome, r.res_parcelas, r.res_valor, r.res_cli_entrou, r.res_cli_saiu,"
				+ "q.qua_id, q.qua_nome, q.qua_endereco, q.qua_id_tipo, q.qua_cobertura, q.qua_arquibancada, q.qua_area_descanso, q.qua_bloqueado \r \n"
				+ "FROM reserva r JOIN forma_pagamento fp"
				+ "ON (r.res_id_forma_pagamento = fp.fp_id)"
				+ "JOIN quadra q"
				+ "ON (r.res_id_quadra = q.qua_id);");
		
		queriesReserva.setProperty("SELECT_ALL_FROM_RESERVA_BY_ID", "SELECT r.res_id, r.res_id_cliente, r.res_hr_inicio, r.res_hr_fim, \r \n"
				+ "r.res_data, fp.fp_nome, r.res_parcelas, r.res_valor, r.res_cli_entrou, r.res_cli_saiu,"
				+ "q.qua_id, q.qua_nome, q.qua_endereco, q.qua_id_tipo, q.qua_cobertura, q.qua_arquibancada, q.qua_area_descanso, q.qua_bloqueado \r \n"
				+ "FROM reserva r JOIN forma_pagamento fp"
				+ "ON (r.res_id_forma_pagamento = fp.fp_id)"
				+ "JOIN quadra q"
				+ "ON (r.res_id_quadra = q.qua_id);"
				+ "WHERE r.res_id = ?");
		
		queriesReserva.setProperty("SELECT_ALL_FROM_RESERVA_BY_DAY", "SELECT r.res_id, r.res_id_cliente, r.res_hr_inicio, r.res_hr_fim, \r \n"
				+ "r.res_data, fp.fp_nome, r.res_parcelas, r.res_valor, r.res_cli_entrou, r.res_cli_saiu,"
				+ "q.qua_id, q.qua_nome, q.qua_endereco, q.qua_id_tipo, q.qua_cobertura, q.qua_arquibancada, q.qua_area_descanso, q.qua_bloqueado \r \n"
				+ "FROM reserva r JOIN forma_pagamento fp"
				+ "ON (r.res_id_forma_pagamento = fp.fp_id)"
				+ "JOIN quadra q"
				+ "ON (r.res_id_quadra = q.qua_id);"
				+ "WHERE r.res_data = ?");
		
		queriesReserva.setProperty("SELECT_ALL_FROM_RESERVA_BY_DAY_AND_TIME", "SELECT r.res_id, r.res_id_cliente, r.res_hr_inicio, r.res_hr_fim, \r \n"
				+ "r.res_data, fp.fp_nome, r.res_parcelas, r.res_valor, r.res_cli_entrou, r.res_cli_saiu,"
				+ "q.qua_id, q.qua_nome, q.qua_endereco, q.qua_id_tipo, q.qua_cobertura, q.qua_arquibancada, q.qua_area_descanso, q.qua_bloqueado \r \n"
				+ "FROM reserva r JOIN forma_pagamento fp"
				+ "ON (r.res_id_forma_pagamento = fp.fp_id)"
				+ "JOIN quadra q"
				+ "ON (r.res_id_quadra = q.qua_id);"
				+ "WHERE r.res_data = ? AND r.res_hr_inicio >= ? AND r.res_hr_fim");
		
		queriesReserva.setProperty("SELECT_ALL_FROM_RESERVA_BY_INTERVAL_OF_DAYS", "SELECT r.res_id, r.res_id_cliente, r.res_hr_inicio, r.res_hr_fim, \r \n"
				+ "r.res_data, fp.fp_nome, r.res_parcelas, r.res_valor, r.res_cli_entrou, r.res_cli_saiu,"
				+ "q.qua_id, q.qua_nome, q.qua_endereco, q.qua_id_tipo, q.qua_cobertura, q.qua_arquibancada, q.qua_area_descanso, q.qua_bloqueado \r \n"
				+ "FROM reserva r JOIN forma_pagamento fp"
				+ "ON (r.res_id_forma_pagamento = fp.fp_id)"
				+ "JOIN quadra q"
				+ "ON (r.res_id_quadra = q.qua_id);"
				+ "WHERE r.res_data >= ? AND r.res_data <= ?");
		
		FileOutputStream out = new FileOutputStream("QUERY_RESERVA.properties");
		queriesReserva.store(out, null);
		out.close();
	}

}
