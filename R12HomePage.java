package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class R12HomePage 
{

	WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id,'quickSearch1::content')]")
	WebElement SearchProgramBox;
	
	@FindBy(xpath="/html/body/div[2]/div[1]")
	WebElement USPayrollTimesheetEntrySearchResult;
	
	@FindBy(xpath="/html/body/div[2]/div[1]")
	WebElement USPayrollEmployeeProfileSearchResult;
	
	@FindBy(xpath="/html/body/div[2]/div[4]")
	WebElement USPayrollProcessingSearchResult;
	
	@FindBy(xpath="/html/body/div[2]/div[2]")
	WebElement USPayrollCheckVoidSearchResult;
	
	public R12HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterSearchTextInSearchBox(String searchText)
	{	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SearchProgramBox.sendKeys(searchText);       
	}
	
	public void selectUSTimesheetEntryOption()
	{
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(USPayrollTimesheetEntrySearchResult));
		USPayrollTimesheetEntrySearchResult.click();
	}
	
	public void selectUSEmployeeProfileOption()
	{
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(USPayrollEmployeeProfileSearchResult));
		USPayrollEmployeeProfileSearchResult.click();
	}
	
	public void selectUSEmploymentHistoryOption()
	{
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(USPayrollEmployeeProfileSearchResult));
		USPayrollEmployeeProfileSearchResult.click();
	}
	
	public void selectUSDirectDepositOption()
	{
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(USPayrollEmployeeProfileSearchResult));
		USPayrollEmployeeProfileSearchResult.click();
	}
	
	public void selectUSTimesheetPostingOption()
	{
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(USPayrollEmployeeProfileSearchResult));
		USPayrollEmployeeProfileSearchResult.click();
	}
	
	public void selectUSCheckProcessingOption()
	{
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(USPayrollEmployeeProfileSearchResult));
		USPayrollEmployeeProfileSearchResult.click();
	}
	
	public void selectUSPayrollProcessingOption()
	{
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(USPayrollProcessingSearchResult));
		USPayrollProcessingSearchResult.click();
	}
	
	public void selectUSPayrollCheckPrintingOption()
	{
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(USPayrollEmployeeProfileSearchResult));
		USPayrollEmployeeProfileSearchResult.click();
	}
	
	public void selectUSPayrollCheckVoidOption()
	{
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(USPayrollCheckVoidSearchResult));
		USPayrollCheckVoidSearchResult.click();
	}
	
	public void selectUSPayrollPostingOption()
	{
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(USPayrollEmployeeProfileSearchResult));
		USPayrollEmployeeProfileSearchResult.click();
	}
}
