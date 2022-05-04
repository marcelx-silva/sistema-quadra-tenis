import java.util.Scanner;

public class interfaceReserva {

	Scanner scanner = new Scanner(System.in);
	
	void interfacePrincipalReservas() {
		Reservas reserva = new Reservas();
		int operadorDoMenu = 0;
		do {
			UtilidadesSimplificadas.exibeMensagem("MENU RESERVAS"
					+ "\n1. FAZER RESERVA"
					+ "\n2. VISUALIZAR RESERVAS"
					+ "\n3. CANCELAR RESERVAS"
					+ "\n4. SAIR DO MENU"
					+ "\nOPÇÃO: ");
			
			operadorDoMenu = scanner.nextInt();
			scanner.nextLine();
			
			switch(operadorDoMenu){
				
				case 1:
					this.fazerReserva();
					break;
					
				case 2:
					this.visualizarReservas();
					break;
					
				case 3:	
					break;
				case 4:
					UtilidadesSimplificadas.exibeMensagem("Voltando ao menu anterior!\n");
					break;
					
				default:
					UtilidadesSimplificadas.exibeMensagem("Opção Invalida!\n");
					break;
			}
			
		}while(operadorDoMenu != 4);
		
	}

	void fazerReserva() {
		
		String dia = "";
		String horarioInicio = "";
		String horarioFim = "";
		String tipo = "";
		boolean cobertura = false;
		boolean arquibancada = false;
		boolean areaDescanso = false;
		int operadorDoMenu = 0;
		
		UtilidadesSimplificadas.exibeMensagem("Dia da reserva (dd/mm/aaaa) : ");
		dia = scanner.nextLine();
		
		UtilidadesSimplificadas.exibeMensagem("Horário de inicio (hh:mm) : ");
		horarioInicio = scanner.nextLine();
		
		UtilidadesSimplificadas.exibeMensagem("Horário de fim (hh:mm) : ");
		horarioFim = scanner.nextLine();

		UtilidadesSimplificadas.exibeMensagem("Tipo de quadra: "
				+ "\n1. Saibro"
				+ "\n2. Superficie sintética"
				+ "\n3. Cimento"
				+ "\n4. Beach Tennis"
				+ "\nOPÇÃO: ");
		switch(operadorDoMenu) {
			case 1 : tipo = "SAIBRO";
				break;
			case 2 : tipo = "SUPERF�CIE SINT�TICA";
				break;
			case 3 : tipo = "CIMENTO";
				break;
			case 4 : tipo = "BEACH TENNIS";
				break;
			default: UtilidadesSimplificadas.exibeMensagem("Opção Invalida");
				break;
		
		}
		
		UtilidadesSimplificadas.exibeMensagem("Deseja quadra com cobertura: (sim/nao)");
		cobertura = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
		UtilidadesSimplificadas.exibeMensagem("Deseja quadra com arquibancada (sim/nao)");
		arquibancada = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
		UtilidadesSimplificadas.exibeMensagem("Deseja quadra com area de descanso: (sim/nao)");
		areaDescanso = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
	
		Quadras.procuraQuadras(dia, horarioInicio, horarioFim, tipo, cobertura, arquibancada, areaDescanso);
		
	}
	
	
	void visualizarReservas() {
		
	}
	
	
}
