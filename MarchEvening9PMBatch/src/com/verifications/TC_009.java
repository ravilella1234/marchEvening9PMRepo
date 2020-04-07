package com.verifications;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.launchings.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_009 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test=report.startTest("TC_009");
		test.log(LogStatus.INFO, "Initializing properties files.....");
		
		openBrowser("chromebrowser");
		test.log(LogStatus.INFO, "Opened the Browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " +  subprop.getProperty("amazonurl"));

		String actualLink = driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML");
		String expectedLink="Customer Ser";
		
		//Assert.assertEquals(actualLink, expectedLink);
		//Assert.assertTrue(actualLink.equals(expectedLink), "Both are not equal...");
		
		SoftAssert s=new SoftAssert();
		//s.assertEquals(actualLink, expectedLink);
		s.assertTrue(actualLink.equals(expectedLink), "Both are not equal...");
		
		s.assertTrue(false, "err1");
		
		s.assertTrue(false, "err2");
		
		s.assertTrue(true, "err3");
		
		s.assertTrue(false, "err4");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sony");
		
		s.assertAll();
		
		report.endTest(test);
		report.flush();

	}

}
