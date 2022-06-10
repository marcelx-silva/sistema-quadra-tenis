package Utilitario;

import Enum.TipoPagamento;
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
	
	public static TipoQuadra transformaInteiroEmTipoQuadra(int id) {
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
	
	public static int transformaTipoQuadraEmInteiro(TipoQuadra tipo) {
		switch(tipo) {
			case SAIBRO:
				return 1;
			
			case SUPERFICIE_SINTETICA:
				return 2;
				
			case CIMENTO:
				return 3;
				
			case BEACH_TENNIS:
				return 4;
				
			default:
				return 0;
		}
	}
	
	public static TipoPagamento transformaInteiroEmTipoPagamento(int modo_pagamento) {
		switch(modo_pagamento) {
		
		case 1:
			return TipoPagamento.CREDITO;
			
		case 2:
			return TipoPagamento.DEBITO;
			
		case 3:
			return TipoPagamento.DINHEIRO;
			
		case 4:
			return TipoPagamento.PIX;
			
		default:
			return TipoPagamento.INVALIDO;
		}
	}
	
	public static int transformaTipoPagamentoEmInteiro(TipoPagamento tipo) {
		switch(tipo) {
		
		case CREDITO:
			return 1;
			
		case DEBITO:
			return 2;
			
		case DINHEIRO:
			return 3;
			
		case PIX:
			return 4;
			
		default:
			return 0;
		}
	}
}
