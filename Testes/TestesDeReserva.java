import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Dominio.Cliente;
import Dominio.Quadra;
import Dominio.Reserva;
import Enum.TipoPagamento;
import Enum.TipoQuadra;

class TestesDeReserva {
	

	interfaceReserva interfaceReserva = new interfaceReserva();
	Quadra qua = new Quadra(15, "Quadra Teste", TipoQuadra.CIMENTO, true);
	Cliente cli = new Cliente("Leandro","emailDoLeandro@gmail.com", "123.456.789-10", "10/10/2010", false);
	Reserva res = new Reserva(qua, cli, "12/05/2022", "10:00", "11:00", TipoPagamento.DINHEIRO, 1);
	
	@Test
	void testeCadastroReserva() {
		
		assertEquals("Leandro",res.getCliente().getNomeCliente());
		assertEquals("123.456.789-10",res.getCliente().getCpfCliente());		
		assertEquals("12/05/2022", res.getDataReserva());
		assertEquals("10:00",res.getHorarioInicioReserva());	
		assertEquals("11:00",res.getHorarioFimReserva());
		assertEquals(TipoPagamento.DINHEIRO,res.getModoPagamento());
		assertEquals(1,res.getParcelas());
		assertEquals(15, res.getQuadra().getCodigoQuadra());

	}	
}
