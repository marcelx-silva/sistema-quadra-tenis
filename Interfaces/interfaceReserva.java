import java.util.Scanner;


public final class interfaceReserva {


	Scanner scanner = new Scanner(System.in);
	
	void interfaceMenuReserva() {
		Quadras quadra = new Quadras(0,"","","",false,false,false);
		Reservas reserva = new Reservas(quadra,"","","","","","",1);
		int operadorMenu = 0;
		
		do {

			UtilidadesSimplificadas.exibeMensagem("MENU RESERVAS"
					+ "\n1. FAZER RESERVA"
					+ "\n2. VISUALIZAR RESERVAS"
					+ "\n3. CANCELAR RESERVAS"
					+ "\n4. SAIR DO MENU"
					+ "\nOPÇÃO: ");
			
			operadorMenu = scanner.nextInt();
			scanner.nextLine();
			
			switch(operadorMenu) {
				case 1:
					this.interfaceCadastroReserva(reserva, quadra);
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
					UtilidadesSimplificadas.exibeMensagem("Opção Inválida!! \n"); 
					

			}
			
		}while(operadorMenu!=5);
	}
	
	void interfaceCadastroReserva(Reservas reserva, Quadras quadra){
		
	
		int cod_quadra;
		String tipo_quadra;
		String nome_quadra;
		boolean cobertura = false;
		
		String nome_reservista = "";
		String cpf_usuario = "";
		
		String data_reserva = "";
		String hr_inicio_reserva = "";
		String hr_fim_reserva = "";
		
		String modo_pagamento = "";
		int parcelas = 1;
		
			
		
		try {
			
			UtilidadesSimplificadas.exibeMensagem("CPF do reservista: ");
			cpf_usuario = scanner.nextLine();
			
			UtilidadesSimplificadas.exibeMensagem("Nome do reservista:");
			nome_reservista = scanner.nextLine();
			
			UtilidadesSimplificadas.exibeMensagem("Data da reserva (dd/mm/aaaa):");
			data_reserva = scanner.nextLine();
			
			UtilidadesSimplificadas.exibeMensagem("Horário da reserva - INÍCIO (hh:mm) :");
			hr_inicio_reserva = scanner.nextLine();
			
			UtilidadesSimplificadas.exibeMensagem("Horário da reserva - FIM (hh:mm):");
			hr_fim_reserva = scanner.nextLine();
			
			UtilidadesSimplificadas.exibeMensagem("Modo de Pagamento, meio pelo qual o reservista pagará a sua reserva:"
					+ "\n1. CRÉDITO"
					+ "\n2. DÉBITO"
					+ "\n3. DINHEIRO"
					+ "\n4. PIX"
					+ "\nOpção: ");
			
			modo_pagamento = reserva.selecionarModoPagamento(Integer.parseInt(scanner.nextLine()));
			
			if(modo_pagamento.equals("CRÉDITO") || modo_pagamento.equals("PIX")) {
				UtilidadesSimplificadas.exibeMensagem("Utilizando "+modo_pagamento+" como modo de pagamento é possível parcelar em:"
						+ "\n1. A vista"
						+ "\n2. 2x"
						+ "\n3. 4x"
						+ "\n Opção: ");
				parcelas = reserva.parcelarReserva(Integer.parseInt(scanner.nextLine()));
			}else {
				parcelas = 1;
			}
			
			
			UtilidadesSimplificadas.exibeMensagem("Código da quadra: ");
			cod_quadra = Integer.parseInt(scanner.nextLine());
			
			
			UtilidadesSimplificadas.exibeMensagem("Nome da Quadra: ");
			nome_quadra = (scanner.nextLine());
			
			UtilidadesSimplificadas.exibeMensagem("Código da quadra: ");
			cod_quadra = Integer.parseInt(scanner.nextLine());
			
			UtilidadesSimplificadas.exibeMensagem("Tipo da quadra, selecione uma das opções atráves dos números:"
					+ "\n1. SAIBRO"
					+ "\n2. SUPERFÍCIE SINTÉTICA"
					+ "\n3. CIMENTO"
					+ "\n4. BEACH TENNIS"
					+ "\nOpção: ");
			tipo_quadra = quadra.identificaTipoQuadra(scanner.nextInt());
			
			UtilidadesSimplificadas.exibeMensagem("Possui cobertura (sim/não): ");
			cobertura = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
			
			Quadras QuadraReserva = new Quadras(cod_quadra,nome_quadra,tipo_quadra,cobertura);
			
			
			reserva.cadastrarReserva(cpf_usuario,nome_reservista, data_reserva, hr_inicio_reserva, hr_fim_reserva, modo_pagamento, parcelas,QuadraReserva.getCodigoQuadra(),QuadraReserva.getNomeQuadra(),QuadraReserva.getTipoQuadra(),QuadraReserva.isPossuiCobertura());
			
			
			UtilidadesSimplificadas.exibeMensagem("Reserva Realizada com Sucesso!\n");
			
			//Quadras.procuraQuadras(data_reserva, hr_inicio_reserva,  hr_fim_reserva, tipo_quadra, cobertura, arquibancada, areaDescanso);
			
			

		}catch(Exception e) {
			UtilidadesSimplificadas.exibeMensagem("Reserva interrompida!\n");
		}
	}
	
	
	void visualizarReservas() {}
	
	
}
