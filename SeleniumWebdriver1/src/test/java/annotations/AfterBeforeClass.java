package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/* 
 1. Login   --@BeforeClass
 2. Search   --@Test
 3.Advanced search  --@Test
 4. Logout --@AfterClass
 */
public class AfterBeforeClass {
	@BeforeClass
	void login()
	{
		System.out.println("This is login..");
		
	}
		@Test(priority=1)
	void search()
	{
	System.out.println("This is search..");	
	}
		@Test(priority=2)
	void advancedsearch()
	{
		System.out.println("This is advanced search");
	}
		@AfterClass
	void logout()
	{
		System.out.println("This is logout..");
	}
}
