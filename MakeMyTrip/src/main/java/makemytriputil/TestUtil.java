package makemytriputil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import makemytripbase.BaseTest;

public class TestUtil extends BaseTest{
  
	public static String departureDate;
	public static String returnDate;
	
	
	public static TestUtil getCurrentDateandReturnDate()
	{
		TestUtil date = new TestUtil();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1 );
		String[] dateArr = cal.getTime().toString().split(" ");
		TestUtil.departureDate = dateArr[0]+""+dateArr[1]+""+dateArr[2]+""+dateArr[5];
		cal.add(Calendar.DATE, 2);
		dateArr = cal.getTime().toString().split(" ");
		TestUtil.returnDate = dateArr[0]+""+dateArr[1]+""+dateArr[2]+""+dateArr[5];
		return date;
	}
	
	public static By customXpath(String xpath,String parm) {
		String rawpath = xpath.replaceAll("%replace%", parm);
		return By.xpath(rawpath);
	}
	
	public static String getScreenshot() {
		String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination =System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\"+currentDate+".png";
		try {
			FileHandler.copy(source, new File(destination));
		} catch (IOException e) {
			System.out.println("Failed to capture the Screenshot:"+e.getMessage());
			
		}
		return destination;
		
		
		
	}
	
	}



