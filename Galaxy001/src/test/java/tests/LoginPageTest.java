package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BasePage;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPageTest extends BasePage {

    WebDriver driver;
    LoginPage loginPage;
    Properties config;

    @BeforeMethod
    public void setUp() throws IOException {
        // Load config.properties
        config = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        config.load(fis);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config.getProperty("url"));

        loginPage = new LoginPage(driver);
    }

    @Test
    public void verifyLogin() {
        loginPage.login(config.getProperty("username"), config.getProperty("password"));
        // Add assertion here
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
