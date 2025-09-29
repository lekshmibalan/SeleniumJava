package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageutilities.PageUtility;
import pageutilities.WaitUtility;
public class ServicesPage {
	WebDriver driver;
	PageUtility utility;
WaitUtility utilities;
	public ServicesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new PageUtility();
		utilities=new WaitUtility();
	}

	@FindBy(xpath = "//a[@href='/unitmanagement/services/gotoUnitServices']")
	WebElement Services_Tab;
	@FindBy(id = "unitSetupListId")
	WebElement select_User;
	@FindBy(xpath = "//button[@onclick='gotoService(\"1d3ca2c9-277f-4b37-8a94-732ecd9fc3a9\")']")
	WebElement serviceName;
@FindBy(xpath="//iframe[@id='modalframe']")WebElement iframe;
@FindBy(xpath="//button[@class='btn btn-success px-4 shadow-sm bootbox-accept']")WebElement proceedButton;
	public ServicesPage moveToServicesTab() {
		Services_Tab.click();
		return this;
	}

	public ServicesPage selectUnitName(String value) {
		utility.selectFromDropDown_ByVisibleText(select_User, value);
		return this;
	}

	public void selectService() {
		serviceName.click();
		//driver.switchTo().frame(iframe);
		utilities.WaitForElementToBeClicked(driver, proceedButton);
		proceedButton.click();
	}
}
