import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestesReserva {

	Quadra qua = new Quadra(15, "Quadra Teste", TipoQuadra.CIMENTO, true);
	Cliente cli = new Cliente("Leandro","emailDoLeandro@gmail.com", "123.456.789-10", "10/10/2010", false,false,true);
	Reserva res = new Reserva(qua, cli, "12/05/2022", "10:00", "11:00", TipoPagamento.DINHEIRO, 1);
	
	@Test
	void testeCadastroReserva() {
		
		assertEquals("Leandro",res.getCliente().getNome());
		assertEquals("123.456.789-10",res.getCliente().getCpf());		
		assertEquals("12/05/2022", res.getData());
		assertEquals("10:00",res.getHorarioInicio());	
		assertEquals("11:00",res.getHorarioFimReserva());
		assertEquals(TipoPagamento.DINHEIRO,res.getModoPagamento());
		assertEquals(1,res.getParcelas());
		assertEquals(15, res.getQuadra().getCodigo());

	}

}
