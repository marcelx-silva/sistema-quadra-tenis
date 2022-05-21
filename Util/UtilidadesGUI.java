import java.util.Scanner;

public class UtilidadesGUI {
	//Algumas utilidades recorrentes para simplificar o código posteriormente
	
	static Scanner scanner = new Scanner(System.in);
	
	static void exibeMensagem(String mensagem) {
		System.out.print(mensagem);
	}
	
	static String persistirValor(String valor) {
		if(valor.equalsIgnoreCase("sim") || valor.equalsIgnoreCase("não"))
			return valor;
		exibeMensagem("Digite sim/não: ");
		valor = scanner.nextLine();
		return persistirValor(valor);
	}
	
	public final static void clearConsole() {
	    try {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	            Runtime.getRuntime().exec("cls");
	        else
	            Runtime.getRuntime().exec("clear");
	    }
	    catch (final Exception e) {
	        e.printStackTrace();
	    }
	}
}
