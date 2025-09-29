
package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasePage {

    public static Properties config;
    public static WebDriver driver;

    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentTest childTest;

    // Load Config.properties
    public void readPropertyFile() throws IOException {
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "src/test/resources/config.properties");
        config = new Properties();
        config.load(fis);
    }

    // Initialize WebDriver
    public void driverInitialization() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(Integer.parseInt(config.getProperty("pageloadtimeout"))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(config.getProperty("URL"));
    }

    // Initialize Extent Reports
    public void extentReportSetup() {
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setReportName("Automation Test Report");
        htmlReporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Project", "Galaxy001");
        extent.setSystemInfo("Tester", "Lekshmi");
    }
}


	
		
		
		
		
		
		


   



