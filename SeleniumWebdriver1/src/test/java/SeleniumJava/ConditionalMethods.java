package SeleniumJava;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ConditionalMethods {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();

		//isDisplayed()

		//WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		//System.out.println("Display status of logo:"+logo.isDisplayed());
		//boolean status=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		//System.out.println("Display status:"+ status);

		//isEnabled()
		//boolean status=driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		//System.out.println("Enable Status:"+ status);

		//isSelected() --- checkbox,radio button,drop down

		WebElement male_rd=driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd=driver.findElement(By.xpath("//input[@id='gender-female']"));
		System.out.println("Before selection...,");
		System.out.println(male_rd.isSelected()); //false
		System.out.println(female_rd.isSelected()); //false

		System.out.println("After selecting...,");
		male_rd.click();   //select male radio button
		System.out.println(male_rd.isSelected()); //true
		System.out.println(female_rd.isSelected()); //false

		System.out.println("After selecting...,");
		female_rd.click();   //select male radio button
		System.out.println(male_rd.isSelected()); //false
		System.out.println(female_rd.isSelected()); //true

		boolean newslettersstatus=driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();
		System.out.println("News Letter Checkbox status:"+ newslettersstatus); //true
		}
}
