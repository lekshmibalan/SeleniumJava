package SeleniumJava;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class XPathDemo {
	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver(); 
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		//Xpath with single attribute........
	//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("T-Shirts");

	//Xpath with multiple attributes.........
	//driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search'")).sendKeys("T-Shirts");
		
		//Xpath with and & or operators.......
		//driver.findElement(By.xpath("//input[@name='search']and[@placeholder='Search'")).sendKeys("T-Shirts");
		//driver.findElement(By.xpath("//input[@name='search']or[@placeholder='Search'")).sendKeys("T-Shirts");
		
		//Xpath with inner text ->text().........
		//driver.findElement(By.xpath("//a[text()='MacBook'"])).click();
		
		/*boolean displaystatus=driver.findElements(By.xpath("//h3[text()='Featured']")).isDisplayed;
		System.out.println(displaystatus);
		
		String value=driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
		System.out.println(value); 
		*/
		/*
		// Xpath with contains().........
		driver.findElement(By.xpath("//input[contains(@placeholder,'Sea')]")).sendKeys("T-Shirts");
		
		//Xpath with start-with()........
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sea')]")).sendKeys("T-Shirts");
		*/
		// Chained xpath -- combination of relative and absolute
		/*
		 // Xpath axes 
		boolean status=driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
		System.out.println(status);
		*/
		}  
}
