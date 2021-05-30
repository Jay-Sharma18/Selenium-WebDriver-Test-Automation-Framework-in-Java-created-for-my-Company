package PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class R12VoidChecksPage 
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
	
	@FindBy(xpath="//*[contains(@id,'screenPanelWindow')]")
	WebElement VoidChecksPrompt;
	
	@FindBy(xpath="//*[text()='Current Date']")
	WebElement CurrentDateRadioButton;
	
	@FindBy(xpath="//*[text()='Accept']")
	WebElement AcceptButton;
	
	@FindBy(xpath="//*[contains(@id,'F23::content')]")
	WebElement BankBox;
	
	@FindBy(xpath="//*[contains(@id,'F19::content')]")
	WebElement FromEmployeeBox;
	
	@FindBy(xpath="//*[contains(@id,'F20::content')]")
	WebElement FromEmployeeDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F21::content')]")
	WebElement ToEmployeeBox;
	
	@FindBy(xpath="//*[contains(@id,'F22::content')]")
	WebElement ToEmployeeDescBox;
	
	@FindBy(xpath="//*[text()='Void Check']")
	WebElement VoidCheckButton;
	
	@FindBy(xpath="//*[contains(@id,'F38::content')]")
	WebElement VoidCheckResultBox;
	
	
	public R12VoidChecksPage(WebDriver driver)
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
	
	public void clickCurrentDateOnPrompt()
	{	
		CurrentDateRadioButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void clickAcceptOnPrompt()
	{	
		AcceptButton.click();
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(PayYearBox, "value"));
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
	
	public void enterFromEmployee(String employee)
	{	
		FromEmployeeBox.sendKeys(employee);
		FromEmployeeBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(FromEmployeeDescBox, "value"));
	}
	
	public void enterToEmployee(String employee)
	{	
		ToEmployeeBox.sendKeys(employee);
		ToEmployeeBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(ToEmployeeDescBox, "value"));
	}
	
	public void clickVoidCheck()
	{
		VoidCheckButton.click();
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(VoidCheckResultBox, "value"));
	}
	
	public String getVoidCheckResultBoxMessage()
	{
		return VoidCheckResultBox.getAttribute("value");
	}
}
