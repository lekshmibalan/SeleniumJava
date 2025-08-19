package SeleniumJava;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
//Excel File --Workbook ---Sheets -- Rows----Cells
public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream file= new FileInputStream("/home/lekshmi/git/SeleniumJava/SeleniumWebdriver1/testdata/AutomationSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("AutomationSheet");
		int totalRows=sheet.getLastRowNum();
		int totalCells=sheet.getRow(1).getLastCellNum();
		
		System.out.println("number of rows:"+ totalRows);
		System.out.println("number of cells:"+ totalCells);
		

	}

}
