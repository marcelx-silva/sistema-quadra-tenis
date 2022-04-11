import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestesDeUnidadeReserva {
	
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	interfaceReserva interfaceReserva = new interfaceReserva();
	Reservas res = new Reservas("","","","","",1,40,false);
	
	@Test
	void testeCadastroReserva() {
		interfaceReserva.interfaceCadastroReserva(res);
		assertEquals("Luiz Silva",res.getNome_reservista());
		assertEquals("08/04/2022",res.getData_reserva());
		assertEquals("10:00",res.getHr_inicio_reserva());	
		assertEquals("10:30",res.getHr_fim_reserva());
		assertEquals("DÉBITO",res.getModo_pagamento());
		assertEquals(1,res.getParcelas());
		assertEquals(false,res.isCobertura());
		assertEquals(40,res.getPreco_reserva());
	}
	
}
