import java.util.Scanner;

public final class interfaceReserva {

	Scanner scanner = new Scanner(System.in);
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	
	Quadras quadra = new Quadras();
	Reservas reserva = new Reservas("","","","","",1,quadra);
	
	void interfaceMenuReserva() {
		int operadorMenu = 0;
		
		do {
			utilidades.exibeMensagem("MENU RESERVA"
					+ "\n1. CADASTRAR RESERVA"
					+ "\n2. VISUALIZAR RESERVAS"
					+ "\n3. CANCELAR RESERVAS"
					+ "\n4. SAIR DO MENU"
					+ "\nOPÇÃO: ");
			
			operadorMenu = scanner.nextInt();
			scanner.nextLine();
			
			switch(operadorMenu) {
				case 1:
					this.interfaceCadastroReserva();
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
	
	void interfaceCadastroReserva(){
		
		String nome = "";
		int numero = 0;
		String endereco = "";
		String tipo = "";
		boolean cobertura = false;
		boolean arquibancada = false;
		boolean area = false;
		
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
			nome_reservista = scanner.nextLine();
			
			utilidades.exibeMensagem("Horário da reserva (INÍCIO):");
			hr_inicio_reserva = scanner.nextLine();
			
			utilidades.exibeMensagem("Horário da reserva (FIM):");
			hr_fim_reserva = scanner.nextLine();
			
			utilidades.exibeMensagem("Modo de Pagamento, meio pelo qual o reservista pagará a sua reserva:"
					+ "\n1. CRÉDITO"
					+ "\n2. DÉBITO"
					+ "\n3. DINHEIRO"
					+ "\n4. PIX"
					+ "\nOpção: ");
			
			modo_pagamento = reserva.selecionarModoPagamento(scanner.nextInt());
			
			if(modo_pagamento.equals("CRÉDITO") || modo_pagamento.equals("PIX")) {
				utilidades.exibeMensagem("Utilizando "+modo_pagamento+" como modo de pagamento é possível parcelar em:"
						+ "\n1. A vista"
						+ "\n2. 2x"
						+ "\n3. 4x"
						+ "\n Opção: ");
				parcelas = reserva.parcelarReserva(scanner.nextInt());
			}
			
			utilidades.exibeMensagem("Nome da quadra: ");
			nome = scanner.nextLine();
			
			utilidades.exibeMensagem("Número da quadra: ");
			numero = Integer.parseInt(scanner.nextLine());
			
			utilidades.exibeMensagem("Endereço da quadra: ");
			endereco = scanner.nextLine();
		
			utilidades.exibeMensagem("Tipo da quadra, selecione uma das opções atráves dos números:"
									+ "\n1. SAIBRO"
									+ "\n2. SUPERFÍCIE SINTÉTICA"
									+ "\n3. CIMENTO"
									+ "\n4. BEACH TENNIS"
									+ "\nOpção: ");
			tipo = quadra.identificaTipoQuadra(scanner.nextInt());
			
			utilidades.exibeMensagem("Possui cobertura (sim/não): ");
			cobertura = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
			
			utilidades.exibeMensagem("Possui arquibancada (sim/não): ");
			arquibancada = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
			
			utilidades.exibeMensagem("Possui área de descanso: ");
			area = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
			
			utilidades.exibeMensagem("Cadastro Realizado com Sucesso!\n");
			quadra.cadastraQuadra(numero, nome, endereco, tipo, cobertura, arquibancada, area);
			reserva.cadastrarReserva(nome_reservista, hr_inicio_reserva, data_reserva, hr_fim_reserva, modo_pagamento, parcelas, quadra);
		}catch(Exception e) {
			utilidades.exibeMensagem("Reserva interrompida!\n");
		}
		
	}
	
	

}
