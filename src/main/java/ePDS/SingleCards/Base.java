package ePDS.SingleCards;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	public WebDriver initializeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mithi\\eclipse-workspace\\SingleCards\\Resourses\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
		
	}
	

}
