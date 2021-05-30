package PageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class R12TimesheetEntryPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id,'F3::content')]")
	WebElement PayRunBox;               
	
	@FindBy(xpath="//*[contains(@id,'F4::content')]")
	WebElement PayRunBoxDesc;
	
	@FindBy(xpath="//*[contains(@id,'F9::content')]")
	WebElement DocumentBox;
	
	@FindBy(linkText = "Insert Multiple")
	WebElement InsertButton;
	
	@FindBy(xpath="//*[contains(@id,'S1CONT4T:t:1:F26_t::content')]")
	WebElement EmployeeBoxFirstRow;
	
	@FindBy(xpath="//*[contains(@id,'S1CONT4T:t:1:F29_t::content')]")
	WebElement TradeBox;
	
	@FindBy(xpath="//*[contains(@id,'S1CONT4T:t:1:F44_t::content')]")
	WebElement NormalHoursBox;
	
	@FindBy(linkText = "Save")
	WebElement SaveButton;
	
	@FindBy(xpath="//*[contains(@id,'F35_t::content')]")
	WebElement RecordDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F10::content')]")
	WebElement NHTotalBox;
	
	@FindBy(xpath="//*[contains(@id,'S1CONT4T:t::scroller')]")
	WebElement ScrollBarTimesheetDetails;
	
	public R12TimesheetEntryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterPayRun(String PayRun) 
	{
		PayRunBox.sendKeys(PayRun);
		PayRunBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver,30).until(ExpectedConditions.attributeToBeNotEmpty(PayRunBoxDesc, "value")); 
	}
	
	public void enterDocument(String Document)
	{
		DocumentBox.sendKeys(Document);
		DocumentBox.sendKeys(Keys.TAB);
	}
	
	public void clickInsertButton()
	{
		InsertButton.click();
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(EmployeeBoxFirstRow));
	}
	
	public void enterEmployee1(String Employee)
	{
		EmployeeBoxFirstRow.sendKeys(Employee);
		EmployeeBoxFirstRow.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(TradeBox,"value"));
	
	}
	
	public void enterNormalHours(String hours)
	{	
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", NormalHoursBox);
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 500", ScrollBarTimesheetDetails);
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(NormalHoursBox));
		NormalHoursBox.sendKeys(hours);
	}
	
	public void clickSaveButton() 
	{
		SaveButton.click();
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(RecordDescBox,"value"));
		
	}
	
	public String returnNHTotalValue()
	{
		return NHTotalBox.getAttribute("value");   
	}
	
	
}

