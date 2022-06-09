package queries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class QueriesReservas {

	Properties queriesReserva = new Properties();
	
	public void consultaReserva() throws IOException{
		
		queriesReserva.setProperty("SELECT_ALL_FROM_RESERVA", "SELECT r.res_id, r.res_id_cliente, r.res_hr_inicio, r.res_hr_fim \r \n"
				+ "r.res_data, r.res_id_quadra, fp.fp_nome, r.res_parcelas, r.res_valor, r.res_cli_entrou, r.res_cli_saiu \r \n"
				+ "FROM reserva r JOIN forma_pagamento fp"
				+ "ON (r.res_id_forma_pagamento = fp.fp_id);");
		
		FileOutputStream out = new FileOutputStream("QUERY_RESERVA.properties");
		queriesReserva.store(out, null);
		out.close();
	}

}
