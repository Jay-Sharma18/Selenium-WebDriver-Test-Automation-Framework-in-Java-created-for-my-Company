package PageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class R12DirectDepositPage 
{	
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id,'F3::content')]")
	WebElement EmployeeBox;
	
	@FindBy(xpath="//*[contains(@id,'F4::content')]")
	WebElement EmployeeDescBox;
	
	@FindBy(xpath="//*[contains(@id,'S1CONT2T:PYEMPSALSPL_INSERTRECORD_toolbarButton')]")
	WebElement InsertButton;
	
	@FindBy(xpath="//*[contains(@id,'t:0:F10_t::content')]")
	WebElement PriorityBox;
	
	@FindBy(xpath="//*[contains(@id,'t:0:F14_t::content')]")
	WebElement PercentBox;
	
	@FindBy(xpath="//*[contains(@id,'S1CONT2T:t:F14_ct')]")
	WebElement TotalPercentDescBox;
	
	@FindBy(xpath="//*[contains(@id,'t:0:F15_t::content')]")
	WebElement SplitTypeMenu;
	
	@FindBy(xpath="//*[contains(@id,'t:0:F16_t::content')]")
	WebElement BankBox;
	
	@FindBy(xpath="//*[contains(@id,'t:0:F18_t::content')]")
	WebElement BankDescBox;
	
	@FindBy(xpath="//*[contains(@id,'t:0:F17_t::content')]")
	WebElement BranchBox;
	
	@FindBy(xpath="//*[contains(@id,'t:0:F21_t::content')]")
	WebElement CodeBox;
	
	@FindBy(xpath="//*[contains(@id,'t:0:F20_t::content')]")
	WebElement CountBox;
	
	@FindBy(xpath="//*[contains(@id,'t:0:F22_t::content')]")
	WebElement AccountNumberBox;
	
	@FindBy(xpath="//*[contains(@id,'Main_save')]")
	WebElement SaveButton;
	
	@FindBy(xpath="//*[contains(text(),'Total Percentage must be 100')]")
	WebElement TotalPercentErrorMessageBox;
	
	@FindBy(xpath="//*[contains(@id,'t:1:F10_t::content')]")
	WebElement PriorityBox2;
	
	@FindBy(xpath="//*[contains(@id,'t:1:F14_t::content')]")
	WebElement PercentBox2;
	
	@FindBy(xpath="//*[contains(@id,'S1CONT2T:PYEMPSALSPL_DELETERECORD_toolbarButton')]")
	WebElement DeleteButton;
	
	@FindBy(xpath="//*[contains(@id,'S1CONT2T:t::hscroller')]")
	WebElement accountDetailsScrollBar;
	
	public R12DirectDepositPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmployee(String employee)
	{	
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(EmployeeBox));
		EmployeeBox.sendKeys(employee);
		EmployeeBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(EmployeeDescBox,"value"));
	}
	
	public void clickInsertButton1()
	{
		InsertButton.click();
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(PriorityBox));
	}
	
	public void enterPriority(String priority)
	{	
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(PriorityBox));
		PriorityBox.sendKeys(priority);
		PriorityBox.sendKeys(Keys.TAB);
	}
	
	public void enterPercentFigure1(String percent)
	{
		PercentBox.sendKeys(percent);
		PercentBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.textToBePresentInElement(TotalPercentDescBox, percent));
		
	}
	
	public void selectDirectDepositSplitType()
	{
		new Select(SplitTypeMenu).selectByValue("1");
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(BankBox));
	}
	
	public void enterBank(String bank)
	{
		BankBox.sendKeys(bank);
		BankBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(BankDescBox,"value"));
	}
	
	public void enterBranch(String branch)
	{
		BranchBox.sendKeys(branch);
		BranchBox.sendKeys(Keys.TAB);
	}
	
	public void enterCode(String code)
	{
		CodeBox.sendKeys(code);
		CodeBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(CountBox,"value"));
	}
	
	public void enterAccountNumber(String accountNum)
	{
		AccountNumberBox.sendKeys(accountNum);
		AccountNumberBox.sendKeys(Keys.TAB);
	}
	
	public void clickSave1()
	{
		SaveButton.click();
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(TotalPercentErrorMessageBox));
	}
	
	public void clickInsertButton2()
	{	
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += -500", accountDetailsScrollBar);
		InsertButton.click();
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(PriorityBox2));
	}
	
	public void enterPriority2(String priority2)
	{	
		
		PriorityBox2.sendKeys(priority2);
		PriorityBox2.sendKeys(Keys.TAB);
	}
	
	public void enterPercentFigure2(String percent2)
	{
		PercentBox2.sendKeys(percent2);
		PercentBox2.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.textToBePresentInElement(TotalPercentDescBox, "100"));
	}
	
	public void clickSave2()
	{
		SaveButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.textToBePresentInElement(TotalPercentDescBox, "100"));
	}
	
	public String returnSavedTotalPercentage()
	{
		return TotalPercentDescBox.getText();
	}
	
	public void clickDeleteToDeleteAllRows()
	{	
		try
		{
				new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(DeleteButton));
				DeleteButton.click();
				new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.textToBePresentInElement(TotalPercentDescBox, "65"));
				
			
		}
		catch(NoSuchElementException e)
		{
			
		}
		
		try
		{
			new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(DeleteButton));
			DeleteButton.click();
			new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.textToBePresentInElement(TotalPercentDescBox, "0"));
			
		}
		catch(NoSuchElementException e)
		{
			
		}
		
	}
	
	public void clickSaveAfterDeletion()
	{
		SaveButton.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.textToBePresentInElement(TotalPercentDescBox, "0"));
		
	}
}
