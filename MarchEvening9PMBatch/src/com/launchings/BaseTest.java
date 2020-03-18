package com.launchings;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectpath=System.getProperty("user.dir");
	public static Properties p;
	public static Properties mainprop;
	public static Properties subprop;
	public static FileInputStream fis;
	
	public static void init() throws Exception
	{
		fis=new FileInputStream(projectpath+"//data.properties");
		p=new Properties();
		p.load(fis);
		
		fis=new FileInputStream(projectpath+"//environment.properties");
		mainprop=new Properties();
		mainprop.load(fis);
		String e = mainprop.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectpath+"//"+e+".properties");
		System.out.println(projectpath+"//"+e+".properties");
		subprop=new Properties();
		subprop.load(fis);
		String url = subprop.getProperty("amazonurl");
		System.out.println(url);
		
	}
	
	
	public static void openBrowser(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\latest Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(p.getProperty(browser).equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\DELL\\Desktop\\latest Drivers\\geckodriver.exe" );
			driver=new FirefoxDriver();
		}
	}
	
	public static void navigateUrl(String url) 
	{
		//driver.get(subprop.getProperty(url));
		driver.navigate().to(subprop.getProperty(url));
	}

}
