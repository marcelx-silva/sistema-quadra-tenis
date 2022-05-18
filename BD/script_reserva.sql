/*PROJETAR TODAS AS RESERVAS*/
SELECT r.res_id 'ID Reserva', r.res_id_cliente 'ID Cliente', c.cli_nome 'Cliente', date_format(r.res_hr_inicio,"%H:%i") 'Horário Início', date_format(r.res_hr_fim,"%H:%i") 'Horário Terminio', 
	date_format(r.res_data,"%d-%m-%Y") 'Data', r.res_id_quadra 'ID Quadra', r.res_id_forma_pagamento 'Forma de Pagamento', r.res_parcelas 'Parcelas da Reserva', r.res_valor 'Valor'
FROM reserva r 
	JOIN cliente c ON r.res_id_cliente = c.cli_id
    JOIN quadra q ON r.res_id_quadra = q.qua_id
	JOIN forma_pagamento fp ON r.res_id_forma_pagamento = fp.fp_id
ORDER BY r.res_id;

/*PROJETAR  RESERVA IDENTIFICADA PELO ID*/
SELECT r.res_id 'ID Reserva', r.res_id_cliente 'ID Cliente', c.cli_nome 'Cliente', date_format(r.res_hr_inicio,"%H:%i") 'Horário Início', date_format(r.res_hr_fim,"%H:%i") 'Horário Terminio', 
	date_format(r.res_data,"%d-%m-%Y") 'Data', r.res_id_quadra 'ID Quadra', r.res_id_forma_pagamento 'Forma de Pagamento', r.res_parcelas 'Parcelas da Reserva', r.res_valor 'Valor'
FROM reserva r 
	JOIN cliente c ON r.res_id_cliente = c.cli_id
    JOIN quadra q ON r.res_id_quadra = q.qua_id
	JOIN forma_pagamento fp ON r.res_id_forma_pagamento = fp.fp_id
WHERE r.res_id = ?;

/*PROJETAR RESERVAS PELA DATA*/
SELECT r.res_id 'ID Reserva', r.res_id_cliente 'ID Cliente', c.cli_nome 'Cliente', date_format(r.res_hr_inicio,"%H:%i") 'Horário Início', date_format(r.res_hr_fim,"%H:%i") 'Horário Terminio', 
	date_format(r.res_data,"%d-%m-%Y") 'Data', r.res_id_quadra 'ID Quadra', r.res_id_forma_pagamento 'Forma de Pagamento', r.res_parcelas 'Parcelas da Reserva', r.res_valor 'Valor'
FROM reserva r 
	JOIN cliente c ON r.res_id_cliente = c.cli_id
    JOIN quadra q ON r.res_id_quadra = q.qua_id
	JOIN forma_pagamento fp ON r.res_id_forma_pagamento = fp.fp_id
WHERE r.res_data = str_to_date(?,'%d-%m-%Y');

/*CADASTRAR RESERVAS*/
INSERT INTO reserva (res_id_cliente,res_hr_inicio,res_hr_fim,res_data,res_id_quadra,res_id_forma_pagamento,res_parcelas,res_valor)
			VALUES(?,str_to_date(?,'%H:%i'),str_to_date(?,'%H:%i'),str_to_date(?,'%d-%m-%Y'),?,?,?,?);