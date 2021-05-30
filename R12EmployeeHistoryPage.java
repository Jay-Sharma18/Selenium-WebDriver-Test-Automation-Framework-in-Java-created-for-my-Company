package PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class R12EmployeeHistoryPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id,'F2::content')]")
	WebElement EmployeeBox;
	
	@FindBy(xpath="//*[contains(@id,'F3::content')]")
	WebElement EmployeeDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F6::content')]")
	WebElement EffectiveDateBox;
	
	@FindBy(xpath="//*[contains(@id,'INSERTRECORD')]")
	WebElement InsertButton;
	
	@FindBy(xpath="//*[contains(@id,'F37::content')]")
	WebElement LastNameBox;
	
	@FindBy(xpath="//*[contains(@id,'CON60_Main::disAcr')]")
	WebElement RatesSalaryTab;
	
	@FindBy(xpath="//*[contains(@id,'F127::content')]")
	WebElement HourlyRateBox;
	
	@FindBy(xpath="//*[contains(text(),'Process')]")
	WebElement ProcessButton;
	
	@FindBy(xpath="//*[contains(@id,'alertPopup::content')]")
	WebElement alertPopUp;
	
	@FindBy(xpath="//*[contains(@id,'scrbtn1137867')]")
	WebElement alertPopUpYesButton;
	
	@FindBy(xpath="//*[contains(@id,'alertPopup::content')]")
	WebElement alertPopUp2;
	
	@FindBy(xpath="//*[contains(@id,'scrbtn1137864')]")
	WebElement alertPopUpYesButton2;
	
	
	public R12EmployeeHistoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmployee(String emp)
	{	
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(EmployeeBox));
		EmployeeBox.sendKeys(emp);
		EmployeeBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(EmployeeDescBox,"value"));
	}
	
	public void entereffectiveDate(String date)
	{
		EffectiveDateBox.sendKeys(date);
		EffectiveDateBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(LastNameBox,"value"));
	}
	
	public void clickInsertButton()
	{
		InsertButton.click();
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(LastNameBox));
	}
	
	
	public void clickRatesTab()
	{
		RatesSalaryTab.click();
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(HourlyRateBox));
	}
	
	public void enterNewRate(String Rate)
	{	
		HourlyRateBox.clear();
		HourlyRateBox.sendKeys(Rate);
		HourlyRateBox.sendKeys(Keys.TAB);
	}
	
	public void clickProcessButton()
	{
		ProcessButton.click();
		//new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(alertPopUp));
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(alertPopUpYesButton));
	}
	
	public void clickYesAlertPopup()
	{	
		
		alertPopUpYesButton.click();
		//new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(alertPopUp2));
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(alertPopUpYesButton2));
	}
	
	public void clickYesAlertPopup2()
	{	
		
		alertPopUpYesButton2.click();
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(HourlyRateBox));
	}
	
	public String getHourlyRateBoxValue()
	{
		return HourlyRateBox.getAttribute("value");
	}
	
	public String getoldHourlyRate()
	{
		return HourlyRateBox.getAttribute("value");
	}
}
