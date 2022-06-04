USE sistema_clube_tenis;

/* Criação das Tabelas */

CREATE TABLE tipo_quadra(
	tp_id INTEGER NOT NULL AUTO_INCREMENT,
	tp_nome VARCHAR(20) NOT NULL,
	
	PRIMARY KEY (tp_id)
);

CREATE TABLE permissao(
	per_id INTEGER NOT NULL AUTO_INCREMENT,
	per_nome VARCHAR(20) NOT NULL,
	
	PRIMARY KEY (per_id)
);

CREATE TABLE quadra(
	qua_id INTEGER NOT NULL AUTO_INCREMENT,
	qua_nome VARCHAR(50) NOT NULL,
	qua_endereco VARCHAR(50) NOT NULL,
	qua_cobertura BOOLEAN NOT NULL,
	qua_arquibancada BOOLEAN NOT NULL,
	qua_area_descanso BOOLEAN NOT NULL,
	qua_status BOOLEAN NOT NULL DEFAULT 0,
	qua_dt_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	qua_id_tipo INTEGER NOT NULL,
	qua_bloqueado BOOL NOT NULL DEFAULT 0, 
	qua_habilitado BOOL NOT NULL DEFAULT 1,
    
	
	PRIMARY KEY (qua_id)
);

CREATE TABLE manutencao(
	man_id INTEGER NOT NULL AUTO_INCREMENT,
	man_desc VARCHAR(100) NOT NULL,
	man_data DATE NOT NULL,
	man_hr_inicio TIME NOT NULL,
	man_hr_fim TIME NOT NULL,
	man_prev BOOLEAN NOT NULL,
	man_cod_quadra INTEGER NOT NULL,
	
	PRIMARY KEY(man_id)
);

CREATE TABLE usuario(
	usu_id INTEGER NOT NULL AUTO_INCREMENT,
	usu_nome VARCHAR(50) NOT NULL,
	usu_senha VARCHAR(20) NOT NULL,
	usu_email VARCHAR(50) NOT NULL,
	usu_dt_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	usu_acesso_gestor_quadra BOOL NOT NULL DEFAULT 0,
	usu_acesso_gestor_usuario BOOL NOT NULL DEFAULT 0,
	usu_acesso_relatorio BOOL NOT NULL DEFAULT 0,
	usu_acesso_zelador BOOL NOT NULL DEFAULT 1,
	usu_bloqueado BOOL NOT NULL DEFAULT 0, 
	usu_habilitado BOOL NOT NULL DEFAULT 1,
	
	PRIMARY KEY (usu_id)
);

CREATE TABLE forma_pagamento(
	fp_id INTEGER NOT NULL AUTO_INCREMENT,
	fp_nome VARCHAR(15) NOT NULL,
	
	PRIMARY KEY(fp_id)
);

CREATE TABLE cliente(
	cli_id INTEGER NOT NULL AUTO_INCREMENT,
	cli_nome VARCHAR(50) NOT NULL,
	cli_cpf VARCHAR(11) NOT NULL,
    	cli_dt_nasc DATE NOT NULL,
    	cli_email VARCHAR(50),
   	cli_celular VARCHAR(15),
    	cli_tel_fixo VARCHAR(14),
	cli_dt_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	cli_bloqueado BOOL NOT NULL DEFAULT  0, 
	cli_habilitado BOOL NOT NULL DEFAULT 1,
	cli_restrito BOOL NOT NULL DEFAULT 0,
	
	PRIMARY KEY(cli_id)
);

CREATE TABLE reserva(
    	res_id INTEGER NOT NULL AUTO_INCREMENT,
    	res_id_cliente INTEGER NOT NULL,
    	res_hr_inicio TIME NOT NULL,
   	res_hr_fim TIME NOT NULL,
    	res_data DATE NOT NULL,
    	res_id_quadra INTEGER NOT NULL,
    	res_id_forma_pagamento INTEGER NOT NULL,
	res_parcelas VARCHAR(1) NOT NULL,
	res_valor FLOAT NOT NULL,
	res_cli_entrou TIMESTAMP DEFAULT NULL,
	res_cli_saiu TIMESTAMP DEFAULT NULL,
    
    PRIMARY KEY(res_id)
);

/* Inserção de valores fixos */

INSERT INTO permissao (per_nome) VALUES ('Zelador');
INSERT INTO permissao (per_nome) VALUES ('Gerente');
INSERT INTO permissao (per_nome) VALUES ('Atendente');

INSERT INTO tipo_quadra (tp_nome) VALUES('Saibro');
INSERT INTO tipo_quadra (tp_nome) VALUES('Sintética');
INSERT INTO tipo_quadra (tp_nome) VALUES('Cimento');
INSERT INTO tipo_quadra (tp_nome) VALUES('Beach');

INSERT INTO forma_pagamento (fp_nome) VALUES('Crédito');
INSERT INTO forma_pagamento (fp_nome) VALUES('Dédito');
INSERT INTO forma_pagamento (fp_nome) VALUES('PIX');
INSERT INTO forma_pagamento (fp_nome) VALUES('Dinheiro');

/* Constraints */

ALTER TABLE quadra
ADD CONSTRAINT quadra_tipo
FOREIGN KEY(qua_id_tipo)
REFERENCES tipo_quadra(tp_id);

ALTER TABLE manutencao
ADD CONSTRAINT man_quadra
FOREIGN KEY (man_cod_quadra)
REFERENCES quadra(qua_id);

ALTER TABLE reserva
ADD CONSTRAINT reserva_cliente
FOREIGN KEY (res_id_cliente)
REFERENCES cliente(cli_id);

ALTER TABLE reserva
ADD CONSTRAINT reserva_quadra
FOREIGN KEY (res_id_quadra)
REFERENCES quadra(qua_id);

