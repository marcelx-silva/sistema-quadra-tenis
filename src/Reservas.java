import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservas {
	
	public static ArrayList<String> horariosReservas(int codigoQuadra){
		
		//Teste
        DateTimeFormatter horarioFormatoPadrao = DateTimeFormatter.ofPattern("HH:mm");
		ArrayList<String> listaReservas = new ArrayList<String>();
		
		LocalDateTime horarioEx = LocalDateTime.now();//.plusDays(1);
		
		listaReservas.add(horarioEx.minusHours(0).minusMinutes(30).withMinute(0).format(horarioFormatoPadrao).toString());
		listaReservas.add(horarioEx.minusHours(15).minusMinutes(12).withMinute(0).format(horarioFormatoPadrao).toString());
		listaReservas.add(horarioEx.minusHours(18).minusMinutes(50).withMinute(0).format(horarioFormatoPadrao).toString());
		listaReservas.add(horarioEx.minusHours(8).minusMinutes(30).withMinute(0).format(horarioFormatoPadrao).toString());
		listaReservas.add(horarioEx.minusHours(6).withMinute(0).format(horarioFormatoPadrao).toString());
		listaReservas.add(horarioEx.minusHours(2).withMinute(0).format(horarioFormatoPadrao).toString());
		
		return listaReservas;
	}

	

}
