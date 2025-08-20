package groupingtests;

import org.testng.annotations.Test;

public class PaymentsTests {
   @Test(priority=1,groups= {"sanity","regression","functional"})
	void paymentinRupees()
	{
		System.out.println("This is paymentinrupees");
	}
   @Test(priority=2,groups= {"sanity","regression","functional"})
	void paymentinDollars()
	{
	   System.out.println("This is paymentindollars");
	}

	
	
}
