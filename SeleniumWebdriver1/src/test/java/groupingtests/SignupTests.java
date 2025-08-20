package groupingtests;

import org.testng.annotations.Test;

public class SignupTests {
    @Test(priority=1,groups= {"regression"})
	void signupbyemail()
	{
		System.out.println("this is signupbyemail");
	}
	
    @Test(priority=2,groups= {"regression"})
	void signupbyfacebook()
	{
		System.out.println("this is signupbyfacebook");
	}
	
    @Test(priority=3,groups= {"regression"})
	void signupbytwitter()
	{
		System.out.println("this is signupbytwitter");
	}
	
}
