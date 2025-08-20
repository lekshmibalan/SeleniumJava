package Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertion {
//@Test
void test_hardassertion()
{
	System.out.println("Testing1...");
	System.out.println("Testing2....");
	
	Assert.assertEquals(1, 2);   //hard assertion
	
	System.out.println("Testing3...");
	System.out.println("Testing4....");
}
	@Test
	void test_softassertion()
	{
		System.out.println("Testing1...");
		System.out.println("Testing2....");
		SoftAssert sa=new SoftAssert();
		
		sa.assertEquals(1, 2);   //soft assertion
		
		System.out.println("Testing3...");
		System.out.println("Testing4....");	
		
		sa.assertAll();   //Mandatory  (Otherwise always it will pass)
	}
	
}

