package com.launchings;

import com.relevantcodes.extentreports.LogStatus;

public class TC_005 extends BaseTest
{
	
	

	public static void main(String[] args) throws Exception 
	{
		
		
		init();
		test=report.startTest("TC_005");
		test.log(LogStatus.INFO, "Initializing properties files.....");
		
		openBrowser("chromebrowser");
		test.log(LogStatus.INFO, "Opened the Browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " +  subprop.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","amazondropitem");
		test.log(LogStatus.PASS, "Selected the option :- " + mainprop.getProperty("amazondropitem") + " by using locator :- " + mainprop.getProperty("amazondropbox_id"));
		
		type("amazonsearchtext_id","amazonsearchtext");
		test.log(LogStatus.INFO, "Entered the value :- " + mainprop.getProperty("amazonsearchtext") + " by using the locator :- "+ mainprop.getProperty("amazonsearchtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.INFO, "Clicked on Element by using the locator : - " + mainprop.getProperty("amazonsearchbutton_xpath"));
		
		report.endTest(test);
		report.flush();
	}

	

}
