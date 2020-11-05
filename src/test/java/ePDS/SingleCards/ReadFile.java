package ePDS.SingleCards;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadFile {
	public void browserSetup() throws IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	FileInputStream fis = new FileInputStream("E:\\Files\\Mahi.FAT");
	Properties prop = new Properties();
	prop.load(fis);
	
	}
	
}
