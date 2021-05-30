package TestClasses;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.testng.annotations.Test;

import PageClasses.R12CheckPrintingPage;
import PageClasses.R12HomePage;
import PageClasses.R12LaunchPage;
import PageClasses.R12SignInPage;
import PageClasses.R12UIConsolePage;
import PageClasses.R12VoidChecksPage;

public class TC10_CheckVoiding extends BaseClass
{	
	public static String ProgramUnderTest="Void Check";
	boolean differentYear=false;
	
	@Test
	public void TestCheckVoiding()
	{
		R12LaunchPage launch=new R12LaunchPage(driver);
		R12SignInPage signIn=new R12SignInPage(driver);
		R12UIConsolePage console =new R12UIConsolePage(driver);
		R12HomePage home=new R12HomePage(driver);
		R12VoidChecksPage cvoid=new R12VoidChecksPage(driver);
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
		log.info("Entering Void Check in search box and opening Check Void program");
		home.enterSearchTextInSearchBox(ProgramUnderTest);
		home.selectUSPayrollCheckVoidOption();
		log.info("Entering Company");
		cvoid.enterCompany(Company);
		String voidHandle=driver.getWindowHandle();
		log.info("Entering Payrun");
		cvoid.enterPayRun(CompanyPayRun);
		log.info("clicking Current Date on prompt");
		String promptHandle=driver.getWindowHandle();
		driver.switchTo().window(promptHandle);
		cvoid.clickCurrentDateOnPrompt();
		log.info("clicking Accept on prompt");
		cvoid.clickAcceptOnPrompt();
		driver.switchTo().window(voidHandle);
		if(!cvoid.getPayYear().equals(CompanyPayYear))
		{	
			log.info("Entering Pay Year");
			cvoid.enterPayYear(CompanyPayYear);
			differentYear=true;
		}
		if(differentYear || !cvoid.getPayPeriod().equals(CompanyPayPeriod))
		{	
			log.info("Entering Pay Period");
			cvoid.enterPayPeriod(CompanyPayPeriod);
		}
		log.info("Entering From Employee");
		cvoid.enterFromEmployee(Employee1);
		log.info("Entering To Employee");
		cvoid.enterToEmployee(Employee1);
		log.info("clicking Void Check Button");
		cvoid.clickVoidCheck();
		log.info("Validating if check was voided successfully or not");
		if(cvoid.getVoidCheckResultBoxMessage().contains("Void check process successfully completed."))
		{
			log.info("Check Voided Successfully! Testing passed");
			assertTrue(true);
		}
		else
		{
			log.info("Check was not voided! Testing failed");
			assertTrue(false);
		}
		
	}
}
