import java.util.Scanner;

public class interfaceQuadra {
	
	Scanner scanner = new Scanner(System.in);
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	
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
			
			utilidades.exibeMensagem("Endere�o da quadra: ");
			endereco = scanner.nextLine();
			
			utilidades.exibeMensagem("N�mero da quadra: ");
			numero = scanner.nextInt();
			
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
			
			quadra.cadastraQuadra(numero, nome, endereco, tipo, cobertura, arquibancada, area);
		}catch(Exception e) {
			utilidades.exibeMensagem("Cadastro interrompido!");
		}
	}
}
