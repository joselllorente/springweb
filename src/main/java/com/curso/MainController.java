package com.curso;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	/**
	 * Muestra la pagina de inicio.
	 *
	 * @param model   Objeto de Spring para la carga de atributos.
	 * @param request Objeto que contiene todas las propiedades de la llamada.
	 * @return String Nombre de la vista.
	 */
	@RequestMapping({ "/", "/index" })
	public String showHomePage(Model model, HttpServletRequest request, HttpServletResponse resp) {

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

	@RequestMapping({ "/index2", "/index3", "/index4", "/index5" })
	public String showHomePage(Model model, HttpServletRequest request) {
		model.addAttribute("author", "Maripaz");
		return "home";
	}

	// Para pasar parametros y recogerlos (request, response y sesion)
	@RequestMapping("/get2") // Responde a una peticion get
	public ModelAndView printHelloGet(ModelMap model, HttpServletRequest req, HttpServletResponse resp,
			HttpSession ses) {
		System.out.println("Session:" + ses.getId());
		String parametro = req.getParameter("parameter");
		System.out.println("Parameter:" + parametro);
		model.addAttribute("message", "Hello Spring get Llamado 2 con parametro " + parametro);

		return new ModelAndView("Hola");// Separado de la vista, se manda el valor pero no se sabe donde se va a
										// mostrar. ME Abstraigo de la tecnologia que hay por debajo
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

}