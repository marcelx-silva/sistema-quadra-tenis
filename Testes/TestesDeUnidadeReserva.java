import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestesDeUnidadeReserva {
	

	interfaceReserva interfaceReserva = new interfaceReserva();
	Quadras qua = new Quadras(15);
	Reservas res = new Reservas(qua,"","","","","","",1);
	
	@Test
	void testeCadastroReserva() {
		interfaceReserva.interfaceCadastroReserva(res);
		
		assertEquals("Luiz Silva",res.getNome_reservista());
		assertEquals("12345",res.getCpf_usuario());
		
		assertEquals("08/04/2022",res.getData_reserva());
		assertEquals("10:00",res.getHr_inicio_reserva());	
		assertEquals("10:30",res.getHr_fim_reserva());
		assertEquals("DÉBITO",res.getModo_pagamento());
		assertEquals(1,res.getParcelas());
		
		assertEquals(15, qua.getCodigoQuadra());

		
	}
	
}
