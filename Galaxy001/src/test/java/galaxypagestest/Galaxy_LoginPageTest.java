package galaxypagestest;

import org.testng.Assert;
import org.testng.annotations.Test;

import galaxyconstants.Constant;

import java.io.IOException;

import org.testng.annotations.Test;

import galaxypages.Galaxy_LoginPage;
import galaxypageutilities.Galaxy_ExcelUtility;

public class Galaxy_LoginPageTest extends Galaxy_BaseTest {
	Galaxy_ExcelUtility utility = new Galaxy_ExcelUtility();

	@Test
	public void verifyThatTheUserIsAbleToLoginAsGalaxyUser() throws IOException {
		Galaxy_LoginPage login = new Galaxy_LoginPage(driver);
		String username = utility.readStringData(1, 0, "login_page");
		String password = utility.readStringData(1, 1, "login_page");
		login.enterUserName(username).enterPassword(password).clickOnLoginButton();
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = "Galaxy login successful";
		Assert.assertEquals(actual, expected, Constant.ERROR_MESSAGE_UNABLE_TO_LOGIN_WITH_VALID_CREDENTIALS);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
