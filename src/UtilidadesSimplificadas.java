import java.util.Scanner;

public class UtilidadesSimplificadas {
	//Algumas utilidades recorrentes para simplificar o código posteriormente
	
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
		if(valor.contentEquals("Sim") || valor.contentEquals("sim") || valor.contentEquals("SIM") || valor.contentEquals("NÃO")  || valor.contentEquals("Não")  || valor.contentEquals("não"))
			return valor;
		exibeMensagem("Digite sim/não: ");
		valor = scanner.nextLine();
		return persistirValor(valor);
	}
}
