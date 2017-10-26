/**
* Copyright (C) 2017 - Todos los derechos reservados.
* Universidad Tecnologica Equinoccial (UTE)
*/
package ec.edu.ute.pdf.union.PdfUnion;

import java.io.ByteArrayOutputStream;

/**
 * Fecha de creacion: 25 oct. 2017
 *
 * @author miguel.amores
 *
 */
public interface PdfUnionService {
	ByteArrayOutputStream unirPdf(String cedula);
}
