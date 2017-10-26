/**
* Copyright (C) 2017 - Todos los derechos reservados.
* Universidad Tecnologica Equinoccial (UTE)
*/
package ec.edu.ute.pdf.union.PdfUnion.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Fecha de creacion: 26 oct. 2017
 *
 * @author miguel.amores
 *
 */
@Entity
@Table(name = "si_persona")
public class SiPersona {

	@Id
	private Long si_prs_cod;

	private String si_prs_ced;

	@OneToMany(mappedBy = "si_prs_cod")
	private List<SiDocumento> documentos;

	public SiPersona() {
	}

	/**
	 * @return the si_prs_cod
	 */
	public Long getSi_prs_cod() {
		return si_prs_cod;
	}

	/**
	 * @param si_prs_cod
	 *            the si_prs_cod to set
	 */
	public void setSi_prs_cod(Long si_prs_cod) {
		this.si_prs_cod = si_prs_cod;
	}

	/**
	 * @return the si_prs_ced
	 */
	public String getSi_prs_ced() {
		return si_prs_ced;
	}

	/**
	 * @param si_prs_ced
	 *            the si_prs_ced to set
	 */
	public void setSi_prs_ced(String si_prs_ced) {
		this.si_prs_ced = si_prs_ced;
	}

	/**
	 * @return the documentos
	 */
	public List<SiDocumento> getDocumentos() {
		return documentos;
	}

	/**
	 * @param documentos
	 *            the documentos to set
	 */
	public void setDocumentos(List<SiDocumento> documentos) {
		this.documentos = documentos;
	}

}
