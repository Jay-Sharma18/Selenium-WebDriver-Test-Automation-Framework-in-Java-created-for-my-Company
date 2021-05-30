package TestClasses;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageClasses.R12EmployeeProfilePage;
import PageClasses.R12HomePage;
import PageClasses.R12LaunchPage;
import PageClasses.R12SignInPage;
import PageClasses.R12UIConsolePage;

public class TC3_EmployeeProfileTest extends BaseClass
{
	public static String ProgramUnderTest="Employee Profile";
	public static String EmployeeNumber;
	public static String BirthDate="01-01-1972";
	public static String HireDate="01-01-2001";
	public static String hourlyRate="35";
	
@Test
	public void CreateNewEmployee()
	{	
		
		EmployeeNumber=Company+"-"+PayRunFrequency+"-"+"H"+"-SE"+employeeIdentifier;  
		R12LaunchPage launch=new R12LaunchPage(driver);
		R12SignInPage signIn=new R12SignInPage(driver);
		R12UIConsolePage console =new R12UIConsolePage(driver);
		R12HomePage home=new R12HomePage(driver);
		R12EmployeeProfilePage employee=new R12EmployeeProfilePage(driver);
		log.info("Clicking Enterprise Console product");
		launch.clickEnterpriseConsoleButton();
		log.info("Clicking test12c environment");
		launch.clickTest12CButton();
		log.info("Clicking Launch Software");
		launch.clickLaunchButton();
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		for(String windowHandle  : handles)
		{
			if(!windowHandle.equals(parentWindow))
		    {
				driver.switchTo().window(windowHandle);
				break;
		    }
		}
		log.info("Entering User ID");
		signIn.enterUserId(username);
		log.info("Entering password");
		signIn.enterPassword(password);
		log.info("Clicking Sign In");
		signIn.clickSignInButton();
		log.info("clicking Go");
		console.clickOkButton();
		log.info("Entering Employee Profile in search box and opening Employee Profile program");
		home.enterSearchTextInSearchBox(ProgramUnderTest);
		home.selectUSEmployeeProfileOption();
		log.info("clicking Add New Button");
		employee.clickAddNewButton();
		log.info("Entering Employee Number");
		employee.enterEmployeeNumber(EmployeeNumber);
		log.info("Entering Employee Last Name");
		employee.enterLastName(Company+CompanyPayRun+"HR");
		log.info("Entering Employee First Name");
		employee.enterFirstName("Employee"+employeeIdentifier);
		log.info("Entering Employee SIN Number");
		employee.enterSINNumber(timeStamp.replace(".","").substring(2, 11));
		log.info("Entering Employee DOB");
		employee.enterDOB(BirthDate);
		log.info("Entering Employee Hire Date");
		employee.enterHireDate(HireDate);
		log.info("Clicking Company Tab and waiting for Company Box to show up");
		employee.clickCompanyTab();
		log.info("Entering Company Name");
		employee.enterPayrollCompany(Company);
		log.info("Entering Company Payroll Department");
		employee.enterPayrollDept(PayrollDepartment);
		log.info("Entering Company PayRun");
		employee.enterPayRun(CompanyPayRun);
		log.info("Entering Company PayGroup");
		employee.enterPayGroup(PayGroup);
		log.info("Entering Work Location");
		employee.enterWorkLocation(WorkLocation);
		log.info("Entering Trade");
		employee.enterTrade(Trade);
		log.info("Entering WC Code");
		employee.enterWCCode(WCCode);
		log.info("Entering PL Code");
		employee.enterPLCode(PLCode);
		log.info("Entering Default Security Group");
		employee.enterDefaultSecurityGroup(EmployeeSecurityGroup);
		log.info("Clicking Rates/Salary Tab");
		employee.clickRatesSalaryTab();
		log.info("Entering hourly Rate");
		employee.enterHourlyRate(hourlyRate);
		log.info("Address Tab");
		employee.clickAddressTab();
		log.info("Entering Zip Code");
		employee.enterZipCode(EmployeeZipCode);
		log.info("clicking Tax Tab");
		employee.clickTaxTab();
		log.info("Entering Federal Filing Status");
		employee.enterFederalFilingStatus("02");
		log.info("Clicking Save to save the new employee profile");
		employee.clickSave();
		/* log.info("Checking if employee was saved successfully or not"); 

		for(int i=employeeIdentifier+1;i<400;i++)
		{
			if(employee.EmployeeExists()) 
			{	
				log.info("Employee "+ EmployeeNumber + " already exists. Creating a new employee!");
				EmployeeNumber=Company+"-"+CompanyPayRun+"-"+"HR"+"-SE"+i;
				log.info("Entering new employee number");
				employee.enterEmployeeNumber(EmployeeNumber);
				employee.clickPersonalTab();
				log.info("Entering new first Name");
				employee.enterFirstName("Employee"+i);
				if(!employee.firstNameHasText())
				{
					employee.enterFirstName("Employee"+i);
				}
				log.info("Saving new employee");
				employee.clickSaveForNewEmployeeNumber();
				continue;
			} */
			//else
			//{
		log.info("Checking if employee was saved successfully or not");
		if(employee.getSavedEmployeeName().contains(Company+CompanyPayRun+"HR"))
		{	
			log.info("Employee Saved Successfully. Testing passed!");
			assertTrue(true);
		}
		else
		{	
			log.info("Employee was not saved Successfully. Testing Failed!");
			assertTrue(false);
		}
				//break;
			//}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
		
		
	
		
	}


//}
