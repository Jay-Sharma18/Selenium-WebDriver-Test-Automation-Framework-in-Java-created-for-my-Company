package TestClasses;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.testng.annotations.Test;

import PageClasses.R12EmployeeHistoryPage;
import PageClasses.R12HomePage;
import PageClasses.R12LaunchPage;
import PageClasses.R12SignInPage;
import PageClasses.R12UIConsolePage;

public class TC4_EmployeeHistoryTest extends BaseClass 
{
	public static String effectiveDate="01-01-2017";
	public static String newRate;
	
	@Test
	public void EmpHistoryTest()
	{
		R12LaunchPage launch=new R12LaunchPage(driver);
		R12SignInPage signIn=new R12SignInPage(driver);
		R12UIConsolePage console =new R12UIConsolePage(driver);
		R12HomePage home=new R12HomePage(driver);
		R12EmployeeHistoryPage history=new R12EmployeeHistoryPage(driver);
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
		log.info("Entering Employment History in search box and opening Employment History program");
		home.enterSearchTextInSearchBox(EmpHistoryProgName);
		home.selectUSEmploymentHistoryOption();
		log.info("Entering Employee Number");
		history.enterEmployee(Employee1);
		log.info("Entering Effective Date");
		history.entereffectiveDate(effectiveDate);
		log.info("clicking Insert record");
		history.clickInsertButton();
		log.info("clicking Rates/Salary Tab");
		history.clickRatesTab();
		log.info("Enter new Hourly Rate");
		String oldRate=history.getoldHourlyRate().substring(0, history.getoldHourlyRate().indexOf("."));
		newRate= new Integer(Integer.parseInt(oldRate)+1).toString();
		if(Integer.parseInt(newRate)==100) 
		{
			newRate=new Integer(26).toString();
		}
		history.enterNewRate(newRate);
		log.info("clicking Process Button and waiting for alert to appear");
		String originalWindow=driver.getWindowHandle();
		history.clickProcessButton();
		String newPopup=driver.getWindowHandle();
		driver.switchTo().window(newPopup);
		log.info("Clicking Yes for first alert");
		history.clickYesAlertPopup();
		log.info("Switching to 2nd alert");
		String newPopup2=driver.getWindowHandle();
		driver.switchTo().window(newPopup2);
		log.info("clicking Yes for 2nd alert");
		history.clickYesAlertPopup2();
		driver.switchTo().window(originalWindow);
		log.info("Confirming Rate is updated successfully");
		if(history.getHourlyRateBoxValue().contains(newRate))
		{	
			log.info("Rate updated successfully. Testing passed!");
			assertTrue(true);
		}
		else
		{	
			log.info("Rate updated successfully. Testing failed!");
			assertTrue(false);
		}
		
	}
	
	
	
}
