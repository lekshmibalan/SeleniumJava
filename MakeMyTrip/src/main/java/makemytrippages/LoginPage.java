package makemytrippages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import makemytripbase.BaseTest;

public class LoginPage extends BaseTest {
	
@FindBy(xpath="//span[text()='Login or']")
WebElement login;

@FindBy(xpath="//input[@placeholder='Enter Mobile Number']")
WebElement EnterMobile;

@FindBy(xpath="//span[text()='Continue']")
WebElement Continuebtn;

public LoginPage() {
	super();
	PageFactory.initElements(driver, this);
}

public void login() {
	login.click();
}
 
public void EnterMobile() {
	 EnterMobile.sendKeys("9876543210");
 }

 public void ClickContinue() {
	 Continuebtn.click();
 }
}
