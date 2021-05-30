package PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class R12PayrollPostingPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id,'F1::content')]")
	WebElement CompanyBox;
	
	@FindBy(xpath="//*[contains(@id,'F2::content')]")
	WebElement CompanyDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F3::content')]")
	WebElement PayRunBox;
	
	@FindBy(xpath="//*[contains(@id,'F4::content')]")
	WebElement PayRunDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F5::content')]")
	WebElement PayYearBox;
	
	@FindBy(xpath="//*[contains(@id,'F6::content')]")
	WebElement PayPeriodBox;
	
	@FindBy(xpath="//*[contains(@id,'F7::content')]")
	WebElement PayPeriodDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F12::content')]")
	WebElement PrintReportsCheckBox;
	
	@FindBy(xpath="//*[contains(@id,'F15::content')]")
	WebElement PostingResultDisplayBox;
	
	@FindBy(xpath="//*[text()='Post Batch']")
	WebElement PostBatchbutton;
	
	@FindBy(xpath="//*[contains(text(),'Unprinted Checks have been found. Please ensure that all checks have been printed before posting')]")
	WebElement UnprintedChecksErrorBox;
	
	public R12PayrollPostingPage(WebDriver driver)
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
	
	public void enterPayYear(String year)
	{	
		PayYearBox.clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PayYearBox.sendKeys(year);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PayYearBox.sendKeys(Keys.TAB);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public String clickPostBatchButton()
	{
		PostBatchbutton.click();
		try
		{
			new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(PostingResultDisplayBox, "value"));
			return PostingResultDisplayBox.getAttribute("value").toString();
		}
		catch(Exception e)
		{	
			new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(UnprintedChecksErrorBox));
			String result="Unprinted Checks exist in this period. Please print all checks before Posting";
			return result;
		}
	}
	
}
