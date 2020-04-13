package com.project;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TC_003 extends BaseTest
{
  
  @BeforeMethod
  public void startProcess() throws Exception 
  {
	  System.out.println("beforeMethod");
	    init();
		test=report.startTest("TC_003");
		test.log(LogStatus.INFO, "Initializing properties files.....");
		
		openBrowser("chromebrowser");
		test.log(LogStatus.INFO, "Opened the Browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " +  subprop.getProperty("amazonurl"));
  }
  
  @Test
  public void amazon() 
  {
	  System.out.println("testMethod");
	    selectOption("amazondropbox_id","amazondropitem");
		test.log(LogStatus.PASS, "Selected the option :- " + mainprop.getProperty("amazondropitem") + " by using locator :- " + mainprop.getProperty("amazondropbox_id"));
		
		type("amazonsearchtext_id","amazonsearchtext");
		test.log(LogStatus.INFO, "Entered the value :- " + mainprop.getProperty("amazonsearchtext") + " by using the locator :- "+ mainprop.getProperty("amazonsearchtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.INFO, "Clicked on Element by using the locator : - " + mainprop.getProperty("amazonsearchbutton_xpath"));
  }

  @AfterMethod
  public void endProcess() 
  {
	  System.out.println("afterMethod");
	  
	  report.endTest(test);
	  report.flush();
	  
	  driver.quit();
	  
  }

}
