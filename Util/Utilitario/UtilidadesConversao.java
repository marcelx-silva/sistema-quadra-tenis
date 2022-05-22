package Utilitario;

public class UtilidadesConversao {
	
	public static boolean transformaString(String valor) {
		if(valor.equalsIgnoreCase("sim"))
			return true;
		else
			return false;
	}
	
	public static String transformaBoolean(boolean valor) {
		if(valor)
			return "Sim";
		else
			return "Não";
	}
}
