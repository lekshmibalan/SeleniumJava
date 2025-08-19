package testcase;

import org.testng.annotations.Test;

/*
 1. Open App
 2. Login
 3. Logout
 */
public class TestCase1 {
    @Test(priority=1)
	void openapp()
	{
		System.out.println("opening application...");
	}
    @Test(priority=2)
	void login()
	{
		System.out.println("login to application...");
	}
    @Test(priority=3)
	void logout()
	{
		System.out.println("logout to application...");
	}
}
