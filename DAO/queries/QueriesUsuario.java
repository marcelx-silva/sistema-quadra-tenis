package queries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class QueriesUsuario {
	
	public Properties queriesUsuario = new Properties();
	
	protected void consultarUsuario() throws IOException{
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_ALL_USUARIO", "SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', \r\n"
				+ "IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'\r\n"
				+ "FROM usuario;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_ID", "SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', \r\n"
				+ "IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_id = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_HABILITADO", "SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', \r\n"
				+ "IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_habilitado = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_USU_BLOQUEADO", "SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', \r\n"
				+ "IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_bloqueado = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_ACESSO_ZELADOR", "SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', \r\n"
				+ "IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_acesso_zelador = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_ACESSO_GESTOR_QUADRA", "SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', \r\n"
				+ "IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_acesso_gestor_quadra = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_ACESSO_GESTOR_USUARIO", "SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', \r\n"
				+ "IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_acesso_gestor_usuario = ?;");
		
		queriesUsuario.setProperty("SELECT_ALL_FROM_USUARIO_BY_ACESSO_RELATORIOS", "SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,\"%d-%m-%Y\") 'Data de Cadastro', \r\n"
				+ "IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', \r\n"
				+ "IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'\r\n"
				+ "FROM usuario\r\n"
				+ "WHERE usu_acesso_relatorio = ?;");
		
		FileOutputStream out =  new FileOutputStream("QUERY_CONSULTA_USUARIO.properties");

		
		queriesUsuario.store(out, null);
		out.close();
	}

}
