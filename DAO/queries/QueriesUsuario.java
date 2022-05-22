package queries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class QueriesUsuario {
	
	Properties queriesUsuario = new Properties();
	
	protected void consultarUsuario() throws IOException{
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_ALL_USUARIO", "SELECT usu_id 'ID', usu_nome_completo 'Nome', usu_login 'USER_LOGIN', usu_senha 'USER_SENHA',"
				+ " usu_email 'E-MAIL',date_format(usu_dt_cadastro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "usu_id_permissao 'Permissão', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'\r\n"
				+ "FROM usuario;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_ID", "SELECT  usu_id 'ID', usu_nome_completo 'Nome', usu_login 'USER_LOGIN', usu_senha 'USER_SENHA', usu_email 'E-MAIL',"
				+ "date_format(usu_dt_cadastro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "usu_id_permissao 'Permissão', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_id = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_USU_BLOQUEADO", "SELECT  usu_id 'ID', usu_nome_completo 'Nome', usu_login 'USER_LOGIN', usu_senha 'USER_SENHA', usu_email 'E-MAIL',"
				+ "date_format(usu_dt_cadastro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "usu_id_permissao 'Permissão', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_bloqueado = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_PERMISSAO_ID", "SELECT  usu_id 'ID', usu_nome_completo 'Nome', usu_login 'USER_LOGIN', usu_senha 'USER_SENHA', usu_email 'E-MAIL',"
				+ "date_format(usu_dt_cadastro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "usu_id_permissao 'Permissão', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_permissao = ?;");
		
		FileOutputStream out =  new FileOutputStream("QUERY_CONSULTA_USUARIO.properties");

		
		queriesUsuario.store(out, null);
		out.close();
	}

}
