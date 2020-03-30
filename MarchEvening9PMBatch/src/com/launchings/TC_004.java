package com.launchings;

import org.apache.log4j.Logger;

public class TC_004 extends BaseTest
{
	
	private static final Logger log=Logger.getLogger(TC_004.class);

	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("Initializing properties files.....");
		
		openBrowser("chromebrowser");
		log.info("Opened the Browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url :- " +  subprop.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","amazondropitem");
		log.info("Selected the option :- " + mainprop.getProperty("amazondropitem") + " by using locator :- " + mainprop.getProperty("amazondropbox_id"));
		
		type("amazonsearchtext_id","amazonsearchtext");
		log.info("Entered the value :- " + mainprop.getProperty("amazonsearchtext") + " by using the locator :- "+ mainprop.getProperty("amazonsearchtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on Element by using the locator : - " + mainprop.getProperty("amazonsearchbutton_xpath"));
	
		
	}

	

}
