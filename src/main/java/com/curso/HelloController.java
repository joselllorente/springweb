package com.curso;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Hello")//Todas las peticiones que tengan /hello llegaran a este controlador
public class HelloController {

	@RequestMapping(value = "/test.do",method = RequestMethod.GET) 
	public String printHello(ModelMap model) {
		System.out.println("printHello");
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "Hola";
	}
	
	@RequestMapping("/get.do") //Responde a una peticion get
	public ModelAndView printHelloGet(ModelMap model) {
		model.addAttribute("message", "Hello Spring get Llamado");
		
		return new ModelAndView("Hola");//Separado de la vista, se manda el valor pero no se sabe donde se va a mostrar. ME Abstraigo de la tecnologia que hay por debajo
	}
	
	//Para pasar parametros y recogerlos (request, response y sesion)
	@RequestMapping("/get2.do") //Responde a una peticion get
	public ModelAndView printHelloGet(ModelMap model, HttpServletRequest req, HttpServletResponse resp, HttpSession ses) {
		System.out.println("Session:" +ses.getId());
		String parametro = req.getParameter("parameter");
		System.out.println("Parameter:" +parametro);
		model.addAttribute("message", "Hello Spring get Llamado 2 con parametro "+parametro);
		
		return new ModelAndView("Hola");//Separado de la vista, se manda el valor pero no se sabe donde se va a mostrar. ME Abstraigo de la tecnologia que hay por debajo
	} 

	//Recoger parametro
	@RequestMapping("/get3.do")
	public String printHelloGet(ModelMap model, @RequestParam("parameter") String param) {
		System.out.println("parametro: "+param);
		model.addAttribute("message", "Hello Spring get Llamado con parametro "+param);
		return "Hola";//Separado de la vista, se manda el valor pero no se sabe donde se va a mostrar. ME Abstraigo de la tecnologia que hay por debajo
	}


}
