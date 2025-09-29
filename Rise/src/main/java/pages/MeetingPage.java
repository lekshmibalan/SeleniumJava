package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageutilities.PageUtility;
import pageutilities.WaitUtility;
public class MeetingPage {
	WebDriver driver;
	WaitUtility utility;
	PageUtility pageutility;

	public MeetingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new WaitUtility();
		pageutility = new PageUtility(driver);
	}

	@FindBy(id = "meetingtab")
	WebElement meetingTab;
	@FindBy(xpath = "//div[@id='addToggleText']")
	WebElement initiateMeetingButton;
	@FindBy(xpath = "//textarea[@id='title']")
	WebElement title;
	@FindBy(xpath = "//input[@id='scheduleDate']")
	WebElement dateField;
	@FindBy(xpath = "//table[@class=' table-condensed']")
	WebElement datepicker;
	@FindBy(xpath = "//select[@id='fromTime']")
	WebElement fromTime;
	@FindBy(xpath = "//select[@id='toTime']")
	WebElement toTime;
	@FindBy(xpath = "//input[@id='venue']")
	WebElement venue;
	@FindBy(xpath = "//button[@id='saveButton']")
	WebElement scheduleButton;
	@FindBy(xpath = "//div[@id='alertMain']//li[contains (text() ,'Please Enter Date')]")
	WebElement noDateAlert;
	@FindBy(xpath = "//div[@id='alertMain']//li[contains (text() ,'Please Enter From Time')]")
	WebElement noFromTimeALert;
	@FindBy(xpath = "//div[@id='alertMain']//li")
	WebElement alertMessage;
	@FindBy(xpath = "//div[@id='addbutton-arrow']")
	WebElement closeButton;

	public MeetingPage clickOnMeetingTab() {
		meetingTab.click();
		return this;
	}

	public MeetingPage clickOnInitiateMeetingButton() {
		initiateMeetingButton.click();
		return this;
	}

	public MeetingPage enterTilteOfTheMeeting(String data) {
		title.sendKeys(data);
		return this;
	}

	public MeetingPage selectDateOfTheMeeting(String day) {
		dateField.click();
		utility.waitForElementToBeLocated(driver, "//table[@class=' table-condensed']");
		pageutility.selectDateOfMeeting(driver, day);
		return this;
	}

	public MeetingPage selectFromTimeOfMeeting(int index) {
		pageutility.selectFromDropDown_ByIndex(fromTime, index);
		return this;
	}

	public MeetingPage selectToTimeForTheMeeting(int index) {
		pageutility.selectFromDropDown_ByIndex(toTime, index);
		return this;
	}

	public MeetingPage enterTheVenueForTheMeeting(String data) {
		venue.sendKeys(data);
		return this;
	}

	public MeetingPage clickOnScheduleButton() {
		scheduleButton.click();
		return this;
	}
	public AddAgenda clickOnCollapseButton() {
		closeButton.click();
		return new AddAgenda(driver);
	}

	// assertion for no date
	public boolean isNoDateAlertIsDisplayed() {

		return getalertMessage().contains("Please Enter Date");
	}

	// assertion for no from time
	public boolean isNoFromTimeAlertDisplayed() {
		return getalertMessage().contains("Please Enter From Time");
	}

	public String getalertMessage() {
		String alert = alertMessage.getText();
		return alert;
	}

	// assertion for no to time
	public boolean isNoToTimeAlertDisplayed() {
		return getalertMessage().contains("Please Enter To");
	}

	// assertion for no venue
	public boolean isNoVenueAlertIsDisplayed() {
		return getalertMessage().contains("Please Enter Venue");
	}
}