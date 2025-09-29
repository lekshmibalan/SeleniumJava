package pagestestscript;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pageutilities.ExcelUtility;

public class LoginPageTest extends Base {
	ExcelUtility utility = new ExcelUtility();

	@Test
	public void verifyThatTheUserIsAbleToLoginAsSeepzUser() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = utility.readStringData(1, 0, "login_page");
		String pass = utility.readStringData(1, 1, "login_page");
		login.loginAsSeepzUser(userName, pass).clickOnLoginButton();
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = "RISe Log In Successful";
		Assert.assertEquals(actual, expected, Constants.ERROR_MESSAGE_UNABLE_TO_LOGIN_WITH_VALID_CREDENTIALS);
	}

	@Test
	public void verifyThatTheUserIsAbleToLoginAsSeepzUserWithInvalidCredentials() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = utility.readStringData(2, 0, "login_page");
		String pass = utility.readStringData(2, 1, "login_page");
		login.loginAsSeepzUser(userName, pass).clickOnLoginButton();
		boolean actual = login.isAlertIsDisplayed();
		Assert.assertTrue(actual, Constants.ERROR_MESSAGE_FOR_LOGIN_WITH_INVALID_CREDENTIAL);
	}

	@Test
	public void verifyThatTheUserIsAbleToLoginWithInvalidUsenameAndValidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = utility.readStringData(3, 0, "login_page");
		String pass = utility.readStringData(3, 1, "login_page");
		login.loginAsSeepzUser(userName, pass).clickOnLoginButton();
		boolean actual = login.isAlertIsDisplayed();
		Assert.assertTrue(actual, Constants.ERROR_MESSAGE_FOR_LOGIN_WITH_INVALID_CREDENTIAL);
	}

	@Test
	public void verifyThatTheUserIsAbleToLoginWithValidUserNameAndInvalidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = utility.readStringData(4, 0, "login_page");
		String pass = utility.readStringData(4, 1, "login_page");
		login.loginAsSeepzUser(userName, pass).clickOnLoginButton();
		boolean actual = login.isAlertIsDisplayed();
		Assert.assertTrue(actual, Constants.ERROR_MESSAGE_FOR_LOGIN_WITH_INVALID_CREDENTIAL);
	}

	// check login of public user
	@Test
	public void verifyThatUserIsAbleToLoginAsPublicUserWithValidCredentials() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = utility.readStringData(2, 0, "login_page");
		String pass = utility.readStringData(2, 1, "login_page");
		login.clickOnPublicUser().loginAsPublicUser(userName, pass).clickOnLoginButton();
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = "RISe Log In Successful";
		Assert.assertEquals(actual, expected, Constants.ERROR_MESSAGE_UNABLE_TO_LOGIN_WITH_VALID_CREDENTIALS);
	}

	@Test
	public void verifyThatUserIsAbleToLoginAsPublicUserWithInvalidCredentials() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = utility.readStringData(5, 0, "login_page");
		String pass = utility.readStringData(5, 1, "login_page");
		login.clickOnPublicUser().loginAsPublicUser(userName, pass).clickOnLoginButton();
		boolean actual = login.isAlertIsDisplayed();
		Assert.assertTrue(actual, Constants.ERROR_MESSAGE_FOR_LOGIN_WITH_INVALID_CREDENTIAL);
	}

	@Test
	public void verifyThatUserisAbleToLoginAsPublicUserWithoutChanginguserType() throws IOException {
		LoginPage login = new LoginPage(driver);
		String userName = utility.readStringData(5, 0, "login_page");
		String pass = utility.readStringData(5, 1, "login_page");
		login.loginAsPublicUser(userName, pass).clickOnLoginButton();
		boolean actual = login.isAlertIsDisplayed();
		Assert.assertTrue(actual, Constants.ERROR_MESSAGE_FOR_LOGIN_WITH_INVALID_CREDENTIAL);
	}
}