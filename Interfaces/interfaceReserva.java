import java.util.Scanner;

public final class interfaceReserva {

	Scanner scanner = new Scanner(System.in);
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	
	Quadras quadra = new Quadras();
	Reservas reserva = new Reservas("","","","",0,0,quadra);
	
	void interfaceMenuReserva() {
		int operadorMenu = 0;
		
		do {
			utilidades.exibeMensagem("MENU RESERVA"
					+ "\n1.CADASTRAR RESERVA"
					+ "\n2.VISUALIZAR RESERVAS"
					+ "\n3.CANCELAR RESERVAS"
					+ "\n4.SAIR DO MENU"
					+ "\nOPÇÃO");
			
			operadorMenu = scanner.nextInt();
			scanner.nextLine();
			
			switch(operadorMenu) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					utilidades.exibeMensagem("Opção Inválida!! \n"); 
					
			}
			
		}while(operadorMenu!=5);
	}
	
	

}
