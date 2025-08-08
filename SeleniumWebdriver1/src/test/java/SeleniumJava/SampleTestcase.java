package SeleniumJava;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

/* Test case
 ---------------
 1. Launch browser(Chrome)
 2. Open URL https://www.saucedemo.com/
 3. Validate title should be "Swag Labs"
 4. Close browser
 */

public class SampleTestcase {
	public static void main(String[] args) {
		
		//1. Launch browser(Chrome)
		//ChromeDriver driver=new ChromeDriver();
			
			WebDriver driver=new ChromeDriver();
		
		//2. Open URL https://demo.opencart.com/
			
			driver.get("https://www.saucedemo.com/");
			
		//  3. Validate title should be "Your Store"
			
			String act_title=driver.getTitle();
			if(act_title.equals("Swag Labs"))
			{
				System.out.println("Test passed");
			}
			else
			{
				System.out.println("Test failed");
			}	
			 //4. Close browser
			//driver.close();
		}
	
	
	
	
	
	
}
