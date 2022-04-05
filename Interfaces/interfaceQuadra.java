import java.util.Scanner;

public class interfaceQuadra {
	
	Scanner scanner = new Scanner(System.in);
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	
	final void interfacePrincipalQuadras() {
		Quadras quadra = new Quadras();
		int operadorDoMenu = 0;
		do {
			utilidades.exibeMensagem("MENU QUADRA"
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
					this.interfaceCadastrarQuadra(quadra);
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
		}catch(Exception e) {
			utilidades.exibeMensagem("Cadastro interrompido!\n");
		}
	}
}
