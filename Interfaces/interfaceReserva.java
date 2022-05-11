import java.util.Scanner;


public final class interfaceReserva {


	Scanner scanner = new Scanner(System.in);
	
	void interfaceMenuReserva() {
		Reservas reserva = new Reservas(0,"","","","","","","","",1,false);
		Quadras quadra = new Quadras(0,"","","",false,false,false);
		int operadorMenu = 0;
		
		do {

			UtilidadesGUI.exibeMensagem("MENU RESERVAS"
					+ "\n1. FAZER RESERVA"
					+ "\n2. VISUALIZAR RESERVAS"
					+ "\n3. CANCELAR RESERVAS"
					+ "\n4. SAIR DO MENU"
					+ "\nOPÇÃO: ");
			
			operadorMenu = scanner.nextInt();
			scanner.nextLine();
			
			switch(operadorMenu) {
				case 1:
					this.interfaceCadastroReserva(reserva,quadra);
					break;
				case 2:
					this.visualizarReservas();
					break;
				case 3:
					break;
				case 4:
					UtilidadesGUI.exibeMensagem("Voltando ao menu anterior!\n");
					break;
				default:
					UtilidadesGUI.exibeMensagem("Opção Inválida!! \n"); 
					

			}
			
		}while(operadorMenu!=5);
	}
	
	void interfaceCadastroReserva(Reservas reserva, Quadras quadra){
		
	
		int cod_quadra = 0;
		String nome_quadra = "";
		String tipo_quadra = "";
		boolean cobertura = false;
		boolean arquibancada = false;
		boolean areaDescanso = false;
		
		String nome_reservista = "";
		String cpf_usuario = "";
		
		String data_reserva = "";
		String hr_inicio_reserva = "";
		String hr_fim_reserva = "";
		
		String modo_pagamento = "";
		int parcelas = 1;
		
		
		
			
		
		try {
			
			UtilidadesGUI.exibeMensagem("CPF do reservista: ");
			cpf_usuario = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("Nome do reservista:");
			nome_reservista = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("Data da reserva (dd/mm/aaaa):");
			data_reserva = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("Horário da reserva - INÍCIO (hh:mm) :");
			hr_inicio_reserva = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("Horário da reserva - FIM (hh:mm):");
			hr_fim_reserva = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("Modo de Pagamento, meio pelo qual o reservista pagará a sua reserva:"
					+ "\n1. CRÉDITO"
					+ "\n2. DÉBITO"
					+ "\n3. DINHEIRO"
					+ "\n4. PIX"
					+ "\nOpção: ");
			
			modo_pagamento = reserva.selecionarModoPagamento(Integer.parseInt(scanner.nextLine()));
			
			if(modo_pagamento.equals("CRÉDITO") || modo_pagamento.equals("PIX")) {
				UtilidadesGUI.exibeMensagem("Utilizando "+modo_pagamento+" como modo de pagamento é possível parcelar em:"
						+ "\n1. A vista"
						+ "\n2. 2x"
						+ "\n3. 4x"
						+ "\n Opção: ");
				parcelas = reserva.parcelarReserva(Integer.parseInt(scanner.nextLine()));
			}else {
				parcelas = 1;
			}
			
			
			
			UtilidadesGUI.exibeMensagem("Nome da Quadra: ");
			nome_quadra = (scanner.nextLine());
			
			UtilidadesGUI.exibeMensagem("Código da quadra: ");
			cod_quadra = Integer.parseInt(scanner.nextLine());
			
			UtilidadesGUI.exibeMensagem("Tipo da quadra, selecione uma das opções atráves dos números:"
					+ "\n1. SAIBRO"
					+ "\n2. SUPERFÍCIE SINTÉTICA"
					+ "\n3. CIMENTO"
					+ "\n4. BEACH TENNIS"
					+ "\nOpção: ");
			tipo_quadra = quadra.identificaTipoQuadra(scanner.nextInt());
		
			
			UtilidadesGUI.exibeMensagem("Possui cobertura (sim/não): ");
			cobertura = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
			
			UtilidadesGUI.exibeMensagem("Deseja quadra com arquibancada (sim/nao)");
			arquibancada = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
			
			UtilidadesGUI.exibeMensagem("Deseja quadra com area de descanso: (sim/nao)");
			areaDescanso = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
			
			
			UtilidadesGUI.exibeMensagem("Reserva Realizada com Sucesso!\n");
			
			Quadras.procuraQuadras(data_reserva, hr_inicio_reserva,  hr_fim_reserva, tipo_quadra, cobertura, arquibancada, areaDescanso);
			
			reserva.cadastrarReserva(cpf_usuario,nome_reservista, data_reserva, hr_inicio_reserva, hr_fim_reserva, modo_pagamento, parcelas,cobertura,cod_quadra,nome_quadra,tipo_quadra);

		}catch(Exception e) {
			UtilidadesGUI.exibeMensagem("Reserva interrompida!\n");
		}
	}
	
	
	void visualizarReservas() {}
	
	
}
