/*Projetar todas as reservas*/

SELECT res_id_cliente, cli_nome, cli_cpf, date_format(res_hr_inicio,"%H:%i"), date_format(res_hr_fim,"%H:%i"), 
	date_format(res_data,"%d-%m-%Y"), res_id_pagamento,


INSERT INTO reserva (res_id_cliente,STR_TO_DATE('?',"%H:%i"),STR_TO_DATE('?',"%H:%i"),res_id_quadra)




DELIMITER $$
CREATE TRIGGER pagamentos_realizados AFTER INSERT ON reserva FOR EACH ROW
BEGIN
    SELECT info_pagamento (?,?,?)
END$$
DELIMITER;


CREATE FUNCTION info_pagamento(id_forma_pag, pag_parcelas, pag_valor)
	INSERT INTO pagamentos(pag_id_forma_pagamento,pag_parcelas,pag_valor,pag_dt_pagamento)
	VALUES (id_forma_pag, pag_parcelas, pag_valor);
