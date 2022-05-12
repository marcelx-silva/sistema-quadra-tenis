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
					+ "\nOP��O: ");
			
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
			
			UtilidadesGUI.exibeMensagem("N�mero da quadra: ");
			numero = Integer.parseInt(scanner.nextLine());
			
			UtilidadesGUI.exibeMensagem("Endere�o da quadra: ");
			endereco = scanner.nextLine();
		
			UtilidadesGUI.exibeMensagem("Tipo da quadra, selecione uma das op��es atr�ves dos n�meros:"
									+ "\n1. SAIBRO"
									+ "\n2. SUPERF�CIE SINT�TICA"
									+ "\n3. CIMENTO"
									+ "\n4. BEACH TENNIS"
									+ "\nOp��o: ");
			tipo = quadra.identificaTipoQuadra(scanner.nextInt());
			
			UtilidadesGUI.exibeMensagem("Possui cobertura (sim/n�o): ");
			cobertura = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
			
			UtilidadesGUI.exibeMensagem("Possui arquibancada (sim/n�o): ");
			arquibancada = UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next()));
			
			UtilidadesGUI.exibeMensagem("Possui �rea de descanso: ");
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
		
		UtilidadesGUI.exibeMensagem("Digite o numero de identifica��o da quadra: ");
		numero = Integer.parseInt(scanner.nextLine());
		Quadras quadra = quadras.get(numero);//necess�rio verificar como fazer isso de uma forma melhor depois
		
		continuaMetodo = quadra.verificaNumeroQuadra(numero);
		
		if(continuaMetodo) {
			estadoQuadra = quadra.isEstaBloqueada();
			
			if(estadoQuadra) 
				UtilidadesGUI.exibeMensagem("A quadra est� DESBLOQUEADA\n");
			else
				UtilidadesGUI.exibeMensagem("A quadra est� BLOQUEADA\n");
			
			do {
				UtilidadesGUI.exibeMensagem("Deseja deixar est� quadra HABILITADA (digite 1) ou DESABILITADA (digite 0): ");
				numero = Integer.parseInt(scanner.nextLine());
			}while(numero != 1 && numero != 0);		
			
			if(numero == 1)
				quadra.desbloqueiaQuadraParaAluguel();
			else
				quadra.bloqueiaQuadraParaAluguel();
		}else
			UtilidadesGUI.exibeMensagem("N�mero digitado n�o corresponde a nenhuma quadra cadastrada!");
	}
	
	private void interfaceAlteraDados() {
		int numero, operador = 100;
		boolean continuaMetodo;
		
		UtilidadesGUI.exibeMensagem("Digite o numero de identifica��o da quadra: ");
		numero = Integer.parseInt(scanner.nextLine());
		Quadras quadra = quadras.get(numero);//necess�rio verificar como fazer isso de uma forma melhor depois
		
		continuaMetodo = quadra.verificaNumeroQuadra(numero);
		
		if(continuaMetodo) {
			UtilidadesGUI.exibeMensagem("Dados atuais: "
					+ "\n N�mero da Quadra (Inalter�vel): " + quadra.getCodigoQuadra()
					+ "\nNome da Quadra: " + quadra.getNomeQuadra()
					+ "\nEndere�o da Quadra: " + quadra.getEnderecoQuadra()
					+ "\nTipo da Quadra: " + quadra.getTipoQuadra()
					+ "\nTem Cobertura: " + UtilidadesConversao.transformaBoolean(quadra.isPossuiCobertura())
					+ "\nTem Arquibancada: " + UtilidadesConversao.transformaBoolean(quadra.isPossuiArquibancada())
					+ "\nTem �rea de Descanso: " + UtilidadesConversao.transformaBoolean(quadra.isPossuiAreaDescanso()));
			do {
				UtilidadesGUI.exibeMensagem("\nOp��es para trocar: "
						+ "\n1. Nome da Quadra"
						+ "\n2. Endere�o da Quadra"
						+ "\n3. Tipo da Quadra"
						+ "\n4. Tem Cobertura"
						+ "\n5. Tem Arquibancada"
						+ "\n6. Tem �rea de Descanso");
				operador = Integer.parseInt(scanner.nextLine());
				switch(operador) {
				
				case 1:
					UtilidadesGUI.exibeMensagem("Digite o novo nome da quadra: ");
					quadra.setNomeQuadra(scanner.nextLine());
					break;
				
				case 2:
					UtilidadesGUI.exibeMensagem("Digite o novo endere�o da quadra: ");
					quadra.setEnderecoQuadra(scanner.nextLine());
					break;
					
				case 3:
					UtilidadesGUI.exibeMensagem("Digite o novo tipo da quadra, selecione uma das op��es atr�ves dos n�meros:"
							+ "\n1. SAIBRO"
							+ "\n2. SUPERF�CIE SINT�TICA"
							+ "\n3. CIMENTO"
							+ "\n4. BEACH TENNIS"
							+ "\nOp��o: ");
					quadra.setTipoQuadra(quadra.identificaTipoQuadra(scanner.nextInt()));
					break;
					
				case 4:
					UtilidadesGUI.exibeMensagem("Digite se a quadra agora possui cobertura (sim/n�o): ");
					quadra.setPossuiCobertura(UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next())));
					break;
					
				case 5:
					UtilidadesGUI.exibeMensagem("Digite se a quadra agora possui arquibancada (sim/n�o): ");
					quadra.setPossuiArquibancada(UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next())));
					break;
					
				case 6:
					UtilidadesGUI.exibeMensagem("Digite se a quadra agora possui �rea de descanso (sim/n�o): ");
					quadra.setPossuiAreaDescanso(UtilidadesConversao.transformaString(UtilidadesGUI.persistirValor(scanner.next())));
					break;
					
				default:
					UtilidadesGUI.exibeMensagem("Op��o Inv�lida!");
					break;
				}
			}while(true);
			
		}else
			UtilidadesGUI.exibeMensagem("N�mero digitado n�o corresponde a nenhuma quadra cadastrada!");
	}
}
