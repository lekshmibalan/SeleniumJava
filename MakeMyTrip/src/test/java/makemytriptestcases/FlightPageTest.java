package makemytriptestcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.annotations.Test;

import makemytripbase.BaseTest;
import makemytrippages.HomePage;

public class FlightPageTest extends BaseTest {
	
	@Test
	public void searchFlight() {
		HomePage home = new HomePage();
		home.selectFlightMenu();
		test.log(Status.INFO, "Clicked on Flight Menu");
		home.selectRoundTrip();
		test.log(Status.INFO, "Clicked on Round Trip Menu");
		home.enterDepatureCity();
		test.log(Status.INFO, "Entered Departure City");
		home.enterReturnCity();
		test.log(Status.INFO, "Entered Return City");
		home.enterDepatureDate();
		test.log(Status.INFO, "Entered Departure Date");
		home.enterReturnDate();
		test.log(Status.INFO, "Entered Return Date");
		home.searchButton();
		test.log(Status.INFO, "Clicked on Search Button");
		
		
	}

}
