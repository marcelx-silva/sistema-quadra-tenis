import java.util.ArrayList;
import java.util.Scanner;

public class GUIQuadras {
	Scanner scanner = new Scanner(System.in);
	ArrayList <Quadra> quadras = new ArrayList<Quadra>();
	
	void GUIPrincipalQuadras() {
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
					this.GUICadastrarQuadra();
					break;
					
				case 2:
					this.GUIBloqueioQuadra();
					break;
					
				case 3:
					this.GUIAlteraDados();
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
	
	void GUICadastrarQuadra() {

		String nome = "";
		int numero = 0;
		String endereco = "";
		TipoQuadra tipo = null;
		boolean cobertura = false;
		boolean arquibancada = false;
		boolean area = false;
		Quadra quadra = new Quadra(numero, nome, endereco, tipo, cobertura, arquibancada, area);
		
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
			quadra = new Quadra(numero, nome, endereco, tipo, cobertura, arquibancada, area);
			quadras.add(quadra);
			
		}catch(Exception e) {
			UtilidadesGUI.exibeMensagem("Cadastro interrompido!\n");
		}
	}
	
	void GUIBloqueioQuadra() {
		int numero;
		boolean continuaMetodo, estadoQuadra;
		
		UtilidadesGUI.exibeMensagem("Digite o numero de identificação da quadra: ");
		numero = Integer.parseInt(scanner.nextLine());
		Quadra quadra = quadras.get(numero);//necessário verificar como fazer isso de uma forma melhor depois
		
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
	
	private void GUIAlteraDados() {
		int numero, operador = 100;
		boolean continuaMetodo;
		
		UtilidadesGUI.exibeMensagem("Digite o numero de identificação da quadra: ");
		numero = Integer.parseInt(scanner.nextLine());
		Quadra quadra = quadras.get(numero);//necessário verificar como fazer isso de uma forma melhor depois
		
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

	void interfaceVisualizarQuadras() {
		
		String[][] quadras;
		int operadorDoMenu = 0;
		do {
			UtilidadesGUI.exibeMensagem("Visualizar quadras: "
					+ "\n1. Cadastradas"
					+ "\n2. Habilitadas"
					+ "\n3. Desabilitadas"
					+ "\n4. Voltar"
					+ "\nOpção: ");
			
			operadorDoMenu = scanner.nextInt();
			scanner.nextLine();
			
			switch(operadorDoMenu){
				
				case 1:
					quadras = Quadra.procuraQuadrasCadastradas();
					exibirQuadras(quadras);
					break;
					
				case 2:
					UtilidadesGUI.exibeMensagem("Em desenvolvimento!\n");
					break;
					
				case 3:
					UtilidadesGUI.exibeMensagem("Em desenvolvimento!\n");
					break;
					
				case 4:
					UtilidadesGUI.exibeMensagem("Voltando ao menu anterior!\n");
					break;
					
				default:
					UtilidadesGUI.exibeMensagem("Opção invalida!\n");
					break;
			}
			
		}while(operadorDoMenu != 4);	
		
	}
	
	void exibirQuadras(String[][] quadras) {
		
		
		String[][] colunas = {{"COD", "3"}, 
							 {"NOME", "50"},
							 {"TIPO", "20"},
							 {"ENDERECO", "50"},
							 {"COBERTURA", "10"},
							 {"ARQUIBANCADA", "12"},
							 {"ÁREA DE DESCANSO", "16"},
							 {"STATUS", "12"}};
		
		for (int i=0; i < colunas.length; i++) {
			formatarColunas(colunas[i][0], Integer.parseInt(colunas[i][1]));
		}
		UtilidadesGUI.exibeMensagem("\n");
		
		for (int i=0; i < quadras.length; i++) {
			for (int j=0; j < 8; j++) {
				formatarColunas(quadras[i][j], Integer.parseInt(colunas[j][1]));
			}
			UtilidadesGUI.exibeMensagem("\n");
		}
		

	}
	
	void formatarColunas(String conteudo, int tamanhoM) {
		UtilidadesGUI.exibeMensagem(conteudo);
		for (int i = conteudo.length(); i <= tamanhoM; i++) 
			UtilidadesGUI.exibeMensagem(" ");
				
	}
}