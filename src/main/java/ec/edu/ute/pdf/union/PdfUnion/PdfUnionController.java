/**
* Copyright (C) 2017 - Todos los derechos reservados.
* Universidad Tecnologica Equinoccial (UTE)
*/
package ec.edu.ute.pdf.union.PdfUnion;

import java.io.ByteArrayOutputStream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha de creacion: 25 oct. 2017
 *
 * @author miguel.amores
 *
 */
@RestController
@RequestMapping("/getpdf")
public class PdfUnionController {

	private final PdfUnionService pdfUnionService;

	public PdfUnionController(PdfUnionService pdfUnionService) {
		this.pdfUnionService = pdfUnionService;
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/pdf", value = "{cedula}")
	public ResponseEntity<?> getPdf(@PathVariable String cedula) {
		System.out.println("Generando pdf...");
		ByteArrayOutputStream baos = pdfUnionService.unirPdf(cedula);

		return ResponseEntity.ok(baos.toByteArray());
	}
}
