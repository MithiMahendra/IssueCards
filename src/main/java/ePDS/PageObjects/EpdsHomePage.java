package ePDS.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EpdsHomePage {
	public WebDriver driver;

	public EpdsHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "uid")
	WebElement userName;
	@FindBy(id = "pwd")
	WebElement passWord;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement login;

	@FindBy(xpath = "//div[@id='cssmenu']/ul/li[2]")
	WebElement cardsPrinting;
	@FindBy(xpath = "//div[@id='cssmenu']/ul/li[2]/ul/li/a[1]/span")
	WebElement singleCard;

	@FindBy(id = "secretariat_code")
	WebElement secName;
	@FindBy(id = "card_type")
	WebElement cardType;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//table[@id='tabcolor']")
	WebElement table;

	By riceCardNo = By.xpath("//table[@id='tabcolor']/tbody/tr/td[2]");
	
	By tSeries = By.xpath("//table[@id='tabcolor']/tbody/tr/td[3]");

	public WebElement userName() {
		return userName;
	}

	public WebElement passWord() {
		return passWord;
	}

	public WebElement login() {
		return login;
	}

	public WebElement cardsPrinting() {
		return cardsPrinting;
	}

	public WebElement singleCard() {
		return singleCard;
	}

	public WebElement secName() {
		return secName;
	}

	public WebElement cardType() {
		return cardType;
	}

	public WebElement submit() {
		return submit;
	}

	public WebElement getTable() {
		return table;
	}

	public List<WebElement> riceCardNo() {
		return table.findElements(riceCardNo);
	}
	public List<WebElement> tSeries(){
		return table.findElements(tSeries);
	}
}
