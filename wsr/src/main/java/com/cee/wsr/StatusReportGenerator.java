package com.cee.wsr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cee.wsr.document.DocxGenerator;
import com.cee.wsr.domain.StatusReport;
import com.cee.wsr.service.StatusReportService;

@Component
public class StatusReportGenerator {
	@Autowired
	StatusReportService srService;
	@Autowired
	DocxGenerator docxGenerator;
	
	public void generate() {
		StatusReport statusReport = srService.getStatusReport();
		docxGenerator.generateDocument(statusReport);
	}
}
