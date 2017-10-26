/**
* Copyright (C) 2017 - Todos los derechos reservados.
* Universidad Tecnologica Equinoccial (UTE)
*/
package ec.edu.ute.pdf.union.PdfUnion.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Fecha de creacion: 26 oct. 2017
 *
 * @author miguel.amores
 *
 */
@Entity
@Table(name = "si_documento", schema = "dbo")
public class SiDocumento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "si_doc_cod")
	private Long si_doc_cod;

	@ManyToOne
	@JoinColumn(name = "si_prs_cod")
	private SiPersona si_prs_cod;
	private String si_doc_rut;
	private String si_doc_nom_arc;

	@ManyToOne
	@JoinColumn(name = "si_tpo_doc_cod")
	private SiTpoDocumento si_tpo_doc_cod;

	public SiDocumento() {
	}

	/**
	 * @param si_doc_cod
	 * @param si_prs_cod
	 * @param si_doc_rut
	 * @param si_doc_nom_arc
	 * @param si_tpo_doc_cod
	 */
	public SiDocumento(Long si_doc_cod, SiPersona si_prs_cod, String si_doc_rut, String si_doc_nom_arc,
			SiTpoDocumento si_tpo_doc_cod) {
		super();
		this.si_doc_cod = si_doc_cod;
		this.si_prs_cod = si_prs_cod;
		this.si_doc_rut = si_doc_rut;
		this.si_doc_nom_arc = si_doc_nom_arc;
		this.si_tpo_doc_cod = si_tpo_doc_cod;
	}

	/**
	 * @return the si_doc_rut
	 */
	public String getSi_doc_rut() {
		return si_doc_rut;
	}

	/**
	 * @param si_doc_rut
	 *            the si_doc_rut to set
	 */
	public void setSi_doc_rut(String si_doc_rut) {
		this.si_doc_rut = si_doc_rut;
	}

	/**
	 * @return the si_doc_nom_arc
	 */
	public String getSi_doc_nom_arc() {
		return si_doc_nom_arc;
	}

	/**
	 * @param si_doc_nom_arc
	 *            the si_doc_nom_arc to set
	 */
	public void setSi_doc_nom_arc(String si_doc_nom_arc) {
		this.si_doc_nom_arc = si_doc_nom_arc;
	}

	/**
	 * @return the si_tpo_doc_cod
	 */
	public SiTpoDocumento getSi_tpo_doc_cod() {
		return si_tpo_doc_cod;
	}

	/**
	 * @param si_tpo_doc_cod
	 *            the si_tpo_doc_cod to set
	 */
	public void setSi_tpo_doc_cod(SiTpoDocumento si_tpo_doc_cod) {
		this.si_tpo_doc_cod = si_tpo_doc_cod;
	}

	/**
	 * @return the si_doc_cod
	 */
	public Long getSi_doc_cod() {
		return si_doc_cod;
	}

	/**
	 * @param si_doc_cod
	 *            the si_doc_cod to set
	 */
	public void setSi_doc_cod(Long si_doc_cod) {
		this.si_doc_cod = si_doc_cod;
	}

	/**
	 * @return the si_prs_cod
	 */
	public SiPersona getSi_prs_cod() {
		return si_prs_cod;
	}

	/**
	 * @param si_prs_cod
	 *            the si_prs_cod to set
	 */
	public void setSi_prs_cod(SiPersona si_prs_cod) {
		this.si_prs_cod = si_prs_cod;
	}

}
