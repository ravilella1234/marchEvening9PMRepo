package com.launchings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\latest Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\DELL\\Desktop\\latest Drivers\\geckodriver.exe" );
		driver=new FirefoxDriver();

		//webdriver.ie.driver
		//webdriver.edge.driver
	}

}
