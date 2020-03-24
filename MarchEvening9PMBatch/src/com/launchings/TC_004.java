package com.launchings;

public class TC_004 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		openBrowser("chromebrowser");
		
		navigateUrl("amazonurl");
		
		selectOption("amazondropbox_id","amazondropitem");
		
		type("amazonsearchtext_id","amazonsearchtext");
		
		clickElement("amazonsearchbutton_xpath");
		
	
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();

	}

	

}
