package SeleniumJava;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
public class GoogleSearchAutoSuggestions {

	public static void main(String[] args) {
		 // Set the path to your chromedriver executabl

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        // Enter search term
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");

        // Wait for suggestions to load
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        // Get suggestions
        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));

        for (WebElement suggestion : suggestions) {
            System.out.println(suggestion.getText());
        }

        driver.quit();
    


	}

}
