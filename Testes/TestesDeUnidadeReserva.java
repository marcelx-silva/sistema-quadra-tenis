import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestesDeUnidadeReserva {
	
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	interfaceReserva interfaceReserva = new interfaceReserva();
	Reservas res = new Reservas(0,"","","","","","","","",1,false);
	Quadras qua = new Quadras();
	
	@Test
	void testeCadastroReserva() {
		interfaceReserva.interfaceCadastroReserva(res,qua);
		
		assertEquals("Luiz Silva",res.getNome_reservista());
		assertEquals("12345",res.getCpf_usuario());
		
		assertEquals("08/04/2022",res.getData_reserva());
		assertEquals("10:00",res.getHr_inicio_reserva());	
		assertEquals("10:30",res.getHr_fim_reserva());
		assertEquals("DÉBITO",res.getModo_pagamento());
		assertEquals(1,res.getParcelas());
		
		assertEquals("Quadra Municipal de Mogi das Cruzes",res.getNome_quadra());
		assertEquals(15, res.getCod_quadra());
		assertEquals("SAIBRO", res.getTipo_quadra());
		assertEquals(false,res.isCobertura());
	}
	
}
