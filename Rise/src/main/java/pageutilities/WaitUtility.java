package pageutilities;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WaitUtility {
	WebDriver driver;

	//wait for element to be clicked
		public void WaitForElementToBeClicked(WebDriver driver, WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}

	//wait for element to be not empty
		public void waitForFieldToBeNotEmpty(WebDriver driver, WebElement element, String attribute) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
		}

		// wait for element to be clickable with locator
		public void waitForElementToBeClickable(WebDriver driver, String locator) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		}

	public void waitForElementToBeLocated(WebDriver driver,String locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	}
