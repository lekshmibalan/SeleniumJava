package galaxypageutilities;
import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Galaxy_PageUtility {
	WebDriver driver;

	public Galaxy_PageUtility() {

	}

	public Galaxy_PageUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void selectFromDropDown_ByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}


	public void selectFromDropDown_ByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectFromDropDown_ByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
//utility to pick the date in meeting tab
	public void selectDateOfMeeting(WebDriver driver,String day) {
		WebElement date=driver.findElement(By.xpath("//td[@class='day' and normalize-space(text())='" + day + "']"));
		date.click();
	}
//java script utilities
	// Scroll into view
	public void scrollIntoView(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Click using JavaScript
	public void clickElementByJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// Set value into input
	public void setInputValue(WebElement element, String value) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='" + value + "';", element);
	}

	// Highlight an element
	public void highlightElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	/** Scroll down by pixels */
	public void scrollDownByPixels(int pixels) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0," + pixels + ")");
	}

	/** Scroll up by pixels */
	public void scrollUpByPixels(int pixels) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,-" + pixels + ")");
	}
}
