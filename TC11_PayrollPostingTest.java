package TestClasses;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.testng.annotations.Test;

import PageClasses.R12HomePage;
import PageClasses.R12LaunchPage;
import PageClasses.R12PayrollPostingPage;
import PageClasses.R12SignInPage;
import PageClasses.R12UIConsolePage;

public class TC11_PayrollPostingTest extends BaseClass
{	
	public static String ProgramUnderTest="Payroll Posting";
	boolean differentYear=false;
	
	@Test
	public void TestPayrollPosting()
	{
		
		R12LaunchPage launch=new R12LaunchPage(driver);
		R12SignInPage signIn=new R12SignInPage(driver);
		R12UIConsolePage console =new R12UIConsolePage(driver);
		R12HomePage home=new R12HomePage(driver);
		R12PayrollPostingPage ppost=new R12PayrollPostingPage(driver);
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
		log.info("Entering Payroll Posting in search box and opening Payroll Posting program");
		home.enterSearchTextInSearchBox(ProgramUnderTest);
		//home.selectUSPayrollPostingOption();
		log.info("Entering Company");
		ppost.enterCompany(Company);
		log.info("Entering Pay Run");
		ppost.enterPayRun(CompanyPayRun);
		if(!ppost.getPayYear().equals(CompanyPayYear))
		{	
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.info("Entering Pay Year");
			ppost.enterPayYear(CompanyPayYear);
			differentYear=true;
		}
		if(differentYear || !ppost.getPayPeriod().equals(CompanyPayPeriod))
		{	
			log.info("Entering Pay Period");
			ppost.enterPayPeriod(CompanyPayPeriod);
		}
		log.info("Clicking Post Batch button");
		String postResult= ppost.clickPostBatchButton();
		log.info("Checking if Posting was completed or Unprinted Checks found error was thrown");
		if(postResult.contains("successfully"))
		{
			log.info("Posting completed successfully! Testing Passed");
			assertTrue(true);
		}
		else if(postResult.contains("Unprinted Checks exist in this period. Please print all checks before Posting"))
		{
			log.info("Unprinted Checks are present. Please print all checks and retry. Testing Passed!");
			assertTrue(true);
		}
		else
		{
			log.info("Posting did not complete successfully. Testing Failed!");
			assertTrue(false);
		}
	}
}
