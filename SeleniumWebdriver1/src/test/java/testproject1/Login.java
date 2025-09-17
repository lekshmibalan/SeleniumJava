package testproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Login {

    public static WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Reusable login method
    public void doLogin(String user, String pass) {
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

        WebElement username = driver.findElement(By.id("Email"));
        WebElement password = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        username.clear();
        password.clear();
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();

        // wait for dashboard
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Dashboard')]")));
    }

    @Test
    public void loginTest() {
        doLogin("admin@yourstore.com", "admin");
        System.out.println("Login successful!");
    }

    @Test
    public void addCustomerDetailsTest() {
        doLogin("admin@yourstore.com", "admin");

        WebElement customerMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[normalize-space()='Customers']")
        ));
        customerMenu.click();

        System.out.println("Customer menu clicked!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


 