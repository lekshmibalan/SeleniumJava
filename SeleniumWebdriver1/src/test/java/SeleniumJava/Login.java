package SeleniumJava;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Login {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://galaxy.kran.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='pw']")).sendKeys("");
		driver.findElement(By.xpath(" //input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		//driver.close();
		}
}
