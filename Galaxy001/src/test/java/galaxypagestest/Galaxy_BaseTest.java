package galaxypagestest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import galaxyconstants.Constant;
import galaxypageutilities.Galaxy_ScreenShotUtility;

public class Galaxy_BaseTest {
	WebDriver driver;
	public Properties properties;
	public FileInputStream fis;
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(@Optional String browser) throws Exception {
		try {
			properties = new Properties();
			fis = new FileInputStream(Constant.CONFIG_FILE);
			properties.load(fis);

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("invalid browser");
		}
		driver.get(properties.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod(ITestResult itestresult) throws IOException {
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			Galaxy_ScreenShotUtility sc = new Galaxy_ScreenShotUtility();
			sc.captureFailureScreenShot(driver, itestresult.getName());
		}
		if (driver != null) {
			//driver.quit();
		}
	}
}
