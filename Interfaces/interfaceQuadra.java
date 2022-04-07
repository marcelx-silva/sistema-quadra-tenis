import java.util.Scanner;

public final class interfaceQuadra {
	
	Scanner scanner = new Scanner(System.in);
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	
	void interfacePrincipalQuadras() {
		Quadras quadra = new Quadras();
		int operadorDoMenu = 0;
		do {
			utilidades.exibeMensagem("MENU QUADRA"
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
					this.interfaceCadastrarQuadra(quadra);
					break;
					
				case 2:
					this.interfaceBloqueioQuadra(quadra);
					break;
					
				case 5:
					utilidades.exibeMensagem("Voltando ao menu anterior!\n");
					break;
					
				default:
					utilidades.exibeMensagem("Ainda em desenvolvimento!\n");
					break;
			}
			
		}while(operadorDoMenu != 5);
		
	}
	
	void interfaceCadastrarQuadra(Quadras quadra) {

		String nome = "";
		int numero = 0;
		String endereco = "";
		String tipo = "";
		boolean cobertura = false;
		boolean arquibancada = false;
		boolean area = false;
		
		try {
			
			utilidades.exibeMensagem("Nome da quadra: ");
			nome = scanner.nextLine();
			
			utilidades.exibeMensagem("N�mero da quadra: ");
			numero = Integer.parseInt(scanner.nextLine());
			
			utilidades.exibeMensagem("Endere�o da quadra: ");
			endereco = scanner.nextLine();
		
			utilidades.exibeMensagem("Tipo da quadra, selecione uma das op��es atr�ves dos n�meros:"
									+ "\n1. SAIBRO"
									+ "\n2. SUPERF�CIE SINT�TICA"
									+ "\n3. CIMENTO"
									+ "\n4. BEACH TENNIS"
									+ "\nOp��o: ");
			tipo = quadra.identificaTipoQuadra(scanner.nextInt());
			
			utilidades.exibeMensagem("Possui cobertura (sim/n�o): ");
			cobertura = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
			
			utilidades.exibeMensagem("Possui arquibancada (sim/n�o): ");
			arquibancada = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
			
			utilidades.exibeMensagem("Possui �rea de descanso: ");
			area = utilidades.transformaString(utilidades.persistirValor(scanner.next()));
			
			utilidades.exibeMensagem("Cadastro Realizado com Sucesso!\n");
			quadra.cadastraQuadra(numero, nome, endereco, tipo, cobertura, arquibancada, area);
		}catch(Exception e) {
			utilidades.exibeMensagem("Cadastro interrompido!\n");
		}
	}
	
	void interfaceBloqueioQuadra(Quadras quadra) {
		int numero;
		boolean continuaMetodo, estadoQuadra;
		utilidades.exibeMensagem("Digite o numero de identifica��o da quadra: ");
		numero = Integer.parseInt(scanner.nextLine());
		
		continuaMetodo = quadra.verificaNumeroQuadra(numero);
		
		if(continuaMetodo) {
			estadoQuadra = quadra.isEstaBloqueada();
			
			if(estadoQuadra) 
				utilidades.exibeMensagem("A quadra est� DESBLOQUEADA\n");
			else
				utilidades.exibeMensagem("A quadra est� BLOQUEADA\n");
			
			do {
				utilidades.exibeMensagem("Deseja deixar est� quadra HABILITADA (digite 1) ou DESABILITADA (digite 0): ");
				numero = Integer.parseInt(scanner.nextLine());
			}while(numero != 1 && numero != 0);		
			
			if(numero == 1)
				quadra.setEstaBloqueada(true);
			else
				quadra.setEstaBloqueada(false);
		}else
			utilidades.exibeMensagem("N�mero digitado n�o corresponde a nenhuma quadra cadastrada!");
	}
}