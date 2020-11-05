package ePDS.SingleCards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ePDS.PageObjects.WSHomePage;

public class WSLogin {

	@Test
	public void WsLogin() throws InterruptedException {
		// Initailizing Browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mithi\\eclipse-workspace\\SingleCards\\Resourses\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Getting URL
		driver.get("https://gramawardsachivalayam.ap.gov.in/GSWS/#!/Login");
		Thread.sleep(7000);
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window ID is " + parentWindow);
		WSHomePage wp = new WSHomePage(driver);
		WebDriverWait explicitWait = new WebDriverWait(driver, 100);
		explicitWait.until(ExpectedConditions.visibilityOf(wp.userName()));
		wp.userName().sendKeys("21008011-WRS");
		wp.passWord().sendKeys("Revenue@105");
		Scanner sc = new Scanner(System.in);
		String captha;
		System.out.println("Enter Captha: ");
		captha = sc.nextLine();
		wp.captha().sendKeys(captha);
		wp.logIn().click();
		Thread.sleep(6000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOf(wp.notification()));
			wp.notification().click();
		} catch (Exception e) {
			System.out.println("Notification did not appear");
		}
		wp.civilSupplies().click();
		wp.applicationStatus().click();
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windows.size());
		//driver.switchTo().window(windows.get(1));
		// driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"\t");
		//WebDriverWait searchWait = new WebDriverWait(driver, 5);
		//searchWait.until(ExpectedConditions.visibilityOf(wp.search()));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		wp.search().click();
		wp.search().clear();
		System.out.println("Enter T Series Number : ");
		String tSeries = sc.nextLine();
		wp.search().sendKeys(tSeries);
		wp.tSubmit().click();

	}
}
