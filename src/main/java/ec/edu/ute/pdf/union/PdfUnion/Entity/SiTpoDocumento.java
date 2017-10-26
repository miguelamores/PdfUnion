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
@Table(name = "si_tpo_documento")
public class SiTpoDocumento {

	@Id
	private Long si_tpo_doc_cod;
	private String si_tpo_doc_nom;

	@OneToMany(mappedBy = "si_tpo_doc_cod")
	private List<SiDocumento> documentos;

	public SiTpoDocumento() {
	}

	/**
	 * @return the si_tpo_doc_cod
	 */
	public Long getSi_tpo_doc_cod() {
		return si_tpo_doc_cod;
	}

	/**
	 * @param si_tpo_doc_cod
	 *            the si_tpo_doc_cod to set
	 */
	public void setSi_tpo_doc_cod(Long si_tpo_doc_cod) {
		this.si_tpo_doc_cod = si_tpo_doc_cod;
	}

	/**
	 * @return the si_tpo_doc_nom
	 */
	public String getSi_tpo_doc_nom() {
		return si_tpo_doc_nom;
	}

	/**
	 * @param si_tpo_doc_nom
	 *            the si_tpo_doc_nom to set
	 */
	public void setSi_tpo_doc_nom(String si_tpo_doc_nom) {
		this.si_tpo_doc_nom = si_tpo_doc_nom;
	}

}
