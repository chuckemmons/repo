package com.cee.wsr.properties;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cee.wsr.utils.DateUtil;

@Component
public class ApplicationProperties {

	private final String reportTitle;
	private final Date reportWeekEndingDate;
	private final String reportClassification;
	private final int sprintNumber;
	private final Date sprintStartDate;
	private final Date sprintEndDate;
	private final String preparerName;
	private final String preparerTitle;
	private final String preparerType;
	private final String xlsPath;
	private final String docxPath;

	@Autowired
	public ApplicationProperties(@Value("${report.title}") String reportTitle,
			@Value("${report.weekendingdate}") String reportWeekEndingDate,
			@Value("${report.classification}") String reportClassification,
			@Value("${sprint.number}") String sprintNumber,
			@Value("${sprint.startdate}") String sprintStartDate,
			@Value("${sprint.enddate}") String sprintEndDate,
			@Value("${preparer.name}") String preparerName,
			@Value("${preparer.title}") String preparerTitle,
			@Value("${preparer.type}") String preparerType, @Value("${xls.path}") String xlsPath,
			@Value("${docx.path}") String docxPath) {
		// Validation can go here if needed, throwing IllegalArgumentException
		// if it fails..
		this.reportTitle = reportTitle;
		this.reportWeekEndingDate = DateUtil.toDate(reportWeekEndingDate)
;		this.reportClassification = reportClassification;
		this.sprintNumber = Integer.parseInt(sprintNumber);
		this.sprintStartDate = DateUtil.toDate(sprintStartDate);
		this.sprintEndDate = DateUtil.toDate(sprintEndDate);
		this.preparerName = preparerName;
		this.preparerTitle = preparerTitle;
		this.preparerType = preparerType;
		this.xlsPath = xlsPath;
		this.docxPath = docxPath;
	}

	/**
	 * @return the reportTitle
	 */
	public String getReportTitle() {
		return reportTitle;
	}

	
	
	/**
	 * @return the reportWeekEndingDate
	 */
	public Date getReportWeekEndingDate() {
		return reportWeekEndingDate;
	}

	/**
	 * @return the reportClassification
	 */
	public String getReportClassification() {
		return reportClassification;
	}

	/**
	 * @return the sprintNumber
	 */
	public int getSprintNumber() {
		return sprintNumber;
	}

	/**
	 * @return the sprintStartDate
	 */
	public Date getSprintStartDate() {
		return sprintStartDate;
	}

	/**
	 * @return the sprintEndDate
	 */
	public Date getSprintEndDate() {
		return sprintEndDate;
	}

	/**
	 * @return the preparerName
	 */
	public String getPreparerName() {
		return preparerName;
	}

	/**
	 * @return the preparerTitle
	 */
	public String getPreparerTitle() {
		return preparerTitle;
	}

	/**
	 * @return the preparerType
	 */
	public String getPreparerType() {
		return preparerType;
	}

	/**
	 * @return the xlsPath
	 */
	public String getXlsPath() {
		return xlsPath;
	}

	/**
	 * @return the docxPath
	 */
	public String getDocxPath() {
		return docxPath;
	}

}
