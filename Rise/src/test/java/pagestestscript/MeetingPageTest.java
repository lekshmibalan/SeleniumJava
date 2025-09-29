package pagestestscript;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MeetingPage;
import pages.ModuleListPage;
import pageutilities.ExcelUtility;
public class MeetingPageTest extends Base {
	ModuleListPage module;
	MeetingPage meeting;

	@Test
	public void verifyThatTheUserIsAbleToCreateMeeting() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(6, 0, "login_page");
		String pass = ExcelUtility.readStringData(6, 1, "login_page");
		int fromTime = ExcelUtility.readIntegerData(15, 0, "Time");
		int toTime = ExcelUtility.readIntegerData(24, 1, "Time");
		String meetingName = ExcelUtility.readStringData(1, 0, "name&venue");
		String meetingVenue = ExcelUtility.readStringData(1, 1, "name&venue");
		login.loginAsSeepzUser(userName, pass);
		module = login.clickOnLoginButton();
		module.clickOnModuleListLink();
		meeting = module.clickOnUAC_Module();
		meeting.clickOnMeetingTab().clickOnInitiateMeetingButton().enterTilteOfTheMeeting(meetingName)
				.selectDateOfTheMeeting("23").selectFromTimeOfMeeting(fromTime).selectToTimeForTheMeeting(toTime)
				.enterTheVenueForTheMeeting(meetingVenue).clickOnScheduleButton();

	}

	@Test
	public void verifyThatTheUserIsAbleToInitiateMeetingWithOutDate() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(6, 0, "login_page");
		String pass = ExcelUtility.readStringData(6, 1, "login_page");
		int fromTime = ExcelUtility.readIntegerData(15, 0, "Time");
		int toTime = ExcelUtility.readIntegerData(24, 1, "Time");
		String meetingName = ExcelUtility.readStringData(1, 0, "name&venue");
		String meetingVenue = ExcelUtility.readStringData(1, 1, "name&venue");
		login.loginAsSeepzUser(userName, pass);
		module = login.clickOnLoginButton();
		module.clickOnModuleListLink();
		meeting = module.clickOnUAC_Module();
		meeting.clickOnMeetingTab().clickOnInitiateMeetingButton().enterTilteOfTheMeeting(meetingName)
				.selectFromTimeOfMeeting(fromTime).selectToTimeForTheMeeting(toTime)
				.enterTheVenueForTheMeeting(meetingVenue).clickOnScheduleButton();
		boolean actual = meeting.isNoDateAlertIsDisplayed();
		Assert.assertTrue(actual, "alert is not displayed if date is not added");
		String alert=meeting.getalertMessage();
        System.out.println(alert);
	}
	@Test
	public void verifyThatTheUserIsAbleToInitiateMeetingWithOutFromTime() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(6, 0, "login_page");
		String pass = ExcelUtility.readStringData(6, 1, "login_page");
		//int fromTime = ExcelUtility.readIntegerData(15, 0, "Time");
		int toTime = ExcelUtility.readIntegerData(24, 1, "Time");
		String meetingName = ExcelUtility.readStringData(1, 0, "name&venue");
		String meetingVenue = ExcelUtility.readStringData(1, 1, "name&venue");
		login.loginAsSeepzUser(userName, pass);
		module = login.clickOnLoginButton();
		module.clickOnModuleListLink();
		meeting = module.clickOnUAC_Module();
		meeting.clickOnMeetingTab().clickOnInitiateMeetingButton().enterTilteOfTheMeeting(meetingName)
				.selectDateOfTheMeeting("23").selectToTimeForTheMeeting(toTime)
				.enterTheVenueForTheMeeting(meetingVenue).clickOnScheduleButton();
         boolean actual=meeting.isNoFromTimeAlertDisplayed();
         Assert.assertTrue(actual, "alert is not displayed if from time is not displayed");
         String alert=meeting.getalertMessage();
         System.out.println(alert);
	}
	@Test
	public void verifyThatTheUserIsAbleToInitiateMeetingWithOutToTime() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(6, 0, "login_page");
		String pass = ExcelUtility.readStringData(6, 1, "login_page");
		int fromTime = ExcelUtility.readIntegerData(15, 0, "Time");
		//int toTime = ExcelUtility.readIntegerData(24, 1, "Time");
		String meetingName = ExcelUtility.readStringData(1, 0, "name&venue");
		String meetingVenue = ExcelUtility.readStringData(1, 1, "name&venue");
		login.loginAsSeepzUser(userName, pass);
		module = login.clickOnLoginButton();
		module.clickOnModuleListLink();
		meeting = module.clickOnUAC_Module();
		meeting.clickOnMeetingTab().clickOnInitiateMeetingButton().enterTilteOfTheMeeting(meetingName)
				.selectDateOfTheMeeting("23").selectFromTimeOfMeeting(fromTime)
				.enterTheVenueForTheMeeting(meetingVenue).clickOnScheduleButton();
		boolean actual=meeting.isNoToTimeAlertDisplayed();
		Assert.assertTrue(actual, "no alert message is displayed");
		String alert=meeting.getalertMessage();
		
        System.out.println(alert);
	}
	@Test
	public void verifyThatTheUserIsAbleToInitiateMeetingWithoutVenue() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = ExcelUtility.readStringData(6, 0, "login_page");
		String pass = ExcelUtility.readStringData(6, 1, "login_page");
		int fromTime = ExcelUtility.readIntegerData(15, 0, "Time");
	    int toTime = ExcelUtility.readIntegerData(24, 1, "Time");
		String meetingName = ExcelUtility.readStringData(1, 0, "name&venue");
		//String meetingVenue = ExcelUtility.readStringData(1, 1, "name&venue");
		login.loginAsSeepzUser(userName, pass);
		module = login.clickOnLoginButton();
		module.clickOnModuleListLink();
		meeting = module.clickOnUAC_Module();
		meeting.clickOnMeetingTab().clickOnInitiateMeetingButton().enterTilteOfTheMeeting(meetingName)
				.selectDateOfTheMeeting("23").selectFromTimeOfMeeting(fromTime)
				.selectToTimeForTheMeeting(toTime).clickOnScheduleButton();
		boolean actual=meeting.isNoVenueAlertIsDisplayed();
		Assert.assertTrue(actual, "no alert is displayed");
		String alert=meeting.getalertMessage();
        System.out.println(alert);
	}
}