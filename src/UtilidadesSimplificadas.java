
public class UtilidadesSimplificadas {
	//Algumas utilidades recorrentes para simplificar o código posteriormente
	
	void exibeMensagem(String mensagem) {
		System.out.println(mensagem);
	}
	
	boolean transformaString(String valor) {
		if(valor.contentEquals("Sim") || valor.contentEquals("sim"))
			return true;
		else
			return false;
	}
}
