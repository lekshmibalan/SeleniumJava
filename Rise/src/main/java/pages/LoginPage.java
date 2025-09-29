package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageutilities.WaitUtility;
public class LoginPage 
{
	WebDriver driver;
	WaitUtility utility;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new WaitUtility();
	}

	@FindBy(xpath = "//label[text()='Public User']")
	WebElement publicUser;
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//input[@id='captcha-customField']")
	WebElement captcha;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	@FindBy(id = "loginErrorsPanel")
	WebElement invalidCredentialAlert;

	public LoginPage loginAsSeepzUser(String username, String pass) {
		userName.sendKeys(username);
		password.sendKeys(pass);
		return this;
	}

	public LoginPage clickOnPublicUser() {
		publicUser.click();
		return this;
	}

	public LoginPage loginAsPublicUser(String username, String pass) {

		userName.sendKeys(username);
		password.sendKeys(pass);
		return this;
	}

	public ModuleListPage clickOnLoginButton() {
		captcha.sendKeys("57");
		utility.waitForFieldToBeNotEmpty(driver, captcha, "value");
		
		loginButton.click();
		return new ModuleListPage(driver);
	}

	public boolean isAlertIsDisplayed() {

		return invalidCredentialAlert.isDisplayed();
	}
}