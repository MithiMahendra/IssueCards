package ePDS.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WSHomePage {
	public WebDriver driver;

	public WSHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@ng-model='userid']")
	WebElement userName;
	
	@FindBy(xpath="//input[@ng-model='gswspwd']")
	WebElement passWord;
	
	@FindBy(xpath="//button[@ng-disabled='isdisabled']")
	WebElement logIn;
	
	@FindBy(xpath="//input[@ng-model='Fcaptcha']")
	WebElement captha;
	
	@FindBy(xpath="//div[@id='notification']/div/div/div/button")
	WebElement notification;
	
	@FindBy(xpath="//ul[@id='myUL 18']/li/span")
	WebElement civilSupplies;
	
	@FindBy(xpath="//a[contains(text(),'Application Status Check Service')]")
	WebElement applicationStatus;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement search;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement tSubmit;
	
	@FindBy(xpath="//a[contains(text(),'VRO Meeseva Approval')]")
	WebElement meesevaApproval;
	
	public WebElement userName() {
		return userName;
		
	}
	public WebElement passWord() {
		return passWord;
	}
	
	public WebElement logIn() {
		return logIn;
	}
	public WebElement captha() {
		return captha;
	}
	
	public WebElement notification() {
		return notification;
	}
	
	public WebElement civilSupplies() {
		return civilSupplies;
	}
	
	public WebElement applicationStatus() {
		return applicationStatus;
	}
	
	public WebElement search() {
		return search;
	}
	public WebElement tSubmit() {
		return tSubmit;
	}
	public WebElement meesevaPortal() {
		return meesevaApproval;
	}
}
