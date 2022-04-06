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
}
