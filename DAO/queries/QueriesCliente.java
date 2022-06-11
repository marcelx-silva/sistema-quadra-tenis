package queries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class QueriesCliente {
	
	public Properties queriesCliente = new Properties();
	
	public void consultaCliente() throws IOException {
		
		queriesCliente.setProperty("SELECT_ALL_FROM_ALL_CLIENT","SELECT cli_id 'ID', cli_nome 'Nome', cli_cpf 'CPF', cli_email 'E-MAIL', cli_celular 'Celular', \r\n"
				+ "date_format(cli_dt_nasc,\"%d-%m-%Y\") 'Data de Nascimento', date_format(cli_dt_registro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "IF(cli_bloqueado,'SIM','N�O') 'Bloqueado', IF(cli_habilitado,'SIM','N�O') 'Habilitado', IF(cli_invalidado,'SIM','N�O') 'Invalidado' \r\n"
				+ "FROM cliente"
				+ "WHERE cli_habilitado <> false");
		
		queriesCliente.setProperty("SELECT_ALL_FROM_CLIENT_BY_ID","SELECT cli_id 'ID', cli_nome 'Nome', cli_cpf 'CPF', cli_email 'E-MAIL', cli_celular 'Celular', \r\n"
				+ "date_format(cli_dt_nasc,\"%d-%m-%Y\") 'Data de Nascimento', date_format(cli_dt_registro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "IF(cli_bloqueado,'SIM','N�O') 'Bloqueado', IF(cli_habilitado,'SIM','N�O') 'Habilitado', IF(cli_invalidado,'SIM','N�O') 'Invalidado' \r\n"
				+ "FROM cliente \r\n"
				+ "WHERE cli_habilitado <> false"
				+ "AND cli_id = ?");
		
		queriesCliente.setProperty("SELECT_ALL_FROM_CLIENT_BY_CPF","SELECT cli_id 'ID', cli_nome 'Nome', cli_cpf 'CPF', cli_email 'E-MAIL', cli_celular 'Celular', \r\n"
				+ "date_format(cli_dt_nasc,\"%d-%m-%Y\") 'Data de Nascimento', date_format(cli_dt_registro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "IF(cli_bloqueado,'SIM','N�O') 'Bloqueado', IF(cli_habilitado,'SIM','N�O') 'Habilitado', IF(cli_invalidado,'SIM','N�O') 'Invalidado' \r\n"
				+ "FROM cliente \r\n"
				+ "WHERE cli_habilitado <> false"
				+ "AND cli_cpf = ?");
		
		queriesCliente.setProperty("SELECT_DISABLE_STATUS_FROM_CLIENT_BY_CPF","SELECT cli_habilitado FROM cliente WHERE cli_cpf = ? ");
		
		queriesCliente.setProperty("SELECT_BLOCK_STATUS_FROM_CLIENT_BY_CPF","SELECT cli_bloqueado FROM cliente WHERE cli_cpf = ? ");
		
		queriesCliente.setProperty("SELECT_INVALID_STATUS_FROM_CLIENT_BY_CPF","SELECT cli_invalidado FROM cliente WHERE cli_cpf = ? ");
		
		queriesCliente.setProperty("SELECT_ALL_BLOCKED_CLIENT","SELECT cli_id 'ID', cli_nome 'Nome', cli_cpf 'CPF', cli_email 'E-MAIL', cli_celular 'Celular', \r\n"
				+ "date_format(cli_dt_nasc,\"%d-%m-%Y\") 'Data de Nascimento', date_format(cli_dt_registro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "IF(cli_bloqueado,'SIM','N�O') 'Bloqueado', IF(cli_habilitado,'SIM','N�O') 'Habilitado', IF(cli_invalidado,'SIM','N�O') 'Invalidado' \r\n"
				+ "FROM cliente WHERE cli_bloqueado = ? ");
		
		
		queriesCliente.setProperty("SELECT_ALL_DISABLE_CLIENT","SELECT cli_id 'ID', cli_nome 'Nome', cli_cpf 'CPF', cli_email 'E-MAIL', cli_celular 'Celular', \r\n"
				+ "date_format(cli_dt_nasc,\"%d-%m-%Y\") 'Data de Nascimento', date_format(cli_dt_registro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "IF(cli_bloqueado,'SIM','N�O') 'Bloqueado', IF(cli_habilitado,'SIM','N�O') 'Habilitado', IF(cli_invalidado,'SIM','N�O') 'Invalidado' \r\n"
				+ "FROM cliente \r\n"
				+ "WHERE cli_habilitado = ?");
		
		
		queriesCliente.setProperty("SELECT_ALL_INVALID_CLIENT","SELECT cli_id 'ID', cli_nome 'Nome', cli_cpf 'CPF', cli_email 'E-MAIL', cli_celular 'Celular',  \r\n"
				+ "date_format(cli_dt_nasc,\"%d-%m-%Y\") 'Data de Nascimento', date_format(cli_dt_registro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "IF(cli_bloqueado,'SIM','N�O') 'Bloqueado', IF(cli_habilitado,'SIM','N�O') 'Habilitado', IF(cli_invalidado,'SIM','N�O') 'Invalidado' \r\n"
				+ "FROM cliente \r\n"
				+ "WHERE cli_invalidado = ?");
	
		FileOutputStream out =  new FileOutputStream("QUERY_CONSULTA_CLIENTE.properties");

		
		queriesCliente.store(out, null);
		out.close();
	}
	
	public void DMLCliente() throws IOException{
		
		queriesCliente.setProperty("INSERT_INTO_CLIENT", "INSERT INTO cliente (cli_nome,cli_cpf,cli_dt_nasc,cli_dt_nasc,cli_email,cli_celular) "
									+ "VALUES(?,?,STR_TO_DATE(?,\"%d-%m-%Y\"),?,?,?)");
		
		
		queriesCliente.setProperty("UPDATE_CLIENT_NAME", "UPDATE cliente  SET cli_nome = ? WHERE cli_cpf = ?");
		
		queriesCliente.setProperty("UPDATE_CLIENT_EMAIL", "UPDATE cliente  SET cli_email = ? WHERE cli_cpf = '?");
	
		queriesCliente.setProperty("UPDATE_CLIENT_CELL_PHONE", "UPDATE cliente  SET cli_celular = ? WHERE cli_cpf = ?");
		
		
		queriesCliente.setProperty("BLOCK_CLIENT", "UPDATE cliente SET cli_bloqueado = ? WHERE cli_cpf = ?");
		
		queriesCliente.setProperty("INVALIDATE_CLIENT", "UPDATE cliente SET cli_invalidado = ? WHEREcli_cpf = ?");
		
		queriesCliente.setProperty("DISABLE_CLIENT", "UPDATE cliente SET cli_habilitado = ? WHERE cli_cpf = ?");
		
		queriesCliente.setProperty("DELETE_CLIENT", "DELETE FROM cliente WHERE cli_cpf = ?");
		
		FileOutputStream out =  new FileOutputStream("QUERY_DML_CLIENTE.properties");

		
		queriesCliente.store(out, null);
		out.close();
	}
}
