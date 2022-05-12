import java.util.Scanner;


public final class interfaceReserva {


	Scanner scanner = new Scanner(System.in);
	
	void interfaceMenuReserva() {
		Quadra quadra = new Quadra(0,"","",null,false,false,false);
		Cliente cliente = new Cliente("","","","",false);
		Reserva reserva = new Reserva(quadra,cliente,"","","",null,1);
		int operadorMenu = 0;
		
		do {

			UtilidadesGUI.exibeMensagem("MENU RESERVAS"
					+ "\n1. FAZER RESERVA"
					+ "\n2. VISUALIZAR RESERVAS"
					+ "\n3. CANCELAR RESERVAS"
					+ "\n4. SAIR DO MENU"
					+ "\nOPÃ‡ÃƒO: ");
			
			operadorMenu = scanner.nextInt();
			scanner.nextLine();
			
			switch(operadorMenu) {
				case 1:
					this.interfaceCadastroReserva(reserva, quadra,cliente);
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
					UtilidadesGUI.exibeMensagem("OpÃ§Ã£o InvÃ¡lida!! \n"); 
					

			}
			
		}while(operadorMenu!=5);
	}
	
	void interfaceCadastroReserva(Reserva reserva, Quadra quadra, Cliente cliente){
		
	
		int cod_quadra;
		TipoQuadra tipo_quadra;
		String nome_quadra;
		boolean cobertura = false;
		
		String nomeCliente = "";
		String cpfCliente = "";
		
		
		String data_reserva = "";
		String hr_inicio_reserva = "";
		String hr_fim_reserva = "";
		
		TipoPagamento modo_pagamento = null;
		int parcelas = 1;
		
			
		
		try {
			
			UtilidadesGUI.exibeMensagem("CPF do reservista: ");
			cpfCliente = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("Nome do reservista:");
			nomeCliente = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("Data da reserva (dd/mm/aaaa):");
			data_reserva = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("HorÃ¡rio da reserva - INÃ�CIO (hh:mm) :");
			hr_inicio_reserva = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("HorÃ¡rio da reserva - FIM (hh:mm):");
			hr_fim_reserva = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("Modo de Pagamento, meio pelo qual o reservista pagarÃ¡ a sua reserva:"
					+ "\n1. CRÃ‰DITO"
					+ "\n2. DÃ‰BITO"
					+ "\n3. DINHEIRO"
					+ "\n4. PIX"
					+ "\nOpÃ§Ã£o: ");
			
			modo_pagamento = reserva.selecionarModoPagamento(Integer.parseInt(scanner.nextLine()));
			
			if(modo_pagamento.equals("CRÃ‰DITO") || modo_pagamento.equals("PIX")) {
				UtilidadesGUI.exibeMensagem("Utilizando "+modo_pagamento+" como modo de pagamento Ã© possÃ­vel parcelar em:"
						+ "\n1. A vista"
						+ "\n2. 2x"
						+ "\n3. 4x"
						+ "\n OpÃ§Ã£o: ");
				parcelas = reserva.parcelarReserva(Integer.parseInt(scanner.nextLine()));
			}else {
				parcelas = 1;
			}
			
			
			UtilidadesGUI.exibeMensagem("CÃ³digo da quadra: ");
			cod_quadra = Integer.parseInt(scanner.nextLine());
			
			
			UtilidadesGUI.exibeMensagem("Nome da Quadra: ");
			nome_quadra = (scanner.nextLine());
			
			UtilidadesGUI.exibeMensagem("CÃ³digo da quadra: ");
			cod_quadra = Integer.parseInt(scanner.nextLine());
			
			UtilidadesGUI.exibeMensagem("Tipo da quadra, selecione uma das opÃ§Ãµes atrÃ¡ves dos nÃºmeros:"
					+ "\n1. SAIBRO"
					+ "\n2. SUPERFÃ�CIE SINTÃ‰TICA"
					+ "\n3. CIMENTO"
					+ "\n4. BEACH TENNIS"
					+ "\nOpÃ§Ã£o: ");
			tipo_quadra = quadra.identificaTipoQuadra(scanner.nextInt());
			
			UtilidadesGUI.exibeMensagem("Possui cobertura (sim/nÃ£o): ");
			cobertura = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
			
			
			Cliente clienteReserva = new Cliente(nomeCliente,cpfCliente);
			Quadra QuadraReserva = new Quadra(cod_quadra,nome_quadra,tipo_quadra,cobertura);
			
			reserva.cadastrarReserva(clienteReserva.getNomeCliente(),clienteReserva.getCpfCliente(), data_reserva, hr_inicio_reserva, hr_fim_reserva, modo_pagamento, parcelas,QuadraReserva.getCodigoQuadra(),QuadraReserva.getNomeQuadra(),QuadraReserva.getTipoQuadra(),QuadraReserva.isPossuiCobertura());
      
			UtilidadesGUI.exibeMensagem("Reserva Realizada com Sucesso!\n");
			
			//Quadras.procuraQuadras(data_reserva, hr_inicio_reserva,  hr_fim_reserva, tipo_quadra, cobertura, arquibancada, areaDescanso);
			
			

		}catch(Exception e) {
			UtilidadesGUI.exibeMensagem("Reserva interrompida!\n");
		}
	}
	
	
	void visualizarReservas() {}
	
	
}
