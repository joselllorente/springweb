package com.curso;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculadoraController {

	@Autowired
	ServicioCalculadora servicioCalculadora;
	
	
	@RequestMapping(value = "/operar.do",method = RequestMethod.GET) 
	public String operar(ModelMap model, HttpServletRequest request) {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String operacion = request.getParameter("operacion");
		
		//ServicioCalculadora servicioCalculadora = new ServicioCalculadora();
		
		int resultado = servicioCalculadora.operar(num1, num2, operacion);
		
		
		
		model.addAttribute("resultado", resultado);
		
		return "operacion";
	}
	
	@RequestMapping(value = "/operar2.do",method = RequestMethod.GET) 
	public String operar(ModelMap model, 
			@RequestParam("num1") int num1, 
			@RequestParam("num2") int num2,
			@RequestParam("operacion") String operacion) {
		
		int resultado = 0;
		
		if (operacion.equals("suma")) {
			resultado =  num1 + num2;
		}else if (operacion.equals("resta")) {
			resultado =  num1 - num2;
		}
		
		model.addAttribute("resultado", resultado);
		
		return "operacion";
	}
	
	@RequestMapping("/{operacion}.do") 
	public String operar(ModelMap model,
			@PathVariable("operacion") String operacion,
			@RequestParam("num1") int num1, 
			@RequestParam("num2") int num2
			) {
		
		int resultado = 0;
		
		if (operacion.equals("suma")) {
			resultado =  num1 + num2;
		}else if (operacion.equals("resta")) {
			resultado =  num1 - num2;
		}
		
		model.addAttribute("resultado", resultado);
		
		return "operacion";
	}
	
	
	
	
}
