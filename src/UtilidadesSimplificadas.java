import java.util.Scanner;

public class UtilidadesSimplificadas {
	//Algumas utilidades recorrentes para simplificar o código posteriormente
	
	static Scanner scanner = new Scanner(System.in);
	
	static void exibeMensagem(String mensagem) {
		System.out.print(mensagem);
	}
	
	static boolean transformaString(String valor) {
		if(valor.contentEquals("Sim") || valor.contentEquals("sim") || valor.contentEquals("SIM"))
			return true;
		else
			return false;
	}
	
	static String persistirValor(String valor) {
		if(valor.contentEquals("Sim") || valor.contentEquals("sim") || valor.contentEquals("SIM") || valor.contentEquals("NÃO")  || valor.contentEquals("Não")  || valor.contentEquals("não"))
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
