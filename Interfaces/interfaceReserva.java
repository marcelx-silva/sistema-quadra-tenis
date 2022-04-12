import java.util.Scanner;

public final class interfaceReserva {

	Scanner scanner = new Scanner(System.in);
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	
	void interfaceMenuReserva() {
		Reservas reserva = new Reservas("","","","","",1,false);
		int operadorMenu = 0;
		
		do {
			utilidades.exibeMensagem("MENU RESERVA"
					+ "\n1. CADASTRAR RESERVA"
					+ "\n2. VISUALIZAR RESERVAS"
					+ "\n3. CANCELAR RESERVAS"
					+ "\n4. SAIR DO MENU"
					+ "\nOP��O: ");
			
			operadorMenu = scanner.nextInt();
			scanner.nextLine();
			
			switch(operadorMenu) {
				case 1:
					this.interfaceCadastroReserva(reserva);
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					utilidades.exibeMensagem("Op��o Inv�lida!! \n"); 
					
			}
			
		}while(operadorMenu!=5);
	}
	
	void interfaceCadastroReserva(Reservas reserva){
		
	
		//int numero = 0;
		boolean cobertura = false;
		
		String nome_reservista = "";
		String data_reserva = "";
		String hr_inicio_reserva = "";
		String hr_fim_reserva = "";
		String modo_pagamento = "";
		int parcelas = 1;
		
		
		try {
			utilidades.exibeMensagem("Nome do reservista:");
			nome_reservista = scanner.nextLine();
			
			utilidades.exibeMensagem("Data da reserva:");
			data_reserva = scanner.nextLine();
			
			utilidades.exibeMensagem("Hor�rio da reserva (IN�CIO):");
			hr_inicio_reserva = scanner.nextLine();
			
			utilidades.exibeMensagem("Hor�rio da reserva (FIM):");
			hr_fim_reserva = scanner.nextLine();
			
			utilidades.exibeMensagem("Modo de Pagamento, meio pelo qual o reservista pagar� a sua reserva:"
					+ "\n1. CR�DITO"
					+ "\n2. D�BITO"
					+ "\n3. DINHEIRO"
					+ "\n4. PIX"
					+ "\nOp��o: ");
			
			modo_pagamento = reserva.selecionarModoPagamento(Integer.parseInt(scanner.nextLine()));
			
			if(modo_pagamento.equals("CR�DITO") || modo_pagamento.equals("PIX")) {
				utilidades.exibeMensagem("Utilizando "+modo_pagamento+" como modo de pagamento � poss�vel parcelar em:"
						+ "\n1. A vista"
						+ "\n2. 2x"
						+ "\n3. 4x"
						+ "\n Op��o: ");
				parcelas = reserva.parcelarReserva(Integer.parseInt(scanner.nextLine()));
			}else {
				parcelas = 1;
			}
			
			
			/*
			utilidades.exibeMensagem("N�mero da quadra: ");
			numero = Integer.parseInt(scanner.nextLine());
			*/
			
			utilidades.exibeMensagem("Possui cobertura (sim/n�o): ");
			cobertura = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
			
			
			utilidades.exibeMensagem("Reserva Realizada com Sucesso!\n");
			
			reserva.cadastrarReserva(nome_reservista, data_reserva, hr_inicio_reserva, hr_fim_reserva, modo_pagamento, parcelas,cobertura);

		}catch(Exception e) {
			utilidades.exibeMensagem("Reserva interrompida!\n");
		}
		
	}
	
	

}
