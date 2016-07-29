package com.cee.wsr.spreadsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.cee.wsr.domain.Project;
import com.cee.wsr.domain.Task;
import com.cee.wsr.utils.DevNameUtil;
@Component
public class JiraTasksXlsxParser {
	private static final int START_ROW = 4;
	private static final int PROJECT_COL = 0;
	private static final int DEV_COL = 37;//41;
	private static final int EPIC_COL = 39;//49;
	private static final int STATUS_COL = 4;
	private static final int SUMMARY_COL = 2;

	public List<Task> parseXlsx(String xlsPath) {
		List<Task> tasks = new ArrayList<Task>();
		try {
			FileInputStream file = new FileInputStream(new File(xlsPath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {				
				if (row.getRowNum() >= START_ROW) {
					tasks.add(process(row));
				}
			}
			workbook.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return tasks;
	}

	private Task process(Row row) {
		String projectName = PoiXlsxUtil.getStrippedCellValue(row.getCell(PROJECT_COL));
		String projectAbbr = Project.getProjectAbbr(projectName);
		
		String epic = PoiXlsxUtil.getStrippedCellValue(row.getCell(EPIC_COL));
		if (StringUtils.isEmpty(epic)) {
			epic = "Uncategorized";
		}
		if (StringUtils.isNotBlank(projectAbbr)) {
			epic += " (" + Project.getProjectAbbr(projectName) + ")";
		}
		
		String summary = PoiXlsxUtil.getStrippedCellValue(row.getCell(SUMMARY_COL));		
		String status = PoiXlsxUtil.getStrippedCellValue(row.getCell(STATUS_COL));
		
		String[] developers = StringUtils.split(PoiXlsxUtil.getStrippedCellValue(row.getCell(DEV_COL)), ",");
		Set<String> devSet = new HashSet<String>();
		for (int i = 0; i < developers.length; i++) {
			devSet.add(DevNameUtil.getFullName(developers[i]));
		}
		return new Task(projectName, epic, summary, status, devSet);
	}
}
