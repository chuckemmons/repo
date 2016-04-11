package com.cee.wsr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cee.wsr.config.ApplicationConfig;
import com.cee.wsr.document.DocxGenerator;
import com.cee.wsr.domain.StatusReport;
import com.cee.wsr.spreadsheet.JiraTasksXlsxParser;

public class WsrCreator {

	private static final String xlsPath = "C:/Users/chuck/Desktop/JIRA.xlsx";

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		JiraTasksXlsxParser xlsxParser = ctx.getBean(JiraTasksXlsxParser.class);
		DocxGenerator docxGenerator = ctx.getBean(DocxGenerator.class);

		StatusReport statusReport = xlsxParser.parseXlsx(xlsPath);

		docxGenerator.generateDocument(statusReport);
	}

	/*
	 * private static void init() { configSpring(); }
	 * 
	 * private static void configSpring() { appContext = new
	 * ClassPathXmlApplicationContext("classpath*:spring/*-context.xml"); }
	 */

}
