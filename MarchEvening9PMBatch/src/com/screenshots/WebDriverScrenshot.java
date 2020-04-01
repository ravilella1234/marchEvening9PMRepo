package com.screenshots;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class WebDriverScrenshot 
{

	public static void main(String[] args) throws Exception 
	{
		
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.bestbuy.com");
		driver.manage().window().maximize();
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File("C:\\Users\\DELL\\Desktop\\bestbuy.png"));
		
		
	}

}
