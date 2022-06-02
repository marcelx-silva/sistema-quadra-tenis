package Utilitario;

import Enum.TipoQuadra;

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
	
	public static TipoQuadra transformaInteiro(int id) {
		switch(id) {
			case 1:
				return TipoQuadra.SAIBRO;
			
			case 2:
				return TipoQuadra.SUPERFICIE_SINTETICA;
				
			case 3:
				return TipoQuadra.CIMENTO;
				
			case 4:
				return TipoQuadra.BEACH_TENNIS;
				
			default:
				return TipoQuadra.INVALIDO;
		}
	}
}
