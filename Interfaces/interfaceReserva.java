import java.util.Scanner;


public final class interfaceReserva {


	Scanner scanner = new Scanner(System.in);
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	
	void interfaceMenuReserva() {
		Reservas reserva = new Reservas(0,"","","","","","","","",1,false);
		Quadras quadra = new Quadras();
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
					this.interfaceCadastroReserva(reserva,quadra);
					break;
				case 2:
					this.visualizarReservas();
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
			
			utilidades.exibeMensagem("CPF do reservista: ");
			cpf_usuario = scanner.nextLine();
			
			utilidades.exibeMensagem("Nome do reservista:");
			nome_reservista = scanner.nextLine();
			
			utilidades.exibeMensagem("Data da reserva (dd/mm/aaaa):");
			data_reserva = scanner.nextLine();
			
			utilidades.exibeMensagem("Hor�rio da reserva - IN�CIO (hh:mm) :");
			hr_inicio_reserva = scanner.nextLine();
			
			utilidades.exibeMensagem("Hor�rio da reserva - FIM (hh:mm):");
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
			
			
			
			utilidades.exibeMensagem("Nome da Quadra: ");
			nome_quadra = (scanner.nextLine());
			
			utilidades.exibeMensagem("C�digo da quadra: ");
			cod_quadra = Integer.parseInt(scanner.nextLine());
			
			utilidades.exibeMensagem("Tipo da quadra, selecione uma das op��es atr�ves dos n�meros:"
					+ "\n1. SAIBRO"
					+ "\n2. SUPERF�CIE SINT�TICA"
					+ "\n3. CIMENTO"
					+ "\n4. BEACH TENNIS"
					+ "\nOp��o: ");
			tipo_quadra = quadra.identificaTipoQuadra(scanner.nextInt());
		
			
			utilidades.exibeMensagem("Possui cobertura (sim/n�o): ");
			cobertura = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
			
			utilidades.exibeMensagem("Deseja quadra com arquibancada (sim/nao)");
			arquibancada = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
			
			utilidades.exibeMensagem("Deseja quadra com area de descanso: (sim/nao)");
			areaDescanso = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
			
			
			utilidades.exibeMensagem("Reserva Realizada com Sucesso!\n");
			
			Quadras.procuraQuadras(data_reserva, hr_inicio_reserva,  hr_fim_reserva, tipo_quadra, cobertura, arquibancada, areaDescanso);
			
			reserva.cadastrarReserva(cpf_usuario,nome_reservista, data_reserva, hr_inicio_reserva, hr_fim_reserva, modo_pagamento, parcelas,cobertura,cod_quadra,nome_quadra,tipo_quadra);

		}catch(Exception e) {
			utilidades.exibeMensagem("Reserva interrompida!\n");
		}
	}
	
	
	void visualizarReservas() {}
	
	
}
