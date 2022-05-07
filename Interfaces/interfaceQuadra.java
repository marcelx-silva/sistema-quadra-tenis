import java.util.ArrayList;
import java.util.Scanner;

public class interfaceQuadra {
	
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
					
				case 4:
					this.interfaceVisualizarQuadras();
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
		Quadras quadra = quadras.get(0);//necessário verificar como fazer isso de uma forma melhor depois
		
		UtilidadesSimplificadas.exibeMensagem("Digite o numero de identificação da quadra: ");
		numero = Integer.parseInt(scanner.nextLine());
		
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
	
	
	void interfaceVisualizarQuadras() {
		
		String[][] quadras;
		int operadorDoMenu = 0;
		do {
			UtilidadesSimplificadas.exibeMensagem("Visualizar quadras: "
					+ "\n1. Cadastradas"
					+ "\n2. Habilitadas"
					+ "\n3. Desabilitadas"
					+ "\n4. Voltar");
			
			operadorDoMenu = scanner.nextInt();
			scanner.nextLine();
			
			switch(operadorDoMenu){
				
				case 1:
					quadras = Quadras.procuraQuadrasCadastradas();
					exibirQuadras(quadras);
					break;
					
				case 2:
					UtilidadesSimplificadas.exibeMensagem("Em desenvolvimento!\n");
					break;
					
				case 3:
					UtilidadesSimplificadas.exibeMensagem("Em desenvolvimento!\n");
					break;
					
				case 4:
					UtilidadesSimplificadas.exibeMensagem("Voltando ao menu anterior!\n");
					break;
					
				default:
					UtilidadesSimplificadas.exibeMensagem("Opção invalida!\n");
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
		UtilidadesSimplificadas.exibeMensagem("\n");
		
		for (int i=0; i < quadras.length; i++) {
			for (int j=0; j < 8; j++) {
				formatarColunas(quadras[i][j], Integer.parseInt(colunas[j][1]));
			}
			UtilidadesSimplificadas.exibeMensagem("\n");
		}
		

	}
	
	void formatarColunas(String conteudo, int tamanhoM) {
		//System.out.println(conteudo + " " +tamanhoM + " "+ conteudo.length());
		UtilidadesSimplificadas.exibeMensagem(conteudo);
		for (int i = conteudo.length(); i <= tamanhoM; i++) 
			UtilidadesSimplificadas.exibeMensagem(" ");
				
	}
	
}
