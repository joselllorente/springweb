package com.curso;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
 
    /**
     * Muestra la pagina de inicio.
     *
     * @param model Objeto de Spring para la carga de atributos.
     * @param request Objeto que contiene todas las propiedades de la llamada.
     * @return String Nombre de la vista.
     */
    @RequestMapping({"/", "/index"})
    public String showHomePage(Model model, HttpServletRequest request) {
 
		// Model y HttpServletRequest son inyectados por Spring IoC en cada
		// llamada, en Model agregaremos la informaci�n necesaria para
		// renderizar la vista, mientras que HttpServletRequest nos aporta toda
		// la informaci�n relativa a la llamada, en este caso no lo utilizamos
		// para nada y podr�amos prescindir de el.
        model.addAttribute("author", "Jose Luis Llorente");
 
		// Retornamos un String con el nombre de la vista encargada de
		// renderizar la respuesta al cliente, en este caso ser� resuelta por
		// nuestro InternalResourceViewResolver.
        return "home";
    }
}