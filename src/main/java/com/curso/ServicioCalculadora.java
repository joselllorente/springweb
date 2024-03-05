package com.curso;

import org.springframework.stereotype.Component;

@Component
public class ServicioCalculadora {
	
	public int operar (int num1, int num2, String operacion) {
		int resultado=0;
		
		if (operacion.equals("suma")) {
			resultado =  num1 + num2;
		}else if (operacion.equals("resta")) {
			resultado =  num1 - num2;
		}else {
			
		}
		
		return resultado;
	}
	
}
