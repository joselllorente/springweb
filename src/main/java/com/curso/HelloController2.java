package com.curso;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Control2")//Todas las peticiones que tengan /Control2 llegaran a este controlador
public class HelloController2 {

	
//De la ruta que mandes lo que llegue antes del do me lo mandas como parametro
	@RequestMapping("/{pepito}.do")
	public String printHelloGet(ModelMap model, 
			@PathVariable("pepito") String accion, 
			@RequestParam("numero") String param) {
		
		System.out.println("printHelloGet entra");
		if (accion.toUpperCase().equals("GET")){
			model.addAttribute("message","Action get called with parameter "+param);
		}else{
			model.addAttribute("message","Action other called with parameter "+param);
		}
		return "Hola";//Separado de la vista, se manda el valor pero no se sabe donde se va a mostrar. ME Abstraigo de la tecnologia que hay por debajo
	}
	
}
