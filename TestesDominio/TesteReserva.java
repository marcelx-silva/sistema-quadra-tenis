import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class TesteReserva {

	DateTimeFormatter horarioFormatoPadrao = DateTimeFormatter.ofPattern("HH:mm");
	DateTimeFormatter dataFormatoPadrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	Quadra qua = new Quadra("15", "Quadra Teste", TipoQuadra.CIMENTO, true);
	Cliente cli = new Cliente("Leandro","emailDoLeandro@gmail.com", "123.456.789-10", "10/10/2010", false,false,true);
	Reserva res = new Reserva(qua, cli, LocalDate.of(2022, 5, 12), LocalTime.of(10, 0), LocalTime.of(11, 0), TipoPagamento.DINHEIRO, 1);
	
	@Test
	public void testeCadastroReserva() {
		
		assertEquals("Leandro",res.getCliente().getNome());
		assertEquals("123.456.789-10",res.getCliente().getCpf());		
		assertEquals("12/05/2022", res.getData().format(dataFormatoPadrao));
		assertEquals("10:00",res.getHorarioInicio().format(horarioFormatoPadrao).toString());	
		assertEquals("11:00",res.getHorarioFim().format(horarioFormatoPadrao).toString());
		assertEquals(TipoPagamento.DINHEIRO,res.getModoPagamento());
		assertEquals(1,res.getParcelas());
		assertEquals("15", res.getQuadra().getCodigo());

	}

}
