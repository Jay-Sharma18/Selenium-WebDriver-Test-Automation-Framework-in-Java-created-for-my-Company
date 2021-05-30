package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class R12PayrollProcessingPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id,'if1::f')]")
	WebElement ProcessingMainFrame;
	
	@FindBy(xpath="//frame[@id='contentFrame']")
	WebElement ProcessingMainFrame2;
	
	@FindBy(name="compCode")
	WebElement PayrollCompanyBox;
	
	@FindBy(xpath="//*[contains(@id,'compName')]")
	WebElement PayrollCompanyDescBox;
	
	@FindBy(xpath="//*[contains(@id,'homeCompCode')]")
	WebElement HomeCompanyBox;
	
	@FindBy(xpath="//*[contains(@id,'homeCompName')]")
	WebElement HomeCompanyDescBox;
	
	@FindBy(xpath="//*[contains(@id,'prnCode')]")
	WebElement PayRunBox;
	
	@FindBy(xpath="//*[contains(@id,'prnName')]")
	WebElement PayRunDescBox;
	
	@FindBy(xpath="//*[contains(@id,'pprYear')]")
	WebElement PayYearBox;
	
	@FindBy(xpath="//*[contains(@id,'pprPeriod')]")
	WebElement PayPeriodBox;
	
	@FindBy(xpath="//*[contains(@id,'processPayrollButton')]")
	WebElement ProcessButton;
	
	public R12PayrollProcessingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void switchToMainFrame()
	{	
		new WebDriverWait(driver,20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ProcessingMainFrame));
		new WebDriverWait(driver,20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ProcessingMainFrame2));
	}
	
	public void enterPayrollCompany(String company)
	{	
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(PayrollCompanyBox));
		PayrollCompanyBox.sendKeys(company);
		PayrollCompanyBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.textToBePresentInElement(PayrollCompanyDescBox,""));
	}
	
	public void enterHomeCompany(String company)
	{
		HomeCompanyBox.sendKeys(company);
		HomeCompanyBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.textToBePresentInElement(HomeCompanyDescBox,""));
	}
	
	public void enterPayRun(String payrun)
	{
		PayRunBox.sendKeys(payrun);
		PayRunBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.textToBePresentInElement(PayRunDescBox,""));
	}
	
	public void enterPayYear(String year)
	{
		PayYearBox.sendKeys(year);
		PayYearBox.sendKeys(Keys.TAB);
	}
	
	public void enterPayPeriod(String period)
	{
		PayPeriodBox.sendKeys(period);
		PayPeriodBox.sendKeys(Keys.TAB);
	}
	
	public void clickProcessButton()
	{
		ProcessButton.click();
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.alertIsPresent());
		
	}
}
