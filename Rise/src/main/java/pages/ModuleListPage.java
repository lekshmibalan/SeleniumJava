package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageutilities.WaitUtility;
public class ModuleListPage {
	WebDriver driver;
	WaitUtility utility;

	public ModuleListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new WaitUtility();
	}

	// Web elements for UAC module from seepz user
	
	@FindBy(xpath = "//span[normalize-space(text())='Module List']")
	WebElement moduleList;
	@FindBy(xpath = "//a[@href='/seepz/goToModule/UAC']")
	WebElement UAC_Module;
	@FindBy(id = "meetingtab")
	WebElement meetingTab;

    //Web elements for unit management module from unit user
	
	@FindBy(xpath = "//a[@href='/seepz/goToModule/UM']")
	WebElement unitManagement;
	@FindBy(xpath = "//a[@href='/unitmanagement/services/gotoUnitServices']")
	WebElement link;
	
   // methods to click on UAC module from seepz user 
	
	public ModuleListPage clickOnModuleListLink() {
		moduleList.click();
		return this;
	}

	public MeetingPage clickOnUAC_Module() {
		UAC_Module.click();
		return new MeetingPage(driver);
	}
	
    // method to click on unit management module from unit user
	
	public ServicesPage clickUnitManagementModule() {
		utility.waitForElementToBeClickable(driver, "//a[@href='/seepz/goToModule/UM']");
		unitManagement.click();
		return new ServicesPage(driver);
	}
  //  methods to check assertion
	
	public boolean isServicesTabDisplayed() {
		return link.isDisplayed();
	}
	public boolean isMeetingTabDisplayed() {
		return meetingTab.isDisplayed();
	}
}