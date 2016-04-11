package com.cee.wsr.spreadsheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

public class PoiXlsxUtils {

	private PoiXlsxUtils() {
	}

	public static String getCellContents(Cell cell) {
		String string = "";
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			string = cell.getRichStringCellValue().getString();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				string = String.valueOf(cell.getDateCellValue());
			} else {
				string = String.valueOf(cell.getNumericCellValue());
			}
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			string = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA:
			string = cell.getCellFormula();
			break;
		default:
			string = "";
		}

		return string;
	}
}
