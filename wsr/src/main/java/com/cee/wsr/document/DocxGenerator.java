package com.cee.wsr.document;

import java.io.File;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cee.wsr.domain.StatusReport;

public class DocxGenerator {
	private static final Logger LOG = LoggerFactory.getLogger(DocxGenerator.class);
	private static final String WrsPath = System.getProperty("user.dir") + "/JIRA.docx";

	public void generateDocument(StatusReport statusReport) {
		try {
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
			MainDocumentPart mdp = wordMLPackage.getMainDocumentPart();
			// Example 1: add text in Title style
			mdp.addStyledParagraphOfText("Title", "Example 1");
			try {
				wordMLPackage.save(new File(WrsPath));
			} catch (Docx4JException d4je) {
				LOG.error("Unable to save document - " + WrsPath, d4je);
			}
		} catch (InvalidFormatException ife) {
			LOG.error("Unable to create document.", ife);
		}
	}

}
