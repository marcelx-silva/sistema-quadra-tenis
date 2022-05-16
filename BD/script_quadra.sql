
/*PROJETAR TODAS AS QUADRAS*/
SELECT  qua_id 'ID', qua_nome 'Nome', qua_endereco 'Localidade', IF(qua_cobertura,'Possui','Não Possui') 'Cobertura', 
        IF(qua_arquibancada,'Possui','Não Possui') 'Arquibancada', IF(qua_area_descanso,'Possui','Não Possui') 'Área de Descanso' , 
	    date_format(qua_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', qua_id_tipo 'Tipo', IF(qua_bloqueado ,'Sim','Não') 'Bloqueada', 
	    IF(qua_habilitado ,'Sim','Não')  'Habilitada'
FROM quadra;


/*PROJETAR QUADRAS HABILITAS OU DESABILITADAS*/
SELECT  qua_id 'ID', qua_nome 'Nome', qua_endereco 'Localidade', IF(qua_cobertura,'Possui','Não Possui') 'Cobertura', 
        IF(qua_arquibancada,'Possui','Não Possui') 'Arquibancada', IF(qua_area_descanso,'Possui','Não Possui') 'Área de Descanso' , 
	   date_format(qua_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', qua_id_tipo 'Tipo', IF(qua_bloqueado ,'Sim','Não') 'Bloqueada', 
	    IF(qua_habilitado ,'Sim','Não')  'Habilitada'
FROM quadra
WHERE qua_habilitada = ?;



/*PROJETAR QUADRAS BLOQUEADAS OU DESBLOQUEADAS*/
SELECT  qua_id 'ID', qua_nome 'Nome', qua_endereco 'Localidade', IF(qua_cobertura,'Possui','Não Possui') 'Cobertura', 
        IF(qua_arquibancada,'Possui','Não Possui') 'Arquibancada', IF(qua_area_descanso,'Possui','Não Possui') 'Área de Descanso' , 
	    date_format(qua_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', qua_id_tipo 'Tipo', IF(qua_bloqueado ,'Sim','Não') 'Bloqueada', 
	    IF(qua_habilitado ,'Sim','Não')  'Habilitada'
FROM quadra
WHERE qua_bloqueada = ?;

/* PROJETAR QUADRA PELO ID*/
SELECT  qua_id 'ID', qua_nome 'Nome', qua_endereco 'Localidade', IF(qua_cobertura,'Possui','Não Possui') 'Cobertura', 
        IF(qua_arquibancada,'Possui','Não Possui') 'Arquibancada', IF(qua_area_descanso,'Possui','Não Possui') 'Área de Descanso' , 
	    date_format(qua_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', qua_id_tipo 'Tipo', IF(qua_bloqueado ,'Sim','Não') 'Bloqueada', 
	    IF(qua_habilitado ,'Sim','Não')  'Habilitada'
FROM quadra
WHERE qua_id = ?;

/*CADASTRAR QUADRA*/
INSERT INTO quadra (qua_nome,qua_endereco,qua_cobertura,qua_arquibancada,qua_area_descanso,qua_id_tipo)
VALUES (?,?,?,?,?,?);

/*ALTERAR DADOS DA QUADRA*/

/*NOME*/
UPDATE quadra SET qua_nome = ? WHERE qua_id = ?;
/*ENDERECO*/
UPDATE quadra SET qua_endereco = ? WHERE qua_id = ?;
/*COBERTURA*/
UPDATE quadra SET qua_cobertura = ? WHERE qua_id = ?;
/*ARQUIBANCADA*/
UPDATE quadra SET qua_arquibancada = ? WHERE qua_id = ?;
/*AREA DE DESCANSO*/
UPDATE quadra SET qua_area_descanso = ? WHERE qua_id = ?;
/*TIPO*/
UPDATE quadra SET qua_id_tipo = ? WHERE qua_id = ?;

/*HABILITAR OU DESABILITAR QUADRA*/
UPDATE quadra SET qua_habilitado = ? WHERE qua_id = ?;

/*BLOQUEAR OU DESBLOQUEAR QUADRA*/
UPDATE quadra SET qua_bloqueado = ? WHERE qua_id = ?;

/*DELETAR QUADRA*/
DELETE FROM quadra WHERE qua_id = ?;

