/**
* Copyright (C) 2017 - Todos los derechos reservados.
* Universidad Tecnologica Equinoccial (UTE)
*/
package ec.edu.ute.pdf.union.PdfUnion.Rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Fecha de creacion: 27 oct. 2017
 *
 * @author miguel.amores
 *
 */
@Controller
public class IndexController {
	public IndexController() {
	}

	@RequestMapping(value = "/")
	public String index() {
		return "index.html";
	}
}
