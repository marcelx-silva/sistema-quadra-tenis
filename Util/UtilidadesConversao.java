
public class UtilidadesConversao {

	static boolean transformaString(String valor) {
		if(valor.equalsIgnoreCase("sim"))
			return true;
		else
			return false;
	}
	
	static String transformaBoolean(boolean valor) {
		if(valor)
			return "Sim";
		else
			return "Não";
	}
}
