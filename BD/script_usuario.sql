/*PROJETA TODOS OS USUARIOS*/

SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', 
	   IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', 
       IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'
FROM usuario;

/*PROJETA USUARIO PELO ID*/
SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', 
	   IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', 
       IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'
FROM usuario
WHERE usu_id = ?;

/*PROJETA USUARIOS HABILITADOS OU NÃO*/
SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', 
	   IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', 
       IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'
FROM usuario
WHERE usu_habilitado = ?;

/*PROJETA USUARIOS BLOQUEADOS OU NÃO*/
SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', 
	   IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', 
       IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'
FROM usuario
WHERE usu_bloqueado = ?;


/*PROJETA USUARIOS COM PERMISSAO DE ZELADOR*/
SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', 
	   IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', 
       IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'
FROM usuario
WHERE usu_acesso_zelador = ?;

/*PROJETA USUARIOS COM PERMISSAO DE GESTOR DE USUARIO*/
SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', 
	   IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', 
       IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'
FROM usuario
WHERE usu_acesso_usuario = ?;

/*PROJETA USUARIOS COM PERMISSAO DE GESTOR DE QUADRAS*/
SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', 
	   IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', 
       IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'
FROM usuario
WHERE usu_acesso_gestor_quadra = ?;

/*PROJETA USUARIOS COM PERMISSAO DE RELATORIOS*/
SELECT usu_id 'ID', usu_nome 'Nome', usu_senha 'Senha', usu_email 'E-mail',date_format(usu_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', 
	   IF(usu_acesso_gestor_quadra,'Sim','Não') 'Gestor de Quadras', IF(usu_acesso_gestor_usuario,'Sim','Não') 'Gestor de Usuários', IF(usu_acesso_relatorio,'Sim','Não') 'Acesso a Relatórios', 
       IF(usu_acesso_zelador,'Sim', 'Não') 'Zelador', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'
FROM usuario
WHERE usu_acesso_relatorio = ?;


/*CADASTRAR USUARIO*/
INSERT INTO usuario(usu_nome, usu_senha, usu_email, usu_dt_cadastro) VALUES (?,?,?,?);

/*ALTERAR DADOS*/

/*SENHA*/
UPDATE usuario SET usu_senha = ? WHERE usu_id = ?;

/*NOME*/
UPDATE usuario SET usu_nome_completo = ? WHERE usu_id = ?;

/*EMAIL*/
UPDATE usuario SET usu_email = ? WHERE usu_id = ?;

/*ACESSO GESTOR QUADRA*/
UPDATE usuario SET usu_acesso_gestor_quadra = ? WHERE usu_id = ?;

/*ACESSO GESTOR USUARIO*/
UPDATE usuario SET usu_acesso_gestor_usuario = ? WHERE usu_id = ?;

/*ACESSO RELATORIOS*/
UPDATE usuario SET usu_acesso_relatorio = ? WHERE usu_id = ?;

/*ACESSO ZELADOR*/
UPDATE usuario SET usu_acesso_zelador = ? WHERE usu_id = ?;

/*HABILITAR OU DESABILITAR USUARIOS*/
UPDATE usuario SET usu_habilitado = ? WHERE usu_id = ?;

/*BLOQUEAR OU DESBLOQUEAR USUARIOS*/
UPDATE usuario SET usu_bloqueado = ? WHERE usu_id = ?;

/*DELETAR USUARIOS*/
DELETE FROM usuario WHERE usu_id = ?;
