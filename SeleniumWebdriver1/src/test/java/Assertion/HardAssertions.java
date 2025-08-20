package Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {

	@Test
	void test()
	{
		//Assert.assertEquals("abc","abc");   //passed
		//Assert.assertEquals("123", 123);    //Failed
		
		//Assert.assertNotEquals(123,123);      //failed
		//Assert.assertNotEquals(123,345);      //failed
		
		//Assert.assertTrue(true);  //passed
		//Assert.assertTrue(1==1);   //Passed
		 
		//Assert.assertFalse(false);  //passed
		//Assert.assertFalse(1==1);    //failed
		
		Assert.fail();   //For failure
	}
	
	
	
}
