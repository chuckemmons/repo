package com.cee.wsr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.cee.wsr.document.DocxGenerator;
import com.cee.wsr.spreadsheet.JiraTasksXlsxParser;

@Configuration
@ComponentScan({ "com.cee.wsr" })
@PropertySource("classpath:properties/app-config.properties")
public class ApplicationConfig {

	@Bean
	public JiraTasksXlsxParser xlsxParser() {
		JiraTasksXlsxParser xlsxParser = new JiraTasksXlsxParser();
		return xlsxParser;
	}

	@Bean
	public DocxGenerator docxGenerator() {
		DocxGenerator docxGenerator = new DocxGenerator();
		return docxGenerator;
	}

	/**
	 * Ensures that placeholders are replaced with property values
	 */
	@Bean
	static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
