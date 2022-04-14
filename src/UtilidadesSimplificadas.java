import java.util.Scanner;

public class UtilidadesSimplificadas {
	//Algumas utilidades recorrentes para simplificar o c�digo posteriormente
	
	Scanner scanner = new Scanner(System.in);
	
	void exibeMensagem(String mensagem) {
		System.out.print(mensagem);
	}
	
	boolean transformaString(String valor) {
		if(valor.contentEquals("Sim") || valor.contentEquals("sim") || valor.contentEquals("SIM"))
			return true;
		else
			return false;
	}
	
	String persistirValor(String valor) {
		if(valor.contentEquals("Sim") || valor.contentEquals("sim") || valor.contentEquals("SIM") || valor.contentEquals("N�O")  || valor.contentEquals("N�o")  || valor.contentEquals("n�o"))
			return valor;
		exibeMensagem("Digite sim/n�o: ");
		valor = scanner.nextLine();
		return persistirValor(valor);
	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	            Runtime.getRuntime().exec("cls");
	        else
	            Runtime.getRuntime().exec("clear");
	    }
	    catch (final Exception e)
	    {
	        e.printStackTrace();
	    }
	}
}
