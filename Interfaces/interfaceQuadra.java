import java.util.ArrayList;
import java.util.Scanner;

public final class interfaceQuadra {
	
	Scanner scanner = new Scanner(System.in);
	ArrayList <Quadras> quadras = new ArrayList<Quadras>();
	
	void interfacePrincipalQuadras() {
		int operadorDoMenu = 0;
		do {
			UtilidadesGUI.exibeMensagem("MENU QUADRA"
					+ "\n1.CADASTRAR QUADRA"
					+ "\n2.DESBLOQUEAR/BLOQUEAR QUADRAS"
					+ "\n3.ALTERAR DADOS"
					+ "\n4.VISUALIZAR QUADRAS"
					+ "\n5.SAIR DO MENU"
					+ "\nOPÇÃO: ");
			
			operadorDoMenu = scanner.nextInt();
			scanner.nextLine();
			
			switch(operadorDoMenu){
				
				case 1:
					this.interfaceCadastrarQuadra();
					break;
					
				case 2:
					this.interfaceBloqueioQuadra();
					break;
					
				case 3:
					this.interfaceAlteraDados();
					break;
					
				case 5:
					UtilidadesGUI.exibeMensagem("Voltando ao menu anterior!\n");
					break;
					
				default:
					UtilidadesGUI.exibeMensagem("Ainda em desenvolvimento!\n");
					break;
			}
			
		}while(operadorDoMenu != 5);
		
	}
	
	void interfaceCadastrarQuadra() {

		String nome = "";
		int numero = 0;
		String endereco = "";
		TipoQuadra tipo = null;
		boolean cobertura = false;
		boolean arquibancada = false;
		boolean area = false;
		Quadras quadra = new Quadras(numero, nome, endereco, tipo, cobertura, arquibancada, area);
		
		try {
			
			UtilidadesGUI.exibeMensagem("Nome da quadra: ");
			nome = scanner.nextLine();
			
			UtilidadesGUI.exibeMensagem("Número da quadra: ");
			numero = Integer.parseInt(scanner.nextLine());
			
			UtilidadesGUI.exibeMensagem("Endereço da quadra: ");
			endereco = scanner.nextLine();
		
			UtilidadesGUI.exibeMensagem("Tipo da quadra, selecione uma das opções atráves dos números:"
									+ "\n1. SAIBRO"
									+ "\n2. SUPERFÍCIE SINTÉTICA"
									+ "\n3. CIMENTO"
									+ "\n4. BEACH TENNIS"
									+ "\nOpção: ");
			tipo = quadra.identificaTipoQuadra(scanner.nextInt());
			
			UtilidadesGUI.exibeMensagem("Possui cobertura (sim/não): ");
			cobertura = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
			
			UtilidadesGUI.exibeMensagem("Possui arquibancada (sim/não): ");
			arquibancada = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
			
			UtilidadesGUI.exibeMensagem("Possui área de descanso: ");
			area = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
			
			UtilidadesGUI.exibeMensagem("Cadastro Realizado com Sucesso!\n");
			quadra = new Quadras(numero, nome, endereco, tipo, cobertura, arquibancada, area);
			quadras.add(quadra);
			
		}catch(Exception e) {
			UtilidadesGUI.exibeMensagem("Cadastro interrompido!\n");
		}
	}
	
	void interfaceBloqueioQuadra() {
		int numero;
		boolean continuaMetodo, estadoQuadra;
		
		UtilidadesGUI.exibeMensagem("Digite o numero de identificação da quadra: ");
		numero = Integer.parseInt(scanner.nextLine());
		Quadras quadra = quadras.get(numero);//necessário verificar como fazer isso de uma forma melhor depois
		
		continuaMetodo = quadra.verificaNumeroQuadra(numero);
		
		if(continuaMetodo) {
			estadoQuadra = quadra.isEstaBloqueada();
			
			if(estadoQuadra) 
				UtilidadesGUI.exibeMensagem("A quadra está DESBLOQUEADA\n");
			else
				UtilidadesGUI.exibeMensagem("A quadra está BLOQUEADA\n");
			
			do {
				UtilidadesGUI.exibeMensagem("Deseja deixar está quadra HABILITADA (digite 1) ou DESABILITADA (digite 0): ");
				numero = Integer.parseInt(scanner.nextLine());
			}while(numero != 1 && numero != 0);		
			
			if(numero == 1)
				quadra.desbloqueiaQuadraParaAluguel();
			else
				quadra.bloqueiaQuadraParaAluguel();
		}else
			UtilidadesGUI.exibeMensagem("Número digitado não corresponde a nenhuma quadra cadastrada!");
	}
	
