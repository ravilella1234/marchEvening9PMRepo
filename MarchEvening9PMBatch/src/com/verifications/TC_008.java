package com.verifications;

import com.launchings.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_008 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test=report.startTest("TC_008");
		test.log(LogStatus.INFO, "Initializing properties files.....");
		
		openBrowser("chromebrowser");
		test.log(LogStatus.INFO, "Opened the Browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " +  subprop.getProperty("amazonurl"));

		String expectedLink="Customer Ser";
		
		if(!isLinkPresent(expectedLink))
			reportFailure("Both links are not equal...");
		else
			reportSuccuss("Both links are equal...");
		
		report.endTest(test);
		report.flush();
		
	}

	

	

}
