package Katalon.demoSite;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceltation {


	private static XSSFWorkbook ExcelWBook;
	
	private static XSSFSheet ExcelWSheet;
	
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public void setExcelFile(String Path, int sheetIndex) {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheetAt(sheetIndex);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	/////////////////////
	public XSSFSheet getExcelWSheet() {
		return ExcelWSheet;
	}
	/////////////////////
	public String getCellData(int RowNum, int ColNum) {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			e.printStackTrace();
			return "";

		}

	}
	////////////////////
	public void setCellData(String Result, int RowNum, int ColNum) {

		try {

			Row = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
