package makemytriptestcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import makemytripbase.BaseTest;
import makemytrippages.HomePage;

public class FlightPageTest extends BaseTest {
	
	@Test
	public void searchFlight() {
		HomePage home = new HomePage();
		home.selectFlightMenu();
		
		home.selectRoundTrip();
		
		home.enterDepatureCity();
		
		home.enterReturnCity();
		
		home.enterDepatureDate();
		
		home.enterReturnDate();
		
		home.searchButton();
		
		
	}

}
