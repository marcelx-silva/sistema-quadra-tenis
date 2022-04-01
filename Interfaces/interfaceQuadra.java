import java.util.Scanner;

public class interfaceQuadra {
	
	Quadras quadraTeste = new Quadras();
	Scanner scanner = new Scanner(System.in);
	UtilidadesSimplificadas utilidades = new UtilidadesSimplificadas();
	
	void cadastrarQuadra() {
		
		utilidades.exibeMensagem("Nome da quadra: ");
		quadraTeste.setNomeQuadra(scanner.nextLine());
		
		utilidades.exibeMensagem("Número da quadra: ");
		quadraTeste.setCodigoQuadra(scanner.nextInt());
		
		utilidades.exibeMensagem("Endereço da quadra: ");
		quadraTeste.setNomeQuadra(scanner.nextLine());
		
		utilidades.exibeMensagem("Tipo da quadra, selecione uma das opções atráves dos números:"
								+ "\n1. SAIBRO"
								+ "\n2. SUPERFÍCIE SINTÉTICA"
								+ "\n3. CIMENTO"
								+ "\n4. BEACH TENNIS"
								+ "\nOpção: ");
		quadraTeste.setTipoQuadra(quadraTeste.identificaTipoQuadra(scanner.nextInt()));
		
		utilidades.exibeMensagem("Possui cobertura(sim/não): ");
		quadraTeste.setPossuiCobertura(utilidades.transformaString(scanner.nextLine()));
		
		utilidades.exibeMensagem("Possui arquibancada(sim/não): ");
		quadraTeste.setPossuiArquibancada(utilidades.transformaString(scanner.nextLine()));
		
		utilidades.exibeMensagem("Possui área de descanso(sim/não): ");
		quadraTeste.setPossuiAreaDescanso(utilidades.transformaString(scanner.nextLine()));
		
	}
}
