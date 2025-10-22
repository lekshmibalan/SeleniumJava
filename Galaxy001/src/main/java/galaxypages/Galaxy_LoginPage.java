package galaxypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import galaxypageutilities.Galaxy_WaitUtility;



public class Galaxy_LoginPage {
WebDriver driver;
Galaxy_WaitUtility utility;

public Galaxy_LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	utility = new Galaxy_WaitUtility();
}

@FindBy(xpath = "//input[@id='un']")
WebElement UserName ;

@FindBy(xpath="//input[@id='pw']")
WebElement Password;

@FindBy(xpath="//input[@value='Login']")
WebElement LoginButton;

WebElement invalidCredentialAlert;

public Galaxy_LoginPage enterUserName(String username) {
	UserName.sendKeys(username);
	return this;
}
public Galaxy_LoginPage enterPassword(String password) {
	Password.sendKeys(password);
	return this;
}

public Galaxy_LoginPage clickOnLoginButton() {
	LoginButton.click();
	return this;
}
public boolean isAlertIsDisplayed() {

	return invalidCredentialAlert.isDisplayed();
}











}