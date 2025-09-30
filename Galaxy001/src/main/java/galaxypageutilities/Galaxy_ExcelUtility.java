package galaxypageutilities;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import galaxyconstants.Constant;
public class Galaxy_ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;

	public static String readStringData(int row, int col, String sheet) throws IOException {
		String filePath = Constant.FILE_PATH;
		f = new FileInputStream(filePath);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();

	}

	public static int readIntegerData(int row, int col, String sheet) throws IOException {
		String filePath = Constant.FILE_PATH;
		f = new FileInputStream(filePath);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		int val = (int) c.getNumericCellValue(); // convert double to int using typecasting
		//return String.valueOf(val); // convert int to string using valueOf() method
		 return val;

	}
}
