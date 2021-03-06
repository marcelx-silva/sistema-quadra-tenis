package queries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class QueriesUsuario {
	
	public Properties queriesUsuario = new Properties();
	
	public void consultarUsuario() throws IOException{
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_ALL_USUARIO", "SELECT usu_id, usu_nome, usu_senha, usu_email, \r\n"
				+ "usu_acesso_gestor_quadra, usu_acesso_gestor_usuario, usu_acesso_relatorio, \r\n"
				+ "usu_acesso_zelador, usu_bloqueado, usu_habilitado 'usu_habilitado'\r\n"
				+ "FROM usuario\r\n");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_ID", "SELECT usu_id, usu_nome, usu_senha, usu_email, \r\n"
				+ "usu_acesso_gestor_quadra, usu_acesso_gestor_usuario, usu_acesso_relatorio, \r\n"
				+ "usu_acesso_zelador, usu_bloqueado, usu_habilitado 'usu_habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_id = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_EMAIL", "SELECT usu_id, usu_nome, usu_senha, usu_email, \r\n"
				+ "usu_acesso_gestor_quadra, usu_acesso_gestor_usuario, usu_acesso_relatorio, \r\n"
				+ "usu_acesso_zelador, usu_bloqueado, usu_habilitado 'usu_habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_email = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_HABILITADO", "SELECT usu_id, usu_nome, usu_senha, usu_email, \r\n"
				+ "usu_acesso_gestor_quadra, usu_acesso_gestor_usuario, usu_acesso_relatorio, \r\n"
				+ "usu_acesso_zelador, usu_bloqueado, usu_habilitado 'usu_habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_habilitado = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_USU_BLOQUEADO", "SELECT usu_id, usu_nome, usu_senha, usu_email, \r\n"
				+ "usu_acesso_gestor_quadra, usu_acesso_gestor_usuario, usu_acesso_relatorio, \r\n"
				+ "usu_acesso_zelador, usu_bloqueado, usu_habilitado 'usu_habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_bloqueado = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_ACESSO_ZELADOR", "SELECT usu_id, usu_nome, usu_senha, usu_email, \r\n"
				+ "usu_acesso_gestor_quadra, usu_acesso_gestor_usuario, usu_acesso_relatorio, \r\n"
				+ "usu_acesso_zelador, usu_bloqueado, usu_habilitado 'usu_habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_acesso_zelador = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_ACESSO_GESTOR_QUADRA", "SELECT usu_id, usu_nome, usu_senha, usu_email, \r\n"
				+ "usu_acesso_gestor_quadra, usu_acesso_gestor_usuario, usu_acesso_relatorio, \r\n"
				+ "usu_acesso_zelador, usu_bloqueado, usu_habilitado 'usu_habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_acesso_gestor_quadra = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_ACESSO_GESTOR_USUARIO", "SELECT usu_id, usu_nome, usu_senha, usu_email, \r\n"
				+ "usu_acesso_gestor_quadra, usu_acesso_gestor_usuario, usu_acesso_relatorio, \r\n"
				+ "usu_acesso_zelador, usu_bloqueado, usu_habilitado 'usu_habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_acesso_gestor_usuario = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_ACESSO_RELATORIOS", "SELECT usu_id, usu_nome, usu_senha, usu_email, \r\n"
				+ "usu_acesso_gestor_quadra, usu_acesso_gestor_usuario, usu_acesso_relatorio, \r\n"
				+ "usu_acesso_zelador, usu_bloqueado, usu_habilitado 'usu_habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_acesso_relatorio = ?;");
		
		queriesUsuario.setProperty("VERIFY_USU_EMAIL_AND_USU_SENHA", "SELECT usu_email, usu_senha, usu_bloqueado\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_email = ? AND usu_senha = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_USU_BLOQUEADO", "SELECT usu_id, usu_nome, usu_senha, usu_email, \r\n"
				+ "usu_acesso_gestor_quadra, usu_acesso_gestor_usuario, usu_acesso_relatorio, \r\n"
				+ "usu_acesso_zelador, usu_bloqueado, usu_habilitado 'usu_habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_bloqueado = ?;");
		
		FileOutputStream out =  new FileOutputStream("QUERY_CONSULTA_USUARIO.properties");

		
		queriesUsuario.store(out, null);
		out.close();
	}
	
	public void DMLUsuario() throws IOException{
		
		queriesUsuario.setProperty("INSERT_INTO_USUARIO", "INSERT INTO usuario(usu_nome, usu_email, usu_senha) VALUES (?,?,?);");
		
		queriesUsuario.setProperty("UPDATE_USU_NOME", "UPDATE usuario SET usu_nome = ? WHERE usu_email = ?;");
		queriesUsuario.setProperty("UPDATE_USU_SENHA", "UPDATE usuario SET usu_senha = ? WHERE usu_email = ?;");
		
		queriesUsuario.setProperty("BLOCK_USU_BY_EMAIL", "UPDATE usuario SET usu_bloqueado = ? WHERE usu_email = ?");
		queriesUsuario.setProperty("DISABLE_USU_BY_EMAIL", "UPDATE usuario SET usu_habilitado = ? WHERE usu_email = ?");
		
		queriesUsuario.setProperty("UPDATE_USU_ACESSO_GESTOR_QUADRA", "UPDATE usuario SET usu_acesso_gestor_quadra = ? WHERE usu_email = ?;");
		queriesUsuario.setProperty("UPDATE_USU_ACESSO_GESTOR_USUARIO", "UPDATE usuario SET usu_acesso_gestor_usuario = ? WHERE usu_email = ?;");
		queriesUsuario.setProperty("UPDATE_USU_ACESSO_RELATORIO", "UPDATE usuario SET usu_acesso_relatorio = ? WHERE usu_email = ?");
		queriesUsuario.setProperty("UPDATE_USU_ACESSO_ZELADOR", "UPDATE usuario SET usu_acesso_zelador = ? WHERE usu_email = ?");
		
		queriesUsuario.setProperty("DELETE_USUARIO_BY_EMAIL", "DELETE FROM usuario WHERE usu_email = ?");
		
		FileOutputStream out = new FileOutputStream("DML_USUARIO.properties");
		queriesUsuario.store(out, null);
		out.close();
	}

}
