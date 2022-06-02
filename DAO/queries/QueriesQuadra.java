package queries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class QueriesQuadra {

	public Properties queriesQuadra = new Properties();
	
	public void consultaQuadra() throws IOException{
		
		queriesQuadra.setProperty("SELECT_ALL_FROM_ALL_QUADRA","SELECT  q.qua_id , q.qua_nome, q.qua_endereco, q.qua_cobertura, \r\n"
				+ "q.qua_arquibancada, q.qua_area_descanso, \r\n"
				+ "date_format(q.qua_dt_cadastro,\"%d-%m-%Y\"), q.qua_id_tipo, tp.tp_nome, q.qua_bloqueado, \r\n"
				+ "q.qua_habilitado\r\n"
				+ "FROM quadra q JOIN tipo_quadra tp\r\n"
				+ "ON (q.qua_id_tipo = tp_id)");
		
		queriesQuadra.setProperty("SELECT_ALL_BLOCKED_QUADRA", "SELECT  q.qua_id , q.qua_nome, q.qua_endereco, q.qua_cobertura, \r\n"
				+ "q.qua_arquibancada, q.qua_area_descanso, \r\n"
				+ "date_format(q.qua_dt_cadastro,\"%d-%m-%Y\"), q.qua_id_tipo, tp.tp_nome, q.qua_bloqueado, \r\n"
				+ "q.qua_habilitado\r\n"
				+ "FROM quadra q JOIN tipo_quadra tp\r\n"
				+ "ON (q.qua_id_tipo = tp_id)\r\n"
				+ "WHERE qua_bloqueado = ?");
		
		queriesQuadra.setProperty("SELECT_DISABLE_QUADRA", "SELECT  q.qua_id , q.qua_nome, q.qua_endereco, q.qua_cobertura, \r\n"
				+ "q.qua_arquibancada, q.qua_area_descanso, \r\n"
				+ "date_format(q.qua_dt_cadastro,\"%d-%m-%Y\"), q.qua_id_tipo, tp.tp_nome, q.qua_bloqueado, \r\n"
				+ "q.qua_habilitado\r\n"
				+ "FROM quadra q JOIN tipo_quadra tp\r\n"
				+ "ON (q.qua_id_tipo = tp_id)\r\n"
				+ "WHERE q.qua_habilitado = ?");
		
		queriesQuadra.setProperty("SELECT_FROM_QUADRA_BY_ID", "SELECT  q.qua_id , q.qua_nome, q.qua_endereco, q.qua_cobertura, \r\n"
				+ "q.qua_arquibancada, q.qua_area_descanso, \r\n"
				+ "date_format(q.qua_dt_cadastro,\"%d-%m-%Y\"), q.qua_id_tipo, tp.tp_nome, q.qua_bloqueado, \r\n"
				+ "q.qua_habilitado\r\n"
				+ "FROM quadra q JOIN tipo_quadra tp\r\n"
				+ "ON (q.qua_id_tipo = tp_id)\r\n"
				+ "WHERE q.qua_id = ?");
		
		queriesQuadra.setProperty("VERIFY_QUADRA_BY_QUA_NOME", "SELECT qua_nome\r\n"
				+ "FROM quadra\r\n"
				+ "WHERE qua_nome = ?");
		
		FileOutputStream out = new FileOutputStream("QUERY_CONSULTA_QUADRA.properties");
		queriesQuadra.store(out, null);
		out.close();
	}
	
	public void DMLQuadra() throws IOException{
		queriesQuadra.setProperty("INSERT_INTO_QUADRA", "INSERT INTO quadra (qua_nome,qua_endereco,qua_cobertura,qua_arquibancada,qua_area_descanso,qua_id_tipo) VALUES (?,?,?,?,?,?)");
		
		queriesQuadra.setProperty("UPDATE_QUADRA_NOME", "UPDATE quadra SET qua_nome = ? WHERE qua_id = ?");
		
		queriesQuadra.setProperty("UPDATE_QUADRA_ENDERECO", "UPDATE quadra SET qua_endereco = ? WHERE qua_id = ?");
		
		queriesQuadra.setProperty("UPDATE_QUADRA_COBERTURA", "UPDATE quadra SET qua_cobertura = ? WHERE qua_id = ?");
		
		queriesQuadra.setProperty("UPDATE_QUADRA_ARQUIBANCADA", "UPDATE quadra SET qua_arquibancada = ? WHERE qua_id = ?");
		
		queriesQuadra.setProperty("UPDATE_QUADRA_AREA_DESCANSO", "UPDATE quadra SET qua_area_descanso = ? WHERE qua_id = ?");
		
		queriesQuadra.setProperty("UPDATE_QUADRA_TIPO", "UPDATE quadra SET qua_id_tipo = ? WHERE qua_id = ?");
		
		queriesQuadra.setProperty("UPDATE_QUADRA_BLOQUEADO", "UPDATE quadra SET qua_bloqueado = ? WHERE qua_id = ?");
		
		queriesQuadra.setProperty("UPDATE_QUADRA_HABILITADO", "UPDATE quadra SET qua_habilitado = ? WHERE qua_id = ?");
		
		queriesQuadra.setProperty("DELETE_QUADRA", "DELETE FROM quadra WHERE qua_id = ?");
		
		FileOutputStream out = new FileOutputStream("DML_QUADRA.properties");
		queriesQuadra.store(out, null);
		out.close();
		
	}
	
}
