package com.cee.wsr.spreadsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.cee.wsr.domain.Project;
import com.cee.wsr.domain.StatusReport;
import com.cee.wsr.domain.Task;
import com.cee.wsr.utils.DevNameUtil;

public class JiraTasksXlsxParser {
	private static final int START_ROW = 4;
	private static final int PROJECT_COL = 0;
	private static final int DEV_COL = 37;//41;
	private static final int EPIC_COL = 39;//49;
	private static final int STATUS_COL = 4;
	private static final int SUMMARY_COL = 2;

	@Autowired
	StatusReport statusReport;

	public StatusReport parseXlsx(String xlsPath) {

		try {
			FileInputStream file = new FileInputStream(new File(xlsPath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				if (row.getRowNum() >= START_ROW) {
					process(row);
				}
			}
			workbook.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return statusReport;
	}

	private void process(Row row) {
		String projectName = cleanCellStringContent(row.getCell(PROJECT_COL));
		
		String epic = cleanCellStringContent(row.getCell(EPIC_COL));
		if (StringUtils.isEmpty(epic)) {
			epic = "Uncategorized";
		}
		epic += " (" + Project.getProjectAbbr(projectName) + ")";
		
		String summary = cleanCellStringContent(row.getCell(SUMMARY_COL));		
		String status = cleanCellStringContent(row.getCell(STATUS_COL));
		
		String developer = DevNameUtil.getFullName(cleanCellStringContent(row
				.getCell(DEV_COL)));

		statusReport.addTask(projectName, epic, new Task(summary, status, developer));
	}
	
	private String cleanCellStringContent(Cell cell) {
		String content = PoiXlsxUtils.getCellContents(cell);
		
		return StringUtils.stripToEmpty(content);
	}
}
