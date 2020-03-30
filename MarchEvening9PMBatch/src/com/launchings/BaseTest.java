package com.launchings;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

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
		
		fis=new FileInputStream(projectpath+"//log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
	}
	
	
	public static void openBrowser(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\latest Drivers\\chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "false");
			
			ChromeOptions option=new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 6");
			
			option.addArguments("--disable-notifications");
			
			driver = new ChromeDriver(option);
		}
		else if(p.getProperty(browser).equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\DELL\\Desktop\\latest Drivers\\geckodriver.exe" );
			
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("MarchFFProfile");
			
			profile.setPreference("dom.webnotifications.enabled", false);
			
			FirefoxOptions option=new FirefoxOptions();
			option.setProfile(profile);
			
			driver=new FirefoxDriver(option);
		}
	}
	
	public static void navigateUrl(String url) 
	{
		//driver.get(subprop.getProperty(url));
		driver.navigate().to(subprop.getProperty(url));
	}
	
	
	public static void clickElement(String locatorKey) 
	{
		//driver.findElement(By.xpath(locatorKey)).click();
		getElement(locatorKey).click();
	}

	public static void type(String locatorKey, String value) 
	{
		//driver.findElement(By.name(locatorKey)).sendKeys(value);
		getElement(locatorKey).sendKeys(mainprop.getProperty(value));
	}

	public static void selectOption(String locatorKey, String item) 
	{
		//driver.findElement(By.id(locatorKey)).sendKeys(item);
		getElement(locatorKey).sendKeys(mainprop.getProperty(item));
	}


	public static WebElement getElement(String locatorKey) 
	{
		WebElement element=null;
		
		if(locatorKey.endsWith("_id")) {
			element=driver.findElement(By.id(mainprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element=driver.findElement(By.name(mainprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element=driver.findElement(By.className(mainprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element=driver.findElement(By.xpath(mainprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element=driver.findElement(By.cssSelector(mainprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element=driver.findElement(By.linkText(mainprop.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element=driver.findElement(By.partialLinkText(mainprop.getProperty(locatorKey)));
		}
		return element;
	
	}

}
