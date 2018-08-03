package com.helperclasses.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.helperclasses.filepath.ResourceHelper;
import com.helperclasses.logHelper.LoggerHelper;

public class ExcelHelper {
	private Logger log = LoggerHelper.getLogger(ExcelHelper.class);

	public Object[][] getExcelData(String excelLocation, String sheetName) {
		try {
			Object dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(ResourceHelper.getResourcePath(excelLocation)));
			// Create workbook instance
			XSSFWorkbook workBook = new XSSFWorkbook(file);
			// Get the sheet name from workbook
			XSSFSheet sheet = workBook.getSheet(sheetName);
			// To Count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum() + 1;
			// To Count number of active column in excel sheet
			int totalCloumn = sheet.getRow(0).getLastCellNum();
			System.out.println(totalRow + " and " + totalCloumn);
			dataSets = new Object[totalRow][totalCloumn];

			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				i++;
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {
					j++;
					Cell cell = cellIterator.next();
					switch (cell.getCellTypeEnum()) {

					case STRING:
						dataSets[i - 1][j - 1] = cell.getStringCellValue();
						break;
					case NUMERIC:
						dataSets[i - 1][j - 1] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataSets[i - 1][j - 1] = cell.getBooleanCellValue();
						break;
					case FORMULA:
						dataSets[i - 1][j - 1] = cell.getCellFormula();
						break;
					default:
						log.info("No Matching Data types Found");
						break;
					}

				}
			}

			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	public void updateResult(String excelLocation, String sheetName, String testCaseName, String result) {
		try {
			FileInputStream file = new FileInputStream(new File(ResourceHelper.getResourcePath(excelLocation)));
			// Create workbook instance
			XSSFWorkbook workBook = new XSSFWorkbook(file);
			// Get the sheet name from workbook
			XSSFSheet sheet = workBook.getSheet(sheetName);
			// To Count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum() + 1;
			for (int i = 1; i < totalRow; i++) {
				XSSFRow r = sheet.getRow(i);
				String cellValue = r.getCell(1).getStringCellValue();
				if (cellValue.contains(testCaseName)) {
					r.createCell(2).setCellValue(result);
					file.close();
					log.info("Result is Updated");
					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workBook.write(out);
					out.close();
					break;
				}
			}
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		ExcelHelper obj = new ExcelHelper();
		String excelLocation = "\\src\\main\\java\\com\\testdata\\TestData.xlsx";
		/*Object[][] data = obj.getExcelData(excelLocation, "LoginTestData");
		System.out.println(data.toString());*/
		obj.updateResult(excelLocation, "Data", "Sample1", "Pass");

	}

}
