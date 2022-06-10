package queries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class QueriesReservas {

	public Properties queriesReserva = new Properties();
	
	public void consultaReserva() throws IOException{
		
		queriesReserva.setProperty("SELECT_ALL_FROM_RESERVA", "SELECT r.res_id, r.res_hr_inicio, r.res_hr_fim, \r \n"
				+ "r.res_data, fp.fp_id, r.res_parcelas, r.res_valor, r.res_cli_entrou, r.res_cli_saiu, \r \n"
				+ "q.qua_id, q.qua_nome, q.qua_endereco, q.qua_id_tipo, q.qua_cobertura, q.qua_arquibancada, q.qua_area_descanso, q.qua_bloqueado \r \n"
				+ "c.cli_nome, c.cli_email, c.cli_cpf, c.cli_celular, c.cli_dt_nasc, c.cli_bloqueado, c.cli_restrito"
				+ "FROM reserva r JOIN forma_pagamento fp"
				+ "ON (r.res_id_forma_pagamento = fp.fp_id)"
				+ "JOIN quadra q"
				+ "ON (r.res_id_quadra = q.qua_id)"
				+ "JOIN cliente c"
				+ "ON (r.res_id_cliente = c.cli_id);");
			        
		queriesReserva.setProperty("SELECT_ALL_FROM_RESERVA_BY_ID", "SELECT r.res_id, r.res_id_cliente, r.res_hr_inicio, r.res_hr_fim, \r \n"
				+ "r.res_data, fp.fp_nome, r.res_parcelas, r.res_valor, r.res_cli_entrou, r.res_cli_saiu,"
				+ "q.qua_id, q.qua_nome, q.qua_endereco, q.qua_id_tipo, q.qua_cobertura, q.qua_arquibancada, q.qua_area_descanso, q.qua_bloqueado \r \n"
				+ "FROM reserva r JOIN forma_pagamento fp"
				+ "ON (r.res_id_forma_pagamento = fp.fp_id)"
				+ "JOIN quadra q"
				+ "ON (r.res_id_quadra = q.qua_id);"
				+ "WHERE r.res_id = ?");
		
		queriesReserva.setProperty("SELECT_ALL_FROM_RESERVA_BY_DAY", "SELECT r.res_id, r.res_hr_inicio, r.res_hr_fim, \r \n"
				+ "r.res_data, fp.fp_id, r.res_parcelas, r.res_valor, r.res_cli_entrou, r.res_cli_saiu, \r \n"
				+ "q.qua_id, q.qua_nome, q.qua_endereco, q.qua_id_tipo, q.qua_cobertura, q.qua_arquibancada, q.qua_area_descanso, q.qua_bloqueado \r \n"
				+ "c.cli_nome, c.cli_email, c.cli_cpf, c.cli_celular, c.cli_dt_nasc, c.cli_bloqueado, c.cli_restrito"
				+ "FROM reserva r JOIN forma_pagamento fp"
				+ "ON (r.res_id_forma_pagamento = fp.fp_id)"
				+ "JOIN quadra q"
				+ "ON (r.res_id_quadra = q.qua_id)"
				+ "JOIN cliente c"
				+ "ON (r.res_id_cliente = c.cli_id);"
				+ "WHERE r.res_data = ?");
		
		queriesReserva.setProperty("SELECT_ALL_FROM_RESERVA_BY_DAY_AND_TIME", "SELECT r.res_id, r.res_hr_inicio, r.res_hr_fim, \r \n"
				+ "r.res_data, fp.fp_id, r.res_parcelas, r.res_valor, r.res_cli_entrou, r.res_cli_saiu, \r \n"
				+ "q.qua_id, q.qua_nome, q.qua_endereco, q.qua_id_tipo, q.qua_cobertura, q.qua_arquibancada, q.qua_area_descanso, q.qua_bloqueado \r \n"
				+ "c.cli_nome, c.cli_email, c.cli_cpf, c.cli_celular, c.cli_dt_nasc, c.cli_bloqueado, c.cli_restrito"
				+ "FROM reserva r JOIN forma_pagamento fp"
				+ "ON (r.res_id_forma_pagamento = fp.fp_id)"
				+ "JOIN quadra q"
				+ "ON (r.res_id_quadra = q.qua_id)"
				+ "JOIN cliente c"
				+ "ON (r.res_id_cliente = c.cli_id);"
				+ "WHERE r.res_data = ? AND r.res_hr_inicio >= ? AND r.res_hr_fim");
		
		queriesReserva.setProperty("SELECT_ALL_FROM_RESERVA_BY_INTERVAL_OF_DAYS", "SELECT r.res_id, r.res_hr_inicio, r.res_hr_fim, \r \n"
				+ "r.res_data, fp.fp_id, r.res_parcelas, r.res_valor, r.res_cli_entrou, r.res_cli_saiu, \r \n"
				+ "q.qua_id, q.qua_nome, q.qua_endereco, q.qua_id_tipo, q.qua_cobertura, q.qua_arquibancada, q.qua_area_descanso, q.qua_bloqueado \r \n"
				+ "c.cli_nome, c.cli_email, c.cli_cpf, c.cli_celular, c.cli_dt_nasc, c.cli_bloqueado, c.cli_restrito"
				+ "FROM reserva r JOIN forma_pagamento fp"
				+ "ON (r.res_id_forma_pagamento = fp.fp_id)"
				+ "JOIN quadra q"
				+ "ON (r.res_id_quadra = q.qua_id)"
				+ "JOIN cliente c"
				+ "ON (r.res_id_cliente = c.cli_id);"
				+ "WHERE r.res_data >= ? AND r.res_data <= ?");
		
		FileOutputStream out = new FileOutputStream("QUERY_RESERVA.properties");
		queriesReserva.store(out, null);
		out.close();
	}
	
	public void DMLReserva() throws IOException{
		
		queriesReserva.setProperty("INSERT_INTO_RESERVA", "INSERT INTO reserva (res_id_cliente, res_hr_inicio, res_hr_fim, res_data, res_id_quadra, res_id_forma_pagamento, res_parcelas,"
				+ " res_valor, res_cli_entrou, res_cli_saiu) VALUES(?, ?, ?, DATE(?), ?, ?, ?, ?, ?, ?)");
		
		queriesReserva.setProperty("DELETE_FROM_RESERVA", "DELETE FROM reserva WHERE res_id = ?");
		
		queriesReserva.setProperty("REGISTER_CUSTOMER_ENTRANCE", "UPDATE reserva SET res_cli_entrou = CURRENT_TIMESTAMP WHERE res_id = ?");
		queriesReserva.setProperty("REGISTER_CUSTOMER_EXIT", "UPDATE reserva SET res_cli_saiu = CURRENT_TIMESTAMP WHERE res_id = ?");
		
		queriesReserva.setProperty("REGISTER_CUSTOMER_PAYMENT", "UPDATE reserva SET res_cli_pagou = ?");
		
		FileOutputStream out = new FileOutputStream("DML_RESERVA.properties");
		queriesReserva.store(out, null);
		out.close();
	}

}
