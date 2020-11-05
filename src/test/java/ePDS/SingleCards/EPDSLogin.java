package ePDS.SingleCards;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ePDS.PageObjects.EpdsHomePage;

public class EPDSLogin extends Base {

	@BeforeMethod
	public void browser() throws InterruptedException {
		driver = initializeBrowser();
		driver.manage().window().maximize();
		driver.get("https://epds1.ap.gov.in/Epds_Divisions/");
		Thread.sleep(7000);
	}

	@Test
	public void loginUser() throws InterruptedException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\mithi\\eclipse-workspace\\SingleCards\\Resourses\\loginDetails.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String userName = prop.getProperty("username");
		String passWord = prop.getProperty("password");
		String secName = prop.getProperty("secname");
		Date da = new Date();
		String today = da.toString().replace(" ", "_").replace(":", "_");
		String file = (System.getProperty("user.dir")+"/Reports/"+secName+"-"+today+".txt");
		PrintWriter writer = new PrintWriter(file);

		EpdsHomePage ep = new EpdsHomePage(driver);
		ep.userName().sendKeys(userName);
		ep.passWord().sendKeys(passWord);
		ep.login().click();
		Thread.sleep(5000);
		Actions ac = new Actions(driver);
		WebElement element = ep.cardsPrinting();
		ac.moveToElement(element).perform();
		ac.click(ep.singleCard()).perform();
		Thread.sleep(7000);
		Select se = new Select(ep.secName());
		se.selectByVisibleText(secName);
		Select se1 = new Select(ep.cardType());
		se1.selectByVisibleText("UnAcknowledgement");
		ep.submit().click();
		Thread.sleep(5000);
		List<WebElement> riceCardNo = ep.riceCardNo();
		int riceCardSize = riceCardNo.size();
		int totalIssueCards = riceCardSize-1;
		List<String> riceCards = new ArrayList<String>();
		List<String> applicationId = new ArrayList<String>();
		System.out.println("Total Pending IssueCards are : "+ totalIssueCards);

		for (int i = 0; i < riceCardSize; i++) {
			String riceCard = ep.riceCardNo().get(i).getText();
			riceCards.add(riceCard);
			System.out.println(riceCard);
			writer.println(riceCard);
		}
		for (int j = 0; j < riceCardSize; j++) {

			String tSeries = ep.tSeries().get(j).getText();
			applicationId.add(tSeries);
			System.out.println(tSeries);
			writer.println(tSeries);
		}
		writer.close();
		
	}
}