	private void interfaceAlteraDados() {
		int numero, operador = 100;
		boolean continuaMetodo;
		
		UtilidadesGUI.exibeMensagem("Digite o numero de identificação da quadra: ");
		numero = Integer.parseInt(scanner.nextLine());
		Quadras quadra = quadras.get(numero);//necessário verificar como fazer isso de uma forma melhor depois
		
		continuaMetodo = quadra.verificaNumeroQuadra(numero);
		
		if(continuaMetodo) {
			UtilidadesGUI.exibeMensagem("Dados atuais: "
					+ "\n Número da Quadra (Inalterável): " + quadra.getCodigoQuadra()
					+ "\nNome da Quadra: " + quadra.getNomeQuadra()
					+ "\nEndereço da Quadra: " + quadra.getEnderecoQuadra()
					+ "\nTipo da Quadra: " + quadra.getTipoQuadra()
					+ "\nTem Cobertura: " + UtilidadesConversao.transformaBoolean(quadra.isPossuiCobertura())
					+ "\nTem Arquibancada: " + UtilidadesConversao.transformaBoolean(quadra.isPossuiArquibancada())
					+ "\nTem Área de Descanso: " + UtilidadesConversao.transformaBoolean(quadra.isPossuiAreaDescanso()));
			do {
				UtilidadesGUI.exibeMensagem("\nOpções para trocar: "
						+ "\n1. Nome da Quadra"
						+ "\n2. Endereço da Quadra"
						+ "\n3. Tipo da Quadra"
						+ "\n4. Tem Cobertura"
						+ "\n5. Tem Arquibancada"
						+ "\n6. Tem Área de Descanso");
				operador = Integer.parseInt(scanner.nextLine());
				switch(operador) {
				
				case 1:
					UtilidadesGUI.exibeMensagem("Digite o novo nome da quadra: ");
					quadra.setNomeQuadra(scanner.nextLine());
					break;
				
				case 2:
					UtilidadesGUI.exibeMensagem("Digite o novo endereço da quadra: ");
					quadra.setEnderecoQuadra(scanner.nextLine());
					break;
					
				case 3:
					UtilidadesGUI.exibeMensagem("Digite o novo tipo da quadra, selecione uma das opções atráves dos números:"
							+ "\n1. SAIBRO"
							+ "\n2. SUPERFÍCIE SINTÉTICA"
							+ "\n3. CIMENTO"
							+ "\n4. BEACH TENNIS"
							+ "\nOpção: ");
					quadra.setTipoQuadra(quadra.identificaTipoQuadra(scanner.nextInt()));
					break;
					
				case 4:
					UtilidadesGUI.exibeMensagem("Digite se a quadra agora possui cobertura (sim/não): ");
					quadra.setPossuiCobertura(UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next())));
					break;
					
				case 5:
					UtilidadesGUI.exibeMensagem("Digite se a quadra agora possui arquibancada (sim/não): ");
					quadra.setPossuiArquibancada(UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next())));
					break;
					
				case 6:
					UtilidadesGUI.exibeMensagem("Digite se a quadra agora possui área de descanso (sim/não): ");
					quadra.setPossuiAreaDescanso(UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next())));
					break;
					
				default:
					UtilidadesGUI.exibeMensagem("Opção Inválida!");
					break;
				}
			}while(true);
			
		}else
			UtilidadesGUI.exibeMensagem("Número digitado não corresponde a nenhuma quadra cadastrada!");
	}
}
