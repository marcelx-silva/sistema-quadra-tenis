SELECT  q.qua_id 'ID', q.qua_nome 'Nome', q.qua_endereco 'Localidade', IF(q.qua_cobertura,'Possui','Não Possui') 'Cobertura', 
        IF(q.qua_arquibancada,'Possui','Não Possui') 'Arquibancada', IF(q.qua_area_descanso,'Possui','Não Possui') 'Área de Descanso' , 
	    date_format(q.qua_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', q.qua_id_tipo 'Tipo ID', tp.tp_nome 'Tipo', IF(q.qua_bloqueado ,'Sim','Não') 'Bloqueada', 
	    IF(q.qua_habilitado ,'Sim','Não')  'Habilitada'
FROM quadra q JOIN tipo_quadra tp
ON (q.qua_id_tipo = tp_id);


/*PROJETAR QUADRAS HABILITAS OU DESABILITADAS*/
SELECT  q.qua_id 'ID', q.qua_nome 'Nome', q.qua_endereco 'Localidade', IF(q.qua_cobertura,'Possui','Não Possui') 'Cobertura', 
        IF(q.qua_arquibancada,'Possui','Não Possui') 'Arquibancada', IF(q.qua_area_descanso,'Possui','Não Possui') 'Área de Descanso' , 
	    date_format(q.qua_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', q.qua_id_tipo 'Tipo ID', tp.tp_nome 'Tipo', IF(q.qua_bloqueado ,'Sim','Não') 'Bloqueada', 
	    IF(q.qua_habilitado ,'Sim','Não')  'Habilitada'
FROM quadra q JOIN tipo_quadra tp
ON (q.qua_id_tipo = tp_id)
WHERE q.qua_habilitado = ?;



/*PROJETAR QUADRAS BLOQUEADAS OU DESBLOQUEADAS*/
SELECT  q.qua_id 'ID', q.qua_nome 'Nome', q.qua_endereco 'Localidade', IF(q.qua_cobertura,'Possui','Não Possui') 'Cobertura', 
        IF(q.qua_arquibancada,'Possui','Não Possui') 'Arquibancada', IF(q.qua_area_descanso,'Possui','Não Possui') 'Área de Descanso' , 
	    date_format(q.qua_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', q.qua_id_tipo 'Tipo ID', tp.tp_nome 'Tipo', IF(q.qua_bloqueado ,'Sim','Não') 'Bloqueada', 
	    IF(q.qua_habilitado ,'Sim','Não')  'Habilitada'
FROM quadra q JOIN tipo_quadra tp
ON (q.qua_id_tipo = tp_id)
WHERE qua_bloqueado = ?;

/* PROJETAR QUADRA PELO ID*/
SELECT  q.qua_id 'ID', q.qua_nome 'Nome', q.qua_endereco 'Localidade', IF(q.qua_cobertura,'Possui','Não Possui') 'Cobertura', 
        IF(q.qua_arquibancada,'Possui','Não Possui') 'Arquibancada', IF(q.qua_area_descanso,'Possui','Não Possui') 'Área de Descanso' , 
	    date_format(q.qua_dt_cadastro,"%d-%m-%Y") 'Data de Cadastro', q.qua_id_tipo 'Tipo ID', tp.tp_nome 'Tipo', IF(q.qua_bloqueado ,'Sim','Não') 'Bloqueada', 
	    IF(q.qua_habilitado ,'Sim','Não')  'Habilitada'
FROM quadra q JOIN tipo_quadra tp
ON (q.qua_id_tipo = tp_id)
WHERE q.qua_id = ?;

/*CADASTRAR QUADRA*/
INSERT INTO quadra (qua_nome,qua_endereco,qua_cobertura,qua_arquibancada,qua_area_descanso,qua_id_tipo) VALUES (?,?,?,?,?,?);

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

