package Utilitario;
import java.util.Scanner;

public class UtilidadesGUI {
	//Algumas utilidades recorrentes para simplificar o c�digo posteriormente
	
		static Scanner scanner = new Scanner(System.in);
		
		public static void exibeMensagem(String mensagem) {
			System.out.print(mensagem);
		}
		
		public static String persistirValor(String valor) {
			if(valor.equalsIgnoreCase("sim") || valor.equalsIgnoreCase("n�o"))
				return valor;
			exibeMensagem("Digite sim/n�o: ");
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
