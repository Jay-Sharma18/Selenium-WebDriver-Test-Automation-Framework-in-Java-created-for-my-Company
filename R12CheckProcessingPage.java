package PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class R12CheckProcessingPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id,'F3::content')]")
	WebElement CompanyBox;
	
	@FindBy(xpath="//*[contains(@id,'F4::content')]")
	WebElement CompanyDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F6::content')]")
	WebElement PayRunBox;
	
	@FindBy(xpath="//*[contains(@id,'F7::content')]")
	WebElement PayRunDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F8::content')]")
	WebElement PayYearBox;
	
	@FindBy(xpath="//*[contains(@id,'F9::content')]")
	WebElement PayPeriodBox;
	
	@FindBy(xpath="//*[contains(@id,'F11::content')]")
	WebElement PayPeriodDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F22::content')]")
	WebElement BankBox;
	
	@FindBy(xpath="//*[contains(@id,'F23::content')]")
	WebElement BankDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F24::content')]")
	WebElement BranchBox;
	
	@FindBy(xpath="//*[contains(@id,'F25::content')]")
	WebElement BranchDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F26::content')]")
	WebElement AccountNumBox;
	
	@FindBy(xpath="//*[contains(@id,'F28::content')]")
	WebElement LastCheckNumBox;
	
	@FindBy(xpath="//*[text()='Process']")
	WebElement ProcessButton;
	
	@FindBy(xpath="//*[contains(@id,'F42::content')]")
	WebElement ProcessingResultBox;
	
	public R12CheckProcessingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterCompany(String company)
	{	
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(CompanyBox));
		CompanyBox.sendKeys(company);
		CompanyBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(CompanyDescBox, "value"));
	}
	
	public void enterPayRun(String payrun)
	{
		PayRunBox.sendKeys(payrun);
		PayRunBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(PayRunDescBox, "value"));
	}
	
	
	public void enterBank(String bank)
	{
		BankBox.sendKeys(bank);
		BankBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(BankDescBox, "value"));
	}
	
	public void enterBranch(String branch)
	{
		BranchBox.sendKeys(branch);
		BranchBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(BranchDescBox, "value"));
	}
	
	public void enterAccountNum(String number)
	{
		AccountNumBox.sendKeys(number);
		AccountNumBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(LastCheckNumBox, "value"));
	}
	
	public void clickProcess()
	{
		ProcessButton.click();
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(ProcessingResultBox, "value"));
	}
	
	public String returnProcessingResultBoxMessage()
	{
		return ProcessingResultBox.getAttribute("value");
	}
	
	public void enterPayYear(String year)
	{	
		PayYearBox.clear();
		PayYearBox.sendKeys(year);
		PayYearBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.not(ExpectedConditions.attributeToBeNotEmpty(PayPeriodBox, "value")));
		
	}
	
	public void enterPayPeriod(String period)
	{
		PayPeriodBox.clear();
		PayPeriodBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.not(ExpectedConditions.attributeToBeNotEmpty(PayPeriodDescBox, "value")));
		PayPeriodBox.sendKeys(period);
		PayPeriodBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(PayPeriodDescBox, "value"));
		
	}
	
	public String getPayYear()
	{
		return PayYearBox.getAttribute("value");
	}
	
	public String getPayPeriod()
	{
		return PayPeriodBox.getAttribute("value");
	}

}
