package SeleniumJava;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class GetMethods {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		//get(url) - opens the url
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		//getTitle -returs title of the page
		System.out.println(driver.getTitle());
		
		// getCurrentUrl()- returns URL of the page
		System.out.println(driver.getCurrentUrl());
		
		//getPageSource()- returns source code of the page
		//System.out.println(driver.getPageSource());
		
		//getWindowHandle()- returns ID of the single browser window
		//String Windowid=driver.getWindowHandle();
		//System.out.println("Window Id:"+Windowid);
		
		//getWindowHandles()- returns ID's of the multiple browser window
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();// this will opens new browser window
		Set<String> windowsids=driver.getWindowHandles();
	    System.out.println(windowsids);
	}
}
