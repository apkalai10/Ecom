package com.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
	
	public static WebDriver driver;
	
	
	public static WebDriver startBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("CHROME")) 
		{
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("EXPLORER")) 
		{
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("Given driver is not available in source");
		}
		return driver;
	}

}
