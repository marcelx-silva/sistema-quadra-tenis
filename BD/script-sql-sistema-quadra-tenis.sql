USE sistema_clube_tenis;

/*CRIACAO DAS TABELAS*/


CREATE TABLE tipo_quadra(
	tp_id INTEGER NOT NULL AUTO_INCREMENT,
	tp_nome VARCHAR(20) NOT NULL,
	
	PRIMARY KEY (tp_id)
);

CREATE TABLE manutencao(
	man_id INTEGER NOT NULL AUTO_INCREMENT,
	man_desc VARCHAR(100) NOT NULL,
	man_dt_inicio DATE NOT NULL,
	man_dt_fim DATE NOT NULL,
	man_prev BOOLEAN NOT NULL,
	man_cod_quadra INTEGER NOT NULL,
	
	PRIMARY KEY(man_id),
	FOREIGN KEY(man_cod_quadra) REFERENCES quadra(qua_id)
);


CREATE TABLE quadra(
	qua_id INTEGER NOT NULL AUTO_INCREMENT,
	qua_nome VARCHAR(50) NOT NULL,
	qua_endereco VARCHAR(50) NOT NULL,
	qua_cobertura BOOLEAN NOT NULL,
	qua_arquibancada BOOLEAN NOT NULL,
	qua_area_descanso BOOLEAN NOT NULL,
	qua_status BOOLEAN NOT NULL,
	qua_dt_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	qua_id_tipo INTEGER NOT NULL,
	
	PRIMARY KEY (qua_id),
	FOREIGN KEY (qua_id_tipo) REFERENCES tipo_quadra(tp_id)
);




CREATE TABLE permissao(
	perm_id INTEGER NOT NULL AUTO_INCREMENT,
	perm_nome VARCHAR(25) NOT NULL,
	
	PRIMARY KEY (perm_id)
);

CREATE TABLE usuario(
	usu_id INTEGER NOT NULL AUTO_INCREMENT,
	usu_nome VARCHAR(50) NOT NULL,
	usu_senha VARCHAR(20) NOT NULL,
	usu_email VARCHAR(50) NOT NULL,
	usu_dt_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usu_id_permissao INTEGER NOT NULL,
	usu_bloqueado BOOL NOT NULL DEFAULT 0, 
	usu_habilitado BOOL NOT NULL DEFAULT 1,
	
	PRIMARY KEY (usu_id),
	FOREIGN KEY (usu_id_permissao) REFERENCES permissao(perm_id)
);


CREATE TABLE forma_pagamento(
	fp_id INTEGER NOT NULL AUTO_INCREMENT,
	fp_nome VARCHAR(15) NOT NULL,
	
	PRIMARY KEY(fp_id)
);

CREATE TABLE pagamento(
	pag_id INTEGER NOT NULL AUTO_INCREMENT,
	pag_id_forma_pagamento INTEGER NOT NULL,
	pag_parcelas VARCHAR(1) NOT NULL,
	pag_valor DOUBLE(10,2) NOT NULL,
	pag_dt_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	
	PRIMARY KEY(pag_id),
	FOREIGN KEY(pag_id_forma_pagamento) REFERENCES forma_pagamento(fp_id)
);




CREATE TABLE cliente(
	cli_id INTEGER NOT NULL AUTO_INCREMENT,
	cli_nome VARCHAR(50) NOT NULL,
	cli_cpf VARCHAR(11) NOT NULL,
	cli_dt_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	cli_bloqueado BOOL NOT NULL DEFAULT  0, 
	cli_habilitado BOOL NOT NULL DEFAULT 1,
	cli_invalidado BOOL NOT NULL DEFAULT 0,
	
	PRIMARY KEY(cli_id)
);

CREATE TABLE reserva(
    res_id INTEGER NOT NULL AUTO_INCREMENT,
    res_id_cliente INTEGER NOT NULL,
    res_nome_cliente VARCHAR(50) NOT NULL,
    res_cpf_cliente VARCHAR(11) NOT NULL,
    res_hr_inicio DATETIME NOT NULL,
    res_hr_fim DATETIME NOT NULL,
    res_data DATE NOT NULL,
    res_id_pagamento INTEGER NOT NULL,
    res_id_quadra INTEGER NOT NULL,
    res_cod_quadra INTEGER NOT NULL,
    res_nome_quadra VARCHAR(50) NOT NULL,
    res_endereco_quadra VARCHAR(50) NOT NULL,
    res_tipo_quadra VARCHAR(20) NOT NULL,
    res_cobertura BOOL NOT NULL,
    
    PRIMARY KEY(res_id),
    FOREIGN KEY(res_id_cliente) REFERENCES cliente(cli_id),
    FOREIGN KEY(res_id_quadra) REFERENCES quadra(qua_id),
    FOREIGN KEY(res_id_pagamento) REFERENCES pagamento(pag_id)  
);



ALTER TABLE pagamento
MODIFY COLUMN pag_valor FLOAT NOT NULL;
