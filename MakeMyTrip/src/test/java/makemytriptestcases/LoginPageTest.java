package makemytriptestcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import makemytripbase.BaseTest;
import makemytrippages.LoginPage;

public class LoginPageTest extends BaseTest{

	@Test
	public void testLoginPage() {
		
	test =extent.createTest("Login to Book Flight")	;
	LoginPage login =new LoginPage();
	
	login.login();
	test.log(Status.INFO, "Clicked on Login link");
	
	login.EnterMobile();
	test.log(Status.INFO,"Entered Mobile Number");
	
	login.ClickContinue();
	test.log(Status.INFO, "Clicked on Continue Button");
	
	
	
	
	
	
	
	}
	
	
}
