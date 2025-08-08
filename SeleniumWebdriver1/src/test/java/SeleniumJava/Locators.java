package SeleniumJava;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Locators {
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		//driver.get("https://demo.opencart.com/");
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		/*name
		driver.findElement(By.name("search")).sendKeys("mac");
		
		//id
		boolean logoDisplaystatus=driver.findElement(By.id("logo")).isDisplayed();
		System.out.println(logoDisplaystatus);
		
		//Linktext & Partial Linktext
		driver.findElement(By.linkText("Tablets")).click();
		driver.findElement(By.partialLinkText("Table")).click();
		
		//Tagname
		List<WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println("total number of links:"+links.size());
		
		List<WebElement> images= driver.findElements(By.tagName("img"));
		System.out.println("total number of images:"+images.size());
		
		
		//ClassName
		List<WebElement> headerLinks= driver.findElements(By.className("list-inline-item"));
		System.out.println("total number of headers links:"+headerLinks.size()); //
		
		
	//CSS Selector  - Cascading style sheets
		
		
		/* tag id  - tag#id (tag is optional)
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
		driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-shirts");*/
		
		// tag class - tag.classname
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("T-shirts");
		
		// tag attribute  - tag[attribute="value"]
		
		//driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("T-shirts");
		
		// tag class  attribute - tag.classname[attribute="value"] */
		//driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("T-shirts");
		
		/* Relative xpath
    Syntax:
    //tagname[@attribute='value']
    //*[@attribute='value']
    
     */
		
		//driver.close();
		
		
		
	
	}
}
