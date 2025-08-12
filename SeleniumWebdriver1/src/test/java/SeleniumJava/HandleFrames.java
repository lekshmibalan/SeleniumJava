package SeleniumJava;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HandleFrames {


			public static void main(String[] args) {
				WebDriver driver=new ChromeDriver(); 

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit
				WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
				driver.get("https://ui.vision/demo/webtest/frames/");
		        driver.manage().window().maximize();
		        WebElement frame1=driver.findElement(By.xpath("frame[src='frame_1.html']"));
		        driver.switchTo().frame(frame1);  //Passed frame as a webelement //switch to frame
		        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome");
		        
		        
		        
	}

}
