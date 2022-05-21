SELECT  * FROM permissao;

INSERT INTO permissao (perm_nome) VALUES ('Zelador');
INSERT INTO permissao (perm_nome) VALUES ('Gerente');
INSERT INTO permissao (perm_nome) VALUES ('Atendente');


SELECT * FROM tipo_quadra;

INSERT INTO tipo_quadra (tp_nome) VALUES('Saibro');
INSERT INTO tipo_quadra (tp_nome) VALUES('Sintética');
INSERT INTO tipo_quadra (tp_nome) VALUES('Cimento');
INSERT INTO tipo_quadra (tp_nome) VALUES('Beach');


SELECT * FROM forma_pagamento;

INSERT INTO forma_pagamento (fp_nome) VALUES('Crédito');
INSERT INTO forma_pagamento (fp_nome) VALUES('Dédito');
INSERT INTO forma_pagamento (fp_nome) VALUES('PIX');
INSERT INTO forma_pagamento (fp_nome) VALUES('Dinheiro');
