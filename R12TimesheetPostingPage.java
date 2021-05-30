package PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class R12TimesheetPostingPage 
{	
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id,'F1::content')]")
	WebElement CompanyBox;
	
	@FindBy(xpath="//*[contains(@id,'F2::content')]")
	WebElement CompanyDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F8::content')]")
	WebElement PayRunBox;
	
	@FindBy(xpath="//*[contains(@id,'F9::content')]")
	WebElement PayRunDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F10::content')]")
	WebElement PayYearBox;
	
	@FindBy(xpath="//*[contains(@id,'F11::content')]")
	WebElement PayPeriodBox;
	
	@FindBy(xpath="//*[contains(@id,'F12::content')]")
	WebElement PayPeriodDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F30::content')]")
	WebElement PrintReportsCheckBox;
	
	@FindBy(xpath="//*[text()='Post']")
	WebElement PostButton;
	
	@FindBy(xpath="//*[contains(@id,'F32::content')]")
	WebElement PostedDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F23::content')]")
	WebElement StartingDateBox;
	
	boolean PayYearsEqual=false;
	
	public R12TimesheetPostingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterCompany(String Company)
	{
		new WebDriverWait(driver,30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(CompanyBox));
		CompanyBox.sendKeys(Company);
		CompanyBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(CompanyDescBox, "value"));
		
	}
	
	public void enterPayRun(String PayRun)
	{
		PayRunBox.sendKeys(PayRun);
		PayRunBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(StartingDateBox, "value"));
		
	}
	
	public void enterPayYear(String Year)
	{	
		String defaultPayyear=PayYearBox.getAttribute("value");
		if(!Year.equals(defaultPayyear))
		{	
			PayYearBox.clear();
			PayYearBox.sendKeys(Year);
			PayYearBox.sendKeys(Keys.TAB);
			new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.not(ExpectedConditions.attributeToBeNotEmpty(PayPeriodBox, "value")));
		}
		else
		{	
			PayYearsEqual=true;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void enterPayPeriod(String Period)
	{	
		
		if(PayYearsEqual && PayPeriodBox.getAttribute("value").equals(Period))
		{	
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{	
			PayPeriodBox.clear();
			PayPeriodBox.sendKeys(Keys.TAB);
			new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.not(ExpectedConditions.attributeToBeNotEmpty(PayPeriodDescBox, "value")));
			PayPeriodBox.sendKeys(Period);
			PayPeriodBox.sendKeys(Keys.TAB);
			new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(PayPeriodDescBox, "value"));
		}
	}
	public void clickPrintReportsCheckBox()
	{
		PrintReportsCheckBox.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickPostButton()
	{
		PostButton.click();
		new WebDriverWait(driver, 50).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.textToBePresentInElement(PostedDescBox, "Timesheet Posting Completed successfully, Created Batch Number"));
	}
	
	public String getPostedBoxText() 
	{
		return PostedDescBox.getText();
	}
	
	
}
