package week2.day2;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static String[][] readData(String filename) throws InvalidFormatException, IOException {
		// To Open workbook
		XSSFWorkbook workbook = new XSSFWorkbook(new File("src\\main\\resources\\Leads\\"+filename+".xlsx"));
		
		// Choose the sheet from the workbook by using index or sheetName
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum(); // The count starts from 0
		System.out.println("Total no of rows are "+rowCount);
		
		short columnCount = sheet.getRow(0).getLastCellNum(); // The count starts from 1
		System.out.println("Total number of columns are "+columnCount);
		
		String[][] data = new String[rowCount][columnCount];
		
		for(int i=1; i<=rowCount; i++) {
			for(int j=0; j<columnCount; j++) {
				String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(stringCellValue);
				data[i-1][j] = stringCellValue;
			}
		}
		
		workbook.close();
		return data;
	}

}
