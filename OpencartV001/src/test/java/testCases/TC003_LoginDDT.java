package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)    //getting data from Data Provider class
	public void verify_loginDDT(String email,String password,String exp)
	{
     logger.info("Starting TC003 LoginDDT");
        try
        {
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail("username");
		lp.setPassword("password");
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		/*
		 Data is valid - Login success --test pass --Logout
		                 Login fail --test fail
		                 
		 Data is invalid - Login success --test fail  --Logout
		                   Login fail --test pass
		 */
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(true);
				macc.clickLogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
        } catch(Exception e)
        {
        	Assert.fail();
        }

	     logger.info("Finished TC003 LoginDDT");	
	}
}
