package pagestestscript;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.AddAgenda;
import pages.LoginPage;
import pages.MeetingPage;
import pages.ModuleListPage;
import pageutilities.ExcelUtility;
public class AddAgendaTest extends Base {
	ModuleListPage modulelist;
	MeetingPage meeting;
	AddAgenda addagenda;

	@Test
	public void verifyThatTheUserIsAbleToAddAgenda() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(6, 0, "login_page");
		String pass = ExcelUtility.readStringData(6, 1, "login_page");
		login.loginAsSeepzUser(username, pass);
		modulelist = login.clickOnLoginButton();
		modulelist.clickOnModuleListLink();
		meeting = modulelist.clickOnUAC_Module();
		String meetingName = ExcelUtility.readStringData(1, 0, "name&venue");
		String venueName = ExcelUtility.readStringData(1, 1, "name&venue");
		int fromTime = ExcelUtility.readIntegerData(18, 0, "Time");
		int toTime = ExcelUtility.readIntegerData(19, 1, "Time");
		meeting.clickOnMeetingTab().clickOnInitiateMeetingButton().enterTilteOfTheMeeting(meetingName)
				.selectDateOfTheMeeting("28").selectFromTimeOfMeeting(fromTime).selectToTimeForTheMeeting(toTime)
				.enterTheVenueForTheMeeting(venueName).clickOnScheduleButton();
		String agenda = ExcelUtility.readStringData(2, 0, "Agenda_Details");
		String sezName = ExcelUtility.readStringData(2, 1, "Agenda_Details");
		int seqNo = ExcelUtility.readIntegerData(1, 4, "Agenda_Details");
		String eUnitName = ExcelUtility.readStringData(1, 2, "Agenda_Details");
		addagenda = meeting.clickOnCollapseButton();
		addagenda.clickOnCreateAgendaLink().selectAgendaFromList(agenda).selectSEZnameFromList(sezName)
				.enterSequenceNumber(seqNo).enterUnitName(sezName, eUnitName).clickOnSaveButton().acceptmodal();

	}
}