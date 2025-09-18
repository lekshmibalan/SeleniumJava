package makemytriptestcases;

import org.testng.annotations.AfterMethod;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import makemytripbase.BaseTest;

public class TestSetup extends BaseTest{
	
	@BeforeSuite
	public void setup() throws IOException {
		readPropertyFile();
		driverInitialization();
		setExtentReport();
		
		
		
		
		
		}
	@AfterMethod
	@AfterSuite
	public void tearDown() {
		extent.flush();
		driver.quit();
	}	

}
