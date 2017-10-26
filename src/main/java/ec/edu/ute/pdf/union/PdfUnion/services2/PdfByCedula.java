/**
* Copyright (C) 2017 - Todos los derechos reservados.
* Universidad Tecnologica Equinoccial (UTE)
*/
package ec.edu.ute.pdf.union.PdfUnion.services2;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ec.edu.ute.pdf.union.PdfUnion.Entity.SiDocumento;

/**
 * Fecha de creacion: 25 oct. 2017
 *
 * @author miguel.amores
 *
 */
@Component
public interface PdfByCedula extends CrudRepository<SiDocumento, Long> {

	@Query(value = "SELECT  si_doc_cod ,\r\n" + "        si_doc_srv ,\r\n" + "        si_doc_rut ,\r\n"
			+ "             REPLACE(si_doc_rut,'\\\\Svrquito09\\','\\\\Svrquito15\\')\r\n"
			+ "        si_doc_nom_arc ,\r\n" + "        si_doc_fch_agr ,\r\n" + "        si_doc_dig ,\r\n"
			+ "        si_doc_ord ,\r\n" + "        si_persona.si_prs_cod ,\r\n" + "        si_tmp_tit_cod ,\r\n"
			+ "        si_tpo_documento.si_tpo_doc_cod ,\r\n" + "        dbo.si_tpo_documento.si_tpo_doc_nom ,\r\n"
			+ "        si_tmp_pub_cod ,\r\n" + "        si_tmp_exp_cod           \r\n"
			+ "FROM    Base_central.dbo.si_documento\r\n"
			+ "        INNER JOIN Base_central.dbo.si_persona ON si_persona.si_prs_cod = si_documento.si_prs_cod\r\n"
			+ "        INNER JOIN dbo.si_tpo_documento ON si_tpo_documento.si_tpo_doc_cod = si_documento.si_tpo_doc_cod\r\n"
			+ "WHERE   si_prs_ced = ?1\r\n" + "        AND si_documento.si_tpo_doc_cod IN ( 2, 9, 37, 36 )\r\n"
			+ "ORDER BY si_tpo_doc_nom", nativeQuery = true)
	List<SiDocumento> getUrlPdf(String cedula);

}
