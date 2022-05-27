USE clube_tenisbd;

show tables;

DESC cliente;

/*Selecionar todos os clientes*/
SELECT cli_id 'ID', cli_nome 'Nome', cli_cpf 'CPF', cli_email 'E-MAIL', cli_celular 'Celular', cli_tel_fixo 'Telefone Fixo', 
	   date_format(cli_dt_nasc,"%d-%m-%Y") 'Data de Nascimento', date_format(cli_dt_registro,"%d-%m-%Y") 'Data de Cadastro', 
       IF(cli_bloqueado,'SIM','NÃO') 'Bloqueado', IF(cli_habilitado,'SIM','NÃO') 'Habilitado', IF(cli_invalidado,'SIM','NÃO') 'Invalidado' 
FROM cliente;

/*Seleciona cliente pelo identificador*/
SELECT cli_id 'ID', cli_nome 'Nome', cli_cpf 'CPF', cli_email 'E-MAIL', cli_celular 'Celular', cli_tel_fixo 'Telefone Fixo', 
	   date_format(cli_dt_nasc,"%d-%m-%Y") 'Data de Nascimento', date_format(cli_dt_registro,"%d-%m-%Y") 'Data de Cadastro', 
       IF(cli_bloqueado,'SIM','NÃO') 'Bloqueado', IF(cli_habilitado,'SIM','NÃO') 'Habilitado', IF(cli_invalidado,'SIM','NÃO') 'Invalidado' 
FROM cliente 
WHERE cli_id = ?;

/*Seleciona clientes bloqueados ou desbloqueados*/

SELECT cli_id 'ID', cli_nome 'Nome', cli_cpf 'CPF', cli_email 'E-MAIL', cli_celular 'Celular', cli_tel_fixo 'Telefone Fixo', 
	   date_format(cli_dt_nasc,"%d-%m-%Y") 'Data de Nascimento', date_format(cli_dt_registro,"%d-%m-%Y") 'Data de Cadastro', 
       IF(cli_bloqueado,'SIM','NÃO') 'Bloqueado', IF(cli_habilitado,'SIM','NÃO') 'Habilitado', IF(cli_invalidado,'SIM','NÃO') 'Invalidado' 
FROM cliente 
WHERE cli_bloqueado = ? ;


/*Seleciona clientes habilitados ou desablilitados*/

SELECT cli_id 'ID', cli_nome 'Nome', cli_cpf 'CPF', cli_email 'E-MAIL', cli_celular 'Celular', cli_tel_fixo 'Telefone Fixo', 
	   date_format(cli_dt_nasc,"%d-%m-%Y") 'Data de Nascimento', date_format(cli_dt_registro,"%d-%m-%Y") 'Data de Cadastro', 
       IF(cli_bloqueado,'SIM','NÃO') 'Bloqueado', IF(cli_habilitado,'SIM','NÃO') 'Habilitado', IF(cli_invalidado,'SIM','NÃO') 'Invalidado' 
FROM cliente 
WHERE cli_habilitado = ?;

/*Seleciona clientes invalidados ou validados*/
SELECT cli_id 'ID', cli_nome 'Nome', cli_cpf 'CPF', cli_email 'E-MAIL', cli_celular 'Celular', cli_tel_fixo 'Telefone Fixo', 
	   date_format(cli_dt_nasc,"%d-%m-%Y") 'Data de Nascimento', date_format(cli_dt_registro,"%d-%m-%Y") 'Data de Cadastro', 
       IF(cli_bloqueado,'SIM','NÃO') 'Bloqueado', IF(cli_habilitado,'SIM','NÃO') 'Habilitado', IF(cli_invalidado,'SIM','NÃO') 'Invalidado' 
FROM cliente 
WHERE cli_invalidado = ?;


/*Cadastra clintes*/

INSERT INTO cliente (cli_nome,cli_cpf,cli_dt_nasc,cli_dt_nasc,cli_email,cli_celular,cli_tel_fixo) VALUES('?','?',STR_TO_DATE('?',"%d-%m-%Y"),'?','?','?','?');

/*Atualizar Dados do Cliente*/

/*NOME*/
UPDATE cliente  SET cli_nome = '?' WHERE cli_id = '?';

/*EMAIL*/
UPDATE cliente  SET cli_email = '?' WHERE cli_id = '?';

/*CELULAR*/
UPDATE cliente  SET cli_celular = '?' WHERE cli_id = '?';

/*TELEFONE-FIXO*/
UPDATE cliente SET cli_tel_fixo = '?' WHERE cli_id = '?';

/*Bloquear e Desbloquear Cliente*/
UPDATE cliente SET cli_bloqueado = '?' WHERE cli_id = '?';

/*Validar e Invalidar Cliente*/
UPDATE cliente SET cli_invalidado = '?' WHERE cli_id = '?';

/*Habilitar e Desabilitar Cliente*/
UPDATE cliente SET cli_habilitado = '?' WHERE cli_id = '?';

/*Deletar cliente*/
DELETE FROM cliente WHERE cli_id = '?';


SELECT date_format(CURRENT_TIMESTAMP,"%d-%m-%y");

SELECT date_format(str_to_date("10-02-2003","%d-%m-%Y"),"%d-%m-%Y");

