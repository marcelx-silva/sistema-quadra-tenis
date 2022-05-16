/*PROJETA TODOS OS USUARIOS*/

SELECT usu_id 'ID', usu_nome_completo 'Nome', usu_login 'USER_LOGIN', usu_senha 'USER_SENHA', usu_email 'E-MAIL',date_format(usu_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', 
	   usu_id_permissao 'Permissão', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'
FROM usuario;

/*PROJETA USUARIO PELO ID*/
SELECT  usu_id 'ID', usu_nome_completo 'Nome', usu_login 'USER_LOGIN', usu_senha 'USER_SENHA', usu_email 'E-MAIL',date_format(usu_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', 
	    usu_id_permissao 'Permissão', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'
FROM usuario
WHERE usu_id = ?;

/*PROJETA USUARIOS HABILITADOS OU NÃO*/
SELECT usu_id 'ID', usu_nome_completo 'Nome', usu_login 'USER_LOGIN', usu_senha 'USER_SENHA', usu_email 'E-MAIL',date_format(usu_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', 
	    usu_id_permissao 'Permissão', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'
FROM usuario
WHERE usu_habilitado = ?;

/*PROJETA USUARIOS BLOQUEADOS OU NÃO*/
SELECT  usu_id 'ID', usu_nome_completo 'Nome', usu_login 'USER_LOGIN', usu_senha 'USER_SENHA', usu_email 'E-MAIL',date_format(usu_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', 
	    usu_id_permissao 'Permissão', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'
FROM usuario
WHERE usu_bloqueado = ?;


/*PROJETA USUARIOS PELA PERMISSAO*/
SELECT  usu_id 'ID', usu_nome_completo 'Nome', usu_login 'USER_LOGIN', usu_senha 'USER_SENHA', usu_email 'E-MAIL',date_format(usu_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', 
	    usu_id_permissao 'Permissão', IF(usu_bloqueado,'Sim','Não') 'Bloqueado', IF(usu_habilitado,'Sim','Não') 'Habilitado'
FROM usuario
WHERE usu_permissao = ?;


/*CADASTRAR USUARIO*/
INSERT INTO usuario(usu_nome_completo,usu_senha,usu_login,usu_email,usu_id_permissao) VALUES (?,?,?,?,?);

/*ALTERAR DADOS*/

/*SENHA*/
UPDATE usuario SET usu_senha = ? WHERE usu_id = ?;

/*SENHA*/
UPDATE usuario SET usu_login = ? WHERE usu_id = ?;

/*NOME*/
UPDATE usuario SET usu_nome_completo = ? WHERE usu_id = ?;

/*EMAIL*/
UPDATE usuario SET usu_email = ? WHERE usu_id = ?;

/*PERMISSAO*/
UPDATE usuario SET usu_id_permissao = ? WHERE usu_id = ?;

/*HABILITAR OU DESABILITAR USUARIOS*/
UPDATE usuario SET usu_habilitado = ? WHERE usu_id = ?;

/*BLOQUEAR OU DESBLOQUEAR USUARIOS*/
UPDATE usuario SET usu_bloqueado = ? WHERE usu_id = ?;

/*DELETAR USUARIOS*/
DELETE FROM usuario WHERE usu_id = ?;