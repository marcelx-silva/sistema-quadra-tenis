import java.util.Scanner;

public class interfaceQuadra {
	
	Quadras quadraTeste = new Quadras();
	Scanner scanner = new Scanner(System.in);
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	
	void cadastrarQuadra() {
		
		utilidades.exibeMensagem("Nome da quadra: ");
		quadraTeste.setNomeQuadra(scanner.nextLine());
		
		utilidades.exibeMensagem("N�mero da quadra: ");
		quadraTeste.setCodigoQuadra(scanner.nextInt());
		
		utilidades.exibeMensagem("Endere�o da quadra: ");
		quadraTeste.setNomeQuadra(scanner.nextLine());
		
		utilidades.exibeMensagem("Tipo da quadra, selecione uma das op��es atr�ves dos n�meros:"
								+ "\n1. SAIBRO"
								+ "\n2. SUPERF�CIE SINT�TICA"
								+ "\n3. CIMENTO"
								+ "\n4. BEACH TENNIS"
								+ "\nOp��o: ");
		quadraTeste.setTipoQuadra(quadraTeste.identificaTipoQuadra(scanner.nextInt()));
		
		utilidades.exibeMensagem("Possui cobertura(sim/n�o): ");
		quadraTeste.setPossuiCobertura(utilidades.transformaString(scanner.nextLine()));
		
		utilidades.exibeMensagem("Possui arquibancada(sim/n�o): ");
		quadraTeste.setPossuiArquibancada(utilidades.transformaString(scanner.nextLine()));
		
		utilidades.exibeMensagem("Possui �rea de descanso(sim/n�o): ");
		quadraTeste.setPossuiAreaDescanso(utilidades.transformaString(scanner.nextLine()));
		
	}
}
