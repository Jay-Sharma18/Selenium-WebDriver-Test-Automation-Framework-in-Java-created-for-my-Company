package TestClasses;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.testng.annotations.Test;

import PageClasses.R12CheckProcessingPage;
import PageClasses.R12EmployeeProfilePage;
import PageClasses.R12HomePage;
import PageClasses.R12LaunchPage;
import PageClasses.R12SignInPage;
import PageClasses.R12UIConsolePage;

public class TC7_CheckProcessing extends BaseClass
{
	public static String ProgramUnderTest="Check Processing";
	boolean differentYear=false;
	
	@Test
	public void TestCheckProcessing()
	{ 
		R12LaunchPage launch=new R12LaunchPage(driver);
		R12SignInPage signIn=new R12SignInPage(driver);
		R12UIConsolePage console =new R12UIConsolePage(driver);
		R12HomePage home=new R12HomePage(driver);
		R12CheckProcessingPage checkprocess= new R12CheckProcessingPage(driver);
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
		log.info("Entering Check Processing in search box and opening Check Processing program");
		home.enterSearchTextInSearchBox(ProgramUnderTest);
		home.selectUSCheckProcessingOption();
		log.info("Entering Company");
		checkprocess.enterCompany(Company);
		log.info("Entering Pay Run");
		checkprocess.enterPayRun(CompanyPayRun);
		if(!checkprocess.getPayYear().equals(CompanyPayYear))
		{
			checkprocess.enterPayYear(CompanyPayYear);
			differentYear=true;
		}
		if(differentYear || !checkprocess.getPayPeriod().equals(CompanyPayPeriod))
		{
			checkprocess.enterPayPeriod(CompanyPayPeriod);
		}
		log.info("Entering Bank");
		checkprocess.enterBank(BankProcessing);
		log.info("Entering Branch");
		checkprocess.enterBranch(BranchProcessing);
		log.info("Entering Account Number");
		checkprocess.enterAccountNum(AccountProcessing);
		log.info("clicking Process and validating whether processing was completed successfully or not");
		checkprocess.clickProcess();
		if(checkprocess.returnProcessingResultBoxMessage().contains("Processing Completed"))
		{
			assertTrue(true);
			log.info("Check Processing Completed successfully. Testing Passed!");
		}
		else
		{
			assertTrue(false);
			log.info("Check Processing did not complete successfully. Testing Failed!");
		}
		
		
	}
	
	
}
