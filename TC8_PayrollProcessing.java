package TestClasses;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import PageClasses.R12HomePage;
import PageClasses.R12LaunchPage;
import PageClasses.R12PayrollProcessingPage;
import PageClasses.R12SignInPage;
import PageClasses.R12UIConsolePage;

public class TC8_PayrollProcessing extends BaseClass
{
	public static String ProgramUnderTest="Processing";
	
	@Test
	public void TestPayrollProcessing()
	{
		R12LaunchPage launch=new R12LaunchPage(driver);
		R12SignInPage signIn=new R12SignInPage(driver);
		R12UIConsolePage console =new R12UIConsolePage(driver);
		R12HomePage home=new R12HomePage(driver);
		R12PayrollProcessingPage processing=new R12PayrollProcessingPage(driver);
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
		home.selectUSPayrollProcessingOption();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		processing.switchToMainFrame();
		processing.enterPayrollCompany(Company);
		processing.enterHomeCompany(Company);
		processing.enterPayRun(CompanyPayRun);
		processing.enterPayYear(CompanyPayYear);
		processing.enterPayPeriod(CompanyPayPeriod);
		processing.clickProcessButton();
	}
	
}
