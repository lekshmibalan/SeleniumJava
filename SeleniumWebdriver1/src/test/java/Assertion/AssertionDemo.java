package Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo {
@Test
void testTitle()
{
	String exp_title="Opencart";
	String act_title="Openshop";
	/*if(exp_title.equals(act_title))
	{
		System.out.println("Test Passed");
	}
	else
	{
		System.out.println("Test Failed");
	} */
	
	Assert.assertEquals(exp_title, act_title);
}
}
