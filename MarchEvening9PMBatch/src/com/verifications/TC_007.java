package com.verifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.launchings.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_007 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test=report.startTest("TC_007");
		test.log(LogStatus.INFO, "Initializing properties files.....");
		
		openBrowser("chromebrowser");
		test.log(LogStatus.INFO, "Opened the Browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " +  subprop.getProperty("amazonurl"));

		WebElement loc = driver.findElement(By.id("twotabsearchtextbox"));
		
		loc.sendKeys("sony");
		String val = loc.getAttribute("value");
		System.out.println("Text is :- " + val);
		
	}

}
