package com.testng;

import org.testng.annotations.Test;

import com.project.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TNG_001 extends BaseTest
{
  
  @BeforeMethod(groups = {"regression","sanity"})
  @Parameters("browser")
  public void startProcess(String bType) throws Exception 
  {
	  System.out.println("beforeMethod");
	    init();
		test=report.startTest("TC_003");
		test.log(LogStatus.INFO, "Initializing properties files.....");
		
		openBrowser(bType);
		test.log(LogStatus.INFO, "Opened the Browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " +  subprop.getProperty("amazonurl"));
  }
  
  @Test(groups = {"regression","sanity"})
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

  @AfterMethod(groups = {"regression","sanity"})
  public void endProcess() 
  {
	  System.out.println("afterMethod");
	  
	  report.endTest(test);
	  report.flush();
	  
	  driver.quit();
	  
  }

}
