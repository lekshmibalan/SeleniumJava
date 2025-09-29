package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LoginPage extends BasePage
{
	//Locators
@FindBy(xpath="//input[@id='un']")
WebElement Username;

@FindBy(xpath=" //input[@id='pw']")
WebElement Password;(replace with your URL)

@FindBy(xpath="//input[@value='Login']")
WebElement LoginBtn;

//Constructor
public LoginPage(WebDriver driver) {
	super();
	PageFactory.initElements(driver, this);
}
	public void Username() {
		Username.sendKeys("lakshmi@kran.co.in");
	 }
 public void Password() {
	 Password.sendKeys("pass");
 }
 public void ClickLoginBtn() {
	 LoginBtn.click();
 }	
	
	
 }

