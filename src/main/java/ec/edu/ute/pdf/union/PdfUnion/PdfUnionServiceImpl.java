/**
* Copyright (C) 2017 - Todos los derechos reservados.
* Universidad Tecnologica Equinoccial (UTE)
*/
package ec.edu.ute.pdf.union.PdfUnion;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

import ec.edu.ute.pdf.union.PdfUnion.Entity.SiDocumento;
import ec.edu.ute.pdf.union.PdfUnion.services2.PdfByCedula;

/**
 * Fecha de creacion: 25 oct. 2017
 *
 * @author miguel.amores
 *
 */
@Component
public class PdfUnionServiceImpl implements PdfUnionService {
	private PdfByCedula pdfByCedula;

	public PdfUnionServiceImpl(PdfByCedula pdfByCedula) {
		this.pdfByCedula = pdfByCedula;
	}

	/**
	 * Merge multiple pdf into one pdf
	 * 
	 * @param list
	 *            of pdf input stream
	 * @param outputStream
	 *            output file output stream
	 * @throws DocumentException
	 * @throws IOException
	 */
	public ByteArrayOutputStream doMerge(List<InputStream> list, ByteArrayOutputStream outputStream)
			throws DocumentException, IOException {
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, outputStream);
		document.open();
		PdfContentByte cb = writer.getDirectContent();

		for (InputStream in : list) {
			PdfReader reader = new PdfReader(in);
			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				document.newPage();
				// import the page from source pdf
				PdfImportedPage page = writer.getImportedPage(reader, i);
				// add the page to the destination pdf
				cb.addTemplate(page, 0, 0);
			}
		}

		outputStream.flush();
		document.close();
		outputStream.close();

		return outputStream;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.edu.ute.pdf.union.PdfUnion.PdfUnionService#unirPdf()
	 */
	@Override
	public ByteArrayOutputStream unirPdf(String cedula) {
		List<InputStream> list = new ArrayList<InputStream>();
		ByteArrayOutputStream doc = null;
		List<SiDocumento> listaPDF = pdfByCedula.getUrlPdf(cedula);

		try {

			for (SiDocumento pdf : listaPDF) {
				System.out.println(pdf.getSi_doc_nom_arc());
				list.add(new FileInputStream(new File(pdf.getSi_doc_nom_arc())));
			}
			// Source pdfs
			// list.add(new FileInputStream(new File("c:/tesoreria.pdf")));
			// list.add(new FileInputStream(new File("c:/Redmine.pdf")));

			// Resulting pdf
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			doc = doMerge(list, out);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

}
