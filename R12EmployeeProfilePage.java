package PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

public class R12EmployeeProfilePage 
{
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(@id,'CON40_Main::disAcr')]")
	WebElement PersonalTab;
	
	@FindBy(xpath="//*[contains(@id,'Main_LOGMODEADD')]")
	WebElement AddNewButton;
	
	@FindBy(xpath="//*[contains(@id,'F36::content')]")
	WebElement EmployeeNumberBox;
	
	@FindBy(xpath="//*[contains(@id,'F53::content')]")
	WebElement LastNameBox;
	
	@FindBy(xpath="//*[contains(@id,'F55::content')]")
	WebElement FirstNameBox;
	
	@FindBy(xpath="//*[contains(@id,'F66::content')]")
	WebElement SINNumberBox;
	
	@FindBy(xpath="//*[contains(@id,'F85::content')]")
	WebElement DOBBox;
	
	@FindBy(xpath="//*[contains(@id,'F86::content')]")
	WebElement HireDateBox;
	
	@FindBy(xpath="//*[contains(@id,'CON50_Main::disAcr')]")
	WebElement CompanyTab;
	
	@FindBy(xpath="//*[contains(@id,'F102::content')]")
	WebElement PayrollCompanyBox;
	
	@FindBy(xpath="//*[contains(@id,'F106::content')]")
	WebElement HomeCompanyBox;
	
	@FindBy(xpath="//*[contains(@id,'F110::content')]")
	WebElement PayrollDeptBox;
	
	@FindBy(xpath="//*[contains(@id,'F113::content')]")
	WebElement HomeDeptBox;
	
	@FindBy(xpath="//*[contains(@id,'F131::content')]")
	WebElement PayRunBox;
	
	@FindBy(xpath="//*[contains(@id,'F132::content')]")
	WebElement PayRunDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F134::content')]")
	WebElement PayGroupBox;
	
	@FindBy(xpath="//*[contains(@id,'F135::content')]")
	WebElement PayGroupDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F138::content')]")
	WebElement WorkLocationBox;
	
	@FindBy(xpath="//*[contains(@id,'F139::content')]")
	WebElement WorkLocationDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F142::content')]")
	WebElement TradeBox;
	
	@FindBy(xpath="//*[contains(@id,'F143::content')]")
	WebElement TradeDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F104::content')]")
	WebElement WCCodeBox;
	
	@FindBy(xpath="//*[contains(@id,'F105::content')]")
	WebElement WCCodeDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F108::content')]")
	WebElement PLCodeBox;
	
	@FindBy(xpath="//*[contains(@id,'F109::content')]")
	WebElement PLCodeDescBox;
	
	@FindBy(xpath="//*[contains(@id,'F136::content')]")
	WebElement DefaultEmployeeSecurityGroupBox;
	
	@FindBy(xpath="//*[contains(@id,'F137::content')]")
	WebElement DefaultEmployeeSecurityGroupDescBox;
	
	@FindBy(xpath="//*[contains(@id,'CON60_Main::disAcr')]")
	WebElement RatesSalaryTab;
	
	@FindBy(xpath="//*[contains(@id,'F151::content')]")
	WebElement HourlyRateBox;
	
	@FindBy(xpath="//*[contains(@id,'F152::content')]")
	WebElement ChargeRateBox;
	
	@FindBy(xpath="//*[contains(@id,'CON70_Main::disAcr')]")
	WebElement AddressTab;
	
	@FindBy(xpath="//*[contains(@id,'F180::content')]")
	WebElement ZipCodeBox;
	
	@FindBy(xpath="//*[contains(@id,'F183::content')]")
	WebElement StateProvinceBox;
	
	@FindBy(xpath="//*[contains(@id,'CON80_Main::disAcr')]")
	WebElement TaxTab;
	
	@FindBy(xpath="//*[contains(@id,'F219::content')]")
	WebElement FederalFilingStatusBox;
	
	@FindBy(xpath="//*[contains(@id,'F220::content')]")
	WebElement FederalFilingStatusDescBox;
	
	@FindBy(xpath="//*[contains(@id,'Main_save::icon')]")
	WebElement SaveButton;
	
	@FindBy(xpath="//*[contains(@id,'F46::content')]")
	WebElement EmployeeFullNameBox;
	
	@FindBy(xpath="//*[contains(text(),'already exists')]")
	WebElement EmployeeAlreadyExistsErrorBox;
	
	
	public R12EmployeeProfilePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddNewButton()
	{
		AddNewButton.click();
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(EmployeeNumberBox));
	}
	
	public void enterEmployeeNumber(String employeeCode) 
	{	
		EmployeeNumberBox.clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmployeeNumberBox.sendKeys(employeeCode);
		EmployeeNumberBox.sendKeys(Keys.TAB);
	}
	
	public void enterLastName(String lastName)
	{
		LastNameBox.sendKeys(lastName);
	}
	
	public void enterFirstName(String firstName)
	{	
		FirstNameBox.clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FirstNameBox.sendKeys(firstName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FirstNameBox.sendKeys(Keys.TAB);
	
	}
	
	public void enterSINNumber(String Sin)
	{
		SINNumberBox.sendKeys(Sin);
	}
	
	public void enterDOB(String birthDate)
	{
		DOBBox.sendKeys(birthDate);
	}
	
	public void enterHireDate(String HireDate)
	{
		HireDateBox.sendKeys(HireDate);
	}
	
	public void clickCompanyTab()
	{
		CompanyTab.click();
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(PayrollCompanyBox));
	}
	
	public void enterPayrollCompany(String Company)
	{
		PayrollCompanyBox.sendKeys(Company);
		PayrollCompanyBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBe(HomeCompanyBox, "value", Company));
	}
	
	public void enterPayrollDept(String dept)
	{
		PayrollDeptBox.sendKeys(dept);
		PayrollDeptBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBe(HomeDeptBox, "value",dept ));
	}
	
	public void enterPayRun(String payrun)
	{
		PayRunBox.sendKeys(payrun);
		PayRunBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(PayRunDescBox, "value"));
	}
	
	public void enterPayGroup(String Paygroup)
	{
		PayGroupBox.sendKeys(Paygroup);
		PayGroupBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(PayGroupDescBox, "value"));
		
	}
	
	public void enterWorkLocation(String workLocation)
	{
		WorkLocationBox.sendKeys(workLocation);
		WorkLocationBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(WorkLocationDescBox, "value"));
	}
	
	public void enterTrade(String Trade)
	{
		TradeBox.sendKeys(Trade);
		TradeBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(TradeDescBox, "value"));
	}
	
	public void enterWCCode(String WCCode)
	{
		WCCodeBox.sendKeys(WCCode);
		WCCodeBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(WCCodeDescBox, "value"));
	}
	
	public void enterPLCode(String PLCode)
	{
		PLCodeBox.sendKeys(PLCode);
		PLCodeBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(PLCodeDescBox, "value"));
	}
	
	public void enterDefaultSecurityGroup(String securityGroup)
	{
		DefaultEmployeeSecurityGroupBox.sendKeys(securityGroup);
		DefaultEmployeeSecurityGroupBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(DefaultEmployeeSecurityGroupDescBox, "value"));
	}
	
	public void clickRatesSalaryTab()
	{
		RatesSalaryTab.click();
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(HourlyRateBox));
	}
	
	public void enterHourlyRate(String hourlyRate)
	{
		HourlyRateBox.sendKeys(hourlyRate);
		HourlyRateBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(ChargeRateBox, "value"));
	}
	
	public void clickAddressTab()
	{
		AddressTab.click();
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(ZipCodeBox));
	}
	
	public void enterZipCode(String zip)
	{
		ZipCodeBox.sendKeys(zip);
		ZipCodeBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(StateProvinceBox, "value"));
	}
	
	public void clickTaxTab()
	{
		TaxTab.click();
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(FederalFilingStatusBox));
	}
	
	public void enterFederalFilingStatus(String taxCode)
	{
		FederalFilingStatusBox.sendKeys(taxCode);
		FederalFilingStatusBox.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(FederalFilingStatusBox, "value"));
	}
	
	public void clickSave()
	{
		SaveButton.click();
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.attributeToBeNotEmpty(EmployeeFullNameBox, "value"));
		
	}
	
	public String getSavedEmployeeName()
	{
		return EmployeeFullNameBox.getAttribute("value");
	}
	
	public boolean EmployeeExists()
	{
		try
		{
			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(EmployeeAlreadyExistsErrorBox));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickPersonalTab()
	{
		PersonalTab.click();
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(FirstNameBox));
		
	}
	
	public void clickSaveForNewEmployeeNumber()
	{	
		SaveButton.click();
		try
		{
			new WebDriverWait(driver, 20).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(FirstNameBox)));
		}
		catch(Exception e)
		{
			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(EmployeeAlreadyExistsErrorBox));
		}
		
	}
	
	public boolean firstNameHasText()
	{	
		if(FirstNameBox.getText()=="") return false;
		else return true;
	}
}
