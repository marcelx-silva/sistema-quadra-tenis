import java.util.ArrayList;
import java.util.Scanner;

public final class interfaceQuadra {
	
	Scanner scanner = new Scanner(System.in);
	ArrayList <Quadras> quadras = new ArrayList<Quadras>();
	
	void interfacePrincipalQuadras() {
		int operadorDoMenu = 0;
		do {
			UtilidadesSimplificadas.exibeMensagem("MENU QUADRA"
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
					UtilidadesSimplificadas.exibeMensagem("Voltando ao menu anterior!\n");
					break;
					
				default:
					UtilidadesSimplificadas.exibeMensagem("Ainda em desenvolvimento!\n");
					break;
			}
			
		}while(operadorDoMenu != 5);
		
	}
	
	void interfaceCadastrarQuadra() {

		String nome = "";
		int numero = 0;
		String endereco = "";
		String tipo = "";
		boolean cobertura = false;
		boolean arquibancada = false;
		boolean area = false;
		Quadras quadra = new Quadras(numero, nome, endereco, tipo, cobertura, arquibancada, area);
		
		try {
			
			UtilidadesSimplificadas.exibeMensagem("Nome da quadra: ");
			nome = scanner.nextLine();
			
			UtilidadesSimplificadas.exibeMensagem("Número da quadra: ");
			numero = Integer.parseInt(scanner.nextLine());
			
			UtilidadesSimplificadas.exibeMensagem("Endereço da quadra: ");
			endereco = scanner.nextLine();
		
			UtilidadesSimplificadas.exibeMensagem("Tipo da quadra, selecione uma das opções atráves dos números:"
									+ "\n1. SAIBRO"
									+ "\n2. SUPERFÍCIE SINTÉTICA"
									+ "\n3. CIMENTO"
									+ "\n4. BEACH TENNIS"
									+ "\nOpção: ");
			tipo = quadra.identificaTipoQuadra(scanner.nextInt());
			
			UtilidadesSimplificadas.exibeMensagem("Possui cobertura (sim/não): ");
			cobertura = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
			
			UtilidadesSimplificadas.exibeMensagem("Possui arquibancada (sim/não): ");
			arquibancada = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
			
			UtilidadesSimplificadas.exibeMensagem("Possui área de descanso: ");
			area = UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next()));
			
			UtilidadesSimplificadas.exibeMensagem("Cadastro Realizado com Sucesso!\n");
			quadra = new Quadras(numero, nome, endereco, tipo, cobertura, arquibancada, area);
			quadras.add(quadra);
			
		}catch(Exception e) {
			UtilidadesSimplificadas.exibeMensagem("Cadastro interrompido!\n");
		}
	}
	
	void interfaceBloqueioQuadra() {
		int numero;
		boolean continuaMetodo, estadoQuadra;
		
		UtilidadesSimplificadas.exibeMensagem("Digite o numero de identificação da quadra: ");
		numero = Integer.parseInt(scanner.nextLine());
		Quadras quadra = quadras.get(numero);//necessário verificar como fazer isso de uma forma melhor depois
		
		continuaMetodo = quadra.verificaNumeroQuadra(numero);
		
		if(continuaMetodo) {
			estadoQuadra = quadra.isEstaBloqueada();
			
			if(estadoQuadra) 
				UtilidadesSimplificadas.exibeMensagem("A quadra está DESBLOQUEADA\n");
			else
				UtilidadesSimplificadas.exibeMensagem("A quadra está BLOQUEADA\n");
			
			do {
				UtilidadesSimplificadas.exibeMensagem("Deseja deixar está quadra HABILITADA (digite 1) ou DESABILITADA (digite 0): ");
				numero = Integer.parseInt(scanner.nextLine());
			}while(numero != 1 && numero != 0);		
			
			if(numero == 1)
				quadra.desbloqueiaQuadraParaAluguel();
			else
				quadra.bloqueiaQuadraParaAluguel();
		}else
			UtilidadesSimplificadas.exibeMensagem("Número digitado não corresponde a nenhuma quadra cadastrada!");
	}
	
	private void interfaceAlteraDados() {
		int numero, operador = 100;
		boolean continuaMetodo;
		
		UtilidadesSimplificadas.exibeMensagem("Digite o numero de identificação da quadra: ");
		numero = Integer.parseInt(scanner.nextLine());
		Quadras quadra = quadras.get(numero);//necessário verificar como fazer isso de uma forma melhor depois
		
		continuaMetodo = quadra.verificaNumeroQuadra(numero);
		
		if(continuaMetodo) {
			UtilidadesSimplificadas.exibeMensagem("Dados atuais: "
					+ "\n Número da Quadra (Inalterável): " + quadra.getCodigoQuadra()
					+ "\nNome da Quadra: " + quadra.getNomeQuadra()
					+ "\nEndereço da Quadra: " + quadra.getEnderecoQuadra()
					+ "\nTipo da Quadra: " + quadra.getTipoQuadra()
					+ "\nTem Cobertura: " + UtilidadesSimplificadas.transformaBoolean(quadra.isPossuiCobertura())
					+ "\nTem Arquibancada: " + UtilidadesSimplificadas.transformaBoolean(quadra.isPossuiArquibancada())
					+ "\nTem Área de Descanso: " + UtilidadesSimplificadas.transformaBoolean(quadra.isPossuiAreaDescanso()));
			do {
				UtilidadesSimplificadas.exibeMensagem("\nOpções para trocar: "
						+ "\n1. Nome da Quadra"
						+ "\n2. Endereço da Quadra"
						+ "\n3. Tipo da Quadra"
						+ "\n4. Tem Cobertura"
						+ "\n5. Tem Arquibancada"
						+ "\n6. Tem Área de Descanso");
				operador = Integer.parseInt(scanner.nextLine());
				switch(operador) {
				
				case 1:
					UtilidadesSimplificadas.exibeMensagem("Digite o novo nome da quadra: ");
					quadra.setNomeQuadra(scanner.nextLine());
					break;
				
				case 2:
					UtilidadesSimplificadas.exibeMensagem("Digite o novo endereço da quadra: ");
					quadra.setEnderecoQuadra(scanner.nextLine());
					break;
					
				case 3:
					UtilidadesSimplificadas.exibeMensagem("Digite o novo tipo da quadra, selecione uma das opções atráves dos números:"
							+ "\n1. SAIBRO"
							+ "\n2. SUPERFÍCIE SINTÉTICA"
							+ "\n3. CIMENTO"
							+ "\n4. BEACH TENNIS"
							+ "\nOpção: ");
					quadra.setTipoQuadra(quadra.identificaTipoQuadra(scanner.nextInt()));
					break;
					
				case 4:
					UtilidadesSimplificadas.exibeMensagem("Digite se a quadra agora possui cobertura (sim/não): ");
					quadra.setPossuiCobertura(UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next())));
					break;
					
				case 5:
					UtilidadesSimplificadas.exibeMensagem("Digite se a quadra agora possui arquibancada (sim/não): ");
					quadra.setPossuiArquibancada(UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next())));
					break;
					
				case 6:
					UtilidadesSimplificadas.exibeMensagem("Digite se a quadra agora possui área de descanso (sim/não): ");
					quadra.setPossuiAreaDescanso(UtilidadesSimplificadas.transformaString(UtilidadesSimplificadas.persistirValor(scanner.next())));
					break;
					
				default:
					UtilidadesSimplificadas.exibeMensagem("Opção Inválida!");
					break;
				}
			}while(true);
			
		}else
			UtilidadesSimplificadas.exibeMensagem("Número digitado não corresponde a nenhuma quadra cadastrada!");
	}
}
